import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение в формате \"строка\" операция число:");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Некорректный формат выражения. Введите строку в кавычках, операцию (+, -, *, /), и число.");
            }

            String str = parts[0];
            String operation = parts[1];
            int num = Integer.parseInt(parts[2]);

            if (str.length() > 10) {
                throw new IllegalArgumentException("Длина входной строки должна быть не более 10 символов.");
            }

            String result = calculate(str, operation, num);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    public static String calculate(String str, String operation, int num) {
        if (operation.equals("+")) {
            return str + num;
        } else if (operation.equals("-")) {
            if (str.contains(String.valueOf(num))) {
                return str.replace(String.valueOf(num), "");
            } else {
                return str;
            }
        } else if (operation.equals("*")) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < num; i++) {
                result.append(str);
            }
            return formatResultString(result.toString());
        } else if (operation.equals("/")) {
            int length = str.length() / num;
            if (length > 40) {
                return formatResultString(str.substring(0, 40) + "...");
            } else {
                return formatResultString(str.substring(0, length));
            }
        }
        return "";
    }

    public static String formatResultString(String input) {
        // Additional formatting can be added here if needed
        return input;
    }
}
