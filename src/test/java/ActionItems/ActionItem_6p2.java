package ActionItems;

public class ActionItem_6p2 {
    public static void main(String[] args) {
        //declare and define string array variable
        String[] region;
        region = new String[] {"Texas", "New York", "Florida", "California"};
        //declare and define linear array for areaCode
        int[] areaCode = new int[]{210, 718, 305, 209};
        //set the initializer
        int i = 0;
        //set condition for while loop
        while(i < areaCode.length){
            System.out.println("My region is " + region[i] + " " + "and my area code is " + areaCode[i]);
            i++;

        }//end of while loop
    }//end of main
}//end of java class
