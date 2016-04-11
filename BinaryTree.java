package binary.tree;

public class BinaryTree {

    private Node root;
    private boolean isInserted = false;
    private boolean isTheSameStatus = true;
    private int numberOfElements = 0;


// -------------------------------------------------------------


   public void insert(int number){

       if(root == null)
           root = new Node(number);
       else
        insert(new Node(number),root);

       isInserted = false;
   }
   public  void insert(Node A , Node R){


       if(R != null ){

           if(R.getLeft() == null && R.getRight() == null){
               R.setLeft(A);
               isInserted = true;

           }
           else if(R.getLeft() == null){
               R.setLeft(A);
               isInserted = true;

           }
           else if(R.getRight() == null){
               R.setRight(A);
               isInserted = true;

           }
           else{
               if(isInserted == false)
                   insert(A,R.getLeft());
               if(isInserted == false)
                   insert(A,R.getRight());

           }

       }
   }


// -------------------------------------------------------------

   public void remove(){

       if(root == null){
           System.out.print("The tree is empty !");
       }
       else{

           Node temp = root;
            if(root.getLeft() == null && root.getRight() == null){
                 root = null;
            }
            else if(root.getRight() == null){
                root = root.getLeft();
            }
            else if(root.getLeft() == null){
                root = root.getRight();
            }
            else{
                Node hold = getSuccesor(temp.getLeft());
                hold.setLeft(temp.getLeft());
                hold.setRight(temp.getRight());
                root  = hold;
            }

       }
   }
   public Node getSuccesor(Node N){

       if(N.getRight() == null && N.getRight().getLeft() != null){
           Node temp = N.getRight();
           N.setRight(N.getRight().getLeft());
           return temp;
       }
       else if(N.getRight() == null){
           return N;
       }
       else
           return getSuccesor(N.getRight());
   }


// -------------------------------------------------------------

   public boolean isTheSame(Node treeOne , Node treeTwo){

    if(treeOne != null && treeTwo != null){

        if(treeOne.getNumber() != treeTwo.getNumber())
            isTheSameStatus = false;
        else {
            isTheSame(treeOne.left, treeTwo.left);
            isTheSame(treeOne.right , treeTwo.right);
        }

    }
    else if(treeOne == null && treeTwo != null)
            isTheSameStatus = false;
    else if(treeOne != null && treeTwo == null)
              isTheSameStatus = false;


    return isTheSameStatus;


   }

// -------------------------------------------------------------


   public Node getRoot(){return root;}


// -------------------------------------------------------------


   public int Height(){
       return Height(root , 0) + 1 ;
   }
   private int Height(Node R , int h){

       if(R == null)
           return h;
       else{
           int left = Height(R.left , (h++));
           int right = Height(R.right, (h++));

           return left > right ? left : right;
       }

   }


// -------------------------------------------------------------


   public int elements(){
       return elements(root) - 1 ;
   }
   private int elements(Node R){

       if(R == null)
           return 1;

       return elements(R.left) + elements(R.right) ;

   }


// -------------------------------------------------------------


     public void preOrder(){
       preOrder(root , 0 , 1);
   }
   private void preOrder(Node R , int counter , int x){

       if(R == null)
           return;

        System.out.println( "Level #:"+ "["+ counter + "]" + "\tData :" + R.getNumber());
        counter++;

        preOrder(R.getLeft() , counter,x);
        preOrder(R.getRight(), counter,x);



   }

   // -------------------------------------------------------------

}
