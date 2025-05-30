package utils;

import java.util.Random;

public class TestDataGenerator {

    private static final String[] CITY_PREFIXES = {
            "New", "Old", "Fort", "Lake", "Port", "San", "Santa"
    };
    private static final String[] CITY_SUFFIXES = {
            "ville", "town", "bury", "field", "ford", "berg", "ton", "grad", "polis"
    };
    private static final String[] CITY_BASES = {
            "Ash", "Green", "River", "Stone", "Oak", "Silver", "Maple", "Bright", "Clear"
    };

    private static final Random random = new Random();

    public static String generateRandomCityName() {
        String prefix = CITY_PREFIXES[random.nextInt(CITY_PREFIXES.length)];
        String base = CITY_BASES[random.nextInt(CITY_BASES.length)];
        String suffix = CITY_SUFFIXES[random.nextInt(CITY_SUFFIXES.length)];

        return prefix + base + suffix;
    }
}
