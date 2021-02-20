import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class StatisticUtilsArrayStream {
    /**
     * StatisticsUtilsArray is a class for calculating some basic statistics parameters
     * in a double array
     */
    double[] doublesArray;

    public StatisticUtilsArrayStream(double[] doublesArray) {
        /**
         * @param doublesArray The array to find the statistics parameters
         *                     It must be double[]
         */
        this.doublesArray = doublesArray;
    }

    public double getMin() {
        /**
         * Find the minimum of the array
         * @return  The minimum of the array
         */
        return Arrays.stream(this.doublesArray).min().getAsDouble();
    }

    public double getMax() {
        /**
         * Find the maximum of the array
         * @return  The maximum of the array
         */
        return Arrays.stream(this.doublesArray).max().getAsDouble();
    }

    public double getMedian() {
        /**
         * Find the median of the array
         * @return  The median of the array
         */
        DoubleStream sortedArray = Arrays.stream(this.doublesArray).sorted();
        return this.doublesArray.length % 2 == 0?
                sortedArray.skip(this.doublesArray.length/2-1).limit(2).average().getAsDouble():
                sortedArray.skip(this.doublesArray.length/2).findFirst().getAsDouble();
    }

    public double getMean() {
        /**
         * Find the mean of the array
         * @return  The mean of the array
         */
        return Arrays.stream(this.doublesArray).average().getAsDouble();
    }

    public double getSd() {
        /**
         * Find the standard deviation of the array
         * @return  The standard deviation of the array
         */
        double mean = getMean();
        double sd = Arrays.stream(this.doublesArray)
                .map(s -> Math.pow(s - mean,2) / this.doublesArray.length)
                .sum();
        return Math.sqrt(sd);
    }

    public static void main(String[] args) {
        /**
         * A simple presentation of the class
         */
        double[] doublesArray = new double[7];
        for (int i = 0; i < 7; i++) {
            doublesArray[i] = i + 1;
        }
        StatisticUtilsArrayStream stats = new StatisticUtilsArrayStream(doublesArray);
        System.out.println(Arrays.toString(doublesArray));
        System.out.println("Max = " + stats.getMax());
        System.out.println("Min = " + stats.getMin());
        System.out.println("Mean = " + stats.getMean());
        System.out.println("Median = " + stats.getMedian());
        System.out.println("Standard Deviation = " + stats.getSd());
    }
}
