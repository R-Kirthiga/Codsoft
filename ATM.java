import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    static void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter your name :");
        ATM.name = sc.nextLine();
        System.out.println("Enter username :");
        String user = sc.nextLine();
        System.out.println("Enter password :");
        String pass = sc.nextLine();
        System.out.println("Enter your Account number :");
        ATM.accnumber = sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFULLY!");
        System.out.println("---------------------------");
        ATM.prompt();
        while (true) {
            display(ATM.name);
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            if (choice == 1) {
                login(user, pass);
                break;
            } else if (choice == 2) {
                System.exit(0);
            } else {
                System.out.println("Bad value! Enter again!");
            }
        }
        sc.close();
    }

    static void display(String name) {
        System.out.println("Welcome " + name);
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

    static void login(String user, String pass) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        if (username.equals(user) && password.equals(pass)) {
            System.out.println("Login successful!");
            ATM.prompt();
        } else {
            System.out.println("Invalid credentials, please try again.");
            login(user, pass);
        }
        sc.close();
    }
}

class Transaction {
    static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to withdraw :");
        int cash = sc.nextInt();
        if (cash <= ATM.balance) {
            ATM.balance -= cash;
            ATM.history.add("Withdraw: " + cash);
            System.out.println("Amount Rs." + cash + "/- withdrawn successfully");
            System.out.println("---------------------------");
        } else {
            System.out.println("Insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATM.prompt();
        sc.close();
    }

    static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit :");
        int dcash = sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add("Deposit: " + dcash);
        System.out.println("Amount Rs." + dcash + "/- deposited successfully!");
        System.out.println("---------------------------");
        ATM.prompt();
        sc.close();
    }

    static void transfer() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // Consume newline
        System.out.println("Enter the receiving body:");
        String s = sc.nextLine();
        System.out.println("Enter the account number of the receiving body:");
        sc.nextLine();
        System.out.println("Enter the amount to be transferred :");
        int tcash = sc.nextInt();
        if (tcash <= ATM.balance) {
            ATM.balance -= tcash;
            ATM.history.add("Transferred: " + tcash + " to " + s);
            System.out.println("Amount Rs." + tcash + "/- transferred successfully");
            System.out.println("---------------------------");
        } else {
            System.out.println("Insufficient balance to transfer the cash");
            System.out.println("---------------------------");
        }
        ATM.prompt();
        sc.close();
    }
    
}

class Check {
    static void checkbalance() {
        System.out.println("------------------");
        System.out.println("The available balance in the bank account:");
        ATM.showbalance();
        System.out.println("---------------------------");
        ATM.prompt();
    }
}

class History {
    static void transactionhistory() {
        System.out.println("---------------------");
        System.out.println("Transaction History:");
        if (!ATM.history.isEmpty()) {
            for (String record : ATM.history) {
                System.out.println(record);
                System.out.println("---------------------");
            }
        } else {
            System.out.println("Your account is empty");
        }
        ATM.prompt();
    }
}

class Savings {
    static void savingaccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("Enter your salary:");
        sc.nextLine();
        System.out.println("Enter your targeted amount:");
       
        int target = sc.nextInt();
        if (target > ATM.balance) {
            System.out.println("You're not eligible to save " + target + " amount in a month");
        } else {
            System.out.println("Amount saving is: " + target);
        }
        System.out.println("----------------------");
        ATM.prompt();
        sc.close();
    }
}

class Emergency {
    static void emergence() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------");
        System.out.println("Enter EMI amount:");
        int emi = sc.nextInt();
        System.out.println("Food expenses:");
        int food = sc.nextInt();
        System.out.println("Groceries:");
        int groceries = sc.nextInt();
        int total = emi + food + groceries;
        System.out.println("Your monthly expenses: " + total);
        ATM.balance -= total;
        ATM.history.add("Emergency expenses: " + total);
        ATM.prompt();
        sc.close();
    }
}

public class ATM {
    public static String name;
    public static int balance = 0;
    public static String accnumber;
    public static ArrayList<String> history = new ArrayList<>();

    static void updatebalance(int dcash) {
        balance += dcash;
    }

    static void showbalance() {
        System.out.println(balance);
    }

    public static void homepage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("Select option:");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        if (choice == 1) {
            BankAccount.register();
        } else if (choice == 2) {
            System.exit(0);
        } else {
            System.out.println("Select a value only from the given options:");
            homepage();
        }
        sc.close();
    }

    static void prompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME " + ATM.name + "! TO ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Savings account");
        System.out.println("7. Emergency expenses");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                Transaction.withdraw();
                break;
            case 2:
                Transaction.deposit();
                break;
            case 3:
                Transaction.transfer();
                break;
            case 4:
                Check.checkbalance();
                break;
            case 5:
                History.transactionhistory();
                break;
            case 6:
                Savings.savingaccount();
                break;
            case 7:
                Emergency.emergence();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                prompt();
                break;
        }
        sc.close();
    }

    public static void main(String[] args) {
        homepage();
    }
}
