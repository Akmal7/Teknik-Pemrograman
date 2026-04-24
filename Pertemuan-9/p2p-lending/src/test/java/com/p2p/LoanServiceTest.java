package com.p2p;

import com.p2p.domain.*;
import com.p2p.service.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
public class LoanServiceTest {
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act (Action) + Assert (Expected Result)
        // =========================
        // Ketika borrower mencoba mengajukan loan
        // sistem harus MENOLAK dengan melempar exception
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        // Arrange
        Borrower borrower = new Borrower(true, 700); // verified = true
        LoanService loanService = new LoanService();

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.ZERO);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(-100));
        });
    }
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {

        // Arrange
        Borrower borrower = new Borrower(true, 700); // verified & score tinggi
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {

        // Arrange
        Borrower borrower = new Borrower(true, 500);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}
