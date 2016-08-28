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
        

        //printing text, looping on i
        int i=0;
        do
        {
            System.out.println(text.get(i));
            i++;
        }while(text.size()!=i);

    }
}
