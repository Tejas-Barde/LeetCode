import java.util.Scanner;

public class Main {
    static void PROCESS(long number, Scanner scanner) {
        String result;
        // tEJAS
        // Step 1: Ask to multiply by 9
        System.out.println("mul 9");
        System.out.flush();
        result = scanner.next();
        if (result.equals("-1")) return;

        // Step 2: Request a digit
        System.out.println("digit");
        System.out.flush();
        result = scanner.next();
        if (result.equals("-1")) return;

        // Step 3: Request another digit
        System.out.println("digit");
        System.out.flush();
        result = scanner.next();
        if (result.equals("-1")) return;

        System.out.println("add " + (number - 9));
        System.out.flush();
        result = scanner.next();
        if (result.equals("-1")) return;

        // Step 5: Finish
        System.out.println("!");
        System.out.flush();
        result = scanner.next();
        if (result.equals("-1")) return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long input_n = scanner.nextLong();
            PROCESS(input_n, scanner);
        }
    }
}
