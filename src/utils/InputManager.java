package utils;

import java.util.Scanner;

public class InputManager {

    private static final Scanner sc = new Scanner(System.in);

    private InputManager() {}

    public static Scanner getSc() {
        return sc;
    }

    public void closeSc() {
        sc.close();
    }
}
