package src.Structures;

import src.Models.User;

/**
 * @author Rodri
 * @author Dorian
 * @author Luis
 */
public class UserList {

    private int length;
    private UserNode header;

    /**
     * List length
     *
     * @return List length
     */
    public int length() {
        return length;
    }
    
    /**
     * Adds an object to the list
     *
     * @param user User to add
     */
    public void add(User user) {

        UserNode node = new UserNode(user);
        if (header == null) {
            header = node;
        } else if (header.getNext() == null) {
            header.setNext(node);
        } else {
            UserNode aux = header;
            do {
                aux = aux.getNext();
            } while (aux.getNext() != null);
            aux.setNext(node);
        }
        length++;
    }

    /**
     * Retrieves the object in the list at the given index
     *
     * @param index Index
     * @return Object
     */
    public User get(int index) {
        if (index > (length - 1)) {
            return null;
        }
        UserNode aux = header;
        int currentIndex = 0;
        while (aux != null) {
            if (currentIndex == index) {
                return aux.getUser();
            }
            aux = aux.getNext();
            currentIndex++;
        }
        return null;
    }

    /**
     * Removes an Object from the list
     *
     * @param user User to remove
     */
    public void remove(User user) {

        do {
            if (header.contains(user)) {
                header = header.getNext();
                length--;
            }
        } while (header != null && header.contains(user));

        if(header == null){
            return;
        }
        
        UserNode prev = header;
        UserNode aux = header.getNext();

        while (aux != null) {
            if (!aux.contains(user)) {
                prev = aux;
                aux = aux.getNext();
            } else {
                prev.setNext(aux.getNext());
                aux = aux.getNext();
                length--;
            }
        }

    }

    /**
     * Checks if the List contains an User
     *
     * @param user User to find
     * @return Result
     */
    public boolean contains(User user) {
        UserNode aux = header;
        while (aux != null) {
            if (aux.contains(user)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

}
