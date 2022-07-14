import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        int number1 = 0; // первая переменная для оаперации
        int number2 = 0; // вторая переменная для операции
        int romanToArab1 = 0; // переменная для перевода из римских в арабские для первого значения
        int romanToArab2 = 0; // переменная для перевода из римских в арабские для второго значения
        int result;
        System.out.println("Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.");
        System.out.println("Числа должны быть от 1 до 10 включительно. Оба числа должны быть либо римскими либо арабскими.");
        System.out.println("Доступные операции: Сложение (+), Вычитание (-), Умножение(*) и деление (/)");
        while (true) {
            Scanner in = new Scanner(System.in);
            String my = in.nextLine(); // строка ввода

            String newMy1 = my.replaceAll(" ", "");//убираем пробелы, чтобы читал ввод с пробелами и без
            String newMy = newMy1.replaceAll("[^A-Za-zА-Яа-я0-9]", ",");//заменяем операцию на зпт
            String[] myArray = newMy.split(",");// делим строку на подстроки и заносим в массив
            String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            List<String> romanList = Arrays.asList(roman);
            List<String> arabList = Arrays.asList(arab);

            if (myArray.length != 2) { //если больше или меньше двух значений выводим ошибку
                System.err.println("Ошибка: калькулятор производит операции только с двумя числами");
                break;
            }

            if (romanList.contains(myArray[0]) && romanList.contains(myArray[1])) {
                for (int i = 1; i <= roman.length; i = i + 1) { //цикл для поиска первого значения
                    if (myArray[0].equals(roman[i - 1])) {
                        romanToArab1 = i;
                    }
                }
                for (int i = 1; i <= roman.length; i = i + 1) { //цикл для поиска второго значения
                    if (myArray[1].equals(roman[i - 1])) {
                        romanToArab2 = i;
                    }

                }

            } else if (arabList.contains(myArray[0]) && arabList.contains(myArray[1])) {
                for (int i = 1; i <= arab.length; i++) { //цикл для поиска первого значения
                    if (myArray[0].equals(arab[i - 1])) {
                        number1 = Integer.parseInt(myArray[0]);
                    }
                }
                for (int i = 1; i <= arab.length; i++) { //цикл для поиска второго значения
                    if (myArray[1].equals(arab[i - 1])) {
                       number2 = Integer.parseInt(myArray[1]);
                    }
                }
            } else {
                System.err.println("Ошибка: Оба числа должны быть либо римскими либо арабскими, в интервале от 1 до 10 (включительно)");
                break;
            }
            char action; //переменная для определения операции
            action = 0;

            for (int i = 0; i < my.length(); i++) { //определяем операцию
                if (my.charAt(i) == '+' || my.charAt(i) == '-' || my.charAt(i) == '*' || my.charAt(i) == '/') {
                    action = my.charAt(i);
                }

            }
            if ((romanToArab1 > 0 && romanToArab2 >0) && (romanToArab1 - romanToArab2) >= 0){
                number1 = romanToArab1;
                number2 = romanToArab2;
            } else if ((romanToArab1 - romanToArab2) < 0) {
                System.err.println("Ошибка: в римской системе нет отрицательных чисел");
                break;
            }


            switch (action) {
                case '+' -> {
                    result = number1 + number2;
                    System.out.println(result);
                }
                case '-' -> {
                    result = number1 - number2;
                    System.out.println(result);
                }
                case '*' -> {
                    result = number1 * number2;
                    System.out.println(result);
                }
                case '/' -> {
                    result = number1 / number2;
                    System.out.println(result);
                }
                default ->
                        System.err.println("Ошибка: Неправильный ввод операции. Доступные арифметические операции: +, -, /,*"); //выводим исключение если введён непредусмотренный оператор
            }
        }
    }
}