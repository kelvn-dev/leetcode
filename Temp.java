import java.io.*;

public class Temp {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./text.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    }
}
