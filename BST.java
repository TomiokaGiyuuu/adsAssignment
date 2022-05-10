public class BST <K extends Comparable<K>, V>{

    ////////////////////
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    ///////////////////

    private Node root;

    public BST(){
        root = null;
    }


    public void put(K key, V value){
        Node temp = new Node(key, value);

        root = insertKey(root, temp);
    }

    public void delete(K key){
        deleteKey(root, key);
    }

    public V get(K key){
        return searcher(root, key);
    }

    public void iterator(){
        iteratorFromLeft(root);
    }


    //CUSTOM METHODS

    private V searcher(Node root, K key){
        if(root == null) {
            return null;
        }

        if(root.key.equals(key)){
            return root.value;
        }

        if((key).compareTo(root.key) > 0) {
            return searcher(root.right, key);
        }

        return searcher(root.left, key);
    }

    private Node insertKey(Node root, Node temp){
        if(root == null) {
            root = new Node(temp.key, temp.value);
            return root;
        }

        if(root.key.equals(temp.key)){
            root.value = temp.value;
            return root;
        }

        if((temp.key).compareTo(root.key) > 0) {
            root.right = insertKey(root.right, temp);
        } else {
            root.left = insertKey(root.left, temp);
        }

        return root;
    }

    private void iteratorFromLeft(Node root){
        if (root != null) {
            iteratorFromLeft(root.left);
            System.out.print(root.key + " ");
            iteratorFromLeft(root.right);
        }
    }

    private Node deleteKey(Node root, K key){
        if(root == null) {
            return root;
        }

        if((key).compareTo(root.key) > 0) {
            root.right = deleteKey(root.right, key);
        } else {
            root.left = deleteKey(root.left, key);
        }

        if(root.key.equals(key)){
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            root = minValOfRoot(root.right);

            root.right = deleteKey(root.right, root.key);
        }


        return root;
    }

    private Node minValOfRoot(Node root){
        Node minVal = root;
        while(root != null){
            minVal = root;
            root = root.left;
        }
        return minVal;
    }
}
