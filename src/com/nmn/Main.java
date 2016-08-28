//Author Naman Rajpal, Ash Law, Mansi Thawani
package com.nmn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        //ArrayList<ArrayList<String>> text = new ArrayList<ArrayList<String>>();
        ArrayList<String> text = new ArrayList<String>();
        String line = new String();
        //System.out.println("Starting");
        Scanner filein = null;
        try {
            filein = new Scanner(new File("C:\\Users\\Naman Rajpal\\Desktop\\Homeowrk1\\input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //adding text to main Array 'text'
        while(filein.hasNextLine())
        {
            line = filein.nextLine();
            text.add(line);
        }
        System.out.println(text.size());
        //printing text, looping on i
        /*int i=0;
        do
        {
            System.out.println(text.get(i));
            i++;
        }while(text.size()!=i);
        */
        //Part 1: Count number of dialogue turns of each interlocutor
        int i=0;
        int[] person = new int[2];
        person[0] = 0;
        person[1] = 0;
        do
        {
            String currentDialog = text.get(i);
            char c;
            for(int j = 0; j < currentDialog.length(); j++){
                c = currentDialog.charAt(j);
                if(c == 'A'){
                    person[0]++;
                    break;
                }
                else if(c == 'B'){
                    person[1]++;
                    break;
                }
            }
            i+=2;
        }while(text.size()>i);
        System.out.println("Person A: " + person[0] + "\nPerson B: " + person[1]);
    }
}
