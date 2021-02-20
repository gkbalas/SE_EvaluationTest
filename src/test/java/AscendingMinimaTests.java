import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class AscendingMinimaTests {
    private AscendingMinima ascMinima;

    private static Stream<Arguments> ascMinimaTest() {
        return Stream.of(
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,3,2,5,8,7,8,9)),
                        new ArrayList<Integer>(Arrays.asList(1,2,5,7,8,9))),
                arguments(new ArrayList<Integer>(Arrays.asList(8,9,5,3,6,5,1,1,0)),
                        new ArrayList<Integer>(Arrays.asList(0))),
                arguments(new ArrayList<Integer>(Arrays.asList(7,4,8,6,3,4,2,1,2)),
                        new ArrayList<Integer>(Arrays.asList(1,2))),
                arguments(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)),
                        new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9))),
                arguments(new ArrayList<Integer>(Arrays.asList(9,8,7,6,5,4,3,2,1)),
                        new ArrayList<Integer>(Arrays.asList(1))),
                arguments(new ArrayList<Integer>(Arrays.asList(9,1,1,3,4,2,6,8,9)),
                        new ArrayList<Integer>(Arrays.asList(1,2,6,8,9)))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Ascending Minima Test")
    void ascMinimaTest(ArrayList<Integer> array, ArrayList<Integer> expectedOutput) {
        ascMinima = new AscendingMinima(array);
        assertEquals(expectedOutput, ascMinima.ascendingMinima(array));
    }

    private static Stream<Arguments> minimaInNewWindowTest() {
        return Stream.of(
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,2,5,8,7,8,9)),
                        6,
                        new ArrayList<Integer>(Arrays.asList(1,2,5,7,8,9)),
                        new ArrayList<Integer>(Arrays.asList(2,5,6))),
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,2,5,8,7,8,9)),
                        10,
                        new ArrayList<Integer>(Arrays.asList(1,2,5,7,8,9)),
                        new ArrayList<Integer>(Arrays.asList(2,5,7,8,9,10))),
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,2,5,8,7,8,9)),
                        0,
                        new ArrayList<Integer>(Arrays.asList(1,2,5,7,8,9)),
                        new ArrayList<Integer>(Arrays.asList(0)))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Minima In New Window Test")
    void minimaInNewWindowTest(
            ArrayList<Integer> prevWindow,
            int newElement,
            ArrayList<Integer> prevMinima,
            ArrayList<Integer> expectedOutput) {
        ascMinima = new AscendingMinima(prevWindow);
        assertEquals(expectedOutput, ascMinima.minimaInNewWindow(prevWindow, newElement, prevMinima));
    }

    private static Stream<Arguments> getAllMinimasTest() {
        return Stream.of(
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,2,5,8,7,8,9)),
                        3,
                        new ArrayList<ArrayList<Integer>>(Arrays.asList(
                                new ArrayList<Integer>(Arrays.asList(1,3)),
                                new ArrayList<Integer>(Arrays.asList(2)),
                                new ArrayList<Integer>(Arrays.asList(2,5)),
                                new ArrayList<Integer>(Arrays.asList(2,5,8)),
                                new ArrayList<Integer>(Arrays.asList(5,7)),
                                new ArrayList<Integer>(Arrays.asList(7,8)),
                                new ArrayList<Integer>(Arrays.asList(7,8,9))
                        ))),
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,2,5,8,7,8,9)),
                        4,
                        new ArrayList<ArrayList<Integer>>(Arrays.asList(
                                new ArrayList<Integer>(Arrays.asList(1,2)),
                                new ArrayList<Integer>(Arrays.asList(2,5)),
                                new ArrayList<Integer>(Arrays.asList(2,5,8)),
                                new ArrayList<Integer>(Arrays.asList(2,5,7)),
                                new ArrayList<Integer>(Arrays.asList(5,7,8)),
                                new ArrayList<Integer>(Arrays.asList(7,8,9))
                        ))),
                arguments(new ArrayList<Integer>(Arrays.asList(1,3,3,2,5,8,7,8,9)),
                        5,
                        new ArrayList<ArrayList<Integer>>(Arrays.asList(
                                new ArrayList<Integer>(Arrays.asList(1,2,5)),
                                new ArrayList<Integer>(Arrays.asList(2,5,8)),
                                new ArrayList<Integer>(Arrays.asList(2,5,7)),
                                new ArrayList<Integer>(Arrays.asList(2,5,7,8)),
                                new ArrayList<Integer>(Arrays.asList(5,7,8,9))
                        )))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Minima In New Window Test")
    void getAllMinimasTest(
            ArrayList<Integer> array,
            int window,
            ArrayList<ArrayList<Integer>> expectedOutput) {
        ascMinima = new AscendingMinima(array, window);
        assertEquals(expectedOutput, ascMinima.getAllMinimas());
    }
}
