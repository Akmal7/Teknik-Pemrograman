package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;

public class LoanService {

    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        // =========================
        // VALIDASI(delegeasi ke awal)
        validateBorrower(borrower);
        validateLoanAmount(amount);

        // =========================
        // CREATE LOAN (domain object)
        // =========================
        Loan loan = new Loan();

        // =========================
        // BUSINESS ACTION (domain behavior)
        // =========================
        applyCreditScoring(borrower, loan);

        return loan;
    }
    // =========================
    // PRIVATE VALIDATION METHOD
    // =========================
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    // TC-02: Validasi jumlah pinjaman harus lebih besar dari 0
    private void validateLoanAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid loan amount");
        }
    }

    // TC-03: Menentukan status loan berdasarkan kelayakan kredit borrower
    private void applyCreditScoring(Borrower borrower, Loan loan) {
        if (borrower.hasGoodCredit()) {
            loan.approve();
        } else {
            loan.reject();
        }
    }
}