package controller;

import entities.Course;
import entities.Users;
import services.CourseManager;
import utils.InputManager;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProgramController {

    private final Scanner sc = InputManager.getSc();
    private final RegisterUser registerUser;
    private final CourseManager courseManager;
    private final CourseController courseController;
    private final Menu menu;

    public ProgramController() {
        this.registerUser = new RegisterUser();
        this.courseManager = new CourseManager(registerUser);
        this.courseController = new CourseController(registerUser, courseManager);
        this.menu = new Menu(registerUser);
    }


    private void register() {
        int choice;
        do {
            registerUser.register();
            choice = menu.repeat();
        } while (choice != 2);
    }

    private void courseController() {
        for (String key : courseManager.getAllCourses().stream().map(Course::getName).toList()) {
            courseController.configureAndEnroll(key);
        }
    }

    private void showEnrollmentSummary() {
        Set<Users> registeredUser = new HashSet<>(registerUser.getListUsers());

        Set<Users> enrolledUser = new HashSet<>();
        for (Course enrolled : courseManager.getAllCourses()) {
            enrolledUser.addAll(enrolled.getUsers());
        }

        Set<Users> nonEnrolledUser = new HashSet<>(registeredUser);
        nonEnrolledUser.removeAll(enrolledUser);

        System.out.println("TOTAL DE USUÁRIOS: " + registeredUser.size());
        System.out.println("Total de Matriculados: " + enrolledUser.size());
        System.out.println("Total de não matriculados: " + nonEnrolledUser.size());
    }

    public void start () {
        register();
        courseController();
        showEnrollmentSummary();
    }

}
