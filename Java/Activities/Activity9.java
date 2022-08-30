package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("Ramya");
        myList.add("Vijay");
        myList.add("Ravi");
        myList.add("Ajay");

        System.out.println("3rd element: " + myList.get(3));
        if(myList.contains("Ajay")) {
            System.out.println("Name is there in list");
        }
        System.out.println("Size:" + myList.size());
        myList.remove(1);
        System.out.println(myList.size());
    }
}
