package src.DataStructures;

import src.DataModels.Task;

public class Queue {

    private Node first, last, data;
    private Task dato;
    private int length = 0;

    /**
     * this method is useful to enqueue the user's project's tasks
     *
     * @param task the one that it is going to be enqueued
     */
    public void enqueue(Task task) {
        if (first == null) {
            first = new Node(task);
            last = first;
            //if there are no task, we enqueue it in first
        } else {
            if (first == last) {
                first.setQueueLast(new Node(task));
                last = first.getQueueLast();
                //if there is only one task, we add the new one in last
            } else {
                last.setQueueLast(new Node(task));
                last = last.getQueueLast();
                //if there are two or more tasks, we add the new one in the end of the queue
            }
        }
        length++;
        //everytime we enqueue a task, the length must increase
    }

    /**
     * this method to get the queue length
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * this method is necessary for the FX screen
     *
     * @param position
     * @return the task in the position indicated in the parameter
     */
    public Task getTask(int position) {
        int counter = 0;//this variable will be compared with the position in the parameter
        if (first != null) {
            Node aux = first;
            while (aux != null) {//once the aux is null it means it already passed throught the hole queue
                if (counter == position) {
                    return aux.getTasks();
                    //if the counter gets to the rigth position
                } else {
                    aux = aux.getQueueLast();
                    counter++;
                    //to know if the position required is in the queue, the counter will increase in one and the aux will keep passing through the queue
                }
            }
            return null;//if the position required does not exist, the method returns null
        } else {
            return null;//if there are no tasks, the method returns null
        }
    }

    /**
     * this method is made to order the tasks by their priority, in order to
     * make the user able to know which are the most important
     */
    public void orderByPriority() {
        Node aux = first;
        Node temp = new Node(dato);
        if (aux != null) {//first thing to do is to make sure that the queue is not empty
            while (aux.getQueueLast() != null) {
                if (aux.getTasks().getPriority() > aux.getQueueLast().getTasks().getPriority()) {
                    temp.setTasks(aux.getTasks());
                    aux.setTasks(aux.getQueueLast().getTasks());
                    aux.getQueueLast().setTasks(temp.getTasks());
                    aux = first;
                    //we must compare to the task next to the aux in order to interchange positions if necessary
                    //the aux must be go back to the first position to pass through the list from the beginning again
                } else {
                    aux = aux.getQueueLast();
                }
            }
        }
    }

    /**
     * this method is made to order the tasks by their due date
     */
    public void orderByDate() {
        Node aux = first;
        Node temp = new Node(dato);
        if (aux != null) {//first thing to do is to make sure that the queue is not empty
            while (aux.getQueueLast() != null) {
                if (aux.getTasks().getYear() > aux.getQueueLast().getTasks().getYear()) {
                    temp.setTasks(aux.getTasks());
                    aux.setTasks(aux.getQueueLast().getTasks());
                    aux.getQueueLast().setTasks(temp.getTasks());
                    aux = first;
                    //we must compare to the task next to the aux in order to interchange positions if necessary
                    //the aux must be go back to the first position to pass through the list from the beginning again
                } else if (aux.getTasks().getYear() == aux.getQueueLast().getTasks().getYear()) {
                    if (aux.getTasks().getMonth() > aux.getQueueLast().getTasks().getMonth()) {//if both task have the same year, we must order them by month
                        temp.setTasks(aux.getTasks());
                        aux.setTasks(aux.getQueueLast().getTasks());
                        aux.getQueueLast().setTasks(temp.getTasks());
                        aux = first;
                        //we must compare to the task next to the aux in order to interchange positions if necessary
                        //the aux must be go back to the first position to pass through the list from the beginning again
                    } else if (aux.getTasks().getMonth() == aux.getQueueLast().getTasks().getMonth()) {
                        if (aux.getTasks().getDay() > aux.getQueueLast().getTasks().getDay()) {//if both task have the same year and month, we must order them by day
                            temp.setTasks(aux.getTasks());
                            aux.setTasks(aux.getQueueLast().getTasks());
                            aux.getQueueLast().setTasks(temp.getTasks());
                            aux = first;
                            //we must compare to the task next to the aux in order to interchange positions if necessary
                            //the aux must be go back to the first position to pass through the list from the beginning again
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
        }

    }

    /**
     * this method returns the quantity of the tasks that are already finished
     *
     * @return a integer with the number of tasks finished
     */
    public int getFinishedTasks() {
        int finishedTasks = 0;
        if (first != null) {//first thing to do is to make sure that the queue is not empty
            Node aux = first;
            while (aux != null) {//once the node after aux is null is because it reached the end of the queue
                if (aux.getTasks().isFinished()) {
                    finishedTasks++;
                    //if the task is finished, the finishedTasks variable increases in one
                }
                aux = aux.getQueueLast();
            }

        }
        return finishedTasks;
    }

    @Override
    public String toString() {
        String queue = "";
        Node aux = first;
        while (aux != null) {
            queue += aux.getTasks() + "\n";
            aux = aux.getQueueLast();
        }
        return queue;
    }

}
