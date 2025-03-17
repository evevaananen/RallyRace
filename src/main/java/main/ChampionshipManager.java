package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResults> races;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;
    
    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }
    
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }
    
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }
    
    public void addRace(RallyRaceResults race) {
        races.add(race);
        totalRaces++;
    }
    
    public List<Driver> getDrivers() {
        return new ArrayList<>(drivers);
    }
    
    public List<RallyRaceResults> getRaces() {
        return new ArrayList<>(races);
    }
    
    public static int getTotalDrivers() {
        return totalDrivers;
    }
    
    public static int getTotalRaces() {
        return totalRaces;
    }
    
    public List<Driver> getStandings() {
        List<Driver> standings = new ArrayList<>(drivers);
        Collections.sort(standings, new Comparator<Driver>() {
            @Override
            public int compare(Driver d1, Driver d2) {
                return d2.getPoints() - d1.getPoints();
            }
        });
        return standings;
    }
    
    public Driver getLeader() {
        if (drivers.isEmpty()) return null;
        
        Driver leader = drivers.get(0);
        for (Driver driver : drivers) {
            if (driver.getPoints() > leader.getPoints()) {
                leader = driver;
            }
        }
        return leader;
    }
    
    public void displayStandings() {
        List<Driver> standings = getStandings();
        for (int i = 0; i < standings.size(); i++) {
            System.out.println((i + 1) + ". " + standings.get(i));
        }
    }
    
    public void displayStatistics() {
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + getTotalDrivers());
        System.out.println("Total Races: " + getTotalRaces());
        System.out.printf("Average Points Per Driver: %.2f%n", ChampionshipStats.calculateAveragePoints(drivers));
        System.out.println("Most Successful Country: " + ChampionshipStats.findMostSuccessfulCountry(drivers));
        System.out.println("Total Championship Points: " + ChampionshipStats.calculateTotalPoints(drivers));
    }
}