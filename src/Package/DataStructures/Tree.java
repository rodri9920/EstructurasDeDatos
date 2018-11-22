
package Package.DataStructures;

import Package.DataModels.Task;


public class Tree {
    
    Node root;
    
    public void add(Task task){
        if(root != null){
            root = new Node(task);
        }else{
            
        }
    }
    
    private void addRec(Task task, Node n){
        if(task.getPriority() <= n.getTask().getPriority()){
            if(n.getLeft() != null){
                n.setLeft(new Node(task));
            }else{
                addRec(task, n.getLeft());
            }
        }
        if(task.getPriority() > n.getTask().getPriority()){
            if(n.getRight() != null){
                n.setRight(new Node(task));
            }else{
                addRec(task, n.getRight());
            }
        }
    }
    
    public void inOrder(){
        if(root != null){
            inOrderRec(root);
        }
    }
    
    private void inOrderRec(Node n){
        if (n != null) {
            inOrderRec(n.getLeft());
            System.out.print(n);
            System.out.println(n);
            inOrderRec(n.getRight());
        }
    }
    
}
