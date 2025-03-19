import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Jose", "João", "Maria", "Pedro", "Paula", "Marcelo");
        String youNeedToFind = "Marcelo";
        boolean nameWasFound = false;

        for (String name : namesList) {         // When Marcelo is in the first place it is the best case O(1)
                                                // When Marcelo is in the last place it is the worst case O(n)

            if (name.equalsIgnoreCase(youNeedToFind)) {
                nameWasFound = true;
                break;
            }
        }

        if (nameWasFound) {
            System.out.println("Usuário foi encontrado.");
        } else {
            System.out.println("Usuário não foi encontrado.");
        }
    }
}