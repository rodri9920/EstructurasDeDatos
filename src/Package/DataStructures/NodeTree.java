
package Package.DataStructures;

import Package.DataModels.Task;


public class NodeTree {
    
    private NodeTree left, right;//For trees
    private Task task;//For trees
    
    public NodeTree(Task task){
        this.task = task;
    }
    
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Task: " + task;
    }
    
    
}
