package src.DataStructures;

import javax.swing.JOptionPane;
import src.DataModels.User;

public class UserList {

    private Node head;
    private Node last;

    public boolean add(User user) {//este metodo servira para agregar usuarios, pedimos de parametro un objeto del mismo
        if (head == null) {
            head = new Node(user);
            last = head;
            //si no hay datos, colocamos el dato en la cabeza
        } else {
            if (last == head) {
                if (!head.getUser().getUsername().equals(user.getUsername())) {//debemos primero asegurar que el username no sea el mismo
                    last.setNext(new Node(user));
                    last = last.getNext();
                    //si solo hay un dato, colocamos el usuario despues del primero
                } else {
                    return false;
                    //si el username ya esta registrado, se lo hacemos saber al usuario
                }
            } else {//si hay dos datos o mas 
                boolean getsIn = true;//este booleano nos va a servir para saber si el username esta disponible o si se repite
                if (head.getUser().getUsername().equals(user.getUsername())) {
                    getsIn = false;
                    //primero lo comparamos con la cabeza, y si es igual el booleano pasa a false, indicando que no entrara en la lista
                } else {
                    Node aux = head.getNext();
                    //si el username no es el mismo que de cabeza, recorremos la lista con un aux
                    while (aux != head) {//ya que es una lista circular, comenzamos debajo de cabeza, y termina el ciclo cuando el aux vuelva a ser cabeza
                        if (aux.getUser().getUsername().equals(user.getUsername())) {
                            getsIn = false;
                            break;
                            //preguntamos con cada dato si los usernames son iguales, en caso de que lo sean el booleano pasa a false y usamos un break
                        } else {//si no son iguales, el aux sigue recorriendo la lista
                            aux = aux.getNext();
                        }
                    }
                }
                if (getsIn) {
                    Node temp = new Node(user);
                    last.setNext(temp);
                    temp.setBack(last);
                    last = temp;
                    //si el booleano se mantuvo en true, entonces introducimos el usuario a la lista
                } else {
                    return false;//si esta en false, le decimos que el username no esta disponible
                }

            }
        }
        head.setBack(last);
        last.setNext(head);
        return true;
    }

    public boolean removeByNameAndPassword(String username, String password) {//este metodo es para eliminar usuarios
        if (head != null) {//primero se pregunta si la lista tiene datos
            boolean removed = false;//este booleano nos indicara si se elimino algun usuario o no
            if (head.getUser().getUsername().equals(username) && head.getUser().getPassword().equals(password)) {
                head = head.getNext();
                head.setBack(last);
                last.setNext(head);
                removed = true;
                //primero preguntamos si el username y password son los que estan en cabeza, de ser asi simplente eliminamos cabeza
            } else {
                Node aux = head;
                //si no es cabeza el usuario a eliminar, debemos recorrer la lista con un auxiliar
                while (aux.getNext() != head) {//ya que se preguntara por el dato que esta despues, si el aux vuelve a ser cabeza es que termino de recorre la lista
                    if (aux.getNext().getUser().getUsername().equals(username) && aux.getNext().getUser().getPassword().equals(password)) {
                        aux.setNext(aux.getNext().getNext());
                        aux.getNext().setBack(aux);
                        removed = true;
                        break;
                        //si se encuentra al usuario, entonces lo eliminamos y aplicamos un break
                        //de igual forma, el booleano pasa a ser true
                    } else {
                        aux = aux.getNext();//si no coinciden los datos, el auxiliar sigue recorriendo la lista
                    }
                }
            }
            return removed;
            //mandamos un mensaje diciendole al usuario que se logro eliminar o que no se encontro el usuario correspondiente
        } else {
            System.out.println("There's no data");
            return false;
        }
    }

    public User signIn(String username, String password) {//este metodo nos servira para iniciar sesion
        if (head != null) {//primero se pregunta si hay datos en la lista
            boolean exists = false;//este booleano nos servira para saber si el usuario esta en la lista o no
            if (head.getUser().getUsername().equals(username) && head.getUser().getPassword().equals(password)) {
                return head.getUser();    
                //primero verificamos si el usuario es esta en la cabeza de la lista
            } else {//de no ser asi, recorremos la lista con un auxiliar
                Node aux = head.getNext();
                while (aux != head) {//mientras sea diferente de cabeza, ya que al ser circular, cuando sea cabeza es porque termino de recorrer
                    if (aux.getUser().getUsername().equals(username) && aux.getUser().getPassword().equals(password)) {
                        return aux.getUser();
                        //si los datos coinciden, hacemos un break y el booleano pasa a true, indicando que si esta el usuario
                    } else {
                        aux = aux.getNext();
                    }
                }
            }

            //si el usuario se encontro, le damos la bienvenida, si no entonces decimos que no esta
        }
        return null;
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
