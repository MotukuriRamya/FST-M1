package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer,String> colours = new HashMap<Integer, String>();
        colours.put(1,"Red");
        colours.put(2,"Yellow");
        colours.put(3,"Blue");
        colours.put(4,"White");
        colours.put(5,"Violet");

        colours.remove(2);
        if(colours.containsValue("Green")){
            System.out.println("Element is there");
        }else {
            System.out.println("Not there");
        }
        System.out.println(colours.size());


    }
}
