//Author Naman Rajpal, Ash Law, Mansi Thawani
package com.nmn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> text = new ArrayList<String>();
    static String line = new String();
    //System.out.println("Starting");
    static Scanner filein = null;


    public static void main(String[] args) {

        //ArrayList<ArrayList<String>> text = new ArrayList<ArrayList<String>>();
        int i=0;
        int k=0;

        try {
            filein = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //adding text to main Array 'text'
        while(filein.hasNextLine())
        {
            line = filein.nextLine();
            text.add(line);
        }


        //printtext();


        //2.How many total words did each interlocutor say?
        int[] person = new int[2];
        person[0]=0;
        person[1]=0;
        do
        {
            if(text.get(i).contains("A:"))
            {
                //System.out.println(text.get(i));
//                for (String retval: text.get(i).split(" ")){
//                    System.out.println(retval);
//                }

                String[] parts = new String[2];
                String[] dialogue = new String[2];
                parts = text.get(i).split("A:");
                //System.out.println(parts[1]);
                dialogue = parts[1].split(" ");
                //System.out.println(dialogue.length);
                person[0] += (dialogue.length-1);
            }
            if(text.get(i).contains("B:"))
            {
                //System.out.println(text.get(i));
//                for (String retval: text.get(i).split(" ")){
//                    System.out.println(retval);
//                }

                String[] parts = new String[2];
                String[] dialogue = new String[2];
                parts = text.get(i).split("B:");
                //System.out.println(parts[1]);
                dialogue = parts[1].split(" ");
                //System.out.println(dialogue.length);
                person[1] += (dialogue.length-1);
            }


            i++;

        }while(text.size()!=i);

        System.out.println("Person A : "+person[0]+ "Person B : "+person[1]);



    }


    public static void printtext()
    {
        int i=0;
        int k=0;
        do
        {

            System.out.println(text.get(i));
            i++;

        }while(text.size()!=i);
    }
}
