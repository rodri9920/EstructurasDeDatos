
package src.DataStructures;

import src.DataModels.Project;


public class Stack {
    
    private Node top;
    private int length = 0;
    
    public void push(Project project){
        if(top != null){
            top = new Node(project);
            length++;
        }else{
            Node n = new Node(project);
            top.setDown(n);
            top = n;
            length++;
        }
    }
    
    public Node pop(){
        Node aux = top;
        if(aux != null){
            top = top.getDown();
            length--;
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String msj = "";
        Node aux = top;
        while(aux != null){
            msj += aux.getProject()+"\n";
            aux = aux.getDown();
        }
        return msj;
    }

    public int getLength() {
        return length;
    }
    
    public Project getProject(int position){
        int counter = 0;
        if (top != null) {
            Node aux = top;
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
}
