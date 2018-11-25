package src.Structures;

import src.Models.User;

/**
 * @author Dorian
 */
public class UserNode {
        
    private User user;  
    private UserNode next;

    public UserNode(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public UserNode getNext() {
        return next;
    }

    public void setNext(UserNode next) {
        this.next = next;
    }   
    
    public boolean contains(User user){
        return this.user.equals(user);
    }
    
}
