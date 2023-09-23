package com.chongdong.ailiaoapp.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.chongdong.ailiaoapp.model.LatitudeAndLongitude;
import org.springframework.util.StringUtils;

import net.sf.json.JSONObject;

public class Distance {

 

    /**

     * 根据地址获得经纬度，把代码中的ak值更改为你自己的ak值

     */

    public static LatitudeAndLongitude getLngAndLat(String address) {

        LatitudeAndLongitude latAndLng = new LatitudeAndLongitude();
        String url = "http://api.tianditu.gov.cn/geocoder?ds=%7B'keyWord':'" + address + "'%7D&tk=" + "d2cf09c537083f2dc69ce8a44d874f48";
        //String url = "http://api.map.baidu.com/geocoding/v3/?address="+address+"&output=json&ak=PlhFWpA02aoURjAOpnWcRGqw7AI8EEyO";//GET请求
        String json = loadJSON(url);
        System.out.println(json);
        if (StringUtils.isEmpty(json))
        {
            return latAndLng;
        }

        int len = json.length();

        // 如果不是合法的json格式

        if (json.indexOf("{") != 0 || json.lastIndexOf("}") != len - 1) {
            return latAndLng;
        }

        JSONObject obj = JSONObject.fromObject(json);
        if (obj.get("status").toString().equals("0")) {
          
            double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
            System.out.println(lng+"1");

            double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");

            latAndLng.setLatitude(lat);

            latAndLng.setLongitude(lng);
           
        }
        
        return latAndLng;

    }

    public static String loadJSON(String url) {

        StringBuilder json = new StringBuilder();

        try {

            URL urlObj = new URL(url);

            URLConnection uc = urlObj.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));

            String inputLine = null;

            while ((inputLine = br.readLine()) != null) {

                json.append(inputLine);

            }

            br.close();

        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }

        return json.toString();

    }


    /**

     * 计算两点之间真实距离

     * @return 千米

     */

    public static double getDistance(String myRegion,String nearRegion) {
        LatitudeAndLongitude latAndLng = Distance.getLngAndLat(myRegion);
        LatitudeAndLongitude latAndLng2 = Distance.getLngAndLat(nearRegion);
        // 维度
        double lat1 = (Math.PI / 180) * latAndLng.getLatitude();
        double lat2 = (Math.PI / 180) * latAndLng2.getLatitude();

        // 经度
        double lon1 = (Math.PI / 180) * latAndLng.getLongitude();
        double lon2 = (Math.PI / 180) * latAndLng2.getLongitude();

        // 地球半径
        double R = 6371;
        
        // 两点间距离 km，如果想要米的话，结果*1000就可以了
        double d = Math.acos
        (Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;
        return d ;
    }

 

}
