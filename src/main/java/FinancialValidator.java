public class FinancialValidator {
    public boolean isValidLoan(double income, double loanAmount, int creditScore) {
        if (income <= 0 || loanAmount <= 0) {
            return false;
        }
        if (creditScore < 300 || creditScore > 850) {
            return false;
        }
        // Regra de negócio: Empréstimo não pode exceder 5x a renda
        if (loanAmount > (income * 5)) {
            return false;
        }
        // Score baixo exige renda maior (Score < 600 só permite 2x a renda)
        if (creditScore < 600 && loanAmount > (income * 2)) {
            return false;
        }
        return true;
    }
}
