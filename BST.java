public class BST<T> {
    Node root;
    class Node <T>{
        Node left;
        Node right;
        Comparable data;
        int instance = 0;
        Node(Comparable item){
            data = item;
        }

    }
    public boolean find(Comparable item){
        return find(item, root);
    }
    private boolean find(Comparable item, Node node){
        if (node == null)
            return false;
        if (item.compareTo(node.data) == 0)
            return true;
        if (item.compareTo(node.data) < 0)
            return find(item, node.left);
        else
            return find(item, node.right);
    }
    public void insert(Comparable item){
        root = insert(item, root);
    }
    private Node insert(Comparable item, Node node){
        if (node == null)
            return new Node(item);
        if (item.compareTo(node.data) == 0)
            node.instance++;
        else {
            if (item.compareTo(node.data) < 0)
                node.left = insert(item, node.left);
            else
                node.right = insert(item, node.right);
        }
        return node;
    }
    public void print(){
        root = print(root);
    }
    private Node print(Node node){
        if (node == null)
            return null;
        print(node.left);
        for (int i = node.instance; i >= 0; i--){
            System.out.println(node.data);
        }
        print(node.right);
        return node;
    }
    public void delete(Comparable item){
        root = delete(item, root);
    }
    private Node delete(Comparable item, Node node){
        if (node == null)
            return null;
        if (item.compareTo(node.data) == 0){
            if (node.instance > 0){
                node.instance--;
            }
            else{
                if (node.left == null)
                    return node.right;
                if (node.right == null)
                    return node.left;
                if (node.right.left == null) {
                    node.data = node.right.data;
                    node.right = node.right.right;
                    return node;
                } else {
                    node.data = removeSmallest(node.right);
                    return node;
                }
            }
        }
        if (item.compareTo(node.data) < 0){
            node.left = delete(item, node.left);
            return node;
        }
        else{
            node.right = delete(item, node.right);
            return node;
        }
    }
    private Comparable removeSmallest(Node node){
        if(node.left.left == null){
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        }
        return removeSmallest(node.left);
    }
}
