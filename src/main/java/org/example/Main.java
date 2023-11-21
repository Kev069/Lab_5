package org.example;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String secret1 = "<div>\n" +
                "<p>Символи <> круглих дужок <code>'('</code> та <code>')'</code>. <br />Ці символи\n" +
                "дозволяють отримати з рядка додаткову інформацію.\n" +
                "<br/>Зазвичай, якщо парсер регулярних виразів шукає в тексті інформацію\n" +
                "за заданим виразом і знаходить її - він просто повертає\n" +
                "знайдений рядок.</p>\n" +
                "<p align=\"right\">А ось тут <a href=\"google.com\">посилання</a>, щоб життя медом не здавалося.</p>\n" +
                "</div>";
        String secret2 = "(+380)68-872-15-14";
        String secret3 = "+1-555-12343";
        String secret4 = "Я не                хочу    бути         програмістом, а хочу     бути DevOps :)";

        Pattern pattern1 = Pattern.compile("\\(\\+380\\)\\d{2}-\\d{3}-\\d{2}-\\d{2}");
        mysteryFunction(pattern1, secret2);
        mysteryFunction(pattern1, secret3);

        String secret5 = "\\s{2,}";
        String secret6 = secret4.replaceAll(secret5, " ");
        System.out.println("\nText cleaned of unnecessary spaces: " + secret6);

        String secret7 = "(<[^>]+>|<+>)";
        String secret8 = secret1.replaceAll(secret7, "");
        System.out.println("\nText cleaned of HTML tags: " + secret8);
    }
    public static void mysteryFunction(Pattern pattern, String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            System.out.println("Number is valid, pattern matched: " + text);
        } else {
            System.out.println("Number is invalid, pattern not matched: " + text);
        }
    }
}
