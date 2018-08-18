package ecom.mycompany.hotel.util;

import org.springframework.stereotype.Service;

import java.util.Comparator;

/**
 * This Class is the library for sorting algorithms
 *
 * @author Vinod
 */
@Service
public class SortingHelper {

    public static <T> T[] bubbleSort(T[] items, Comparator c, String sortOrder) {
        if("asc".equalsIgnoreCase(sortOrder) || "ascending".equalsIgnoreCase(sortOrder)) {
            for (int a = 1; a < items.length; a++) {
                for (int b = 0; b < items.length - a; b++) {
                    if (c.compare(items[b], items[b + 1]) > 0) {
                        T temp = (T) items[b];
                        items[b] = items[b + 1];
                        items[b + 1] = temp;
                    }
                }
            }
        } else {
            for (int a = 1; a < items.length; a++) {
                for (int b = 0; b < items.length - a; b++) {
                    if (c.compare(items[b], items[b + 1]) < 0) {
                        T temp = (T) items[b];
                        items[b] = items[b + 1];
                        items[b + 1] = temp;
                    }
                }
            }
        }
        return items;
    }

    public static <T> T[] insertionSort(T[] items, Comparator c, String sortOrder) {
        int in, out;
        if("asc".equalsIgnoreCase(sortOrder) || "ascending".equalsIgnoreCase(sortOrder)) {
            for (out = 1; out < items.length; out++) {
                T temp = items[out];
                in = out;
                while (in > 0 && c.compare(items[in - 1], temp) > 0) {
                    items[in] = items[in - 1];
                    --in;
                }
                items[in] = temp;
            }
        } else{
            for (out = 1; out < items.length; out++) {
                T temp = items[out];
                in = out;
                while (in > 0 && c.compare(items[in - 1], temp) < 0) {
                    items[in] = items[in - 1];
                    --in;
                }
                items[in] = temp;
            }
        }
        return items;
    }



    /*private static <T> void swap(T[] x, int a, int b) {
        T t = x[a];
        x[a] = x[b];
        x[b] = t;
    }*/
}
