package com.hm.coolweather.gson;

/**
 * Created by ThinkPad on 2017/11/14.
 */

public class AQI {
    public AQICity city;
    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
