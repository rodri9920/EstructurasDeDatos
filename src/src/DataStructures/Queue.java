package src.DataStructures;

import src.DataModels.Project;
import src.DataStructures.Node;

public class Queue {
    private Node first, last;
    private Project dato;

    public void enqueue(Project project) {
        if (first == null) {
            first = new Node(project);
            last = first;
        } else {
            if (first == last) {
                first.setQueueLast(new Node(project));
                last = first.getQueueLast();
            } else {
                last.setQueueLast(new Node(project));
                last = last.getQueueLast();
            }
        }
    }


    public void removeByName(String nombre) {
        if (first != null) {
            if (first.getProject().getName().equals(nombre)) {
                if(first.getQueueLast() != null){
                    first = first.getQueueLast();
                }else{
                    first.setProject(null);
                }
            } else {
                Node aux = first;
                while (aux.getQueueLast() != null) {
                    if (aux.getQueueLast().getProject().getName().equals(nombre)) {
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
                if (aux.getProject().getPriority()> aux.getQueueLast().getProject().getPriority()) {
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
                if (aux.getProject().getMonth()> aux.getQueueLast().getProject().getMonth()) {
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
        String queue = "";
        Node aux = first;
        while (aux != null) {
            queue += aux.getProject() + "\n";
            aux = aux.getQueueLast();
        }
        return queue;
    }

}