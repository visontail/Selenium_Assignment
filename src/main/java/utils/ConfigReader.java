package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = new FileInputStream("src/test/java/config/config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
