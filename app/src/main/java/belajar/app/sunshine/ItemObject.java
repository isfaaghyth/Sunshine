package belajar.app.sunshine;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by isfaaghyth on 12/11/16.
 */

public class ItemObject {
    public static class ListWeather {
        private String judul;

        public String getJudul() {
            return judul;
        }

        public ListWeather(String judul) {
            this.judul = judul;
        }

        @SerializedName("list")
        List<Test> list;

        public List<Test> getList() {
            return list;
        }

        public class Test {
            @SerializedName("temp")
            private Temperature temp;

            public Temperature getTemp() {
                return temp;
            }

            public class Temperature {
                @SerializedName("day")
                private String day;
                public String getDay() {
                    return day;
                }
            }
            @SerializedName("pressure")
            private String pressure;
            @SerializedName("humidity")
            private String humidity;

            public String getPressure() {
                return pressure;
            }

            public String getHumidity() {
                return humidity;
            }

            @SerializedName("weather")
            List<Weather> weather;

            public List<Weather> getWeather() {
                return weather;
            }

            public class Weather {
                @SerializedName("main")
                private String main;
                @SerializedName("description")
                private String description;
                @SerializedName("icon")
                private String icon;
                public String getMain() {
                    return main;
                }
                public String getDescription() {
                    return description;
                }
                public String getIcon() {
                    return icon;
                }
            }
        }
    }

    public static class CurrentWeather {
        @SerializedName("name")
        private String name;

        public String getName() {
            return name;
        }

        @SerializedName("weather")
        List<Weather> weather;

        public class Weather {
            @SerializedName("icon")
            private String icon;

            public String getIcon() {
                return icon;
            }
        }

        @SerializedName("main")
        private MainTemperature main;

        public MainTemperature getMain() {
            return main;
        }

        public class MainTemperature {
            @SerializedName("temp")
            private String temp;

            public String getTemp() {
                return temp;
            }
        }
    }
}
