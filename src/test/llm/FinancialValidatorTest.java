import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinancialValidatorTest {
    FinancialValidator validator = new FinancialValidator();

    @Test
    public void testValidLoan() {
        assertTrue(validator.isValidLoan(5000, 10000, 750));
    }

    @Test
    public void testInvalidIncomeOrAmount() {
        assertFalse(validator.isValidLoan(0, 10000, 700));
        assertFalse(validator.isValidLoan(5000, -500, 700));
    }

    @Test
    public void testInvalidCreditScore() {
        assertFalse(validator.isValidLoan(5000, 10000, 200));
        assertFalse(validator.isValidLoan(5000, 10000, 900));
    }

    @Test
    public void testLoanLimitExceeded() {
        // Testa o limite de 5x a renda
        assertFalse(validator.isValidLoan(2000, 15000, 800));
    }

    @Test
    public void testLowScoreRestriction() {
        // Score < 600: deve falhar se o empréstimo for > 2x a renda
        assertFalse(validator.isValidLoan(3000, 7000, 500));
        assertTrue(validator.isValidLoan(3000, 5000, 500));
    }
}
