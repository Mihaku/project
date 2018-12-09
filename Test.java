package NewExample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.parse(new File("pogoda.html"), "UTF-8");
//        Document doc = Jsoup.parse(new URL("https://yandex.ru/pogoda/saint-petersburg"), 5000);

        //        Document doc1 = Jsoup.parse(0)
        Elements table = doc.getElementsByClass("forecast-briefly-old__days"); //работает, выводит таблицу

        //вывод дня недели
        String dayOfWeek = table.select(".forecast-briefly-old__name").text();

        //вывод даты
        String dateOfWeek = table.select(".forecast-briefly-old__date").text();

        //вывод температуры, выводится температура днем и ночью
        String tempOfWeek = table.select(".temp__value").text();

        //разбиение строк на массив строк
        String[] days = dayOfWeek.split(" ");
        String[] dates = dateOfWeek.split("\\. ");
        String[] temps = tempOfWeek.split(" ");

        System.out.println("Яндекс погода:");
        System.out.print("День недели:\t");
        for (String day : days) {
            System.out.print(day + "\t\t");
        }
        System.out.println();

        System.out.print("Дата:\t\t");
        for (String date : dates) {
            System.out.print("\t" + date);
        }
        System.out.println();

        System.out.print("День:\t\t\t");
        for (int i = 0; i < temps.length; i++) {
            if (i % 2 == 0) {
                System.out.print(temps[i] + "\t\t");
            }
        }
        System.out.println();

        System.out.print("Ночь:\t\t\t");
        for (int i = 1; i < temps.length; i++) {
            if (i % 2 != 0) {
                System.out.print(temps[i] + "\t\t");
            }
        }
    }
}
