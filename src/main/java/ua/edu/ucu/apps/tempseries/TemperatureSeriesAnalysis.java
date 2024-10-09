package ua.edu.ucu.apps.tempseries;

import java.util.ArrayList;
import java.util.Arrays;



public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (temperatureSeries == null) {
            throw new IllegalArgumentException("Temperature series cannot be null");
        }

        for (double temp : temperatureSeries) {
            if (temp < -273) {
                throw new IllegalArgumentException("Temperature series contains values below absolute zero (-273°C)");
            }
        }

        this.temperatureSeries = temperatureSeries;
    }

    public double average() {
        if (this.temperatureSeries == null) {
            throw new IllegalArgumentException("Temperature series cannot be null");
        }
        if (this.temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series cannot be empty");
        }
        double sum = 0;
        for (double temp : this.temperatureSeries) {
            sum += temp;
        }
        return sum / this.temperatureSeries.length;
    }

    public double deviation() {
        if (this.temperatureSeries == null) {
            throw new IllegalArgumentException("Temperature series cannot be null");
        }
        double deviation = 0;
        for (double temp : this.temperatureSeries) {
            double average = this.average();

            deviation += Math.pow(temp - average, 2);

        }
        
        return Math.sqrt(deviation / temperatureSeries.length);
    }

    public double min() {
        if (this.temperatureSeries == null) {
            throw new IllegalArgumentException("Temperature series cannot be null");
        }
        double minValue = this.temperatureSeries[0];
        for (double temp : this.temperatureSeries){
            if (minValue >= temp){
                minValue = temp;
            }
        }
        return minValue;
    }

    public double max() {
        if (this.temperatureSeries == null) {
            throw new IllegalArgumentException("Temperature series cannot be null");
        }
        double maxValue = this.temperatureSeries[0];
        for (double temp : this.temperatureSeries){
            if (maxValue <= temp){
                maxValue = temp;
            }
        }
        return maxValue;
    }

    public double findTempClosestToZero() {
        if (this.temperatureSeries == null) {
            throw new IllegalArgumentException("Temperature series cannot be null");
        }
        double minValue = Math.abs(this.temperatureSeries[0]);
        for (double temp : this.temperatureSeries){
            temp= Math.abs(temp);
            if (minValue >= temp){
                minValue = temp;
            }
        }
    
        return minValue;
    }

    public double findTempClosestToValue(double tempValue) {
        if (this.temperatureSeries == null) {
            throw new IllegalArgumentException("Temperature series cannot be null");
        }
        double tempClosestToValue = this.temperatureSeries[0];
        double difference = Math.abs(tempValue - this.temperatureSeries[0]);
        for (double temp : this.temperatureSeries){
            
            if (difference >=  Math.abs(tempValue - temp)){
                difference =  Math.abs(tempValue - temp);
                tempClosestToValue = temp;
            }
        }
    
        return tempClosestToValue;
    }

    public double[] findTempsLessThen(double tempValue) {

        int count = 0;
        for (double temp : this.temperatureSeries) {
            if (temp < tempValue) {
                count++;
            }
        }
    

        double[] resultArray = new double[count];
        int index = 0;
        for (double temp : this.temperatureSeries) {
            if (temp < tempValue) {
                resultArray[index] = temp;
                index++;
            }
        }
    
        return resultArray; 
    }

    public double[] findTempsGreaterThen(double tempValue) {
       
        int count = 0;
        for (double temp : this.temperatureSeries){
            
            if (temp > tempValue){
                count++;
            }
        }
        
        double[] resultArray = new double[count];
        int index = 0;
        for (double temp : this.temperatureSeries) {
            if (temp > tempValue) {
                resultArray[index] = temp;
                index++;
            }
        }

        return resultArray; 
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        int count = 0;
        
        for (double temp : this.temperatureSeries){
            
            if (temp > lowerBound && temp < upperBound){
                count++;
            }
        }
        
        double[] resultArray = new double[count];
        int index = 0;
        for (double temp : this.temperatureSeries){
            
            if (temp > lowerBound && temp < upperBound){
                resultArray[index] = temp;
                index++;
            }
        }

        return resultArray; 
    }

    public void reset() {
        this.temperatureSeries = new double[0];
    }
    public double[] sortTemps() {
        double[] sortedArray = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }


    public int addTemps(double... temps) {
        if (temps == null || temps.length == 0) {
            return temperatureSeries.length;
        }

        int requiredSize = temperatureSeries.length + temps.length;
        if (requiredSize > temperatureSeries.length) {
            double[] newArray = new double[Math.max(temperatureSeries.length * 2, requiredSize)];
            System.arraycopy(temperatureSeries, 0, newArray, 0, temperatureSeries.length);
            temperatureSeries = newArray;
        }


        for (int i = 0; i < temps.length; i++) {
            temperatureSeries[temperatureSeries.length - temps.length + i] = temps[i];
        }

        return temperatureSeries.length;
    }
}
