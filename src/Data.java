import java.util.PrimitiveIterator;
import java.util.Stack;

public class Data {
    private final static String LOGIN = "ABCDEFGHIJKLMNOPQRSTYVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
    private final static String PASSWORD = "ABCDEFGHIJKLMNOPQRSTYVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";


    public static boolean startLogin(String login,
                                     String password,
                                     String confirmPassword)
             {
        try {
            login(login, password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println("пароли не совпадают");
            return false;
        } catch (IllegalAccessException e) {
            System.out.println("Некорректный логин или пароль");
            return false;
        }
        return true;
    }

    private static void login(String login,
                             String password,
                             String confirmPassword) throws WrongPasswordException, IllegalAccessException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают ");
        }
        if (!checkLogic(login) || !checkLogic(password) || !checkLogic(confirmPassword)) {
            throw new IllegalAccessException("Некорректный логин или пароль");

        }else {
            System.out.println("Добро пожаловать");

        }
    }

    private static boolean checkLogic(String s) {

        if (s.length() < 1 || s.length() > 20) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!LOGIN.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }

        }
        return true;
    }

}
