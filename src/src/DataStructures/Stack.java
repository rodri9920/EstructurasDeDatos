
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
            boolean getsIn = true;
            Node aux = top;
            while(aux != null){
                if(project.getName().equals(aux.getProject().getName())){
                    getsIn = false;
                    break;
                }else{
                    aux = aux.getDown();
                }
            }
            if(getsIn){
                Node n = new Node(project);
                top.setDown(n);
                top = n;
                length++;
            }else{
                System.out.println("There is already a project with that name");
            }
            
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
