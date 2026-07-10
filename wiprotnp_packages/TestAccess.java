import test.Foundation;
public class TestAccess {
    public static void main(String[] args) {

        Foundation obj = new Foundation();

        // System.out.println(obj.var1); // Error
        // System.out.println(obj.var2); // Error
        // System.out.println(obj.var3); // Error

        System.out.println(obj.var4);    // Accessible
    }
}