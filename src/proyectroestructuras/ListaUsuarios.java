package proyectroestructuras;

public class ListaUsuarios {

    private Nodo cabeza;
    private Nodo ultimo;

    public void agregarUsuario(Usuario user) {
        if (cabeza == null) {
            cabeza = new Nodo(user);
            ultimo = cabeza;
        } else {
            if (ultimo == cabeza) {
                if (!cabeza.getUser().getUsername().equals(user.getUsername())) {
                    ultimo.setNext(new Nodo(user));
                    ultimo = ultimo.getNext();
                } else {
                    System.out.println("Ya esta ese username");
                }
            } else {
                boolean entra = true;
                if (cabeza.getUser().getUsername().equals(user.getUsername())) {
                    entra = false;
                } else {
                    Nodo aux = cabeza.getNext();
                    while (aux != cabeza) {
                        if (aux.getUser().getUsername().equals(user.getUsername())) {
                            entra = false;
                            break;
                        } else {
                            aux = aux.getNext();
                        }
                    }
                }
                if(entra){
                    Nodo temp = new Nodo(user);
                    ultimo.setNext(temp);
                    temp.setBack(ultimo);
                    ultimo = temp;
                }else{
                    System.out.println("Ya esta ese username");
                }
                
            }
        }
        cabeza.setBack(ultimo);
        ultimo.setNext(cabeza);
    }

    public void eliminarUsuario(String username, String password) {
        if (cabeza != null) {
            boolean eliminado = false;
            if (cabeza.getUser().getUsername().equals(username) && cabeza.getUser().getPassword().equals(password)) {
                cabeza = cabeza.getNext();
                cabeza.setBack(ultimo);
                ultimo.setNext(cabeza);
                eliminado = true;
            } else {
                Nodo aux = cabeza;
                while (aux.getNext() != cabeza) {
                    if (aux.getNext().getUser().getUsername().equals(username) && aux.getNext().getUser().getPassword().equals(password)) {
                        aux.setNext(aux.getNext().getNext());
                        aux.getNext().setBack(aux);
                        eliminado = true;
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
            System.out.println(eliminado ? "Se elimino" : "No estaba");
        } else {
            System.out.println("No hay datos");
        }
    }

    public void iniciarSesion(String username, String password) {
        if (cabeza != null) {
            boolean pertenece = false;
            if (cabeza.getUser().getUsername().equals(username) && cabeza.getUser().getPassword().equals(password)) {
                pertenece = true;
            } else {
                Nodo aux = cabeza.getNext();
                while (aux != cabeza) {
                    if (aux.getUser().getUsername().equals(username) && aux.getUser().getPassword().equals(password)) {
                        pertenece = true;
                        break;
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
            System.out.println(pertenece ? "Bienvenido" : "No esta");
        } else {
            System.out.println("Vacia");
        }
    }

    @Override
    public String toString() {
        String lista = "";
        Nodo aux = cabeza;
        if (cabeza != null) {
            lista += aux + "\n";
            aux = aux.getNext();
            while (aux != cabeza) {
                lista += aux + "\n";
                aux = aux.getNext();
            }
        } else {
            System.out.println("vacia");
        }
        return lista;
    }

}
