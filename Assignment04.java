package assignment04;

/**
 *
 * @author Martin Bacala C202 Programming Assignment 4 The objective of this
 * program is to find the average number of words found, not found, and number
 * of comparisons given a dictionary of LinkedLists and book.
 */
import java.io.*;
import java.util.Scanner;

public class Assignment04 {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        long wordsFound = 0;
        long wordsNotFound = 0;
        long compsFound = 0;
        long compsNotFound = 0;
        int[] count = new int[1];

        MyLinkedList[] dict = new MyLinkedList[26];
        for (int i = 0; i < dict.length; i++) {
            dict[i] = new MyLinkedList<String>();
        }//for

        java.io.File readFile = new java.io.File("random_dictionary.txt");
        Scanner input = new Scanner(readFile);

        //Adds all words into LinkedList sorted by 'a'
        while (input.hasNextLine()) {
            String s = input.nextLine();
            s = s.replaceAll("\\s+", "");
            s = s.toLowerCase();
            dict[s.charAt(0) - 97].add(s);
        }//while

        java.io.File readFile1 = new java.io.File("oliver.txt");
        Scanner scanOliver = new Scanner(readFile1);
        while (scanOliver.hasNext()) {
            try {
                String wordsToSearch = scanOliver.next();
                wordsToSearch = wordsToSearch.replaceAll("[^a-zA-Z]", "");
                wordsToSearch = wordsToSearch.toLowerCase();
                int indexSearch = (wordsToSearch.charAt(0) - 97);
                if (dict[indexSearch].contains(wordsToSearch, count)) {
                    wordsFound++;
                    compsFound += count[0];
                }//if
                else {
                    wordsNotFound++;
                    compsNotFound += count[0];
                }//else
            }//try
            catch (StringIndexOutOfBoundsException e) {
                scanOliver.next();
            }//catch
        }//while

        Assignment04 a = new Assignment04();
        long avgCompsFound = compsFound / wordsFound;
        System.out.println("Average Number of Words Found: " + avgCompsFound);
        long avgCompsNotFound = compsNotFound / wordsNotFound;
        System.out.println("Average Number of Words Not Found: " + avgCompsNotFound);
        System.out.println("Number of Words Found: " + wordsFound + " in " + compsFound + " comparisons");
        System.out.println("Number of Words Not Found: " + wordsNotFound + " in " + compsNotFound + " comparisons");

    }//main
}//Assignment04

