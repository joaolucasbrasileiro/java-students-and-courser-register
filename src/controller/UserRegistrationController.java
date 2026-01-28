package controller;

import entities.Courses;
import services.Menu;
import services.RegisterUser;

public class UserRegistrationController {

    RegisterUser registerUser = new RegisterUser();
    Menu menu = new Menu(registerUser);

    public void flow() {
        int choice = 0;
        do {
            registerUser.register();
            choice = menu.repeat();

        }while(choice == 1);
    }

    Courses courses = new Courses(registerUser);

    public void courseController() {
        courses.addCourse("A", courses.getCourseA());
        courses.addCourse("B", courses.getCourseB());
        courses.addCourse("C", courses.getCourseC());
        System.out.print("TOTAL DE ESTUDANTES MATRICULADOS: " + courses.getTotalCourseUsers());
    }

}
