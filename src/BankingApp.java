import java.util.Scanner;
public class BankingApp {
    public static void main(String[] args){
        BankAccount obj1 = new BankAccount("Ashish","CNB001");
        obj1.showMenu();
    }
}

class BankAccount  {
    int activeBalance;
    int previousTransactions;
    String AccountHolderName;
    String AccountHolderID;

    BankAccount(String cname, String cid){
        AccountHolderName = cname;
        AccountHolderID = cid;
    }

    void deposit(int amount){
        if(amount!= 0){
            activeBalance = activeBalance +amount;
            previousTransactions = amount;
        }
    }

    void withdraw(int amount){
        if(amount!=0)
        {
            activeBalance = activeBalance -amount;
            previousTransactions =- amount;
        }
    }

    void getPreviousTransaction()
    {
        if(previousTransactions >0)
        {
            System.out.println("Deposited: "+previousTransactions);
        }
        else if(previousTransactions <0)
        {
            System.out.println("Withdrawn: "+Math.abs(previousTransactions));
        }
        else
        {
            System.out.println("No transaction occured");
        }
    }

    void showMenu()
    {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome "+ AccountHolderName);
        System.out.println("Your id is "+ AccountHolderID);
        System.out.println("\n ");
        System.out.println("A. check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("***********************");
            System.out.println("Enter an option");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option)
            {
                case 'A':
                    System.out.println("***********************");
                    System.out.println("Balance = "+ activeBalance);
                    System.out.println("***********************");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("***********************");
                    System.out.println("Enter an amount to deposit :");
                    System.out.println("***********************");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("***********************");
                    System.out.println("Enter an amount to withdraw :");
                    System.out.println("***********************");
                    int amount1 = scanner.nextInt();
                    withdraw(amount1);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("***********************");
                    System.out.println("Previous transaction :");
                    getPreviousTransaction();
                    System.out.println("***********************");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("***********************");
                    break;

                default:
                    System.out.println("***********************");
                    System.out.println("Invalid option, please try again");
                    break;
            }

        } while(option !='E');

        System.out.println("Thank you!");
    }
}