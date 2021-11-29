/*
* This is a program that calculates mean, median and mode
* after reading in a text file into an array.
*
* @author  Mr Coxall
* @version 1.0
* @since   2020-01-01
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* This is the statistics program.
*/
final class Statistics {

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Statistics() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The mean() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the mean of the integers
    */
    public static double mean(final Integer[] arrayOfIntegers) {
        int size = arrayOfIntegers.length;
        int total = 0;
        for (int counter = 0; counter < size; counter ++) {
            // code block to be executed
            total = total + arrayOfIntegers[counter];
        }
        final double meanValue = (double) total / (double) size;
        return meanValue;
    }

    /**
    * The median() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the median of the integers
    */
    public static double median(final Integer[] arrayOfIntegers) {
        double returnValue = 0;
        Arrays.sort(arrayOfIntegers);
        final int numbersOfNumbers = arrayOfIntegers.length;
        if (numbersOfNumbers % 2 == 0) {
            final int numberOfMedian1 = (numbersOfNumbers / 2) - 1;
            final int median1 = arrayOfIntegers[numberOfMedian1];
            final int numberOfMedian2 = numbersOfNumbers / 2;
            final int median2 = arrayOfIntegers[numberOfMedian2];
            returnValue = (median1 + median2) / 2;
        } else {
            final int numberOfMedian = (int) (((double) numbersOfNumbers / 2.0) + 0.5);
            returnValue = arrayOfIntegers[numberOfMedian];
        }
        return returnValue;
    }

    /**
    * The mode() function.
    *
    * @param numbers the collection of integers
    * @return the mode of the integers
    */
    public static List<Integer> mode(final Integer[] numbers) {
        List<Integer> modes = new ArrayList<Integer>();
        modes.add(1);
        return modes;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        Integer tempNumber;
        final ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        final Path filePath = Paths.get("../", args[0]);
        final Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tempNumber = Integer.parseInt(line);
                listOfNumbers.add(tempNumber);
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }

        final Integer[] arrayOfNumbers = listOfNumbers.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arrayOfNumbers));

        System.out.println("\nCalculating stats...");
        final double mean = mean(arrayOfNumbers);
        final double median = median(arrayOfNumbers);
        final List<Integer> mode = mode(arrayOfNumbers);

        System.out.println("The mean is: " + mean);
        System.out.println("The median is: " + median);
        System.out.println("The mode(s) is/are: "
                            + Arrays.toString(mode.toArray()));

        System.out.println("\nDone.");
    }
}
