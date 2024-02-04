package com.example.demo.service.borrower_code;

import com.example.demo.model.BorrowerCode;

import java.util.List;

public interface IBorrowerCodeService {
    void create(BorrowerCode borrowerCode);
    void remove(BorrowerCode borrowerCode);
    BorrowerCode findById(int id);
    BorrowerCode findByCode(String code);
    List<BorrowerCode> findAll();
}
