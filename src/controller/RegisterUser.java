package controller;


import entities.Users;
import utils.InputManager;
import utils.NameFormatter;

import java.util.*;

public class RegisterUser {

    private Scanner sc = InputManager.getSc();

    private Set<Users> listUsers = new TreeSet<>();//Lista de Usuarios(Estudantes)
    private Map<Integer, Users> mapListUsers = new HashMap<>();


    public void register() {
        System.out.println("REGISTRO DE ESTUDANTE");
        String name;
        while (true) {
            try {
                System.out.print("Nome do estudante:");
                name = sc.nextLine();


                if (!name.matches("[a-zA-ZÀ-ÿ ]{3,}")) {
                    throw new IllegalArgumentException("Nome contem caractere inválido!");
                }

                NameFormatter nameFmt = new NameFormatter();
                Users user = new Users(nameFmt.nameFormatter(name));
                listUsers.add(user);
                mapListUsers.put(user.getId(), user);
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
        return mapListUsers.get(numberId);
    }

}
