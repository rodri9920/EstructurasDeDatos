package src.DataStructures;

import javax.swing.JOptionPane;
import src.DataModels.Project;
import src.DataModels.Task;

public class Queue {

    private Node first, last, data;
    private Task dato;
    private int length = 0;

    public void enqueue(Task task) {
        if (first == null) {
            first = new Node(task);
            last = first;
        } else {
            if (first == last) {
                first.setQueueLast(new Node(task));
                last = first.getQueueLast();
            } else {
                last.setQueueLast(new Node(task));
                last = last.getQueueLast();
            }
        }
        length++;
    }

    public int getLength() {
        return length;
    }

    public Project getTask(int position) {
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

    public boolean remove(Task task) {
        if (first != null) {
            if (first.getTasks().equals(task)) {
                if (first.getQueueLast()!= null) {
                    first = first.getQueueLast();
                    length--;
                    return true;
                } else {
                    length--;
                    first.setTasks(null);
                }
            } else {
                Node aux = first;
                while (aux.getQueueLast() != null) {
                    if (aux.getQueueLast().getTasks().equals(task)) {
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
                if (aux.getTasks().getPriority() > aux.getQueueLast().getTasks().getPriority()) {
                    temp.setTasks(aux.getTasks());
                    aux.setTasks(aux.getQueueLast().getTasks());
                    aux.getQueueLast().setTasks(temp.getTasks());
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
                if (aux.getTasks().getYear() > aux.getQueueLast().getTasks().getYear()) {
                    temp.setTasks(aux.getTasks());
                    aux.setTasks(aux.getQueueLast().getTasks());
                    aux.getQueueLast().setTasks(temp.getTasks());
                    aux = first;
                } else if (aux.getTasks().getYear() == aux.getQueueLast().getTasks().getYear()) {
                    if (aux.getTasks().getMonth() > aux.getQueueLast().getTasks().getMonth()) {
                        temp.setTasks(aux.getTasks());
                        aux.setTasks(aux.getQueueLast().getTasks());
                        aux.getQueueLast().setTasks(temp.getTasks());
                        aux = first;
                    } else if (aux.getTasks().getMonth() == aux.getQueueLast().getTasks().getMonth()) {
                        if (aux.getTasks().getDay() > aux.getQueueLast().getTasks().getDay()) {
                            temp.setTasks(aux.getTasks());
                            aux.setTasks(aux.getQueueLast().getTasks());
                            aux.getQueueLast().setTasks(temp.getTasks());
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
            queue += aux.getTasks()+ "\n";
            aux = aux.getQueueLast();
        }
        return queue;
    }

}
