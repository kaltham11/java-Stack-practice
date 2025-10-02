import java.util.Stack;

class HtmlValidator {
    /**
     * TO-DO: Check if an array of HTML tags is well-formed.
     \*
     * @param tags An array of strings, where each string is a tag like "<html>" or "</html>".
     * @return true if the tags are properly nested and balanced, false otherwise.
     */
    public boolean isWellFormed(String[] tags) {
        Stack<String> tagStack = new Stack<>();

        for (String tag : tags) {
            if (tag.startsWith("</")) {
                String tagClose=tag.substring(2, tag.length()-1);
                // This is a closing tag
                if(tag.isEmpty()){
                    return false;
                }
              String extractTagOpen=tagStack.pop();
                if(!tagClose.equals(extractTagOpen)){
                    return false;
                }
                // 2. Check if the stack is empty. If so, return false.
                // 3. Pop from the stack and check if it matches the closing tag's name. If not, return false.

            } else { // This is an opening tag
                // Your code here:
                // 1. Get the tag name (e.g., "html" from "<html>").
                // 2. Push the tag name onto the stack.
                String tagOpen=tag.substring(1,tag.length()-1);
                tagStack.push(tagOpen);
            }
        }

        // Your code here:
        // After checking all tags, what must be true about the stack
        // for the HTML to be considered well-formed?
        return tagStack.isEmpty(); // Placeholder
    }
    public static void main(String[] args) {
        HtmlValidator validator = new HtmlValidator();

        // مثال 1: well-formed HTML
        String[] tags1 = {"<html>", "<body>", "<h1>", "</h1>", "</body>", "</html>"};

        // مثال 2: not well-formed HTML
        String[] tags2 = {"<html>", "<body>", "<h1>", "</body>", "</h1>", "</html>"};

        // مثال 3: empty tags
        String[] tags3 = {};

        System.out.println("Tags1 well-formed? " + validator.isWellFormed(tags1)); // متوقع: true
        System.out.println("Tags2 well-formed? " + validator.isWellFormed(tags2)); // متوقع: false
        System.out.println("Tags3 well-formed? " + validator.isWellFormed(tags3)); // متوقع: true
    }
}