package testing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        var writer = new FileWriter("test.txt", true);// true - дозаписываем, фалсе - перезапись
        writer.write("\n2 5 7");
        writer.write("\n2 5 7");
        writer.write("\n2 5 7");
        writer.write("\n2 5 7");
        writer.flush();

        var sc = new Scanner(new File("test.txt"));
        while (sc.hasNextLine()) {
           list.add(sc.nextLine());
        }
        sc.close();
        System.out.println(list);
    }
}
