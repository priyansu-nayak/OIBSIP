import java.util.*;

class Account {
    static void Log_In() {
        Scanner obj = new Scanner(System.in);
        System.out.println("————————————————————————————————");
        System.out.println("Please enter your full name :");
        ATM_INTERFACE.full_name = obj.nextLine();
        System.out.println("Please enter the username :");
        String user_name = obj.nextLine();
        System.out.println("Input your password :");
        String password = obj.nextLine();
        System.out.println("Please enter your Account number :");
        ATM_INTERFACE.account_number = obj.nextLine();
        System.out.println("Account Logged In ✅ ");

        ATM_INTERFACE.prompt();
        while (true) {
            display(ATM_INTERFACE.full_name);
            int choice = obj.nextInt();
            switch (choice) {
                case 1 -> login(user_name, password);
                case 2 -> System.exit(0);
                default -> System.out.println("Invalid input !!!");
            }
        }
    }

    static void display(String Name) {

    }

    static void login(String username, String passcode) {

    }
}

class Transactions {
    static void withDraw_Amount() {
        System.out.println("————————————————————————————————");
        Scanner sc = new Scanner(System.in);
        System.out.println("How much amount you want to withdraw ? :");
        int withDrawn_Amount = sc.nextInt();
        if (withDrawn_Amount <= ATM_INTERFACE.account_balance) {
            ATM_INTERFACE.account_balance -= withDrawn_Amount;
            ATM_INTERFACE.transaction_history.add("Amount Withdrawn: ");
            ATM_INTERFACE.transaction_history.add(Integer.toString(withDrawn_Amount));

            System.out.println(" ₹ " + withDrawn_Amount + " withDrawn [✔]");
        } else {
            System.out.println("ENTERED AMOUNT IS GREATER THAN CURRENT BALANCE ❎ ");
        }

        ATM_INTERFACE.prompt();
    }

    static void Deposit_Amount() {
        System.out.println("————————————————————————————————");
        Scanner sc = new Scanner(System.in);
        System.out.println("How much cash you want to deposit ? :");
        int deposited_Cash = sc.nextInt();
        ATM_INTERFACE.updated_Balance(deposited_Cash);
        ATM_INTERFACE.transaction_history.add("Amount Deposited: ");
        ATM_INTERFACE.transaction_history.add(Integer.toString(deposited_Cash));
        System.out.println(" ₹ " + deposited_Cash + "/- deposited [✔]");
        ATM_INTERFACE.prompt();
    }

    static void Transfer() {
        System.out.println("————————————————————————————————");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter name of receiver: ");
        String receiver_name = sc.nextLine();
        System.out.println("Please enter the account number of the receiver: ");
        int receiver_acc_num = sc.nextInt();
        System.out.println("Please enter the amount to be transferred :");
        int transferred_amount = sc.nextInt();
        if (transferred_amount <= ATM_INTERFACE.account_balance) {
            ATM_INTERFACE.account_balance -= transferred_amount;
            ATM_INTERFACE.transaction_history.add("Amount Transferred: ");
            ATM_INTERFACE.transaction_history.add(Integer.toString(transferred_amount));

            System.out.println(" ₹ " + transferred_amount + " transferred [✔]");
        } else {
            System.out.println("ENTERED AMOUNT IS GREATER THAN CURRENT BALANCE ❎ ");
        }

    }
}

class Display_Balance {
    static void display_Balance() {
        System.out.println("————————————————————————————————");
        System.out.println("CURRENT BALANCE :");
        ATM_INTERFACE.display_Balance();
        ATM_INTERFACE.prompt();
    }
}

class Transaction_History {
    static void Transc_History() {
        System.out.println("————————————————————————————————");
        System.out.println("Transaction History :");
        int count = 0;
        if (ATM_INTERFACE.account_balance > 0) {
            for (int i = 0; i < (ATM_INTERFACE.transaction_history.size() / 2); i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.println(ATM_INTERFACE.transaction_history.get(count) + " ");
                    count++;

                }

            }
            System.out.println();
        } else {
            System.out.println("Your Balance is  ₹0 ");
        }
        ATM_INTERFACE.prompt();
    }
}

class ATM_INTERFACE {
    public static String full_name;
    public static int account_balance = 0;
    public static String account_number;
    public static ArrayList<String> transaction_history = new ArrayList<>();

    static void updated_Balance(int deposited_cash) {
        account_balance += deposited_cash;
    }

    static void display_Balance() {
        System.out.println(account_balance);
    }

    public static void Log_In_Page() {
        Scanner sc = new Scanner(System.in);
        System.out.println("—————————— WELCOME USER ——————————");
        System.out.println("Choose your choice:");
        System.out.println("(1) Log-In");
        System.out.println("(2) Log-Out");
        System.out.println("Your choice:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> Account.Log_In();
            case 2 -> System.exit(0);
            default -> {
                System.out.println("Invalid Choice ❎ ");
                Log_In_Page();
            }
        }
    }

    static void prompt() {
        System.out.println("————————————————————————————————");
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + ATM_INTERFACE.full_name);
        System.out.println("Choose from the options down below - ");
        System.out.println("[1] Withdraw");
        System.out.println("[2] Deposit");
        System.out.println("[3] Transfer");
        System.out.println("[4] Display Current Balance");
        System.out.println("[5] Transaction History");
        System.out.println("[6] Quit");
        System.out.println("Your Choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Transactions.withDraw_Amount();
            case 2:
                Transactions.Deposit_Amount();
            case 3:
                Transactions.Transfer();
            case 4:
                Display_Balance.display_Balance();
            case 5:
                Transaction_History.Transc_History();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        Log_In_Page();
    }
}