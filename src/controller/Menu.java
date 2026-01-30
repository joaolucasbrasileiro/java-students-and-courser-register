package controller;

import utils.InputManager;

import java.util.Scanner;


public class Menu {

    private RegisterUser registerUser;
    private Scanner sc = InputManager.getSc();


    public Menu(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    public int repeat() {

        int choice;

        while (true) {
            try {
                System.out.println("Desejar adicionar mais um estudante?");
                System.out.println("1 - SIM");
                System.out.println("2 - NAO");
                choice = Integer.parseInt(sc.nextLine());

                if (choice != 1 && choice != 2) {
                    throw new IllegalArgumentException("Opção inválida!");
                }

                if (choice == 2) {
                    return choice;
                }else registerUser.register();

            }catch (NumberFormatException e) {
                System.out.println("ERROR: Digite apenas números para escolher!");
            }catch (IllegalArgumentException e) {
                System.out.println("ERROR:" + e.getMessage());
            }
        }

    }
}
