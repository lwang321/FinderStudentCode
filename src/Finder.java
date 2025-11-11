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

    // Radix 256 for extended ASCII
    private static final int Radix = 256;
    public HashTable Map;

    // String hashing function using Horner's method using tablesize as p-value
    public static int hashString(String sequence, int tablesize) {
        int hash = 0;
        for (int i = 0; i < sequence.length(); i++) {
            hash = (hash * Radix + sequence.charAt(i)) % tablesize;
        }
        return hash;
    }
    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        Map = new HashTable();

        // Alpha keeps track of how full table is (as a decimal)
        float alpha;

        String line;

        while ((line = br.readLine()) != null) {

            // Table is resized to twice the size + 1 once it gets half full
            // Use 2*size+1 instead of 2*size to minimize collisions
            alpha = (float) Map.getCount() / Map.getTablesize();
            if (alpha >= 0.5) {
                int newSize = 2 * Map.getTablesize() + 1;
                Map.resizeMap(newSize);
                Map.setTablesize(newSize);
            }

            String[] splitted =  line.split(",");

            String key = splitted[keyCol];
            String value = splitted[valCol];

            int keyhash = hashString(key, Map.getTablesize());

            // Once we calculate the hash, use linear probing to avoid collisions
            while (Map.getHash(keyhash) != null) {
                keyhash++;
                // Wrap around if keyhash gets out of range, faster than modulus
                if (keyhash >= Map.getTablesize()){
                    keyhash = 0;
                }
            }

            Map.setHash(keyhash, key);
            Map.setValue(keyhash, value);

            // Update the count of elements in table
            Map.updateCount();

        }

        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!

        int keyhash = hashString(key, Map.getTablesize());

        int i = 0;

        // Use linear probing to find true position of key in table (avoid collisions)
        while (i < Map.getTablesize()) {
            int index = (keyhash + i) % Map.getTablesize();

            // Null means the element doesn't exist in the table, so return invalid
            if (Map.getHash(index) == null) {
                return INVALID;
            }

            // If hash is found in the hash table, return the value at the same position in the value table
            if (Map.getHash(index).equals(key)) {
                return Map.getValue(index);
            }

            i++;
        }
        return INVALID;
    }
}