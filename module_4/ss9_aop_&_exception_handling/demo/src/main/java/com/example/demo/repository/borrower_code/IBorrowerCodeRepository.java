package com.example.demo.repository.borrower_code;

import com.example.demo.model.BorrowerCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowerCodeRepository extends JpaRepository<BorrowerCode, Integer> {
    @Query("select bc from BorrowerCode bc where bc.borrowerCode = :code")
    BorrowerCode findByCode(@Param("code") String code);
}
