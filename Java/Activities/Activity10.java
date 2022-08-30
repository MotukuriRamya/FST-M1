package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet();
        hs.add("Mango");
        hs.add("Apple");
        hs.add("Mango");
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Banana");
        System.out.println(hs.size());
        hs.remove("Apple");
        hs.remove("Cherry");
        if(hs.contains("Mango")){
            System.out.println("Element is there");
        }
        System.out.println(hs);
    }
}
