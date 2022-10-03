import java.util.*;
class BankDetails {
    private String accountnumber;
    private String name;
    private String accounttype;
    private long balance;
    Scanner sc = new Scanner(System.in);
    //method to open new account
    public void openAccount() {
        System.out.print("Enter Account No: ");
        accountnumber = sc.next();
        System.out.print("Enter Account type: ");
        accounttype = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }


    //method to display account details
    public void showAccount() {
        System.out.println("Name of Account Holder: " + name);
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Account Type: " + accounttype);
        System.out.println("Balance: " + balance);
    }

    //method to deposit money
    public void deposit() {
        Long amount;
        System.out.println("Enter the amount to be deposited: ");
        amount = sc.nextLong();
        balance = balance + amount;
    }


    //method to withdraw money
    public void withdrawal() {
        Long amount;
        System.out.println("Enter the amount to be withdrawn: ");
        amount = sc.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: "+ balance);
        } else {
            System.out.println("Your balance is less than " + amount + "\tTransaction failed…!!" );
        }
    }


    //method to search an account number
    public boolean search(String ac_num) {
        if (accountnumber.equals(ac_num)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class Accounts {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        //create initial accounts
        System.out.print("How many number of customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails B[] = new BankDetails[n];
        for (int i = 0; i < B.length; i++) {
            B[i] = new BankDetails();
            B[i].openAccount();
        }

        int c;
        do {
            System.out.println("\n ***Banking System Application***");
            System.out.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
            System.out.println("Enter your choice: ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    for (int i = 0; i < B.length; i++) {
                        B[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account number to be searched: ");
                    String ac_num = sc.next();
                    Boolean found = false;
                    for (int i = 0; i < B.length; i++) {
                        found = B[i].search(ac_num);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account does not exist.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_num = sc.next();
                    found = false;
                    for (int i = 0; i < B.length; i++) {
                        found = B[i].search(ac_num);
                        if (found) {
                            B[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account does not exist.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_num = sc.next();
                    found = false;
                    for (int i = 0; i < B.length; i++) {
                        found = B[i].search(ac_num);
                        if (found) {
                            B[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account does not exist.");
                    }
                    break;
                case 5:
                    System.out.println("See you soon.");
                    break;
            }
        }
        while (c != 5);
    }
}