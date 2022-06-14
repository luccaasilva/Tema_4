package com.company;

public class Primos {
    public static int[] generadorPrimos(int max_num_p) {
        Primos primo = new Primos();
        int i, j;
        if (max_num_p >= 2) {
            int size = max_num_p + 1;
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
    public int countingPrimos(int size, boolean[] esPrimo) {
        int counting = 0;
        for (int i = 0; i < size; i++) {
            if (esPrimo[i]) {
                counting++;
            }
        }
        return counting;
    }
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
    public boolean[] startArray(int size, boolean[] esPrimo) {
        for (int i = 0; i < size; i++) {
            esPrimo[i] = true;
        }
        return esPrimo;
    }
}