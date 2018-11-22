
package Package;


public class Nodo {
    
    private Usuario user;
    private Nodo next;
    private Nodo back;
    private Proyecto proyecto;//para colas
    private Nodo atras;//para colas

    public Nodo(Usuario user) {
        this.user = user;
    }

    public Nodo(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getBack() {
        return back;
    }

    public void setBack(Nodo back) {
        this.back = back;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }
    
    

    @Override
    public String toString() {
        return "Usuario: " + user;
    }
    
    
}
