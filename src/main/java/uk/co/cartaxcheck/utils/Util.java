package uk.co.cartaxcheck.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static String readFileContent(String uri) throws IOException {
        Path file = Path.of(uri);
        return Files.readString(file);
    }

    public static List<String> getRegistrationNumbers(String text) {
        Pattern registrationNumberPattern = Pattern.compile("([A-Z]{2}[0-9]{2}\\s?[A-Z]{3})");
        Matcher matcher = registrationNumberPattern.matcher(text);

        List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }
}
