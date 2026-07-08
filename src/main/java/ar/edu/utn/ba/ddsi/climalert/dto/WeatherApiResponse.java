package ar.edu.utn.ba.ddsi.climalert.dto;

public class WeatherApiResponse {
    private Current current;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public static class Current {
        private Double temp_c;
        private Double humidity;

        public Double getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(Double temp_c) {
            this.temp_c = temp_c;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }
    }
}