package view;

import model.User;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View implements StringConstants {
    public static ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
//                    new Locale("uk_UA"));
                      new Locale("en_GB"));        // English

    public void printMessage(String message) {
            System.out.println(changeEncoding(bundle.getString(message)));
    }

    public void printUserPersonalData(User user) {
        System.out.println(user);
    }

    public String changeEncoding(String message) {
        try {
            return new String(message.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return e.getMessage();
        }

    }
}
