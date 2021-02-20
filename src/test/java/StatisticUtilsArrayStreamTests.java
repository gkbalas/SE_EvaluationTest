import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StatisticUtilsArrayStreamTests {
    private StatisticUtilsArrayStream sUArray;

    private static Stream<Arguments> testGetMin() {
        return Stream.of(
                arguments(new double[]{1,3,3,3,2,5,8,7,8,9},1),
                arguments(new double[]{8,9,5,3,6,5,1,1,0},0),
                arguments(new double[]{10,30,30,30,20,50,80,70,80,90},10),
                arguments(new double[]{0,0,0,0,0,0,0,0},0),
                arguments(new double[]{1,1,1,1,1,1,1,1},1)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get min test")
    public void testGetMin(double[] doublesArray, double expectedOutput) {
        sUArray = new StatisticUtilsArrayStream(doublesArray);
        assertEquals(expectedOutput, sUArray.getMin());
    }

    private static Stream<Arguments> testGetMax() {
        return Stream.of(
                arguments(new double[]{1,3,3,3,2,5,8,7,8,9},9),
                arguments(new double[]{8,9,5,3,6,5,1,1,0},9),
                arguments(new double[]{10,30,30,30,20,50,80,70,80,90},90),
                arguments(new double[]{0,0,0,0,0,0,0,0},0),
                arguments(new double[]{1,1,1,1,1,1,1,1},1)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get max test")
    public void testGetMax(double[] doublesArray, double expectedOutput) {
        sUArray = new StatisticUtilsArrayStream(doublesArray);
        assertEquals(expectedOutput, sUArray.getMax());
    }

    private static Stream<Arguments> testGetMedian() {
        return Stream.of(
                arguments(new double[]{1,3,3,3,2,5,8,7,8,9},4),
                arguments(new double[]{8,9,5,3,6,5,1,1,0},5),
                arguments(new double[]{10,30,30,30,20,50,80,70,80,90},40),
                arguments(new double[]{0,0,0,0,0,0,0,0},0),
                arguments(new double[]{1,1,1,1,1,1,1,1},1)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get median test")
    public void testGetMedian(double[] doublesArray, double expectedOutput) {
        sUArray = new StatisticUtilsArrayStream(doublesArray);
        assertEquals(expectedOutput, sUArray.getMedian());
    }

    private static Stream<Arguments> testGetMean() {
        return Stream.of(
                arguments(new double[]{1,3,3,3,2,5,8,7,8,9},4.9),
                arguments(new double[]{8,9,5,3,6,5,1,1,0},4.222222222222222),
                arguments(new double[]{10,30,30,30,20,50,80,70,80,90},49.0),
                arguments(new double[]{0,0,0,0,0,0,0,0},0),
                arguments(new double[]{1,1,1,1,1,1,1,1},1)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get mean test")
    public void testGetMean(double[] doublesArray, double expectedOutput) {
        sUArray = new StatisticUtilsArrayStream(doublesArray);
        assertEquals(expectedOutput, sUArray.getMean());
    }

    private static Stream<Arguments> testGetSd() {
        return Stream.of(
                arguments(new double[]{1,3,3,3,2,5,8,7,8,9},2.7367864366808017),
                arguments(new double[]{8,9,5,3,6,5,1,1,0},3.010270485365348),
                arguments(new double[]{10,30,30,30,20,50,80,70,80,90},27.367864366808018),
                arguments(new double[]{0,0,0,0,0,0,0,0},0),
                arguments(new double[]{1,1,1,1,1,1,1,1},0)

        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Get sd test")
    public void testGetSd(double[] doublesArray, double expectedOutput) {
        sUArray = new StatisticUtilsArrayStream(doublesArray);
        assertEquals(expectedOutput, sUArray.getSd());
    }
}