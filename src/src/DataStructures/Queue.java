package src.DataStructures;


import javax.swing.JOptionPane;
import src.DataModels.Project;
import src.DataStructures.Node;

public class Queue {

    private Node first, last;
    private Project dato;

    public void enqueue(Project project) {
        if(1 <= project.getPriority() && project.getPriority() <= 4){
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
        }else{
            JOptionPane.showMessageDialog(null, "Project's pryority has to be from 1 to 4");
        }
        
    }

    public void removeByName(String name) {
        if (first != null) {
            if (first.getProject().getName().equals(name)) {
                if (first.getQueueLast() != null) {
                    first = first.getQueueLast();
                } else {
                    first.setProject(null);
                }
            } else {
                Node aux = first;
                while (aux.getQueueLast() != null) {
                    if (aux.getQueueLast().getProject().getName().equals(name)) {
                        aux.setQueueLast(aux.getQueueLast().getQueueLast());
                    } else {
                        aux = aux.getQueueLast();
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "This user has no projects");
        }
    }

    public void orderByPriority() {
        Node aux = first;
        Node temp = new Node(dato);
        if (aux != null) {
            while (aux.getQueueLast() != null) {
                if (aux.getProject().getPriority() > aux.getQueueLast().getProject().getPriority()) {
                    temp.setProject(aux.getProject());
                    aux.setProject(aux.getQueueLast().getProject());
                    aux.getQueueLast().setProject(temp.getProject());
                    aux = first;
                } else {
                    aux = aux.getQueueLast();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "This user has no projects");
        }
    }

    public void orderByDate() {
        Node aux = first;
        Node temp = new Node(dato);
        if (aux != null) {
            while (aux.getQueueLast() != null) {
                if (aux.getProject().getYear() > aux.getQueueLast().getProject().getYear()) {
                    temp.setProject(aux.getProject());
                    aux.setProject(aux.getQueueLast().getProject());
                    aux.getQueueLast().setProject(temp.getProject());
                    aux = first;
                } else if (aux.getProject().getYear() == aux.getQueueLast().getProject().getYear()) {
                    if (aux.getProject().getMonth() > aux.getQueueLast().getProject().getMonth()) {
                        temp.setProject(aux.getProject());
                        aux.setProject(aux.getQueueLast().getProject());
                        aux.getQueueLast().setProject(temp.getProject());
                        aux = first;
                    } else if (aux.getProject().getMonth() == aux.getQueueLast().getProject().getMonth()) {
                        if (aux.getProject().getDay() > aux.getQueueLast().getProject().getDay()) {
                            temp.setProject(aux.getProject());
                            aux.setProject(aux.getQueueLast().getProject());
                            aux.getQueueLast().setProject(temp.getProject());
                            aux = first;
                        }else{
                            aux = aux.getQueueLast();
                        }
                    }else{
                        aux = aux.getQueueLast();
                    }
                } else {
                    aux = aux.getQueueLast();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "This user has no projects");
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
