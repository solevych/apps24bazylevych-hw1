package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void test() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

   @Test
   public void testAverageWithOneElementArray() {
       // setup input data and expected result
       double[] temperatureSeries = {-1.0};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = -1.0;

       // call tested method
       double actualResult = seriesAnalysis.average();

       // compare expected result with actual result
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testAverageWithEmptyArray() {
       double[] temperatureSeries = {};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

       // expect exception here
       seriesAnalysis.average();
   }

   @Test
   public void testAverage() {
       double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = 1.0;

       double actualResult = seriesAnalysis.average();

       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
public void testDeviationWithSingleElement() {
    double[] temperatureSeries = {10.0};
    TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    double expResult = 0.0; // Досвід показує, що стандартне відхилення є 0, якщо лише одне значення

    double actualResult = seriesAnalysis.deviation();
    assertEquals(expResult, actualResult, 0.00001);
}



@Test
public void testMinWithMultipleElements() {
    double[] temperatureSeries = {1.0, 2.0, -5.0, 4.0};
    TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    double expResult = -5.0;

    double actualResult = seriesAnalysis.min();
    assertEquals(expResult, actualResult, 0.00001);
}

@Test
public void testMaxWithMultipleElements() {
    double[] temperatureSeries = {1.0, 2.0, -5.0, 4.0};
    TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    double expResult = 4.0;

    double actualResult = seriesAnalysis.max();
    assertEquals(expResult, actualResult, 0.00001);
}

@Test
public void testFindTempsLessThan() {
    double[] temperatureSeries = {1.0, 2.0, 3.0, 4.0, 5.0};
    TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    double[] expResult = {1.0, 2.0, 3.0}; // Значення менше 4.0

    double[] actualResult = seriesAnalysis.findTempsLessThen(4.0);
    assertArrayEquals(expResult, actualResult, 0.00001);
}

@Test
public void testFindTempsGreaterThan() {
    double[] temperatureSeries = {1.0, 2.0, 3.0, 4.0, 5.0};
    TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    double[] expResult = {4.0, 5.0}; // Значення більше 3.0

    double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
    assertArrayEquals(expResult, actualResult, 0.00001);
}

@Test
public void testFindTempsInRange() {
    double[] temperatureSeries = {1.0, 2.0, 3.0, 4.0, 5.0};
    TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    double[] expResult = {2.0, 3.0, 4.0}; // Значення між 1.5 і 4.5

    double[] actualResult = seriesAnalysis.findTempsInRange(1.5, 4.5);
    assertArrayEquals(expResult, actualResult, 0.00001);
}


   
    

}
