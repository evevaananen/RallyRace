package main;

import java.util.HashMap;
import java.util.Map;

public class RallyRaceResults implements RaceResults {
    private String raceName;
    private String location;
    private Map<Integer, Driver> results;
    private static final int[] POINTS = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    public RallyRaceResults(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    @Override
    public void addResult(Driver driver, int position) {
        results.put(position, driver);
        
        if (position > 0 && position <= POINTS.length) {
            driver.addPoints(POINTS[position - 1]);
        }
    }

    @Override
    public Driver getDriverAtPosition(int position) {
        return results.get(position);
    }

    @Override
    public String getRaceName() {
        return raceName;
    }

    @Override
    public String getLocation() {
        return location;
    }
    
    public void displayResults() {
        System.out.println("Race: " + raceName + " (" + location + ")");
        for (int i = 1; i <= results.size(); i++) {
            Driver driver = results.get(i);
            if (driver != null) {
                int points = (i <= POINTS.length) ? POINTS[i - 1] : 0;
                System.out.println("Position " + i + ": " + driver.getName() + " - " + points + " points");
            }
        }
    }
}