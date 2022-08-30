package activities;//In this activity, we are writing a program to check if the sum of all the
// 10's in the array is exactly 30.
import java.util.Scanner;

public class Activity2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter 5 numbers : ");
        int numbers[] = new int[5];
        //reading input
        for(int i = 0;i < 5;i++){
            numbers[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i = 0; i < numbers.length;i++){
            if(numbers[i] == 10) {
                sum += numbers[i];
            }
        }
        if(sum == 30)
            System.out.println("sum is equal to 30");
        else
            System.out.println("Not equal");
    }
}



