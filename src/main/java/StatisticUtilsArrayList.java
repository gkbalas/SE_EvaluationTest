import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.ArrayList;

public class StatisticUtilsArrayList {
    /**
     * StatisticsUtilsArrayList is a class for calculating some basic statistics parameters
     * in an ArrayList
     */
    double min;
    double max;
    double median;
    double mean;
    double sd;
    DescriptiveStatistics stats;

    public StatisticUtilsArrayList(ArrayList<? extends Integer> doublesArrayList) {
        /**
         * @param doublesArrayList The array to find the statistics parameters
         *                         It must be ArrayList
         */
        double[] doublesArray = new double[doublesArrayList.size()];
        for (int i = 0; i < doublesArrayList.size(); i++)
            doublesArray[i] = doublesArrayList.get(i);
        this.stats = new DescriptiveStatistics(doublesArray);
    }

    public double getMin() {
        /**
         * Find the minimum of the array
         * @return  The minimum of the array
         */
        this.min = this.stats.getMin();
        return this.min;
    }

    public double getMax() {
        /**
         * Find the maximum of the array
         * @return  The maximum of the array
         */
        this.max = this.stats.getMax();
        return this.max;
    }

    public double getMedian() {
        /**
         * Find the median of the array
         * @return  The median of the array
         */
        this.median = this.stats.getPercentile(50);
        return this.median;
    }

    public double getMean() {
        /**
         * Find the mean of the array
         * @return  The mean of the array
         */
        this.mean = this.stats.getMean();
        return this.mean;
    }

    public double getSd() {
        /**
         * Find the standard deviation of the array
         * @return  The standard deviation of the array
         */
        this.sd = this.stats.getStandardDeviation();
        return this.sd;
    }

    public static void main(String[] args) {
        /**
         * A simple presentation of the class
         */
        ArrayList<Integer> doublesArray = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            doublesArray.add(i+1);
        }
        StatisticUtilsArrayList stats = new StatisticUtilsArrayList(doublesArray);
        System.out.println(doublesArray);
        System.out.println("Max = " + stats.getMax());
        System.out.println("Min = " + stats.getMin());
        System.out.println("Mean = " + stats.getMean());
        System.out.println("Median = " + stats.getMedian());
        System.out.println("Standard Deviation = " + stats.getSd());
    }
}
