import java.io.*;
import java.util.Scanner;

// Author: Aparna Mahadev
// Course Name: CS 242 Data Structures
// Project 5 - Hashing with linear probing
// E-mail: amahadev@worcester.edu
// Description:
//    In this assignment (part II) we implement the closed hashing
//    with linear probing which is an implementation
//    of the Dictionary ADT.  
//
//    An input file of Books has been provided by the instructor.
//    The program first inserts all these Book objects into an empty 
//    hash table. The program reports the number of collisions while 
//    creating the hash table.
//
//    A file of 80 keys is given by the instructor to perform 
//    searches in the hash table. For each search, if the key is 
//    found in the hash table, the program reports
//    the # of element-to-element comparisons made for this search.
//
//    If the key is not found, the program reports that the key is
//    not found along with the # of element-to-element comparisons 
//    made for the search.
// 
//    A file of 1474 keys is given by the instructor to perform 
//    deletions in the hash table. For each deletion, if the key is 
//    found in the hash table, the program deletes the element and reports
//    the # of element-to-element comparisons made for this deletion.
//
//    If the key is not found, the program reports that the key is
//    not found along with the # of element-to-element comparisons 
//    made for the deletion.  
//
//    The program reports the average # of comparisons made for a
//    successful search, an unsuccessful search a successful deletion
//    and an unsuccessful deletion.
//
//    Known Bugs: None


public class LinearProbingDriver {
    public static void main (String args[]) {
       String line;
       Book element;
       LinearProbing <Book> ht = new LinearProbing <Book> ();
       int unsuccessfulComparisons = 0;
       int successfulComparisons = 0;
       int unsuccessfulSearches = 0;
       int successfulSearches = 0;
       int unsuccessfulDeletions = 0;
       int successfulDeletions = 0;
       int successfulDeleteComps = 0;
       int unsuccessfulDeleteComps = 0;
       IntObject searchCount = new IntObject(0);
       IntObject deleteCount = new IntObject(0);
       int collisions = 0;
       int insertCount = 0;

       try {
    	   Scanner inFile = new Scanner (new FileReader("Books.txt"));
           Scanner searchFile = new Scanner(new FileReader("SearchISBN.txt"));
           Scanner deleteFile = new Scanner(new FileReader("DeleteISBN.txt"));

           PrintWriter out = new PrintWriter(
        		    new FileWriter("LinearProbing_Output.txt"));

           while (inFile.hasNextLine())  {
               line = inFile.nextLine();
               Book aBook = new Book(line.substring(0,10),
                  line.substring(15,55).trim(),
                  line.substring(55,95).trim(),
                  Integer.parseInt(line.substring(95,99)),
                  line.substring(104,line.length()));
                  collisions += ht.insert(aBook);
                  insertCount++;
           }
           inFile.close();
           out.println("All the " + insertCount + " elements have been successfully " +
                      "inserted into the hash table");
           out.println("The total number of collisions while constructing the " +
                       "hash table is " + collisions);
           out.println();

           // now start searching the hash table
           while (searchFile.hasNextLine()) {
               line = searchFile.nextLine();
               element = new Book();
               element.setIsbn(line);
               searchCount.setData(0);
               Book result = ht.search(element, searchCount);
               if (result != null) {
            	   out.println("SUCCESS!! Book with ISBN " + result.getIsbn() 
                   + " exists in the hash table");
            	   // out.println(result);
                   out.println("The number of comparisons made for " +
                                "this succeesful search is " +
                                searchCount.getData() );
                   out.println();
                   successfulComparisons += searchCount.getData();
                   successfulSearches++;
               }
               else { // key is not found in the hash table
                    out.println("There is no book with ISBN " + element.getIsbn());
                    out.println("The number of comparisons made for " +
                           "this unsucceesful search is " +
                           searchCount.getData() );
                    out.println();

                   unsuccessfulComparisons += searchCount.getData();
                   unsuccessfulSearches++;
               }  // else
           }  // while

          searchFile.close();

          // now start deleting from the hash table
          while (deleteFile.hasNextLine()) {
              line = deleteFile.nextLine();
              element = new Book();
              element.setIsbn(line);
              deleteCount.setData(0);
              Book result = ht.delete(element, deleteCount);
              if (result != null) {
                 out.println("Book with ISBN " + result.getIsbn() 
                     + " is successfully deleted");
                 // out.println(result);
                 out.println("The number of comparisons made for " +
                               "this succeesful deletion is " +
                                deleteCount.getData() );
                 out.println();
                 successfulDeleteComps += deleteCount.getData();
                 successfulDeletions++;
              }
              else { // key is not found in the hash table
                  out.println("There is no book with ISBN " + element.getIsbn());
                  out.println("The number of comparisons made for " +
                          "this unsucceesful deletion is " +
                           deleteCount.getData() );
                  out.println();
                  unsuccessfulDeleteComps += deleteCount.getData();
                  unsuccessfulDeletions++;
              }  // else
          }  // while

         deleteFile.close();
         
         out.println("-------------------------------------------------");
         out.println("There were " + successfulSearches +
                 " successful searches");
         if (successfulSearches > 0)
               out.printf("The average number of comparisons for a " +
               "successful search is %.2f",
               (double)successfulComparisons / successfulSearches);
         out.println();
         out.println();
         
         out.println("-------------------------------------------------");
         out.println("There were " + unsuccessfulSearches +
                 " unsuccessful searches");
         if (unsuccessfulSearches > 0)
              out.printf("The average number of comparisons for " +
              "an unsuccessful search is %.2f", 
              (double)unsuccessfulComparisons / unsuccessfulSearches);
         out.println();
         out.println();
         out.println("-------------------------------------------------");
         out.println("There were " + successfulDeletions +
                 " successful deletions");
         if (successfulDeletions > 0)
         out.printf("The average number of comparisons for a " +
               "successful deletions is %.2f", 
               (double)successfulDeleteComps / successfulDeletions);
         out.println();
         out.println();
         out.println("-------------------------------------------------");
         out.println("There were " + unsuccessfulDeletions +
                 " unsuccessful deletions");
         if (unsuccessfulDeletions > 0)
             out.printf("The average number of comparisons for " +
              "an unsuccessful deletion is %.2f", 
              (double)unsuccessfulDeleteComps / unsuccessfulDeletions);
          out.println();
          out.close();
       }          
       catch (IOException e) {
		   System.out.println("Input file or the test file cannot be opened");
		   System.exit(0);
       }
    }
}