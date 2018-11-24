
package src.DataStructures;

import src.DataModels.Project;
import src.DataModels.Task;
import src.DataModels.User;


public class Node {
    
    private User user;
    private Node next;
    private Node back;
    private Project project;//For Queues
    private Node queueLast;//For Queues
    private Node left, right;//For trees
    private Task task;//For trees
   
    public Node(User user) {
        this.user = user;
    }

    public Node(Project project) {
        this.project = project;
    }
    
    public Node(Task task){
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Node getQueueLast() {
        return queueLast;
    }

    public void setQueueLast(Node queueLast) {
        this.queueLast = queueLast;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "User: " + user;
    }
    
    
}
