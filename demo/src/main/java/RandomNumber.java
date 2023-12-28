import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumber {
    private Random random;

    public RandomNumber() {
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt();
    }

    public int getRandomNumberInRange(int range) {
        return random.nextInt(range + 1);
    }

    public int getRandomNumberInRange(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public int[] getNDifferentValues(int n) {
        Set<Integer> uniqueValues = new HashSet<>();
        while (uniqueValues.size() < n) {
            uniqueValues.add(random.nextInt());
        }
        return uniqueValues.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getNDifferentValuesInRange(int n, int range) {
        Set<Integer> uniqueValues = new HashSet<>();
        while (uniqueValues.size() < n) {
            uniqueValues.add(random.nextInt(range + 1));
        }
        return uniqueValues.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getNDifferentValuesInRange(int n, int min, int max) {
        Set<Integer> uniqueValues = new HashSet<>();
        while (uniqueValues.size() < n) {
            uniqueValues.add(random.nextInt(max - min + 1) + min);
        }
        return uniqueValues.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();

        // Returning a random number
        System.out.println("Random number: " + randomNumber.getRandomNumber());

        // Returning a random value within [0, range]
        int range = 10;
        System.out.println("Random number within [0, " + range + "]: " + randomNumber.getRandomNumberInRange(range));

        // Returning a random number within [min, max]
        int min = 5;
        int max = 15;
        System.out.println("Random number within [" + min + ", " + max + "]: " + randomNumber.getRandomNumberInRange(min, max));

        // Returning n different values
        int n = 5;
        int[] differentValues = randomNumber.getNDifferentValues(n);
        System.out.println("n different values:");
        for (int value : differentValues) {
            System.out.println(value);
        }

        // Returning n different values within [0, range]
        System.out.println("n different values within [0, " + range + "]:");
        differentValues = randomNumber.getNDifferentValuesInRange(n, range);
        for (int value : differentValues) {
            System.out.println(value);
        }

        // Returning n different values within [min, max]
        System.out.println("n different values within [" + min + ", " + max + "]:");
        differentValues = randomNumber.getNDifferentValuesInRange(n, min, max);
        for (int value : differentValues) {
            System.out.println(value);
        }
    }
}