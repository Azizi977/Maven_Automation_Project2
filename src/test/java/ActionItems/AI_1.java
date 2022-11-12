package ActionItems;

import java.util.ArrayList;

public class AI_1 {
    public static void main(String[] args) {
        //declare and define arrayList of countries
        ArrayList<String> country = new ArrayList<>();
        country.add("United Sates ");
        country.add("Afghanistan ");
        country.add("Pakistan ");
        country.add("India ");
        //add countryCode using int to arrayList
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1 );
        countryCode.add(93 );
        countryCode.add(92 );
        countryCode.add(91 );

        for(int i=0; i < country.size(); i++){

            System.out.println("My country is " + country.get(i) + "and my country code is " + countryCode.get(i));

        }//end of for loop
    }//end of main
}//end of java class

