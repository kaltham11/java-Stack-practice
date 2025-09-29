import java.util.Stack;

class StackSorter {
    /**
     * TO-DO: Sort the given stack so that the smallest element is at the top.
     * You may use a temporary stack, but no other data structures.
     \*
     * @param stack The stack of integers to be sorted.
     */

    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();
        int element=0;
        // Your code here.
        // While the original stack is not empty...
        // Pop an element.
        // While the sorted stack is not empty and its top is smaller than the element...
        // Move elements from sorted back to original.
        // Push the element to the sorted stack.

        // After the main loop, copy the sorted stack back to the original stack.


        while (!stack.isEmpty()){
            element=stack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek()>element){
                stack.push(sortedStack.pop());
            }
            sortedStack.push(element);
            }
        while (!sortedStack.isEmpty()){
            stack.push(sortedStack.pop());
        }
    }
}