package Package;

public class Queue {

    private Nodo first, last;
    private Proyecto dato;

    public void enqueue(Proyecto tarea) {
        if (first == null) {
            first = new Nodo(tarea);
            last = first;
        } else {
            if (first == last) {
                first.setAtras(new Nodo(tarea));
                last = first.getAtras();
            } else {
                last.setAtras(new Nodo(tarea));
                last = last.getAtras();
            }
        }
    }


    public void removeByName(String nombre) {
        if (first != null) {
            if (first.getProyecto().getNombre().equals(nombre)) {
                if(first.getAtras() != null){
                    first = first.getAtras();
                }else{
                    first.setProyecto(null);
                }
            } else {
                Nodo aux = first;
                while (aux.getAtras() != null) {
                    if (aux.getAtras().getProyecto().getNombre().equals(nombre)) {
                        aux.setAtras(aux.getAtras().getAtras());
                    }else{
                        aux = aux.getAtras();
                    }
                }
            }

        } else {
            System.out.println("Vacia");
        }
    }

    public void orderByPriority() {
        Nodo aux = first;
        Nodo temp = new Nodo(dato);
        if (aux != null) {
            while (aux.getAtras() != null) {
                if (aux.getProyecto().getPrioridad() > aux.getAtras().getProyecto().getPrioridad()) {
                    temp.setProyecto(aux.getProyecto());
                    aux.setProyecto(aux.getAtras().getProyecto());
                    aux.getAtras().setProyecto(temp.getProyecto());
                    aux = first;
                } else {
                    aux = aux.getAtras();
                }
            }
        } else {
            System.out.println("Empty");
        }
    }

    public void orderByDate() {
        Nodo aux = first;
        Nodo temp = new Nodo(dato);
        if (aux != null) {
            while (aux.getAtras() != null) {
                if (aux.getProyecto().getMes() > aux.getAtras().getProyecto().getMes()) {
                    temp.setProyecto(aux.getProyecto());
                    aux.setProyecto(aux.getAtras().getProyecto());
                    aux.getAtras().setProyecto(temp.getProyecto());
                    aux = first;
                } else {
                    aux = aux.getAtras();
                }
            }
        } else {
            System.out.println("Empty");
        }
    }

    @Override
    public String toString() {
        String cola = "";
        Nodo aux = first;
        while (aux != null) {
            cola += aux.getProyecto() + "\n";
            aux = aux.getAtras();
        }
        return cola;
    }

}
