package controller;

import model.User;
import model.entity.LoginDuplicateException;
import model.entity.RegisteredLogins;
import view.StringConstants;
import view.View;

import java.util.Scanner;

import static view.View.bundle;

public class Controller implements StringConstants, RegexContainer{
    private View view;
    private Scanner scanner = new Scanner(System.in, "UTF-8");

    public Controller(View view) {
        this.view = view;
    }

    public void insertData() {
        //view.printMessage(CHANGE_LANGUAGE);

        String name = insertName();
        String surname = insertSurname();
        String login = insertLogin();

        User user = new User(name, surname, login);

        view.printUserPersonalData(user);
    }

    private String defineRegexByLocal() {
        return String.valueOf(bundle.getLocale().toString()).equals("uk_UA")
                ? NAME_SURNAME_UKR : NAME_SURNAME_LAT;
    }

    private boolean check(String inputData, String regex) {
        return (inputData.matches(regex));
    }

    private String inputNameSurname(String message, String regex) {
        String personalData;

        do {
            personalData = scanner.nextLine();
            if (check(personalData, regex)) {
                return personalData;
            } else {
                view.printMessage(message);
            }

        } while (true);
    }

    private String insertName() {
        view.printMessage(NAME_INPUT_MESSAGE);

        return inputNameSurname(NAME_ERROR, defineRegexByLocal());
    }


    private String insertSurname() {
        view.printMessage(SURNAME_INPUT_MESSAGE);

        return inputNameSurname(SURNAME_ERROR, defineRegexByLocal());
    }

    private String insertLogin() {
        view.printMessage(NICKNAME_INPUT_MESSAGE);

        String login = inputNameSurname(NICKNAME_ERROR, NICKNAME_REGEX);
        try {
            RegisteredLogins.loginCheck(login);
        } catch (LoginDuplicateException e) {
            view.printMessage(LOGIN_EXISTS_MESSAGE);
            login = insertLogin();
        }
        return login;
    }
}
