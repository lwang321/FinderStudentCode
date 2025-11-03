import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
    private TST table;

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        table = new TST();

        String line;

        while ((line = br.readLine()) != null) {
//            System.out.println(line);
            String[] splitted =  line.split(",");

            String key = splitted[keyCol];
            String value = splitted[valCol];
            table.insert(key, value);
        }


        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        String ans = table.lookup(key);
        if (ans != null) {
            return table.lookup(key);
        }
        else {
            return INVALID;
        }
    }
}