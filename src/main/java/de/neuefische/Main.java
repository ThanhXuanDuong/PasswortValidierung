package de.neuefische;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("""
                            Passwort muss enthalten:\040
                            - 8 bis 20 Charakter
                            - mindestens 1 Zahl
                            - mindestens 1 große Buchstabe
                            - mindestens 1 von den Charakter !,§,$,%,&,/,=,?,*,#
                            - kein einfacher Passwort wie "password","123456","654321","abcdef"
                            Bitte Passwort eingeben:\040""");
        String password=scanner.nextLine();

        while (!isValidPassword(password)) {
            System.out.println("Ungültige Eingabe. Bitte erneut eingeben: ");
            password=scanner.nextLine();
        }

    }

    public static boolean checkValidLength(String password){
        char[] chars=password.toCharArray();
        return chars.length >= 8 && chars.length <= 20;
    }

    public static boolean containNumber(String password){
        char[] chars=password.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containUpperCaseLetter(String password){
        char[] chars=password.toCharArray();
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containBadPassword(String password){
        String[] badPasswords=new String[]{"password","123456","654321","abcdef"};
        int i=0;
        boolean result=false;
        while (!result && i<badPasswords.length) {
            result=password.contains(badPasswords[i]);
            i++;
        }
        return result;
    }

    public static boolean containSpecialCharacter(String password){
        String[] specialChars= {"!","§","$","%","&","/","(",")","=","?","*","#"};
        int i=0;
        boolean result=false;
        while (!result && i<specialChars.length) {
            result=password.contains(specialChars[i]);
            i++;
        }
        return result;
    }

    public static boolean isValidPassword(String password){
        return checkValidLength(password) && containNumber(password) &&
                containUpperCaseLetter(password) && containSpecialCharacter(password) &&
                !containBadPassword(password);
    }
}