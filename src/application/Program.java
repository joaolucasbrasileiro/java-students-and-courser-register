package application;


import controller.UserRegistrationController;


public class Program {
    static void main(String[] args) {

        UserRegistrationController controller = new UserRegistrationController();
        controller.start();

    }
}
