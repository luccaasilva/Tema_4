package com.company;

public class Primos {
    /**
     * @param max el numero final
     * @return devuelve los numeros primos
     */
    public static int[] generadorPrimos(int max) {
        Primos primo = new Primos();
        int i, j;
        if (max >= 2) {
            int size = max + 1;
            boolean[] esPrimo = new boolean[size];
            esPrimo = primo.startArray(size, esPrimo);

            esPrimo[0] = esPrimo[1] = false;

            esPrimo = primo.criba(esPrimo, size);

            int counting = primo.countingPrimos(size, esPrimo);


            return primo.rellenarVPrimos(counting, size, esPrimo);
        } else {
            return new int[0];

        }
    }
    /**
     * @param size el tamaño del array
     * @param esPrimo te dice si es primo o no
     * @return return del numero de primos
     */
    public int countingPrimos(int size, boolean[] esPrimo) {
        int counting = 0;
        for (int i = 0; i < size; i++) {
            if (esPrimo[i]) {
                counting++;
            }
        }
        return counting;
    }
    /**
     * @param counting el numero de primos
     * @param size tamaño del array
     * @return return del array con los primos
     */
    public int[] rellenarVPrimos(int counting, int size, boolean[] esPrimo) {
        int[] primos = new int[counting];
        int i, j;
        for (i = 0, j = 0; i < size; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    public boolean[] criba(boolean[] esPrimo, int size) {
        for (int i = 2; i < Math.sqrt(size) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < size; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
        return esPrimo;
    }
    /**
     * @return asigna true a todos los numeros, como que todos los numeros son primos
     */
    public boolean[] startArray(int size, boolean[] esPrimo) {
        for (int i = 0; i < size; i++) {
            esPrimo[i] = true;
        }
        return esPrimo;
    }
}