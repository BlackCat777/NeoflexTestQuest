import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        String numberSystemIn = numberSystemIn();
        String numberIn = numberIn(Integer.parseInt(numberSystemIn));
        String numberSystemOut;
        String numberIn10NS;


        numberSystemOut = numberSystemOut();
        if (!numberSystemIn.equals(10))
            numberIn10NS = Integer.toString(convert10(numberIn, Integer.parseInt(numberSystemIn)));
        else numberIn10NS = numberIn;

        if (numberSystemOut.equals("1"))
            System.out.println("Ответ: " + convert2(numberIn10NS));
        else if (numberSystemOut.equals("2"))
            System.out.println("Ответ: " + convert8(numberIn10NS));
        else if (numberSystemOut.equals("3"))
            System.out.println("Ответ: " + numberIn10NS);
        else if (numberSystemOut.equals("4"))
            System.out.println("Ответ: " + convert16(numberIn10NS));
    }

    public static int convert10(String number, int ns) {
        int number10 = 0;
        char[] array = number.toCharArray();
        int degree = array.length - 1;
        for (char i : array) {
            number10 += Character.getNumericValue(i) * Math.pow(ns, degree);
            degree--;
        }
        return number10;
    }

    public static String convert16(String number) {
        return Integer.toHexString(Integer.parseInt(number));
    }

    public static String convert8(String number) {
        return Integer.toOctalString(Integer.parseInt(number));
    }

    public static String convert2(String number) {
        return Integer.toBinaryString(Integer.parseInt(number));
    }

    public static String numberSystemIn() throws IOException {
        BufferedReader readers = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите систему счисления вводимого числа: ");
        String numberSystemIn = readers.readLine();
        return numberSystemIn;
    }

    public static String numberIn(int numberSystem) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberIn;
        while (true) {
            System.out.println("Введите число от 0 до 10000, с учётом заданной системы счисления.");
            numberIn = reader.readLine();

            if (Integer.toString(numberSystem).equals("2")) {
                char[] array = numberIn.toCharArray();
                for (char i : array) {
                    if (i != '0' || i == '1') {
                        System.out.println("Введено число вне системы счисления. Введите число заново.");
                        numberIn = reader.readLine();
                        //continue;
                    }
                }
            } else if (Integer.toString(numberSystem).equals("3")) {
                char[] array = numberIn.toCharArray();
                for (char i : array) {
                    if (i != '0' || i != '1' || i != '2') {
                        System.out.println("Введено число вне системы счисления. Введите число заново:");
                        numberIn = reader.readLine();
                        continue;
                    }
                }
            } else if (Integer.toString(numberSystem).equals("8")) {
                char[] array = numberIn.toCharArray();
                for (char i : array) {
                    if (i == '9' || i == '8') {
                        System.out.println("Введено число вне системы счисления. Введите число заново.");
                        numberIn = reader.readLine();
                        continue;
                    }
                }
            }

            if (Integer.parseInt(numberIn) < 0 || Integer.parseInt(numberIn, numberSystem) > 10000) {
                System.out.println("Вы ввели слишком большое число, или число < 0");
                continue;
            } else
                break;
        }
        return numberIn;
    }

    public static String numberSystemOut() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberSystemOut;
        while (true) {
            System.out.println("Выберите систему счисления выводимого числа: \n 1 - двоичная" +
                    "\n 2 - восьмеричная \n 3 - десятичная \n 4 - шестнадцатеричная ");
            numberSystemOut = reader.readLine();
            if (numberSystemOut.equals("1") || numberSystemOut.equals("2") ||
                    numberSystemOut.equals("3") || numberSystemOut.equals("4")) break;
            else continue;
        }
        return numberSystemOut;
    }


}