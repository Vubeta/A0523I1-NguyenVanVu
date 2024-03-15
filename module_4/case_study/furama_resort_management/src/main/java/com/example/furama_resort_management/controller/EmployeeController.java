package com.example.furama_resort_management.controller;

import com.example.furama_resort_management.model.employee.Employee;
import com.example.furama_resort_management.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/")
    public String showEmployees(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                Model model){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Employee> employees = iEmployeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        return "/employee/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/employee/create", "employee", new Employee());
    }

    @PostMapping("/create")
    public String addNewEmployee(Employee employee) {
        iEmployeeService.save(employee);
        return "redirect:/employee/";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
        iEmployeeService.remove(employeeId);
        return "redirect:/employee/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable Integer id) {
        return new ModelAndView("/employee/update", "employee", iEmployeeService.findById(id));
    }
}
