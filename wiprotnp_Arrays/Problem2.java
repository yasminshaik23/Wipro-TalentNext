import java.util.*;
public class Problem2{
    public static void main(String[] args){
        int[] arr = new int[]{10,20,30,40,50};
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Maximun: "+max);
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("Minimun: "+min);
    }
}