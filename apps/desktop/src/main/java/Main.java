import ui.Gestore;
import utils.Fetcher;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader( System.getProperty("user.dir") + "/src/main/resources/key.txt"))) {
            String line = br.readLine();

            Fetcher fetcher = new Fetcher(line);
            Gestore frame = new Gestore(fetcher);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
