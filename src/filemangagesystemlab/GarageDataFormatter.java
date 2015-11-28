/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemangagesystemlab;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Matthew_2
 */
public class GarageDataFormatter implements DataFormatStrategy {
//G:\College\WCTC\Semester 3\Advanced Java\Class 23\FileMangageSystemLab\src\GarageData.txt
    /*
        add exception handing
        for instance, the encode method will throw a error if there is to many more spaces (arrayoutofbounds error)
    */
   
    @Override
    public List<Map<String, String>> decode(String garageData) {

        List<Map<String, String>> newDataFormat = new ArrayList<>();

        String hours;
        String fee;
        String[] lines = garageData.split("\n");
        for (int i = 0; i < lines.length; i++) {
            Map<String, String> garageDataMap = new LinkedHashMap<>();
            String[] parts = lines[i].split(" ");
            hours = parts[0];
            fee = parts[1];
            garageDataMap.put("hours", hours);
            garageDataMap.put("fee", fee);
            newDataFormat.add(garageDataMap);
        }

        return newDataFormat;
    }

    @Override
    public String encode(List<Map<String, String>> records) {
        String garageData = "";
        for (int i = 0; i < records.size(); i++) {
            Map<String, String> singleRecord = records.get(i);
            String hours = records.get(i).get("hours");
            String fee = records.get(i).get("fee");
            garageData += hours + " " + fee + "\n";

        }

        return garageData;
    }

    public static void main(String[] args) {
        GarageDataFormatter gdf = new GarageDataFormatter();
        List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();

        listOfMaps = gdf.decode("23.3 70.5\n30.4 80.4");

        String someVariable = gdf.encode(listOfMaps);

        listOfMaps = gdf.decode(someVariable);
        System.out.println(listOfMaps);
    }

}
