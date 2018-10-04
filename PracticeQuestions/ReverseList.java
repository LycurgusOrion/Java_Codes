import java.util.Collections;
import java.util.LinkedList;

public class ReverseList {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Aman");
        ll.add("Verma");
        ll.add("Someone");
        ll.add("Aaditya");

        LinkedList<String> llCopy = new LinkedList<String>(ll);
        Collections.reverse(llCopy);

        System.out.println(llCopy);
    }
}