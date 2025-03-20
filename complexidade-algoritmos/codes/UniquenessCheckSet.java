import java.util.*;

public class UniquenessCheckSet {
    public static void main(String[] args) {
        List<String> listaNomes = Arrays.asList("Jose", "João", "Maria", "Pedro", "Paula", "Jose");
        Set<String> setNomes = new HashSet<>();
        for (String elemento : listaNomes) { //  O laço for percorre listaNomes, que tem n elementos. Isso tem complexidade O(n).
            if (setNomes.contains(elemento)) {// HashSet usa uma tabela hash, onde a busca (contains) tem complexidade média O(1)
                System.out.println("Nome duplicado: " + elemento);

            } else {
                setNomes.add(elemento); //A inserção em um HashSet também tem complexidade média O(1).git
                System.out.println(elemento);
            }
        }
    }
}