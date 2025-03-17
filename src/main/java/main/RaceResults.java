package main;

public interface RaceResults {
    void addResult(Driver driver, int position);
    Driver getDriverAtPosition(int position);
    String getRaceName();
    String getLocation();
}