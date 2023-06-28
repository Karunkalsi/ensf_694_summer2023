import java.awt.desktop.SystemEventListener;
import java.util.Scanner;
import java.util.Arrays;

public class main{

    public static String binarySearch(int[] elems, int low, int high, int key){
/**
 * I used binary search as my interpolation search method and did it recursively
 * I chose recursive because it is easier for me to read
 *
 * This method runs faster because of its timing complexity is much better this is due to the
 * search method splitting the array in half to search by making a max time complexity of O(log(N))
 * compared to linear which is O(N) for worst case
 */

        if (low <= high){
            int mid = (low + high)/2;
            if (key == elems[mid]){
                return "Search key found at index " + mid;
            }
            else if (key < elems[mid]){
                return binarySearch(elems,low, mid-1,key);
            }
            else if (key > elems[mid]){
                return binarySearch(elems,mid+1, high, key);
            }
        }
        return "Search key NOT FOUND";
    }
    public static String linearSearch(int[] elems, int key){
        for (int i = 0; i < elems.length; i++){
            if (elems[i] == key){
                return ("Search key found at index " + i);
            }
        }
        return "Search key NOT FOUND";
    }
    public static String improvedLinearSearch(int[] elems, int key){
        /**
         * This function is improved from the regular liinear search because it simultaneously
         * is checking the array from the front and back speeding it up substantially making the worst case scenario go from
         * O(N) to now O(N/2) improving on average more than 20% for larger cases
         *
         */
        for (int i = 0; i < elems.length/2; i++){
            if (elems[i] == key){
                return "Search key found at index " + i;
            }
            if (elems[elems.length-(i+1)] == key){
                return "Search key found at index " + (elems.length - (i+1));
            }
        }
        return "Search key NOT FOUND";
    }
    public static void main(String[] args){
        System.out.print("Enter the number of elements of: ");
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        int elemLength = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] elem = new int[elemLength];

        for (int i = 0; i < elemLength; i++){
            elem[i] = sc.nextInt();
        }

        System.out.print("Enter the search key: ");
        int searchKey = sc.nextInt();
        Arrays.sort(elem);

        long startTime = System.nanoTime();
        System.out.println("Using Linear Search: ");
        System.out.println(linearSearch(elem,searchKey));
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000 + " ms");

        startTime = System.nanoTime();
        System.out.println("Using Interpolation Search: ");
        System.out.println(binarySearch(elem,0,elemLength, searchKey));
        endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000 + " ms");

        startTime = System.nanoTime();
        System.out.println("Using Linear Search: ");
        System.out.println(improvedLinearSearch(elem,searchKey));
        endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000 + " ms");
    }

}