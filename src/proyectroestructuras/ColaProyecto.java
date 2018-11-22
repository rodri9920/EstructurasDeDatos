package proyectroestructuras;

public class ColaProyecto {

    private Nodo frente, ultimo;
    private Proyecto dato;

    public void encola(Proyecto tarea) {
        if (frente == null) {
            frente = new Nodo(tarea);
            ultimo = frente;
        } else {
            if (frente == ultimo) {
                frente.setAtras(new Nodo(tarea));
                ultimo = frente.getAtras();
            } else {
                ultimo.setAtras(new Nodo(tarea));
                ultimo = ultimo.getAtras();
            }
        }
    }
    
//    public Nodo atiende(){
//        Nodo aux = frente;
//        if(aux != null){
//            frente = frente.getAtras();
//            aux.setAtras(null);
//            if(aux == ultimo){
//                ultimo = null;
//            }
//        }
//        return aux;
//    }

    public void eliminarProyecto(String nombre) {
        if (frente != null) {
            if (frente.getProyecto().getNombre().equals(nombre)) {
                if(frente.getAtras() != null){
                    frente = frente.getAtras();
                }else{
                    frente.setProyecto(null);
                }
            } else {
                Nodo aux = frente;
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

    public void ordenarPorPrioridad() {
        Nodo aux = frente;
        Nodo temp = new Nodo(dato);
        if (aux != null) {
            while (aux.getAtras() != null) {
                if (aux.getProyecto().getPrioridad() > aux.getAtras().getProyecto().getPrioridad()) {
                    temp.setProyecto(aux.getProyecto());
                    aux.setProyecto(aux.getAtras().getProyecto());
                    aux.getAtras().setProyecto(temp.getProyecto());
                    aux = frente;
                } else {
                    aux = aux.getAtras();
                }
            }
        } else {
            System.out.println("Vacia");
        }
    }

    public void ordenarPorFecha() {
        Nodo aux = frente;
        Nodo temp = new Nodo(dato);
        if (aux != null) {
            while (aux.getAtras() != null) {
                if (aux.getProyecto().getMes() > aux.getAtras().getProyecto().getMes()) {
                    temp.setProyecto(aux.getProyecto());
                    aux.setProyecto(aux.getAtras().getProyecto());
                    aux.getAtras().setProyecto(temp.getProyecto());
                    aux = frente;
                } else {
                    aux = aux.getAtras();
                }
            }
        } else {
            System.out.println("Vacia");
        }
    }

    @Override
    public String toString() {
        String cola = "";
        Nodo aux = frente;
        while (aux != null) {
            cola += aux.getProyecto() + "\n";
            aux = aux.getAtras();
        }
        return cola;
    }

}
