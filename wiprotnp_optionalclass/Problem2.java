import java.util.Optional;
public class Problem2 {
    public static void main(String[] args) {
        String address = null;
        Optional<String> op = Optional.ofNullable(address);
        System.out.println(op.orElse("India"));
    }
}