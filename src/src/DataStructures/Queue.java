package src.DataStructures;

import javax.swing.JOptionPane;
import src.DataModels.Project;

public class Queue {

    private Node first, last, data;
    private Project dato;
    private int length = 0;

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
        length++;
    }

    public int getLength() {
        return length;
    }

    public Project getProject(int position) {
        int counter = 0;
        if (first != null) {
            Node aux = first;
            while (aux != null) {
                if (counter == position) {
                    return aux.getProject();
                } else {
                    aux = aux.getQueueLast();
                    counter++;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public boolean remove(Project project) {
        if (first != null) {
            if (first.getProject().equals(project)) {
                if (first.getQueueLast() != null) {
                    first = first.getQueueLast();
                    length--;
                    return true;
                } else {
                    length--;
                    first.setProject(null);
                }
            } else {
                Node aux = first;
                while (aux.getQueueLast() != null) {
                    if (aux.getQueueLast().getProject().equals(project)) {
                        aux.setQueueLast(aux.getQueueLast().getQueueLast());
                        length--;
                        return true;
                    } else {
                        aux = aux.getQueueLast();
                    }
                }
            }

        } else {
            return false;
        }
        return false;
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
                        } else {
                            aux = aux.getQueueLast();
                        }
                    } else {
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
