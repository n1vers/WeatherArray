package ee.ivkhkdev;

import java.util.Random;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private WeatherManager weatherManager = new WeatherManager();

    public void run() {
        boolean repeat = true;
        System.out.println("Программа прогноза погоды");
        System.out.println("-------------------------");

        weatherManager.generateYearlyTemperature();

        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Погода на указанную дату (с самой теплой и холодной погодой в году)");
            System.out.println("2. Средняя температура по месяцам");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();

            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Введите месяц (1-12): ");
                    int month = scanner.nextInt() - 1;
                    System.out.println("Введите день: ");
                    int day = scanner.nextInt() - 1;
                    weatherManager.printTemperatureForDate(month, day);
                    break;
                case 2:
                    weatherManager.printAverageMonthlyTemperature();
                    break;
                default:
                    System.out.println("Неверная задача");
                    break;
            }
        } while (repeat);

        System.out.println("До свидания! :)");
    }
}
