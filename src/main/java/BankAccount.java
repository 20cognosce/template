import lombok.Getter;

import java.util.function.DoubleFunction;

@Getter
public class BankAccount {
    private double currentSum;

    public BankAccount(Double initialFee) {
        this.currentSum = initialFee;
    }

    public void applyMonthlyIncrement(DoubleFunction<Double> incrementFunction) {
        currentSum = incrementFunction.apply(currentSum);
    }
}
