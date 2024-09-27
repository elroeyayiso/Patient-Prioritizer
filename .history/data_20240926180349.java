import java.io.*;
import java.util.*;
public class FunWithHistograms {
     public static void main(String[] args) throws FileNotFoundException {
         intro();
         // Scanner to input file name
        Scanner console = new Scanner(System.in); 
        System.out.print("input file name? ");
          // file
        String fileName = console.nextLine();
        System.out.println();

        Scanner fileScan = new Scanner(new File(fileName));
        int[] dataFromFile = readData(fileScan); 
        indexMax(dataFromFile);
        int[] count= numOccurance(dataFromFile);
        printHistogram(count);
        summary(dataFromFile,count);
        
    }
        
   // A method to print the program's introduction message
     public static void intro(){
          System.out.println("The program will analyze data from a dataset of");
          System.out.println("non-negative integer values. It will produce a");
          System.out.println("histogram of the data and output some statistics.");
          System.out.println("");
   }


     // A method to read in the data from an input file
     //parameters:
    // a Scanner to read the data from file 
     public static int[] readData(Scanner fileScan) {
         int numValues = fileScan.nextInt();
         fileScan.nextLine();
         int [] dataFromFile = new int[numValues];
         // array to read file
        for (int i = 0; i < numValues; i++) {
            dataFromFile[i] = fileScan.nextInt();
        }

        return dataFromFile;
    }

     //A method to find the index of the maximum value in an array
    //parameters:
    public static int indexMax(int[]dataFromFile){
        int max = dataFromFile[0];
        int index = 0;
        for(int i = 0; i <dataFromFile.length;i++){
            if(max < dataFromFile[i]){
                max = dataFromFile[i];
                index =i;
            }
        }
        return index;
    }

    
    // A method to count the occurrences of each value in an array
    //parameters:
    public static int[] numOccurance(int[] dataFromFile){
        int index= indexMax(dataFromFile);
         int[] count = new int[dataFromFile[index]+1];

         for(int i = 0; i < dataFromFile.length;i++){
            int digit = dataFromFile[i];
              count[digit]++;

        }
        return count;
    
    }

    // A method to compute the mean (average) of the data in an array
    //parameters:
    public static double computedMean(int[] dataFromFile){
        double mean = 0;
        double sum = 0;
        for (int i = 0; i<dataFromFile.length;i++){
            sum = sum +dataFromFile[i];
        }
        mean = sum/dataFromFile.length;
        return mean;
    } 


     // A method to print a text-based histogram
    //parameters:
       public static void printHistogram(int[] count){
        for(int i =0; i<count.length; i++){
          
            System.out.print(i+ "| ");
            for(int j=0; j < count[i];j++){
              System.out.print("*");  
            }
            System.out.println();
        }
    }

    // A method to compute and print the summary statistics
   //parameters:
    public static void summary(int[] dataFromFile, int[] count){
        System.out.println("");
        System.out.println("Num. Values: " + dataFromFile.length);
        System.out.println("Mean: " + computedMean(dataFromFile));
        System.out.println("Mode: " + indexMax(count));
    }
       
    



}

        










