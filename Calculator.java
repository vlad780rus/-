import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (пример: 1 + 2):");
        String input = scanner.nextLine();
        scanner.close();

        try {
            int result = calculate(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int calculate(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Неправильный формат выражения.");
        }

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        char operator = parts[1].charAt(0);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10.");
        }

        int result;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }

        return result;
    }
}