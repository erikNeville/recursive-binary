import java.io.*;
import java.util.*;

/**
 * This program takes in a file containing integers, adds them to
 * an ArrayList, sorts them, then uses a recursive binary search
 * to search for the location of a desired integer within the ArrayList
 * 
 * @author Erik Neville <erikeneville@gmail.com>
 */
public class recursiveBinary {
    
    /**
     * Method which runs a recursive binary search on the file
     * 
     * @param nums ArrayList which stores the Integer values
     * @param low lowest range in each search iteration
     * @param high highest range in each search iteration
     * @param value the value being searched for
     * @return the index of the value searched for, -1 if value is not present
     * @throws FileNotFoundException 
     */
    public static int binary(ArrayList<Integer> nums, int low, int high, int value) 
            throws FileNotFoundException {
        
        if (high >= low) {
            int mid = low + (high - low) / 2;
            
            // conditional statements which will change the value of
            // low or high to mid +/- 1 depending on where the value
            // is in respect to mid
            if (value == nums.get(mid)) {
                return mid;
            } else if (value < nums.get(mid)) { // remove right side
                return binary(nums, low, mid - 1, value);
            } else if (value > nums.get(mid)) { // remove left side
                return binary(nums, mid + 1, high, value);
            }
        }
        return -1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("int_list.txt"));
        ArrayList<Integer> nums = new ArrayList<>();
  
        // adding to and sorting the ArrayList nums
        while (in.hasNext()) {
            nums.add(in.nextInt());
        }
        Collections.sort(nums);
        
        System.out.println("List of all numbers: " + nums + "\n");
        
        // numbers being searched for
        int[] tests = {634, 4, 7532, 534, 2888, 45654, 555};
        
        // loop to run the binary() method and search for assigned numbers
        for (int i = 0; i < tests.length; i++) {
            int search = binary(nums, 0, nums.size(), tests[i]);
            
            if (search == -1) {
                // provide useful message if -1 is returned
                System.out.println(tests[i] + "\tDOES NOT EXIST IN FILE");
            } else {
                System.out.println(tests[i] + "\toccurs at index: " + search);
            }
        }   
    }
}
