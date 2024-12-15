public class myMath { // Definicja klasy myMath
    public static int random(int min, int max) { // definicja metody random, która przyjmuje dwie wartości o typie int
        double randomValue = Math.random() * (max - min) + min; // Wbudowany sposób na losowanie liczby
        return (int)randomValue; // Ucięcie wartości po przecinku, przez co wartość double staje sie int'em
    }
}