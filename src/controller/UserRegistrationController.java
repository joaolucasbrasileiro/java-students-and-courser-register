package controller;

import entities.Courses;
import services.Menu;
import services.RegisterUser;

public class UserRegistrationController {

    private final RegisterUser registerUser;
    private final Menu menu;
    private final Courses courses;

    public UserRegistrationController() {
        this.registerUser = new RegisterUser();
        this.menu = new Menu(registerUser);
        this.courses = new Courses(registerUser);
    }


    public void flow() {
        int choice = 0;
        do {
            registerUser.register();
            choice = menu.repeat();

        }while(choice == 1);
    }

    public void courseController() {
        courses.addCourse("A", courses.getCourseA());
        courses.addCourse("B", courses.getCourseB());
        courses.addCourse("C", courses.getCourseC());
        System.out.print("TOTAL DE ESTUDANTES MATRICULADOS: " + courses.getTotalCourseUsers());
    }

}
