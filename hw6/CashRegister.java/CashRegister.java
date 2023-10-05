import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
class Money {
    private int cents;
    public Money() {
        cents = 0;
    }
    public Money(Scanner input) {
        String moneyString = input.next();
        String[] parts = moneyString.split("\\.");
        int dollars = Integer.parseInt(parts[0].substring(1));
        int cents = Integer.parseInt(parts[1]);
        this.cents = dollars * 100 + cents;
    }
    public String toString() {
        int dollars = cents / 100;
        int remainingCents = cents % 100;
        return "$" + dollars + "." + (remainingCents < 10 ? "0" : "") + remainingCents;
    }
    public boolean equals(Money other) {
        return this.cents == other.cents;
    }
    public void add(Money other) {
        this.cents += other.cents;
    }
    public int getCents() {
        return cents;
    }
}
public class CashRegister {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner balanceFile = new Scanner(new File("balance"));
        Money startingBalance = new Money(balanceFile);
        balanceFile.close();
        System.out.println("Starting balance: " + startingBalance.toString());
        Scanner transactionsFile = new Scanner(new File("transactions"));
        int transactionCount = 0;
        Money transactionTotal = new Money();
        while (transactionsFile.hasNext()) {
            Money transaction = new Money(transactionsFile);
            startingBalance.add(transaction);
            transactionTotal.add(transaction);
            transactionCount++;
        }
        transactionsFile.close();
        PrintWriter balanceOutput = new PrintWriter("balance");
        balanceOutput.println(startingBalance.toString());
        balanceOutput.close();
        System.out.println(transactionCount + " transactions");
        System.out.println("Transaction Total: " + transactionTotal.toString());
        System.out.println("Closing balance: " + startingBalance.toString());
    }
}
