
package Package;


public class Node {
    
    private User user;
    private Node next;
    private Node back;
    private Proyecto project;//para colas
    private Node queueLast;//para colas
   
    public Node(User user) {
        this.user = user;
    }

    public Node(Proyecto proyecto) {
        this.project = proyecto;
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

    public Proyecto getProject() {
        return project;
    }

    public void setProject(Proyecto proyecto) {
        this.project = proyecto;
    }

    public Node getQueueLast() {
        return queueLast;
    }

    public void setQueueLast(Node atras) {
        this.queueLast = atras;
    }        

    @Override
    public String toString() {
        return "User: " + user;
    }
    
    
}
