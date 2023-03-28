import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.WriteAbortedException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

/**
 * Урок 3. Продвинутая работа с исключениями в Java
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
 * разделенные пробелом:
 * Фамилия Имя Отчество датарождения номертелефона пол
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * дата_рождения - строка формата dd.mm.yyyy
 * номер_телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * <p>
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
 * вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных,
 * чем требуется.
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
 * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать
 * встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено
 * сообщение с информацией, что именно неверно.
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку
 * должны записаться полученные данные, вида
 * <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
 * пользователь должен увидеть стектрейс ошибки.
 */

public class Program {
    public static void main(String[] args) {
        inputString();
    }

    public static void inputString() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваши данные в виде: Фамилия Имя Отчество датарождения номертелефона пол");

//        try {
//            int element = sc.nextInt();
//            System.out.println("Element in the given index is :: "+myArray[element]);
//        } catch(ArrayIndexOutOfBoundsException e) {
//            System.out.println("The index you have entered is invalid");
//            System.out.println("Please enter an index number between 0 and 6");
//        }
        String line = in.nextLine();
        String[] dt = line.split(" ");
        if (dt[0].isEmpty()) System.out.println("пусто");
        try {
            if (dt[0].isEmpty() || dt[1].isEmpty() || dt[2].isEmpty() || dt[3].isEmpty() || dt[4].isEmpty() || dt[5].isEmpty())
                throw new ArrayIndexOutOfBoundsException();
            }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("введены нулевые значения");
            inputString();
        }

//            try {
//                if (line.isEmpty() || dt[0].isEmpty() || dt[1].isEmpty() || dt[0].length() == 0 || dt[1].length() == 0)
//                    throw new ArrayIndexOutOfBoundsException();
//    }catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("Переделай");
//            }

        String sur = (dt[0]);
        String name = (dt[1]);
        String surN = (dt[2]);
        String born = (dt[3]);
        String tel = (dt[4]);
        String gender = (dt[5]);
        String f = "f";
        String m = "m";

        try {

            if (tel.length() < 10 || tel.length() > 10)
                throw new RuntimeException();

            if (sur.length() < 1 || name.length() < 1 || surN == null || born == null || tel == null || gender == null)
                throw new ArrayIndexOutOfBoundsException();

            if (gender.length() != 1 || !gender.equals(f) && !gender.equals(m))
                throw new InvalidPropertiesFormatException("введены неверные данные по полу");

        } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Введите 6 верных аргументов");

        } catch (RuntimeException e) {
            System.out.println("введите корректно номер телефона 10 цифр подряд, - например 9267004070");
            inputString();

        } catch (InvalidPropertiesFormatException e) {
            System.out.println("Введите верные данные для gender: один символ f или m");
            inputString();
        }

        System.out.println(sur + " " + name + " " + surN + " " + born + " " + tel + " " + gender +
                " - данные успешно сохранены");
        in.close();

//        String k = null;
//        try {
//            k = in.next();
//            System.out.println("Вам удалось ввести валидные данные: " + k);
//        } catch (InputMismatchException e) {
//            System.out.println("Введите корректное дробное число типа float");
//            inputString();
//        }
//        finally {
//            FileWriter writer = new FileWriter("data.csv");
//            writer.write(k);
//            writer.close();
//        }
//
//        in.close();
    }
}


