package src.DataStructures;

import javax.swing.JOptionPane;
import src.DataModels.User;

public class UserList {

    private Node head;
    private Node last;
    
    /**
     * This method is used to add users to the list
     * @param user it is the user we are going to add
     * @return a boolean which indicates if the user is able to get in the list or not
     */
    public boolean add(User user) {
        if (head == null) {
            head = new Node(user);
            last = head;
            //if there is no data in the list, we put the user in head
        } else {
            if (last == head) {
                if (!head.getUser().getUsername().equals(user.getUsername())) {//we must be sure that usernames are not repeated
                    last.setNext(new Node(user));
                    last = last.getNext();
                    //if there is only one user, we add the new one next to the first one
                } else {
                    return false;//if the username is already in the list, our method will return false
                }
            } else {//if there are more than two users in the list
                boolean getsIn = true;//this boolean will be usefull to know if the user is able to get in the list
                if (head.getUser().getUsername().equals(user.getUsername())) {
                    getsIn = false;
                    //if the username is already in the list, our boolean variable will turn to false
                } else {
                    Node aux = head.getNext();
                    while (aux != head) {//if the aux becomes head, it means that it already pass through every node in the list
                        if (aux.getUser().getUsername().equals(user.getUsername())) {
                            getsIn = false;
                            break;//we must remember to break the while cicle in order to get out of it
                            //if the username is already in the list, our boolean variable will turn to false
                        } else {
                            aux = aux.getNext();
                        }
                    }
                }
                if (getsIn) {//if the variable remains true
                    Node temp = new Node(user);
                    last.setNext(temp);
                    temp.setBack(last);
                    last = temp;
                } else {
                    return false;//if not, we return false to indicate that the user can not enter the list
                }

            }
        }
        head.setBack(last);
        last.setNext(head);
        return true;//if the method gets here, it is because the user is able to be added to the list
    }
    
    
    /**
     * this method will be useful to remove users from the list 
     * @param username
     * @param password
     * @return a boolean, which in case of true indicates that the user is in the list
     */
    public boolean removeByNameAndPassword(String username, String password) {
        if (head != null) {//the first thing we do is to verify that our list is not empty
            boolean removed = false;
            if (head.getUser().getUsername().equals(username) && head.getUser().getPassword().equals(password)) {
                head = head.getNext();
                head.setBack(last);
                last.setNext(head);
                removed = true;
                //if the username and its password are in the head, we turned the variable to true
            } else {
                Node aux = head;
                while (aux.getNext() != head) {//once the aux becomes head again it means that it already finished passing through the list
                    if (aux.getNext().getUser().getUsername().equals(username) && aux.getNext().getUser().getPassword().equals(password)) {
                        aux.setNext(aux.getNext().getNext());
                        aux.getNext().setBack(aux);
                        removed = true;
                        break;
                        //if the aux finds a node that contains the information, the removed variable removes turns true and we break the cicle
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
            return removed;
        } else {
            System.out.println("There's no data");
            return false;
        }
    }
    
    
    /**
     * this method will be one used when a user wants to signIn in the application
     * @param username
     * @param password
     * @return the user if it is in the list, if not, the method returns null
     */
    public User signIn(String username, String password) {
        if (head != null) {//the first thing we do is to verify that our list is not empty
            boolean exists = false;
            if (head.getUser().getUsername().equals(username) && head.getUser().getPassword().equals(password)) {
                return head.getUser();
                //if the user is in head, we return it
            } else {
                Node aux = head.getNext();
                while (aux != head) {//once the aux becomes head again it means that it already finished passing through the list
                    if (aux.getUser().getUsername().equals(username) && aux.getUser().getPassword().equals(password)) {
                        return aux.getUser();
                        //if the aux finds a node that contains the information, the removed variable removes turns true and we break the cicle
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
        }
        return null;//if the user is not in the list, the method will return null
    }

    @Override
    public String toString() {
        String lista = "";
        Node aux = head;
        if (head != null) {
            lista += aux + "\n";
            aux = aux.getNext();
            while (aux != head) {
                lista += aux + "\n";
                aux = aux.getNext();
            }
        } else {
            JOptionPane.showMessageDialog(null, "There are no users");
        }
        return lista;
    }

}
