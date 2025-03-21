import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {

        List<Integer> listMassaDados = new ArrayList<>(Arrays.asList(2, 8, 5, 3, 9, 4, 1));

        int tamanhoLista = listMassaDados.size();

        for (int i = 1; i < tamanhoLista; i++) {
            for (int j = 0; j < (tamanhoLista - 1); j++) {
                if (listMassaDados.get(j) > listMassaDados.get(j + 1)) {
                    Collections.swap(listMassaDados, j, j + 1);
                }
            }

        }
        System.out.println(listMassaDados);
    }
}
