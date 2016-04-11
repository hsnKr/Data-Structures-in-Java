package binary.tree;

public class Node {


    Node left , right;
    private int Number;


    public Node(int number){
        Number = number;
        left = right = null;
    }


    public int getNumber(){return Number;}
    public Node getLeft(){return left;}
    public Node getRight(){return right;}

    public void setLeft(Node n){left = n;}
    public void setRight(Node n){right = n;}
    public void setNumber(int n){Number = n;}

}
