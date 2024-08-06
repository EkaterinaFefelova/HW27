import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Scanner;

public class Main {
    public static final String LOGIN_REGEX = "\\w{1,19}";
    public static final String PASSWORD_REGEX = "\\w{1,19}";

    public static void main(String[] args) throws Exception {
        //todo Тут протестить работу метода
        while (true) {
            try {
                System.out.println("Введите логин: ");
                String input = new Scanner(System.in).nextLine();
                System.out.println("Введите пароль: ");
                String password = new Scanner(System.in).nextLine();
                System.out.println("Повторите ввод пароля: ");
                String confirmedPassword = new Scanner(System.in).nextLine();

                System.out.println(confirmPassword(input, password, confirmedPassword));
            }
            catch (WrongLoginException | WrongPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean confirmPassword (String login, String password, String confirmedPassword) throws Exception {
            if (!login.matches(LOGIN_REGEX)) {
                throw new WrongLoginException("Логин не соответствует требованиям (длина меньше 20 символов," +
                        " содержит только латинские буквы, цифры и знак подчеркивания)");
            }
            if (!(password.matches(PASSWORD_REGEX))){
                throw new WrongPasswordException("Пароль не соответствует требованиям (длина меньше 20 символов," +
                        " содержит только латинские буквы, цифры и знак подчеркивания)");
            }
            return password.equals(confirmedPassword);
    }
}