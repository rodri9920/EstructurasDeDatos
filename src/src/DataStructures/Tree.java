
package src.DataStructures;

import src.DataModels.Task;


public class Tree {
    
    NodeTree root;
    
    public void add(Task task){
        if(root == null){
            root = new NodeTree(task);
        }else{
            addRec(task, root);
        }
    }
    
    private void addRec(Task task, NodeTree n){
        if(task.getPriority() <= n.getTask().getPriority()){
            if(n.getLeft() == null){
                n.setLeft(new NodeTree(task));
            }else{
                addRec(task, n.getLeft());
            }
        }
        if(task.getPriority() > n.getTask().getPriority()){
            if(n.getRight() == null){
                n.setRight(new NodeTree(task));
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
    
    private void inOrderRec(NodeTree n){
        if (n != null) {
            inOrderRec(n.getLeft());
            System.out.print(n);
            System.out.println();
            inOrderRec(n.getRight());
        }
    }
    
}
