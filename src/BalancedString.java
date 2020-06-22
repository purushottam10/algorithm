import java.util.Deque;
import java.util.LinkedList;

public class BalancedString {
    public static boolean isBalanced(String str) {
        isValidString(str);
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty() || (deque.peekFirst() == '[' && ch == ']') || (deque.peekFirst() == '{' && ch == '}') || (deque.peekFirst() == '(' && ch == ')')) {
                    deque.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidString(String str) {
        if (str.length() % 2 != 0) {
            return false;
        } else {
            for (char ch : str.toCharArray()) {
                if (!(ch == '[' || ch == '{' || ch == '(' || ch == ']' || ch == '}' || ch == ')')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String... str) {
        if (isBalanced("{([])}")) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }
}
