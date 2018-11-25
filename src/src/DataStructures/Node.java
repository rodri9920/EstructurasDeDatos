
package src.DataStructures;

import src.DataModels.Project;
import src.DataModels.Task;
import src.DataModels.User;


public class Node {
    
    private User user;
    private Node next;
    private Node back;
    private Project project;//for stacks
    private Node down;//for stacks
    private Task tasks;//for queues
    private Node queueLast;//For Queues
    
   
    public Node(User user) {
        this.user = user;
    }

    public Node(Project project) {
        this.project = project;
    }

    public Node(Task tasks) {
        this.tasks = tasks;
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

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Task getTasks() {
        return tasks;
    }

    public void setTasks(Task tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User: " + user;
    }
    
}
