package model.entity;

public enum RegisteredLogins {
    MARIIA("Mariia97"), MYKHAILO("Misha1278"), ARTEM("ArtemARTEM");

    private String login;

    RegisteredLogins(String login) {
        this.login = login;
    }

    public static boolean loginCheck(String loginToCheck) throws LoginDuplicateException{
        for (RegisteredLogins registeredLogin : RegisteredLogins.values()) {
            if (loginToCheck.equals(registeredLogin.login)) {
                throw new LoginDuplicateException();
            }
        }
        return true;
    }
}
