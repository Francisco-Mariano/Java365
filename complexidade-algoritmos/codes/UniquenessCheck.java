import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class UniquenessCheck {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList( "Jose", "João", "Maria", "Pedro", "Paula", "Marcelo" );

        Hashtable<String, Integer> hashTable = new Hashtable<>();
        int duplicated = 0;

        for (String name : namesList) {                 // O(n)
            String key = name.toLowerCase();
            if (hashTable.containsKey(key)) {           // Time Complexity of HashMap.containsKey() is O(1) in Average Case, and O(n) in worst case.
                duplicated++;
            } else {
                hashTable.put(key, 0);
            }
        }

        if (duplicated>0) {
            System.out.println("Tem " + duplicated + " Duplicados");
        } else {
            System.out.println("Não tem Duplicados");
        }
    }
}