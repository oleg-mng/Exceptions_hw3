import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.getProperty;

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
        //System.out.println("success, - данные успешно сохранены в db");
    }

    public static void inputString() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваши данные в виде: Фамилия Имя Отчество датарождения номертелефона пол");

        String line = in.nextLine();
        String[] dt = line.split(" ");
        if (dt[0].isEmpty()) System.out.println("первый элемент пустой");
        try {
            if (dt[0].isEmpty() || dt[1].isEmpty() || dt[2].isEmpty() || dt[3].isEmpty() || dt[4].isEmpty()
                    || dt[5].isEmpty()) throw new IndexOutOfBoundsException();
            if (dt.length > 6) throw new NegativeArraySizeException();
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("введено 6 значений");
//            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Введены пустые элементы");
//            inputString();
            return;
        } catch (NegativeArraySizeException e) {
            System.out.println("введено более 6-ти значений");
//            inputString();
            return;
        }catch (NoSuchElementException e){
            System.out.println();
        }


        String sur = (dt[0]);
        String name = (dt[1]);
        String surN = (dt[2]);
        String born = (dt[3]); // 12.05.1987
        String tel = (dt[4]);
        String gender = (dt[5]);
        String f = "f";
        String m = "m";

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        try {
            Date docDate = format.parse(born);
        } catch (ParseException e) {
            System.out.println("введите дату рождения в формате \"dd.MM.yyyy\"");
//            inputString();
            return;
        }

        try {
            if (born.length() < 10 || born.length() > 10)
                throw new IllegalAccessException();

            if (tel.length() < 10 || tel.length() > 10)
                throw new RuntimeException();

            if (gender.length() != 1 || !gender.equals(f) && !gender.equals(m))
                throw new InvalidPropertiesFormatException("введены неверные данные по полу");
//            if (sur.isEmpty() || name.isEmpty() || surN.isEmpty() || born.isEmpty() || tel.isEmpty()
//                    || gender.isEmpty()) throw new ArrayIndexOutOfBoundsException();

//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Введите 6 верных аргументов");
//            inputString();
        }catch (NoSuchElementException e){
                System.out.println();

        } catch (RuntimeException e) {
            System.out.println("введите корректно номер телефона 10 цифр подряд, - например 9267004070");
//            inputString();
            return;

        } catch (IllegalAccessException e) {
            System.out.println("введите корректно дату рождения, например 11.11.2000");
//            inputString();
            return;

        } catch (InvalidPropertiesFormatException e) {
            System.out.println("Введите верные данные для gender: один символ f или m");
//            inputString();
            return;
        }
//            FileWriter writer = null;
//            try {
//                writer = new FileWriter("data.csv");
//                writer.write(sur + " " + name + " " + surN + " " + born + " " + tel + " " + gender);
//                writer.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
            File file = new File("dbList.csv");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                String lineSeparator = getProperty("line.separator");
                writer.write(sur + " " + name + " " + surN + " " + born + " " + tel + " " + gender + lineSeparator);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
//            try {
//                writer.write(sur + " " + name + " " + surN + " " + born + " " + tel + " " + gender);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                writer.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

        in.close();
        System.out.println("success, - данные успешно сохранены в db");
    }
}


