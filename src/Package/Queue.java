package Package;

public class Queue {

    private Nodo first, last;
    private Project dato;

    public void enqueue(Project tarea) {
        if (first == null) {
            first = new Node(tarea);
            last = first;
        } else {
            if (first == last) {
                first.setQueueLast(new Node(tarea));
                last = first.getQueueLast();
            } else {
                last.setQueueLast(new Node(tarea));
                last = last.getQueueLast();
            }
        }
    }


    public void removeByName(String nombre) {
        if (first != null) {
            if (first.getProject().getNombre().equals(nombre)) {
                if(first.getQueueLast() != null){
                    first = first.getQueueLast();
                }else{
                    first.setProject(null);
                }
            } else {
                Node aux = first;
                while (aux.getQueueLast() != null) {
                    if (aux.getQueueLast().getProject().getNombre().equals(nombre)) {
                        aux.setQueueLast(aux.getQueueLast().getQueueLast());
                    }else{
                        aux = aux.getQueueLast();
                    }
                }
            }

        } else {
            System.out.println("Vacia");
        }
    }

    public void orderByPriority() {
        Node aux = first;
        Node temp = new Node(dato);
        if (aux != null) {
            while (aux.getQueueLast() != null) {
                if (aux.getProject().getPrioridad() > aux.getQueueLast().getProject().getPrioridad()) {
                    temp.setProject(aux.getProject());
                    aux.setProject(aux.getQueueLast().getProject());
                    aux.getQueueLast().setProject(temp.getProject());
                    aux = first;
                } else {
                    aux = aux.getQueueLast();
                }
            }
        } else {
            System.out.println("Empty");
        }
    }

    public void orderByDate() {
        Node aux = first;
        Node temp = new Node(dato);
        if (aux != null) {
            while (aux.getQueueLast() != null) {
                if (aux.getProject().getMes() > aux.getQueueLast().getProject().getMes()) {
                    temp.setProject(aux.getProject());
                    aux.setProject(aux.getQueueLast().getProject());
                    aux.getQueueLast().setProject(temp.getProject());
                    aux = first;
                } else {
                    aux = aux.getQueueLast();
                }
            }
        } else {
            System.out.println("Empty");
        }
    }

    @Override
    public String toString() {
        String cola = "";
        Node aux = first;
        while (aux != null) {
            cola += aux.getProject() + "\n";
            aux = aux.getQueueLast();
        }
        return cola;
    }

}
