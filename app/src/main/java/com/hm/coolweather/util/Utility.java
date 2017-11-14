package com.hm.coolweather.util;

import android.text.TextUtils;

import com.google.gson.JsonArray;
import com.hm.coolweather.db.City;
import com.hm.coolweather.db.County;
import com.hm.coolweather.db.Provice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ThinkPad on 2017/11/14.
 */

public class Utility {
    public static boolean handleProvinceResponse(String responseText) {
        if (!TextUtils.isEmpty(responseText)) {
            try {
                JSONArray allProvinces = new JSONArray(responseText);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObj = allProvinces.getJSONObject(i);
                    Provice province = new Provice();
                    province.setProvinceName(provinceObj.getString("name"));
                    province.setProviceCode(provinceObj.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handlerCityResponse(String responseText, int id) {
        if (!TextUtils.isEmpty(responseText)) {
            try {
                JSONArray allCities = new JSONArray(responseText);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObj = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityObj.getInt("id"));
                    city.setCityName(cityObj.getString("name"));
                    city.setProviceId(id);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handlerCountyResponse(String responseText, int id) {
        if (!TextUtils.isEmpty(responseText)) {
            try {
                JSONArray allCounties = new JSONArray(responseText);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObj = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCityId(id);
                    county.setCountyName(countyObj.getString("name"));
                    county.setWeatherId("weather_id");
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
