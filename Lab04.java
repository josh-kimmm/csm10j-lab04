import java.io.FileReader;
import java.util.*;
import java.io.FileNotFoundException;

public class Lab04 
{
    
    
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "input.txt";
        Scanner inFile = new Scanner(new FileReader(filename));
        
        System.out.print("Input: ");
        while(inFile.hasNext())
        {
            System.out.print(inFile.nextInt() + " ");
        }
        System.out.printf("\nMean: %.2f", computeMean(filename));
        System.out.printf("\nStdDev: %.2f\n", computeStandardDeviation
        (filename, computeMean(filename)));
        
        inFile.close();
        
        
        
    }
    
    public static double computeMean(String filename) throws FileNotFoundException
    {
        Scanner inFile;
        inFile = new Scanner(new FileReader(filename));
        
        double mean = 0;
        int count = 0;
        while(inFile.hasNext())
        {
            mean += inFile.nextDouble();
            count++;
        }
        mean = mean / count;
        inFile.close();
        return mean;
    }

    public static double computeStandardDeviation(String filename, double mean)
            throws FileNotFoundException
    {
        Scanner inFile = new Scanner(new FileReader(filename));
        
        double stdDev, hold = 0;
        int count = 0;
        while(inFile.hasNext())
        {
            hold = hold + Math.pow((inFile.nextDouble() - mean), 2);
            count++;
        }
        hold = hold / count;
        stdDev = Math.pow(hold, .5);
        inFile.close();
        return stdDev;
    }

}
