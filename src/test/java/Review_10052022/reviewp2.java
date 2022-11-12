package Review_10052022;

import java.util.ArrayList;

public class reviewp2 {
    public static void main(String[] args) {
        //declare and define array list of phone numbers
        ArrayList<String> numbers = new ArrayList<>();
        //add phone numbers
        numbers.add("3475556666");
        numbers.add("7185554444");
        numbers.add("5161234567");
        numbers.add("3476667777");
        numbers.add("6465551111");
        //add for loop
        for(int i=0; i < numbers.size(); i++){
            System.out.println("My phone number is " + numbers.get(i));


        }//end of for loop



    }//end of main


}//end of java class
