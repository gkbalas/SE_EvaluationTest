import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AscendingMinima {
    /**
     * AscendingMinima class implements the ascending minima algorithm in rolling window.
     * It has two features
     *      - The ascending minima algorithm itself
     *      - The ascending minima algorithm in rolling window
     *
     * @param array the array that will be used in the algorithm, it is is an ArrayList of Integers
     * @param k     the number of elements in array to be used in the rolling window
     */
    ArrayList<Integer> array;
    int k;
    ArrayList<Integer> minima;
    ArrayList<Integer> window;

    public AscendingMinima (ArrayList<Integer> array, int k) {
        /**
         * Constructor of the class Ascending Minima if the user wants to use the rolling window
         */
        this.array = array;
        this.k = k;
    }

    public AscendingMinima (ArrayList<Integer> array) {
        /**
         * Constructor of the class Ascending Minima if the user does not wants
         * to use the rolling window
         */
        this.array = array;
    }

    public ArrayList<Integer> ascendingMinima(ArrayList<Integer> array) {
        /**
         * Implementation of the Ascending Minima algorithm
         *
         * @param array the array (or window) to find the ascending minima
         *              It must be as ArrayList<Integer>
         * @return      The minima that was found in current window
         */
        ArrayList<Integer> minima = new ArrayList<Integer>();
        if (array.size() == 0) {
            return minima;
        }
        if (array.size() == 1) {
            minima.addAll(array);
            return minima;
        }
        AtomicInteger minIndex = new AtomicInteger();
        minIndex.set(0);
        IntStream
                .range(0, array.size())
                .filter(i -> array.get(i) <= array.get(minIndex.get()))
                .forEach(b -> minIndex.set(b));
        minima.add(array.get(minIndex.get()));
        minima.addAll(ascendingMinima(
                new ArrayList<Integer>(array.subList(minIndex.get()+1, array.size()))));
        return minima;
    }

    public ArrayList<Integer> minimaInNewWindow(
            ArrayList<Integer> prevWindow,
            int newElement,
            ArrayList<Integer> prevMinima) {
        /**
         * The new minima in the next window by adding one new element in the previous window
         *
         * @param prevWindow The window that used for the previous minima
         *                   It must be as ArrayList<Integer>
         * @param newElement The new element that will be added in the window
         *                   It is in int form
         * @param prevMinima The minima that was found in the previous window
         *                   It must be as ArrayList<Integer>
         * @return           The minima that was found in current window
         */
        if (prevWindow.get(0) == prevMinima.get(0)) {
            prevMinima.remove(0);
        }
        while (prevMinima.size() > 0 && prevMinima.get(prevMinima.size()-1) >= newElement) {
            prevMinima.remove(prevMinima.size()-1);
        }
        prevMinima.add(newElement);
        return prevMinima;
    }

    public ArrayList<ArrayList<Integer>> getAllMinimas() {
        /**
         * The function that implements both the two parts of the algorithm
         * and prints the current window and the current minima
         * WARNING The user must have set k in the class constructor
         */
        ArrayList<ArrayList<Integer>> allMinimas = new ArrayList<>();
        if (Optional.ofNullable(this.k).orElse(0) == 0) {
            System.out.println("k variable must be initialized");
            return allMinimas;
        }
        this.window = new ArrayList<Integer>(this.array.subList(0, this.k));
        this.minima = this.ascendingMinima(this.window);
        ArrayList<Integer> remainingElements = new ArrayList<Integer>(
                this.array.subList(this.k, this.array.size()));
        allMinimas.add(new ArrayList<Integer>(this.minima));
        while (remainingElements.size() > 0) {
            this.minima = this.minimaInNewWindow(this.window, remainingElements.get(0),this.minima);
            this.window.remove(0);
            this.window.add(remainingElements.get(0));
            remainingElements.remove(0);
            allMinimas.add(new ArrayList<Integer>(this.minima));
        }
        return allMinimas;
    }

    public static void main(String[] args) {
        /**
         * A simple presentation of the class
         */
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1,3,3,3,2,5,8,7,8,9));
        AscendingMinima asc = new AscendingMinima(array, 3);
        AscendingMinima asc2 = new AscendingMinima(array);
        ArrayList<ArrayList<Integer>> allMinimas = asc.getAllMinimas();
        allMinimas.stream().forEach(s -> System.out.println(s));
    }
}
