package activities;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

    public static void main(String[] args) {
        System.out.println("Enter 5 values into array");
        Scanner sc = new Scanner(System.in);
        ArrayList list = new ArrayList();
        for(int i = 0; i < 5; i++) {
            list.add(sc.nextInt());
        }
        Integer[] nums = (Integer[]) list.toArray(new Integer[0]);
        Random random = new Random();
        int index = random.nextInt(nums.length);
        System.out.println("Index value" + index);
        System.out.println("Value at index"+nums[index]);
        sc.close();
    }

}
