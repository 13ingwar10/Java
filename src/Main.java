import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        solveFirstTask();
        solveSecondTask();
        solveThirdTask();
        solveFourthTask();
    }

    public static void solveFirstTask() {
        System.out.println("Задача 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)");

        System.out.println("Введите число n:");
        int n = scanner.nextInt();

        int sum = 0; // пеменная для хранения итоговой суммы
        int fact = 1; // переменная для хранения итогового факториала

        for (int i = 1; i <= n; i++) {
            sum += i;
            fact *= i;
        }

        System.out.printf("Сумма чисел от 1 до n равна %d \n", sum);
        System.out.printf("Факториал числа n равен %d \n", fact);
        System.out.println("\n");
    }

    public static void solveSecondTask() {
        System.out.println("Задача 2. Вывести все простые числа от 1 до 1000");

        int n = 1000;
        int counter = 0; // вспомогательный счетчик для цикла
        int total = 4; // счетчик выведенных чисел для переноса строки, не знаю как сделать лучше
        int[] array = {2, 3, 5, 7}; // массив простых чисел от 0 до 10 берем по умолчанию и сразу выводим

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        for (int i = 8; i <= n; i++) { //перебираем числа по порядку до n, если не разделилось ни на одно число из массива array - выводим
            counter = 0;
            for (int j = 0; j < array.length; j++) {
                if (i % array[j] == 0) {
                    continue;
                } else {
                    counter++;
                }

                if (counter == array.length) { // если не разделилось ни на одно число из array, counter равен длинне array - число выводим
                    System.out.print(i + " ");
                    total++;
                }
            }
            if (total % 10 == 0 && total != 0) { // механизм переноса строки, если дошло до 10 - переносим строку
                System.out.println("");
                total = 0;
            }
        }
        System.out.println("\n");
    }

    public static void solveThirdTask() {
        System.out.println("Задача 3. Реализовать простой калькулятор");

        System.out.println("Введите число X: ");
        int X = scanner.nextInt();

        String[] operaitons = {"+", "-", "*", "/"}; // массив операций для проверки ввода от пользователя
        String op = "";
        boolean check = false;
        int result = 0;

        while (check == false) {
            System.out.println("Укажите операцию (+  -  *  /)");
            op = scanner.next();

            for (int i = 0; i < operaitons.length; i++) {   // проверка ввода от пользователя
                if(operaitons[i].equals(op)){
                    check = true;
                }
            }
        }

        System.out.println("Введите число Y: ");
        int Y = scanner.nextInt();

        switch (op) {
            case ("+"):
                result = X + Y;
                System.out.printf("Результат сложения = %d", result);
                break;
            case ("-"):
                result = X - Y;
                System.out.printf("Результат вычитания = %d", result);
                break;
            case ("*"):
                result = X * Y;
                System.out.printf("Результат умножения = %d", result);
                break;
            case ("/"):
                result = X / Y;
                System.out.printf("Результат деления = %d", result);
                break;
        }
        System.out.println("\n");
    }

    public static void solveFourthTask() {
        System.out.println("Задано уравнение вида q + w = e, q, w, e >= 0. Требуется восстановить выражение до верного равенства.");

        // q + w = e

        int q = 0;
        int x = 0;
        int e = 0;
        boolean check = false;             // проверка нашлось ли решение

        String user_q = "";                // то что получаем от пользователя
        String user_x = "";
        String user_e = "";

        String converted_q = "";           // то что получаем после замены "?" на число
        String converted_x = "";
        String converted_e = "";

        System.out.println("Введите зашифрованное число Q: ");
        user_q = scanner.next();

        System.out.println("Введите зашифрованное число X: ");
        user_x = scanner.next();

        System.out.println("Введите зашифрованное число E: ");
        user_e = scanner.next();

        System.out.printf("Поиск решения для выражения: %s + %s = %s\n", user_q, user_x, user_e);

        for(int i = 0; i < 10; i++) {                        // перебираем по очереди [0; 10) подставляя вместо "?"

            if(user_q.indexOf("?") == -1) {
                q = Integer.parseInt(user_q);
            } else {
                converted_q = user_q.replace('?', (char)(i+48));
                q = Integer.parseInt(converted_q);
            }

            if(user_x.indexOf("?") == -1) {
                x = Integer.parseInt(user_x);
            } else {
                converted_x = user_x.replace('?', (char)(i+48));
                x = Integer.parseInt(converted_x);
            }

            if(user_e.indexOf("?") == -1) {
                e = Integer.parseInt(user_e);
            } else {
                converted_e = user_e.replace('?', (char)(i+48));
                e = Integer.parseInt(converted_e);
            }

            if (q + x == e) {
                System.out.printf("Найдено решение n = %d\n", i);
                check = true;
            }
        }

        if (check == false) {
            System.out.println("Для заданного выражения не найдено решений");
        }
    }
}