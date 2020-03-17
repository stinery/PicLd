import java.io.File;
import java.time.LocalDateTime;

public class tidtesting {
    public static void main(String[] args) {
        String s = "2020:03:08 21:00:11";
        String[] g = s.split("[ :]");
        LocalDateTime jau = LocalDateTime.of(Integer.parseInt(g[0]), Integer.parseInt(g[1]), Integer.parseInt(g[2]), Integer.parseInt(g[3])
        , Integer.parseInt(g[4]), Integer.parseInt(g[5]));
        File file = new File("C:/Users/olelo/OneDrive/Bilder/Kamerabilder/WIN_20200308_21_00_11_Pro.jpg");
        System.out.println(file.lastModified());

    }
}