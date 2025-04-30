
package homeworks.hw4.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
    private static final String fileName = "vocabulary.txt";

    public static Map<String, String> readFromFile() {
        try {
            File file = getFile();

            if (!file.exists()) {
                return new HashMap<>();
            }

            try (Stream<String> lines = Files.lines(file.toPath())) {
                return lines
                        .map(line -> line.split(",", 2))
                        .filter(parts -> parts.length == 2)
                        .collect(Collectors.toMap(
                                parts -> parts[0],
                                parts -> parts[1],
                                (existing, replacement) -> existing
                        ));
            }
        }
        catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            return new HashMap<>();
        }
    }

    public static void writeToFile(String content) {
        try {
            File file = getFile();

            if (!file.exists()) {
                file.createNewFile();
            }

            if (isInFile(content)) {
                System.out.println("You've already added this translation to the file!");
                return;
            }

            Files.write(file.toPath(), (content + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static boolean isInFile(String content) {
        try {
            File file = getFile();

            if (!file.exists()) {
                return false;
            }

            try (Stream<String> lines = Files.lines(file.toPath())) {
                return lines.anyMatch(line -> line.equals(content));
            }
        }
        catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    private static String getExecutingPath() {
        return FileUtil.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath();
    }

    private static File getFile() {
        String executingPath = getExecutingPath();

        File jarDir = new File(executingPath).getParentFile();

        return new File(jarDir, fileName);
    }
}