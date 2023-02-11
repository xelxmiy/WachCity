/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wachcity;

import javax.swing.*;
import java.util.*;

/**
 * @author Adam Belski
 * @since 11-Feb-2023
 * @version 1.0.0
 */
public class WachCity {
    //init vars
    static ArrayList<Integer> ChangeOverYears = new ArrayList<>();
    static int CurrentYear = -1;
    static int FinalYear = -1;
    
    public static void main(String[] args) {
        //intro message
        //jesus this is long
        JOptionPane.showMessageDialog(null,
                "In Wachs city (a very mathematical place to live)\n"
              + "the mayor is elected every 4 years\n"
              + "the treasurer is appointed every 2 years,\n"
              + " the chief programmer is elected every 3 years\n" 
              + "the dog catcher is replaced every 5 years.\n"
              + "This year (year n), the newly elected mayor announced the\n"
              + " appointment of the new treasurer, a new dog catcher\n" 
              + "and congratulated the chief programmer for winning the recent election.\n"
              + " That is, all positions were changed over.\n"
              + " This is highly unusual. You will quantify how unusual this\n" 
              + "really is. This is a program that lets you inputs the year x and the future\n"
              + "year y and then lists all years between x and y (inclusive)\n"
              + " when all positions change.\n",
                "WachCity", 
                JOptionPane.INFORMATION_MESSAGE);  
        //get the starting year
        while(CurrentYear < 0) {
            try {
                CurrentYear = Integer.parseInt(JOptionPane.showInputDialog(
                     null, "Enter the current year?",
                     "WachCity",
                     JOptionPane.INFORMATION_MESSAGE));
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null,
                "Please enter a positive integer!",
                "WachCity", 
                JOptionPane.INFORMATION_MESSAGE);           
            }
        }
        //get our final year
        while(FinalYear < 0) {
            try {
                FinalYear = Integer.parseInt(JOptionPane.showInputDialog(
                     null,
                     "Enter the target year?",
                     "WachCity",
                     JOptionPane.INFORMATION_MESSAGE));
                //i don't really care to implement calculating past years
                //though it shouldn't be too difficult
                //make sure we enter a higher year then the current year
                if(FinalYear < CurrentYear) {
                    FinalYear = -1;
                    throw new ArithmeticException("only designed to calculate the future years");
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null,
                "Please enter a positive integer greater than the current year!",
                "WachCity",
                JOptionPane.INFORMATION_MESSAGE);           
            }
            //calculate the years where all positions change
            CalcYears(CurrentYear, FinalYear);
            
            String years = "";
            for(int i = 0; i < ChangeOverYears.size(); i++) {
                years += "All positions change in year " + ChangeOverYears.get(i) + "\n";
            }
            if(!ChangeOverYears.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                "Over the next " + (FinalYear - CurrentYear) + " years...\n\n"  + years,
                "WachCity",
                JOptionPane.INFORMATION_MESSAGE);                
            } 
            //if the year doesn't change over
            else {
                JOptionPane.showMessageDialog(null,
                "Over the next " + (FinalYear - CurrentYear) + " years there's no"
              + "\nyear where all positions change",
                "WachCity",
                JOptionPane.INFORMATION_MESSAGE); 
            }
            //i've used this same code so many times i should just write a thing for it
            //restart program
            Object[] options = {"again", "quit"};
            int choice = JOptionPane.showOptionDialog(null,
                        "Thank you for using WachCity",
                   "WachCity",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                    null, options, null);
                        // play again
                        if(choice == JOptionPane.YES_OPTION) {
                            ChangeOverYears.removeAll(ChangeOverYears);
                            CurrentYear = -1;
                            FinalYear = -1;
                            main(args);
                        }
                        else System.exit(0);                               
        }
    }
    
    public static void CalcYears(int startYear, int EndYear) {
        int range = EndYear - startYear ;
        for(int i = 0; i < range; i ++) {
            if(i % 2 == 0 && i % 3 == 0 && i % 4 == 0 && i % 5 == 0){
                if(i != 0) ChangeOverYears.add(i + startYear);               
            }            
        }   
    }  
}   