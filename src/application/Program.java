package application;


import controller.UserRegistrationController;


public class Program {
    static void main(String[] args) {

        UserRegistrationController start = new UserRegistrationController();
        start.flow();
        start.courseController();

    }
}
