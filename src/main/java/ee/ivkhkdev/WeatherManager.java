package ee.ivkhkdev;

import java.util.Random;

public class WeatherManager {
    private Temperature[][] temperatures = new Temperature[12][];
    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private Random random = new Random();


    public void generateYearlyTemperature() {
        for (int month = 0; month < 12; month++) {
            temperatures[month] = new Temperature[daysInMonth[month]];
            for (int day = 0; day < daysInMonth[month]; day++) {
                int temp = generateTemperatureForMonth(month);
                temperatures[month][day] = new Temperature(month, day, temp);
            }
        }
    }


    private int generateTemperatureForMonth(int month) {
        if (month >= 2 && month <= 4) {
            return random.nextInt(16) + 5;
        } else if (month >= 5 && month <= 7) {
            return random.nextInt(16) + 20;
        } else if (month >= 8 && month <= 10) {
            return random.nextInt(16) + 5;
        } else {
            return random.nextInt(21) - 15;
        }
    }


    public void TemperatureForDate(int month, int day) {
        if (month >= 0 && month < 12 && day >= 0 && day < daysInMonth[month]) {
            System.out.println("Температура на " + (month + 1) + "/" + (day + 1) + ": " + temperatures[month][day].getTemperature() + "°C");
            MonthlyTemperatures();

            WarmestAndColdestDays();
        } else {
            System.out.println("Некорректная дата.");
        }
    }
    public void MonthlyTemperatures() {
        System.out.printf("%-10s","");
        for (int day = 0; day < 31; day++) {
            System.out.printf("%-6d", day + 1);
        }
        System.out.println();


        for (int month = 0; month < 12; month++) {
            System.out.printf("%-10s", getMonthName(month));
            for (int day = 0; day < 31; day++) {
                if (day < daysInMonth[month]) {
                    System.out.printf("%-6d", temperatures[month][day].getTemperature());
                } else {
                    System.out.printf("%-6s", " ");
                }
            }
            System.out.println();
        }
    }

    public void WarmestAndColdestDays() {
        Temperature warmest = temperatures[0][0];
        Temperature coldest = temperatures[0][0];

        for (int month = 0; month < 12; month++) {
            for (int day = 0; day < daysInMonth[month]; day++) {
                if (temperatures[month][day].getTemperature() > warmest.getTemperature()) {
                    warmest = temperatures[month][day];
                }
                if (temperatures[month][day].getTemperature() < coldest.getTemperature()) {
                    coldest = temperatures[month][day];
                }
            }
        }

        System.out.println("Самая теплая погода была " + warmest.getDate() + ": " + warmest.getTemperature() + "°C");
        System.out.println("Самая холодная погода была " + coldest.getDate() + ": " + coldest.getTemperature() + "°C");
    }


    public void AverageMonthlyTemperature() {
        for (int month = 0; month < 12; month++) {
            int sum = 0;
            for (int day = 0; day < daysInMonth[month]; day++) {
                sum += temperatures[month][day].getTemperature();
            }
            double averageTemp = (double) sum / daysInMonth[month];
            System.out.printf("Средняя температура в месяце %d: %.2f°C\n", month + 1, averageTemp);
        }
    }

    private String getMonthName(int month) {
        String[] monthNames = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return monthNames[month];
    }
}