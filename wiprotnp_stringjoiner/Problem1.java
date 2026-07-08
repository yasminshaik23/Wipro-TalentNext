import java.util.*;
public class Problem1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<>();
        str.add("A");
        str.add("B");
        str.add("C");
        StringJoiner sj = new StringJoiner(",", "{", "}");
        for(String element:str){
            sj.add(element);
        }
        System.out.println(str);
    }
    
}
