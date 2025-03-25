import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> listaNum = new ArrayList<>(Arrays.asList(2, 8, 5, 3, 9, 4, 1));
        int n = listaNum.size();

        // Selection Sort O(n²)
        for (int i = 0; i < n - 1; i++) {
            int indiceDoMenorNumero = i;

            for (int a = i + 1; a < n; a++) {
                if (listaNum.get(indiceDoMenorNumero) > listaNum.get(a)) {
                    indiceDoMenorNumero = a;
                }
            }

            if (indiceDoMenorNumero != i) {
                Collections.swap(listaNum, i, indiceDoMenorNumero);
            }
        }

        System.out.println(listaNum);
    }
}