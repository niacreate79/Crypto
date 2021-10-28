import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    // метод колирования сообщения
    public static String Encode(String str, String codeStr) {
        for (int i = 0; i < codeStr.length() / 2; i++) {
            char findChar = codeStr.charAt(i);
            char newChar = codeStr.charAt(codeStr.length() - 1 - i);
            str = str.replace(findChar, newChar);
        }
        return str;
    }

    // метод декодирования
    public static String Decode(String str, String codeStr) {
        for (int i = 0; i < codeStr.length() / 2; i++) {
            char findChar = codeStr.charAt(codeStr.length() - 1 - i);
            char newChar = codeStr.charAt(i);
            str = str.replace(findChar, newChar);
        }
        return str;
    }


    public static void main(String[] args) {
        // исходный текст сообщения
        String s = "шеф, все пропало! гипс снимают, клиент уезжает... "; // отрывок из к/ф "Брилиантовая рука"
        // ключ шифрования
        String codeKey = "ауоыиэяюеёбвгджзйклмнпрстфхцчшщьъы0123456789.:,!?auoie@#$%^&*bcdfghjklmnpqrstvwxyz()[]{}<>/;'`-+|~№";

        // получаем текущую дату и время
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY HH:mm:ss");
        // добавляем дату и время в конец сообщения
        s = s + dateFormat.format(calendar.getTime()).toString();

        System.out.println("Исходное сообщение: " + s);

        s = Encode(s, codeKey);
        System.out.println("Закодированное сообщение: " + s);

        s = Decode(s, codeKey);
        System.out.println("Декодировнное сообщение: " + s);
    }

}
