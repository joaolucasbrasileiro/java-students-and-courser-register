package services;


import entities.Users;
import utils.InputManager;
import utils.NameFormatter;

import java.util.Set;
import java.util.TreeSet;

public class RegisterUser {

    Set<Users> listUsers = new TreeSet<>();

    InputManager inputManager = new InputManager();

    public void register() {
        System.out.println("REGISTRO DE ESTUDANTE");
        String name;
        while (true) {
            try {
                System.out.print("Nome do estudante:");
                name = inputManager.getSc().nextLine();


                if (!name.matches("[a-zA-ZÀ-ÿ ]{3,}")) {
                    throw new IllegalArgumentException("Nome contem caractere inválido!");
                }

                NameFormatter nameFmt = new NameFormatter();
                Users user = new Users(nameFmt.nameFormatter(name));
                listUsers.add(user);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    public Set<Users> getListUsers() {
        return listUsers;
    }
    public Users getUsersById(int numberId) {
        for (Users user : listUsers) {
            if (user.getId() == numberId) {
                return user;
            }
        }
        return  null;
    }
}
