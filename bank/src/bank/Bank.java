/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author khatere
 */
import java.io.*;
import java.util.*;

class Account {

    int ID;
    String name;
    double deposit;

    void settle(double amount) {
        deposit = deposit + amount;
        System.out.printf("new deposit is:%f", deposit);
    }

    void withdraw(double amount) {
        if (amount > deposit) {
            System.out.println("the amount of withdraw is bigger than deposit!");
        } else {
            deposit = deposit - amount;
            System.out.printf(" new deposit is:%f", deposit);
        }

    }

    void ChangeInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter a new name:");
        String new_name = input.next();
        name = new_name;
    }

    void List() {
        Scanner input = new Scanner(System.in);
        System.out.println(name + " " + ID + " " + deposit + " ");
        System.out.println("\n");
    }
    
    
}

public class Bank {

    /**
     * @param args the command line arguments
     */
                 static void NewAcc(Account array []){
             Scanner input = new Scanner(System.in);
             System.out.println("how many accounts you want to add?");
                    int new_acc = input.nextInt();
                    for (int i =0; i < new_acc; i++) {
                        array[i] = new Account();
                        System.out.printf("enter name of %dth user:", i + 1);
                        array[i].name = input.next();
                        System.out.printf("enter ID of %dth user:", i + 1);
                        array[i].ID = input.nextInt();
                        System.out.printf("enter deposit of %dth user:", i + 1);
                        array[i].deposit = input.nextDouble();
                    }  
    }
    public static void main(String[] args) throws FileNotFoundException {

        int I = 0, new_acc = 0;
        Scanner input = new Scanner(System.in);
        Account[] user;
        user = new Account[100];
        System.out.println("\n");
        System.out.println("ENTER:\n");
        System.out.println("['1' to 'add  new accounts']\n['2' to 'choose acount]'\n['3' to 'settle']\n['4' to 'withdraw']\n['5' to 'changeInfo']\n['6' to 'see the list of users']\n['7' to 'save data']\n['8' to 'exit']");
        int choose = input.nextInt();
        while (choose != 8) {
            switch (choose) {
                case 1:
                  NewAcc(user);
                  break;

                case 2:
                    System.out.println("enter '1' to choose the user by ID or enter '2' to choose the user by name:");
                    int choose_user = input.nextInt();
                    if (choose_user == 1) {
                        System.out.println("enter ID:");
                        int id = input.nextInt();
                        for (int i = 0; i < new_acc; i++) {
                            if (user[i].ID == id) {
                                I = i;
                            }
                        }
                    }
                    if (choose_user == 2) {
                        System.out.println("enter name:");
                        String Name = input.next();
                        for (int i=0;i <new_acc; i++) {
                            if (user[i].name.equals(Name)) {
                                I = i;
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("enter amount of money to settle into the account:");
                    double amount_1 = input.nextInt();
                    user[I].settle(amount_1);
                    break;

                case 4:
                    System.out.println("enter amount of money to withdraw from the account:");
                    double amount_2 = input.nextInt();
                    user[I].withdraw(amount_2);
                    break;

                case 5:
                    user[I].ChangeInfo();
                    break;

                case 6:
                    for (int i = 0; i < new_acc; i++) {
                        user[i].List();
                    }
                    break;
                case 7:
                    File file = new File("BankAccount.txt");
                    PrintWriter writer = new PrintWriter(file);
                    for(int i=0;i<new_acc;i++){
                    writer.println(user[i].name + " " + user[i].ID + " " + user[i].deposit + " ");
                    }
                    writer.close();
                    break;
                    

                default:
                    System.out.println("unknown choice!\n");
                            System.out.println("enter '1' to 'add  new accounts'\nenter '2' to 'choose acount'\nenter '3' to 'settle'\nenter '4' to 'withdraw'\nenter '5' to 'changeInfo'\nenter '6' to 'see the list of users'\nenter '7' to save data\nenter '8' to exit");
                    break;
            }
            System.out.println("enter your choice:");
            choose = input.nextInt();

        }
        System.out.println("good bye!");

    }
    
   

}
