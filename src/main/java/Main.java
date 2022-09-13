import java.text.DecimalFormat;

public class Main {
    private static final Double monthRate = 1.0083;
    private static final Double initialSum = 9_800_000.0;

    public static void main(String[] args) {
        var myBankAccount = new BankAccount(initialSum);

        for (int i = 0; i < 12; i++) {
            myBankAccount.applyMonthlyIncrement((arg) -> arg * monthRate + 350_000);
        }

        System.out.printf(new DecimalFormat("###,###.###").format(myBankAccount.getCurrentSum()));
    }

    //1.5 - 1st year or 22y.o //80k
    //3.3 - 2nd year or 23y.o //130k
    //6.1 - 3rd year or 24y.o //200k
    //9.8 - 4th year or 25y.o //250k
    //15.2 - 5th year or 26y.o //350k
}


