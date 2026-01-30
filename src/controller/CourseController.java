package controller;

import entities.Course;
import entities.Users;
import services.CourseManager;
import utils.InputManager;

import java.util.Scanner;

public class CourseController {

    private final Scanner sc = InputManager.getSc();
    private final RegisterUser registerUser;
    private final CourseManager courseManager;

    public CourseController(RegisterUser registerUser, CourseManager courseManager) {
        this.registerUser = registerUser;
        this.courseManager = courseManager;
    }

    //String courseKey é a key do Map<> de CourseManager
    public void configureAndEnroll (String courseKey) {

        Course course = courseManager.getCourse(courseKey);

        if (courseKey == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        int vecancies;

        while (true) {
            try {
                System.out.println("Quantas vagas no curso " + course.getName() + "? ");
                vecancies = Integer.parseInt(sc.nextLine());

                course.setVacancies(vecancies);
                break;
            }catch (NumberFormatException e) {
                System.out.println("ERROR: Digite um número válido.");
            }
        }

        System.out.println("Serão " + vecancies + " vagas no curso " + course.getName() + ".");
        System.out.println("Alunos disponíveis:");
        for (Users u : registerUser.getListUsers()) {
            System.out.println(u);
        }

        while (course.hasVacancy()) {
            System.out.print("Digite o ID do aluno: ");

            try {
                int id = Integer.parseInt(sc.nextLine());
                Users user = registerUser.getUsersById(id);

                if (user == null) {
                    System.out.println("ID não encontrado.");
                    continue;
                }

                if (!course.addUser(user)) {
                    System.out.println("Aluno já matriculado neste curso.");
                    continue;
                }

                System.out.println("Aluno matriculado com sucesso!");

            }
            catch (NumberFormatException e) {
                System.out.println("Digite apenas número.");
            }
        }
    }
}
