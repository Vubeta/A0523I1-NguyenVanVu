package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowerCode;
import com.example.demo.service.book.IBookService;
import com.example.demo.service.borrower_code.IBorrowerCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBorrowerCodeService iBorrowerCodeService;

    @GetMapping("/")
    public String show(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                       Model model){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Book> books = iBookService.findAll(pageable);
        model.addAttribute("books", books);
        return "/show";
    }

    @GetMapping("/form-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/create","book", new Book());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("book") Book book){
        iBookService.saveBook(book);
        return "redirect:/book/";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable("id") int id){
        return new ModelAndView("/view","book",iBookService.findById(id));
    }

    @GetMapping("/{id}/borrow")
    public String borrow(@PathVariable("id") int id, RedirectAttributes redirectAttributes) throws Exception {
        //check quantity book before create borrower code
        Book book = iBookService.findById(id);
        BorrowerCode borrowerCode = new BorrowerCode();
        if (book.getBookQuantity() > 0){
            borrowerCode.setBorrowerCode(randomBorrowerCode());
            borrowerCode.setBook(book);
            iBorrowerCodeService.create(borrowerCode);
            iBookService.reduceQuantity(id);
            String successfulMess = "Your borrower code is: " + borrowerCode.getBorrowerCode();
            redirectAttributes.addFlashAttribute("successfulMess", successfulMess);
        } else {
            throw new Exception();
        }
        return "redirect:/book/{id}/view";
    }

    @GetMapping("/give-back")
    public String giveBack(@RequestParam("code") String code, RedirectAttributes redirectAttributes) {
        BorrowerCode borrowerCode = iBorrowerCodeService.findByCode(code);
        if (borrowerCode != null) {
            Book book = borrowerCode.getBook();
            iBookService.increaseQuantity(book.getBookId());
            iBorrowerCodeService.remove(borrowerCode);
        } else {
            String error_giveback = "Borrower code " + code + " doesn't exist";
            redirectAttributes.addFlashAttribute("error_giveback", error_giveback);
        }
        return "redirect:/book/";
    }



    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "/error_page";
    }

    private String randomBorrowerCode(){
        int codeLength = 5;
        StringBuilder sb = new StringBuilder(codeLength);
        Random random = new Random();

        do {
            for (int i = 0; i < codeLength; i++) {
                int randomNum = random.nextInt(10);
                sb.append(randomNum);
            }
        } while (iBorrowerCodeService.findByCode(sb.toString()) != null);

        return sb.toString();
    }
}
