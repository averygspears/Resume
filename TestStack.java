public class TestStack {
    public static void main(String[] args) {
        StackArrayBased stack = new StackArrayBased<Integer>();
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println("Is full? " + stack.isFull());
        System.out.println("Size: " + stack.size());
        for (int i = 0; i < 20; i++) {
            stack.push((Integer) i);
        }
        stack.toString();
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println("Is full? " + stack.isFull());
        System.out.println("Size: " + stack.size());
        for (int i = 1; i < 20; i += 2) {
            System.out.println(stack.peek() + "   ");
            System.out.print(stack.pop());
        }
        stack.toString();
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println("Is full? " + stack.isFull());
        System.out.println("Size: " + stack.size());
    }
}
