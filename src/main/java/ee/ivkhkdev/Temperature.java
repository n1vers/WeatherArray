package ee.ivkhkdev;

public class Temperature {
        private int month;
        private int day;
        private int temperature;

        public Temperature(int month, int day, int temperature) {
            this.month = month;
            this.day = day;
            this.temperature = temperature;
        }

        public int getTemperature() {
            return temperature;
        }

        public String getDate() {
            return (month + 1) + "/" + (day + 1);
        }

}
