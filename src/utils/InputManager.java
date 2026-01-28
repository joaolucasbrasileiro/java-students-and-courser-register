package utils;

import java.util.Scanner;

public class InputManager {

    private Scanner sc;

    public InputManager() {
        this.sc = new Scanner(System.in);
    }

    public Scanner getSc() {
        return sc;
    }

    public void closeSc() {
        sc.close();
    }
}
