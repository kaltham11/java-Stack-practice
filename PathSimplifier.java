import java.util.Stack;

class PathSimplifier {
    /**
     * TO-DO: Simplify a Unix-style file path.
     * For example, "/a/./b/../../c/" should become "/c".
     * And "/../" should become "/".
     \*
     * @param path The absolute path string.
     * @return The simplified canonical path.
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        // Your code here:
        // Iterate through the 'components'.
        // Use if/else if to handle "..", ".", and regular directory names.
        for(String com: components){
            if(!com.equals("..") && !com.equals(".") && !com.equals("")) {
                stack.push(com);
            }
            if(com.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            }

        if (stack.isEmpty()) {
            return "/";
        }

        // Your code here:
        // Use a StringBuilder to join the elements in the stack
        // to form the final path string (e.g., "/dir1/dir2").
        StringBuilder finalPath=new StringBuilder();
        for(String dir:stack){
            finalPath.append("/");
            finalPath.append(dir);
        }

        return finalPath.toString(); // Placeholder
    }
    public static void main(String[] args) {
        PathSimplifier simplifier = new PathSimplifier();

        // بعض الأمثلة لاختبار المسارات
        String path1 = "/a/./b/../../c/";
        String path2 = "/../";
        String path3 = "/home//foo/";
        String path4 = "/a/b/c/./../../d/";

        System.out.println("Original: " + path1 + " -> Simplified: " + simplifier.simplifyPath(path1));
        System.out.println("Original: " + path2 + " -> Simplified: " + simplifier.simplifyPath(path2));
        System.out.println("Original: " + path3 + " -> Simplified: " + simplifier.simplifyPath(path3));
        System.out.println("Original: " + path4 + " -> Simplified: " + simplifier.simplifyPath(path4));
    }
}