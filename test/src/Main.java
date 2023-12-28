// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.lang.*;
import


public class Main {
    public static void main(String[] args) throws IOException  {
        ArrayDeque<String> queue = new ArrayDeque<String>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");

        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());



    }
}