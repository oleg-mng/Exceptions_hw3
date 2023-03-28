import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
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
 *
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
    public static void main(String[] args) throws IOException {
        inputString();
    }
    public static void inputString() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваши данные в виде: Фамилия Имя Отчество датарождения номертелефона пол");

        String k = null;
        try {
            k = in.next();
            System.out.println("Вам удалось ввести валидные данные: " + k);
        } catch (InputMismatchException e) {
            System.out.println("Введите корректное дробное число типа float");
            inputString();
        }
        finally {
            FileWriter writer = new FileWriter("data.csv");
            writer.write(k);
        }

        in.close();
    }
}

