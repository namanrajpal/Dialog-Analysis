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

        int i=0;
        int k=0;

        try {
            filein = new Scanner(new File("test.txt"));
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

        //Part 1: Count number of dialogue turns of each interlocutor
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
        System.out.println("\n" +
                "\n" +
                "Answer 1 \nPerson A: " + person[0] + "\nPerson B: " + person[1]);



        //2.How many total words did each interlocutor say?
        i=0;
        int[] person1 = new int[2];
        person1[0]=0;
        person1[1]=0;
        do
        {
            if(text.get(i).contains("A:"))
            {


                String[] parts = new String[2];
                String[] dialogue = new String[2];
                parts = text.get(i).split("A:");
                dialogue = parts[1].split(" ");
                person1[0] += (dialogue.length-1);
            }
            if(text.get(i).contains("B:"))
            {
                String[] parts = new String[2];
                String[] dialogue = new String[2];
                parts = text.get(i).split("B:");
                dialogue = parts[1].split(" ");
                person1[1] += (dialogue.length-1);
            }
            i++;

        }while(text.size()!=i);

        System.out.println("\n\nAnswer 2 \nPerson A : "+person1[0]+ "\nPerson B : "+person1[1]);



        // 3- How many words per turn on average did each interlocutor make?
        int[] person3 = new int[2];
        person3[1] = person1[1]/person[1];
        person3[0] = person1[0]/person[0];
        System.out.println("\n\nAnswer 3 \nPerson A : "+person3[0]+ "\nPerson B : "+person3[1]);


    }


    public static void printtext()
    {
        int i=0;
        int k=0;

        System.out.println(text.size());

    }
}
