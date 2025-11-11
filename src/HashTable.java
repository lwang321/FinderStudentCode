import java.util.HashMap;

public class HashTable {
    // My hashtable uses an array to keep track of a map for hash -> key, and also has an associative array for hash -> value
    private String[] hashtable;
    private String[] valuetable;

    // Default table size is a big prime number less than 1000
    private static final int DEFAULT_TABLE_SIZE = 997;

    // Track number of elements in table and tablesize for alpha
    int count = 0;
    int tablesize = 997;

    // Setters and Getters
    public HashTable() {
        hashtable = new String[DEFAULT_TABLE_SIZE];
        valuetable = new String[DEFAULT_TABLE_SIZE];
    }

    public String getHash(int index){
        return hashtable[index];
    }

    public void setHash(int index, String value){
        hashtable[index] = value;
    }

    public String getValue(int index){
        return valuetable[index];
    }

    public void setValue(int index, String value){
        valuetable[index] = value;
    }

    public int getCount(){
        return count;
    }

    public void updateCount(){
        count++;
    }

    public int getTablesize(){
        return tablesize;
    }

    public void setTablesize(int n){
        tablesize = n;
    }

    // Resizing function: when this is called, each hash in the table is recalculated with the new tablesize (p-value in Horner's method) and the table is updated
    public void resizeMap(int size){
        String[] newhashtable = new String[size];
        String[] newvaluetable = new String[size];

        for(int i = 0; i < hashtable.length; i++){
            // Skip if there's nothing there
            if (hashtable[i] == null){
                continue;
            }

            // Grab key and value from original hashtable
            String key = hashtable[i];
            String value = valuetable[i];

            int keyhash = Finder.hashString(key, size);

            // Use linear probing to avoid collisions while finding true index in the table for each hash
            while (newhashtable[keyhash] != null) {
                keyhash++;
                if (keyhash >= size) {
                    keyhash = 0;
                }
            }

            // Set values for key and value in new tables
            newhashtable[keyhash] = key;
            newvaluetable[keyhash] = value;

        }

        hashtable = newhashtable;
        valuetable = newvaluetable;
    }
}
