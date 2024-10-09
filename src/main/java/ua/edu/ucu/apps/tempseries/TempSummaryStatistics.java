package ua.edu.ucu.apps.tempseries;

public class TempSummaryStatistics {

    private double maxTemp;
    private double devTemp;
    private double minTemp;
    private double avgTemp;

    public TempSummaryStatistics(double avg, 
    double dev, double min, double max) {
        this.avgTemp = avg;
        this.devTemp = dev;
        this.minTemp = min;
        this.maxTemp = max;
    }
    
}
