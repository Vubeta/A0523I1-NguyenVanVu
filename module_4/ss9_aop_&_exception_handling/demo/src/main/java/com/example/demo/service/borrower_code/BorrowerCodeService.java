package com.example.demo.service.borrower_code;

import com.example.demo.model.BorrowerCode;
import com.example.demo.repository.borrower_code.IBorrowerCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerCodeService implements IBorrowerCodeService {
    @Autowired
    IBorrowerCodeRepository iBorrowerCodeRepository;

    @Override
    public void create(BorrowerCode borrowerCode) {
        iBorrowerCodeRepository.save(borrowerCode);
    }

    @Override
    public void remove(BorrowerCode borrowerCode) {
        if (borrowerCode != null) {
            iBorrowerCodeRepository.delete(borrowerCode);
        }
    }

    @Override
    public BorrowerCode findById(int id) {
        Optional<BorrowerCode> borrowerCodeOptional = iBorrowerCodeRepository.findById(id);
        BorrowerCode borrowerCode = null;

        if (borrowerCodeOptional.isPresent()) {
            borrowerCode = borrowerCodeOptional.get();
        }
        return borrowerCode;
    }

    @Override
    public BorrowerCode findByCode(String code) {
        return iBorrowerCodeRepository.findByCode(code);
    }

    @Override
    public List<BorrowerCode> findAll() {
        return iBorrowerCodeRepository.findAll();
    }
}
