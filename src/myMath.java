public class myMath {
    public static int random(int min, int max) {
        double randomValue = Math.random() * (max - min) + min;
        return (int)randomValue;
    }
}