import java.util.*;
import java.io.*;

public class InputTest {
    public static void main(String args[]) {
        if( args.length < 2 ) {
            System.out.println("You need two parameters for correct calling: File name & string for searching");
            return;
        }
        String searchString = args[1];
        String thisLine;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            while ((thisLine = fin.readLine()) != null) {
                System.out.println("== Entered string:" + thisLine);
                list.add(thisLine);
            }
            Collections.sort(list);
            System.out.println("Sorted string list:");
            Iterator<String> iter = list.iterator();
            while( iter.hasNext() ) {
                String str = iter.next();
                System.out.println(str);
            }
            int index = Collections.binarySearch(list, searchString);
            if (index >= 0) {
                System.out.println("String '" + searchString + "' was found in the list on position " + index);
            } else {
                System.out.println("String '" + searchString + "' wasn't found in the list");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error input/output. File " + args[0]);
            System.out.println("Error: " + e);
        } finally {
            if ( fin != null ) {
                try {
                    fin.close(); // !!! Закрыть файл
                } catch ( IOException ex ) {
                    System.out.println("Error file closing " + args[0]);
                    System.out.println("Error: " + ex);
                }
            }
        }
    }
}