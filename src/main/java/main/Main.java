package main;

public class Main {
    public static void main(String[] args) {
        // Get championship manager instance
        ChampionshipManager manager = ChampionshipManager.getInstance();
        
        // Create cars
        GravelCar gravelCar1 = new GravelCar("Toyota", "Yaris WRC", 380, 7.5, 28);
        GravelCar gravelCar2 = new GravelCar("Hyundai", "i20 WRC", 375, 7.2, 30);
        AsphaltCar asphaltCar1 = new AsphaltCar("Ford", "Puma Rally1", 385, 5.8, 62);
        AsphaltCar asphaltCar2 = new AsphaltCar("Toyota", "GR Yaris Rally1", 390, 5.9, 65);
        
        // Create and register drivers
        Driver driver1 = new Driver("Sébastien Ogier", "France", gravelCar1);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", gravelCar2);
        Driver driver3 = new Driver("Ott Tänak", "Estonia", asphaltCar1);
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", asphaltCar2);
        
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);
        
        // Create first race
        RallyRaceResults finlandRally = new RallyRaceResults("Rally Finland", "Jyväskylä");
        finlandRally.addResult(driver1, 1);
        finlandRally.addResult(driver3, 2);
        finlandRally.addResult(driver2, 3);
        finlandRally.addResult(driver4, 4);
        
        manager.addRace(finlandRally);
        
        // Switch cars for next race
        driver1.setCar(asphaltCar2);
        driver4.setCar(gravelCar1);
        
        // Create second race
        RallyRaceResults monteCarloRally = new RallyRaceResults("Monte Carlo Rally", "Monaco");
        monteCarloRally.addResult(driver2, 1);
        monteCarloRally.addResult(driver4, 2);
        monteCarloRally.addResult(driver1, 3);
        monteCarloRally.addResult(driver3, 4);
        
        manager.addRace(monteCarloRally);
        
        // Display championship standings
        manager.displayStandings();
        
        // Display championship leader
        System.out.println("===== CHAMPIONSHIP LEADER =====");
        Driver leader = manager.getLeader();
        System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        
        // Display championship statistics
        manager.displayStatistics();
        
        // Display race results
        System.out.println("===== RACE RESULTS =====");
        for (RallyRaceResults race : manager.getRaces()) {
            race.displayResults();
        }
        
        // Display car performance ratings
        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar1.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar1.calculatePerformance());
    }
}