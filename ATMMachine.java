import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
 class ATM {
    float Balance = 0;
    int PIN = 1234;
    Scanner sc = new Scanner(System.in);
    ArrayList<String> transactionHistory = new ArrayList<>();


    public void checkPIN(int PIN) {
        System.out.println("Enter your pin:");
        if (this.PIN == PIN) {
            menu();
        } else {
            System.out.println("Enter a Valid PIN");
            this.PIN = sc.nextInt();
            checkPIN(this.PIN);

        }
    }

    public void menu() {
        System.out.println();
        System.out.println("Enter Your choice ");
        System.out.println("1. Account balance inquiry");
        System.out.println("2.Cash withdrawal");
        System.out.println("3. Cash deposit");
        System.out.println("4. PIN change");
        System.out.println("5. Transaction history");
        System.out.println("6. EXIT");


        int opt = sc.nextInt();
        switch (opt) {
            case 1:
                AccountBalanceInquiry();
                break;
            case 2:
                CashWithdrawal();
                break;
            case 3:
                CashDeposit();
                break;
            case 4:
                changePIN();
                break;
            case 5:
                transactionHistory();
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println("Please enter a valid option!!");
        }
    }

    public void AccountBalanceInquiry() {
        System.out.println("Balance :" + Balance);
        addTransaction("Checked balance: " + Balance);
        menu();
    }

    public void CashWithdrawal() {
        System.out.println("enter the withraw amount:");

        float withdrawAmount = sc.nextFloat();
        if (Balance > withdrawAmount) {
            Balance = Balance - withdrawAmount;
            System.out.println("Withdraw succesfull !!");
            addTransaction("Withdrew: " + withdrawAmount);
        } else {
            System.out.println("Insufficient Balance");
        }
        menu();
    }

    public void CashDeposit() {
        System.out.println("enter the amount to be deposited");
        float depositedAmount = sc.nextFloat();
        Balance = Balance + depositedAmount;
        System.out.println("Deposit successful! !!");
        addTransaction("Deposited: " + depositedAmount);
        menu();
    }

    public void changePIN() {
        System.out.println("Enter your current PIN:");
        int currentPIN = sc.nextInt();
        if (currentPIN == PIN) {
            System.out.println("Enter your new PIN:");
            PIN = sc.nextInt();
            System.out.println("PIN changed successfully!!");
        } else {
            System.out.println("Incorrect current PIN. Please try again.");
        }
        menu();

    }

    public void transactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        menu();

    }

    public void exit() {
        System.out.println("Thanks for visiting!!");
    }

    private void addTransaction(String transactionDetail) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now().withNano(0);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = time.format(timeFormatter);
        transactionHistory.add(date + " " + formattedTime + " - " + transactionDetail);
    }

}
public class ATMMachine{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your PIN:");
        int PIN = sc.nextInt();
        ATM a = new ATM();
        a.checkPIN(PIN);


        }
    }

