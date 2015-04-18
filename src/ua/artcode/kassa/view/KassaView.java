package ua.artcode.kassa.view;

import ua.artcode.kassa.controller.IKassaController;
import ua.artcode.kassa.model.Bill;

import java.util.Scanner;

/**
 * Created by serhii on 18.04.15.
 */
public class KassaView {

    private IKassaController kassaController;
    private Scanner sc = new Scanner(System.in);

    public KassaView(IKassaController kassaController) {
        this.kassaController = kassaController;
    }

    public void start(){


        while(true){


            showMainMenu();
            int choice = sc.nextInt();
            doChoice(choice);


        }

    }

    private void doChoice(int choice){
        switch (choice) {

            case 1 :
                System.out.println("Input key");
                String key = sc.next();
                if(kassaController.open(key)){
                    System.out.println("Kassa is open");
                } else {
                    System.err.println("wrong key, try again");
                }
                break;


            case 2 :
                kassaController.close();
                break;
            case 3 :
                kassaController.showAllProducts();
                break;
            case 4 :
                System.out.println("Input product key");
                int id = sc.nextInt();
                kassaController.sellProduct(id);
                break;
            case 5 :
                Bill bill = kassaController.getBill();
                System.out.println(bill);
                break;

            default:
                System.err.println("wrong choice");
                break;
        }
    }

    private void showMainMenu() {
        System.out.println("1.Open");
        System.out.println("2.Close");
        System.out.println("3.Show products");
        System.out.println("4.Sell product");
        System.out.println("5.Generate Bill");
    }


}
