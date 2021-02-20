import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class StatisticUtilsArrayListStream {
    /**
     * StatisticsUtilsArray is a class for calculating some basic statistics parameters
     * in a double array
     */
    ArrayList<? extends Integer> doublesArray;

    public StatisticUtilsArrayListStream(ArrayList<? extends Integer> doublesArrayList) {
        /**
         * @param doublesArray The array to find the statistics parameters
         *                     It must be double[]
         */
        this.doublesArray = doublesArrayList;
    }

    public double getMin() {
        /**
         * Find the minimum of the array
         * @return  The minimum of the array
         */
        return this.doublesArray.stream().min(Integer::compare).get();
    }

    public double getMax() {
        /**
         * Find the maximum of the array
         * @return  The maximum of the array
         */
        return this.doublesArray.stream().max(Integer::compare).get();
    }

    public double getMedian() {
        /**
         * Find the median of the array
         * @return  The median of the array
         */
        DoubleStream sortedArray = this.doublesArray.stream().mapToDouble(Integer::doubleValue).sorted();
        return this.doublesArray.size() % 2 == 0?
                sortedArray.skip(this.doublesArray.size()/2-1).limit(2).average().getAsDouble():
                sortedArray.skip(this.doublesArray.size()/2).findFirst().getAsDouble();
    }

    public double getMean() {
        /**
         * Find the mean of the array
         * @return  The mean of the array
         */
        return this.doublesArray.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
    }

    public double getSd() {
        /**
         * Find the standard deviation of the array
         * @return  The standard deviation of the array
         */
        double mean = getMean();
        double sd = this.doublesArray.stream()
                .mapToDouble(s -> Math.pow(s - mean,2) / this.doublesArray.size())
                .sum();
        return Math.sqrt(sd);
    }

    public static void main(String[] args) {
        /**
         * A simple presentation of the class
         */
        ArrayList<Integer> doublesArray = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            doublesArray.add(i+1);
        }
        StatisticUtilsArrayListStream stats = new StatisticUtilsArrayListStream(doublesArray);
        System.out.println(doublesArray);
        System.out.println("Max = " + stats.getMax());
        System.out.println("Min = " + stats.getMin());
        System.out.println("Mean = " + stats.getMean());
        System.out.println("Median = " + stats.getMedian());
        System.out.println("Standard Deviation = " + stats.getSd());
    }
}

