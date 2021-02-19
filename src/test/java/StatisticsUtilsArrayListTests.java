import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StatisticsUtilsArrayListTests {
    private StatisticUtilsArrayList sUArrayList;

    private static Stream<Arguments> testGetMin() {
        return Stream.of(
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,3,2,5,8,7,8,9)),1),
                arguments(new ArrayList<Integer>(Arrays.asList(8,9,5,3,6,5,1,1,0)),0),
                arguments(new ArrayList<Integer>(Arrays.asList(10,30,30,30,20,50,80,70,80,90)),10),
                arguments(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0)),0),
                arguments(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1,1)),1)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get min test")
    public void testGetMin(ArrayList<Integer> doublesArray, double expectedOutput) {
        sUArrayList = new StatisticUtilsArrayList(doublesArray);
        assertEquals(expectedOutput, sUArrayList.getMin());
    }

    private static Stream<Arguments> testGetMax() {
        return Stream.of(
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,3,2,5,8,7,8,9)),9),
                arguments(new ArrayList<Integer>(Arrays.asList(8,9,5,3,6,5,1,1,0)),9),
                arguments(new ArrayList<Integer>(Arrays.asList(10,30,30,30,20,50,80,70,80,90)),90),
                arguments(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0)),0),
                arguments(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1,1)),1)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get max test")
    public void testGetMax(ArrayList<Integer> doublesArray, double expectedOutput) {
        sUArrayList = new StatisticUtilsArrayList(doublesArray);
        assertEquals(expectedOutput, sUArrayList.getMax());
    }

    private static Stream<Arguments> testGetMedian() {
        return Stream.of(
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,3,2,5,8,7,8,9)),4),
                arguments(new ArrayList<Integer>(Arrays.asList(8,9,5,3,6,5,1,1,0)),5),
                arguments(new ArrayList<Integer>(Arrays.asList(10,30,30,30,20,50,80,70,80,90)),40),
                arguments(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0)),0),
                arguments(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1,1)),1)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get median test")
    public void testGetMedian(ArrayList<Integer> doublesArray, double expectedOutput) {
        sUArrayList = new StatisticUtilsArrayList(doublesArray);
        assertEquals(expectedOutput, sUArrayList.getMedian());
    }

    private static Stream<Arguments> testGetMean() {
        return Stream.of(
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,3,2,5,8,7,8,9)),4.9),
                arguments(new ArrayList<Integer>(Arrays.asList(8,9,5,3,6,5,1,1,0)),4.222222222222222),
                arguments(new ArrayList<Integer>(Arrays.asList(10,30,30,30,20,50,80,70,80,90)),49),
                arguments(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0)),0),
                arguments(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1,1)),1)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get mean test")
    public void testGetMean(ArrayList<Integer> doublesArray, double expectedOutput) {
        sUArrayList = new StatisticUtilsArrayList(doublesArray);
        assertEquals(expectedOutput, sUArrayList.getMean());
    }

    private static Stream<Arguments> testGetSd() {
        return Stream.of(
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,3,2,5,8,7,8,9)),2.8848262031225076),
                arguments(new ArrayList<Integer>(Arrays.asList(8,9,5,3,6,5,1,1,0)),3.192874010111336),
                arguments(new ArrayList<Integer>(Arrays.asList(10,30,30,30,20,50,80,70,80,90)),28.848262031225072),
                arguments(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0)),0),
                arguments(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1,1)),0)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get sd test")
    public void testGetSd(ArrayList<Integer> doublesArray, double expectedOutput) {
        sUArrayList = new StatisticUtilsArrayList(doublesArray);
        assertEquals(expectedOutput, sUArrayList.getSd());
    }
}
