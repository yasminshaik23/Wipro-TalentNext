import java.util.*;
import java.util.function.Supplier;

public class Problem8 {

    public static void main(String[] args) {

        Supplier<ArrayList<Integer>> s = () -> {

            ArrayList<Integer> list = new ArrayList<>();

            int n = 2;

            while(list.size()<10){

                boolean prime=true;

                for(int i=2;i<=Math.sqrt(n);i++){

                    if(n%i==0){
                        prime=false;
                        break;
                    }
                }

                if(prime)
                    list.add(n);

                n++;
            }

            return list;
        };

        System.out.println(s.get());
    }
}