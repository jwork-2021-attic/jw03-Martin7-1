package example;

import java.io.IOException;

/**
 * @author Zyi
 */
public class Transform {

    public static void main(String[] args) throws IOException {
        example.encoder.SteganographyFactory.getSteganography("example/QuickSorter.java","example/resources/miku.jpg");
        example.encoder.SteganographyFactory.getSteganography("example/SelectionSorter.java","example/resources/selectionSort.jpg");
    }
    
}
