package ua.artcode.view;

import ua.artcode.exception.LoginException;
import ua.artcode.exception.RegistrarException;
import ua.artcode.model.User;
import ua.artcode.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Created by serhii on 30.05.15.
 */
public class ConsoleUserView implements UserView {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private UserService userService;

    public ConsoleUserView(UserService userService) {
        this.userService = userService;
    }

    public void start() {
        while (true){
            showMainMenu();
            try {
                int choice = Integer.parseInt(bufferedReader.readLine().trim());

                if(choice == 4){
                    break;
                }

                doChoice(choice);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void doChoice(int choice){
        switch (choice){
            case 1 : {
                registerMenu();
                break;
            }

            case 2 : {
                loginMenu();
                break;
            }

            case 3 : {
                showUsers();
                break;
            }

            default:
                System.out.println("wrong choice");
                break;

        }
    }

    public void showUsers(){
        List<User> userList = userService.getAll();
        System.out.println("USER LIST");
        for(User u : userList){
            System.out.println("\t" + u);
        }
    }


    private void showMainMenu(){
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Show all users");
        System.out.println("4. exit");


    }

    private void loginMenu(){
        try {
            System.out.println("Input email");
            String email = bufferedReader.readLine().trim();
            System.out.println("Input pass");
            String pass = bufferedReader.readLine().trim();
            User user = userService.login(email,pass);
            System.out.println(user  + " in system");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            System.err.println(e.getMessage());
        }
    }

    private void registerMenu(){
        try {
            System.out.println("Input email");
            String email = bufferedReader.readLine().trim();
            System.out.println("Input fullname");
            String fullname = bufferedReader.readLine().trim();
            System.out.println("Input pass");
            String pass = bufferedReader.readLine().trim();

            userService.register(email,fullname,pass);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (RegistrarException e) {
            System.err.println(e.getMessage());
        }
    }

}
