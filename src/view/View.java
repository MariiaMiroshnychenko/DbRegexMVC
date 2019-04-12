package view;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class View implements StringConstants{

    public void printMessage(String message) {
            System.out.println(message);
    }

    public void printUserPersonalData(User user) {
        System.out.println(user);
    }
}
