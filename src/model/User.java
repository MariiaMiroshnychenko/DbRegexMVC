package model;

public class User {
    private String name;
    private String surname;
    private String login;

    @Override
    public String toString() {
        return "User name: " + getName() + "\n" +
                "User surname: " + getSurname() + "\n" +
                "User login: " + getLogin();
    }

    public User(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }

    private String getName() {
        return name;
    }

    private String getSurname() {
        return surname;
    }


    private String getLogin() {
        return login;
    }
}
