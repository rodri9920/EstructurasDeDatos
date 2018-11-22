
package Package;


public class Node {
    
    private User user;
    private Node next;
    private Node back;
    private Project project;//para colas
    private Node queueLast;//para colas
   
    public Node(User user) {
        this.user = user;
    }

    public Node(Project project) {
        this.project = project;
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

    @Override
    public String toString() {
        return "User: " + user;
    }
    
    
}
