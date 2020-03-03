import java.util.*;

public class Random {

    /*
    * resources
    * - 30 interview questions: https://javarevisited.blogspot.com/2011/06/top-programming-interview-questions.html
    * - 50 interview questions: https://simpleprogrammer.com/programming-interview-questions/
    */

    // TODO: refactor 'problems' into proper classes (via methods)

    public static void main(String[] args) throws Exception {
        // check if palindrome
        boolean a = isPalindrome("a");
        boolean ana = isPalindrome("ana");
        boolean abe = isPalindrome("abe");
        boolean racecar = isPalindrome("racecar");
        boolean onomatopoeia = isPalindrome("onomatopoeia");
        System.out.println("a: " + a);
        System.out.println("ana: " + ana);
        System.out.println("abe: " + abe);
        System.out.println("racecar: " + racecar);
        System.out.println("onomatopoeia: " + onomatopoeia);

        // find duplicate number in array
        int[] duplicateArr = {5, 4, 3, 2, 5, 1, 0};
        int[] noDuplicateArr = {5, 4, 3, 2, 1, 0};
        int duplicate = findDuplicate(duplicateArr);
        try {
            findDuplicate(noDuplicateArr);
            System.out.println("failed to hit catch for 'noDuplicatesArr'");
        } catch(Exception e) {
            System.out.println("succesfully threw for 'noDuplicatesArr': " + e.getMessage());
        }
        System.out.println("duplicate: " + duplicate);

        // find middle of linked list (in one pass)
        java.util.LinkedList<Integer> llFive = new java.util.LinkedList<Integer>();
        List<Integer> llFiveCollection = Arrays.asList(1, 2, 3, 4, 5);
        // List<Integer> llFiveCollection = Arrays.asList(1, 2, 3);
        llFive.addAll(llFiveCollection);
        int middle = findMiddle(llFive);
        int middleLazy = findMiddleLazy(llFive);
        System.out.println("middle: " + middle); // expected:  3
        System.out.println("middle (lazy): " + middleLazy); // expected:  3

        // find depth of binary tree

        // left subtree
        Node<Integer> one = new Node<Integer>(1, null, null);
        Node<Integer> two = new Node<Integer>(2, one, null);
        Node<Integer> three = new Node<Integer>(3, two, null);

        // right subtree
        Node<Integer> six = new Node<Integer>(6, null, null);
        Node<Integer> five = new Node<Integer>(5, six, null);

        // root
        Node<Integer> four = new Node<Integer>(4, three, five);
        BinaryTree<Integer> tree = new BinaryTree<Integer>(four);
        
        int treeHeight = treeHeight(tree);
        System.out.println("treeHeight: " + treeHeight);

        // sort Integers using Java comparator
        List<Integer> ints = Arrays.asList(5, 3, 4, 2, 1);
        Collections.sort(ints, new SortIntegerAscending());
        System.out.println("ints (ascending): " + ints);
        Collections.sort(ints, new SortIntegerDescending());
        System.out.println("ints (descending): " + ints);
    }

    // public static boolean isPalindrome(String s) {
    //     return s.equals(new StringBuilder(s).reverse().toString());
    // }

    public static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static int findDuplicate(int[] ints) throws Exception {
        
        Set<Integer> duplicates = new HashSet<Integer>();
        for(int current: ints) {
            if (duplicates.contains(current)) {
                return current;
            }
            duplicates.add(current);
        }

        throw new Exception("failed to find diplicate");
    }

    // TODO: fix (current problem is iterator can't be (easily) cloned, and need to iterators to perform properly)
    // assume odd number
    public static int findMiddle(java.util.LinkedList<Integer> ll) throws Exception {
        
        // int middle = ll.peekFirst();
        // int end = ll.peekFirst();
        
        Iterator<Integer> iterator = ll.iterator();

        // System.out.println("ll.hasNext():  " + iterator.hasNext());

        // start at item 0
        int currentMiddle = iterator.next();

        while (iterator.hasNext()) {
            // System.out.println("endIterator.next():  " + endIterator.next());
            currentMiddle = iterator.next();
            iterator.next();
        }

        return currentMiddle;
    }

    // handles both odd and even
    public static int findMiddleLazy(java.util.LinkedList<Integer> ll) throws Exception {
        int middle = ll.size() / 2;
        // // then even
        // if (ll.size() % 2 != 0) {

        // }
        return ll.get(middle);
    }

    public static int treeHeight(BinaryTree<Integer> tree) {
        return treeHeight(tree.root, -1);
    }

    public static int treeHeight(Node<Integer> node, int height) {
        if (node == null) {
            return height;
        }
        height++;
        return Math.max(treeHeight(node.left, height), treeHeight(node.right, height));
    }
}

class SortIntegerAscending implements Comparator<Integer> {

    @Override
    public int compare(Integer left, Integer right) {
        return left - right;
    }
}

class SortIntegerDescending implements Comparator<Integer> {

    @Override
    public int compare(Integer left, Integer right) {
        return  right - left;
    }
}
