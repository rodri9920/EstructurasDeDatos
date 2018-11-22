package Package.DataStructures;

import Package.DataModels.User;
import javax.swing.JOptionPane;

public class UserList {

    private Node head;
    private Node last;

    public void add(User user) {
        if (head == null) {
            head = new Node(user);
            last = head;
        } else {
            if (last == head) {
                if (!head.getUser().getUsername().equals(user.getUsername())) {
                    last.setNext(new Node(user));
                    last = last.getNext();
                } else {
                    JOptionPane.showMessageDialog(null, "That username already exists");
                }
            } else {
                boolean getsIn = true;
                if (head.getUser().getUsername().equals(user.getUsername())) {
                    getsIn = false;
                } else {
                    Node aux = head.getNext();
                    while (aux != head) {
                        if (aux.getUser().getUsername().equals(user.getUsername())) {
                            getsIn = false;
                            break;
                        } else {
                            aux = aux.getNext();
                        }
                    }
                }
                if(getsIn){
                    Node temp = new Node(user);
                    last.setNext(temp);
                    temp.setBack(last);
                    last = temp;
                }else{
                    JOptionPane.showMessageDialog(null, "That username already exists");
                }
                
            }
        }
        head.setBack(last);
        last.setNext(head);
    }

    public void removeByNameAndPassword(String username, String password) {
        if (head != null) {
            boolean removed = false;
            if (head.getUser().getUsername().equals(username) && head.getUser().getPassword().equals(password)) {
                head = head.getNext();
                head.setBack(last);
                last.setNext(head);
                removed = true;
            } else {
                Node aux = head;
                while (aux.getNext() != head) {
                    if (aux.getNext().getUser().getUsername().equals(username) && aux.getNext().getUser().getPassword().equals(password)) {
                        aux.setNext(aux.getNext().getNext());
                        aux.getNext().setBack(aux);
                        removed = true;
                        break;
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
            JOptionPane.showMessageDialog(null, removed ? "User removed" : "User did not exist");
        } else {
            System.out.println("There's no data");
        }
    }

    public void signIn(String username, String password) {
        if (head != null) {
            boolean exists = false;
            if (head.getUser().getUsername().equals(username) && head.getUser().getPassword().equals(password)) {
                exists = true;
            } else {
                Node aux = head.getNext();
                while (aux != head) {
                    if (aux.getUser().getUsername().equals(username) && aux.getUser().getPassword().equals(password)) {
                        exists = true;
                        break;
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
            JOptionPane.showMessageDialog(null, exists ? "Welcome" : "User does not exist");
        } else {
            JOptionPane.showMessageDialog(null, "There are no users");
        }
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
