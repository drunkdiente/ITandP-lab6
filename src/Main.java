public class Main{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
    }
    public static class Stack<T> {
        private T[] data;
        private int size;

        public Stack(int capacity){
            data = (T[]) new Object[capacity];
            size = 0;
        }

        public void push(T element){
            data[size] = element;
            size += 1;
        }

        public T pop(){
            size -= 1;
            return data[size];
        }

        public T peek(){
            return data[size-1];
        }
    }

}