// Java program for implementation of Insertion Sort
import java.util.*;

public class ComboSort 
{            
    private static Scanner input = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String args[])
    {


        int SIZE = 20;
        int key = 0;
        int[] records    = new int[SIZE];

        System.out.println("Load record Bubble Sort");
        loadRecord(records);
        printrecord(records);

        bubbleSort(records);
        printrecord(records);
        System.out.println();

        System.out.println("Load record Insertion Sort");
        loadRecord(records);
        printrecord(records);
        insertionSort(records);
        printrecord(records);
        System.out.println();

        System.out.println("Load record and do bubble sort, then binary half search");       
        loadRecord(records);
        bubbleSort(records);
        printrecord(records);
        System.out.println("Enter # to search");
        key = input.nextInt();

        binarySearch(records, key);

        System.out.println("End of sorts");
    }

    static void loadRecord(int[] records) 
    {
        int n = records.length; // Get the length of the record
        int index = 0;
            
        // Load record with random numbers
        for (index = 0; index <= n - 1; index++) 
        {
            records[index] = random.nextInt(100);
        }
    }

    static void bubbleSort(int[] records) 
    {
        int loop = 0;
        int n = records.length; 


        // This will loop through n-1 times until all records are in order


        for (int i = 0; i < n-1; i++) 
        {
        
        // if record 0 is > record 1, swap
          for (int j = 0; j < n-i-1; j++) 
          { 
            if (records[j] > records[j+1]) 
            {
            // count number of swaps
              loop = loop + 1;

              int temp = records[j];
              records[j] = records[j+1];
              records[j+1] = temp;
            }
          }
        }
        System.out.println("Loop for bubble sort = " + loop);

    }

    /* A utility function to print records of size n*/
    static void printrecord(int records[])
    {
           int n = records.length;
           for (int i = 0; i < n; ++i)
            {
               System.out.print(records[i] + " ");
            }

           System.out.println();
    }

    static void insertionSort (int records[])
    
        // Function to sort record using insertion sort*/
    {   // Algorithm courtsey of Daniel Liang, Introduction to Java
            int loop = 0;

            for (int i = 1; i < records.length; ++i) 
            {
                int currentElement = records[i];
                int j;
     
                /* Move elements of records[0..i-1], that are
                   greater than key, to one position ahead
                   of their current position */

                for (j= i - 1; j >= 0 && records[j] > currentElement; j--)
                    // decrementing through a loop is faster than incrementing
                    {
                        records[j + 1] = records[j];
                        loop = loop + 1;
                    }
                    records[j + 1] = currentElement;

            }
            System.out.println("Loop for insertion sort = " + loop);

        }
            // From book page 367
 
        static void binarySearch(int[] records, int key)
        {
            int first, last, split, loop, position;
            int n = records.length;

            first = 0;
            last = n - 1;
            loop = 0;
            position = 0;

            boolean found;
            
            found = false;
            
            // 
            while (!found && first <= last) 
            {
                split = (int) ((double) (first + last) / 2);

                if (records[split] == key) 
                {
                    position = split;
                    found = true;
                } 
                else 
                {
                    loop = loop + 1;
                    if (records[split] > key) 
                    {
                        last = split - 1;
                    } 
                    else 
                    {
                        first = split + 1;
                    }
                 }

            }
            
            System.out.println("Loop for search = " + loop);
            System.out.println("Key position is = " + position);
        }
   
}

