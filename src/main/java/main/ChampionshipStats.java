package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStats {
    
    public static double calculateAveragePoints(List<Driver> drivers) {
        if (drivers.isEmpty()) return 0.0;
        
        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }
        
        return (double) totalPoints / drivers.size();
    }
    
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        if (drivers.isEmpty()) return "No countries";
        
        Map<String, Integer> countryPoints = new HashMap<>();
        
        for (Driver driver : drivers) {
            String country = driver.getCountry();
            countryPoints.put(country, countryPoints.getOrDefault(country, 0) + driver.getPoints());
        }
        
        String mostSuccessful = "";
        int highestPoints = -1;
        
        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {
            if (entry.getValue() > highestPoints) {
                highestPoints = entry.getValue();
                mostSuccessful = entry.getKey();
            }
        }
        
        return mostSuccessful;
    }
    
    public static int calculateTotalPoints(List<Driver> drivers) {
        int total = 0;
        for (Driver driver : drivers) {
            total += driver.getPoints();
        }
        return total;
    }
}