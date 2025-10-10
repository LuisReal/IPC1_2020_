package practica2;

public class Ordenador {

    /*public void ordenarQuicksort(int[] array) {

        array = quicksort1(array);

    }*/

    public int[] quicksort1(int[] array) {

        return quicksort2(array, 0, array.length - 1);

    }

    public int[] quicksort2(int[] array, int izq, int der) {

        if (izq >= der) {

            return array;

        }

        int i = izq, d = der;

        if (izq != der) {

            int pivote;
            int aux;
            pivote = izq;

            while (izq != der) {

                while (array[der] >= array[pivote] && izq < der) {

                    der--;
                }
                while (array[izq] < array[pivote] && izq < der) {

                    izq++;

                }

                if (der != izq) {

                    aux = array[der];
                    array[der] = array[izq];
                    array[izq] = aux;

                }

                if (izq == der) {

                    quicksort2(array, i, izq - 1);
                    quicksort2(array, izq + 1, d);
                }

            }
        } else {

            return array;
        }

        return array;
    }// fin del metodo quicksort2

}
