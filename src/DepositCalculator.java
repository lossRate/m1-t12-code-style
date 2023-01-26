import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double income = 0;
        if (action == 1) income = calculateSimplePercentFunction(amount, period);
        if (action == 2) income = calculateComplexPercentFunction(amount, period);

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    static double random(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }


    static double calculateSimplePercentFunction(double amount, int depositPeriod) {
        return random(amount + (amount * 0.06 * depositPeriod));
    }

    static double calculateComplexPercentFunction(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);
        return random(pay);
    }
}