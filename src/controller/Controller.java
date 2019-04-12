package controller;

import model.User;
import view.StringConstants;
import view.View;

import java.util.Scanner;

public class Controller implements StringConstants, RegexContainer {
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);

    public Controller() {
    }

    public Controller(View view) {
        this.view = view;
    }

    public void insertData() {
        String name = insertName();
        String surname = insertSurname();
        String login = insertLogin();

        User user = new User(name, surname, login);

        view.printUserPersonalData(user);
    }

    private boolean check(String inputData, String regex) {
        return (inputData.matches(regex));
    }

    private String input(String regex, String errorMessage) {
        String personalData;

        do {
            personalData = scanner.nextLine();
            if(check(personalData, regex)) {
                return personalData;
            } else {
                view.printMessage(errorMessage);
            }

        } while(true);
    }

    private String insertName() {
        view.printMessage(NAME_INPUT_MESSAGE);

        return input(NAME_SURNAME_REGEX, NAME_ERROR);
    }


    private String insertSurname() {
        view.printMessage(SURNAME_INPUT_MESSAGE);

        return input(NAME_SURNAME_REGEX, SURNAME_ERROR);
    }

    private String insertLogin() {
        view.printMessage(NICKNAME_INPUT_MESSAGE);

        return input(NICKNAME_REGEX, NICKNAME_ERROR);
    }
}
