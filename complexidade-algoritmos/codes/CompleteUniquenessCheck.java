import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

public class CompleteUniquenessCheck {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Jose", 20),
                new Person("João", 21),
                new Person("Maria", 37),            // Exemplo de Duplicidade
                new Person("Pedro", 25),
                new Person("Paula", 25),
                new Person("Marcelo", 54),
                new Person("Maria", 37)             // Exemplo de Duplicidade
        );

        Hashtable<String, Person> hashTable = new Hashtable<>();
        int duplicated = 0;

        for (Person person : personList) {                          // O(n)
            String key = person.getName().toLowerCase();
            if (hashTable.containsKey(key)) {                       // Time Complexity of HashMap.containsKey() is O(1) in Average Case, and O(n) in worst case.
                duplicated++;
            } else {
                hashTable.put(key, person);
            }
        }

        if (duplicated > 0) {
            System.out.println("Tem " + duplicated + " duplicados");
        } else {
            System.out.println("Não tem duplicados");
        }
    }
}
