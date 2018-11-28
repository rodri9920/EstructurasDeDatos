
package src.DataStructures;

import src.DataModels.Project;


public class Stack {
    
    private Node top;
    private int length = 0;
    
    /**
     * this method is made to push projects into de stack
     * @param project which is the project wanted to be pushed
     * @return true if the project is able to get into the stack
     */
    public boolean push(Project project){
        if(top == null){//the first thing we do is verify if the stack is not empty or not
            top = new Node(project);
            length++;
            return true;
            //if it is empty, we create a node in top and the method returns true
        }else{
            boolean getsIn = true;
            Node aux = top;
            //if the stack is not empty, we must pass through it using the aux to verify that the project name is able to be used
            while(aux != null){//once the aux becomes null it means it finished passing through the stack
                if(project.getName().equals(aux.getProject().getName())){
                    getsIn = false;
                    break;
                    //if the name is found in the stack the variable turns false and we break the while cicle
                }else{
                    aux = aux.getDown();
                }
            }
            if(getsIn){
                Node n = new Node(project);
                n.setDown(top);
                top = n;
                length++;
                //if the variable remained true, we add the node to the stack and increase length
            }
            
            return getsIn;
            
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
    
    /**
     * this method is made to remove the project got in the parameter
     *
     * @param project
     * @return a boolean that indicates if the project exists
     */
    public boolean remove(Project project) {
        if (top != null) {//first thing to do is to make sure that the stack is not empty
            if (top.getProject().equals(project)) {
                if (top.getDown() != null) {
                    top = top.getDown();
                    length--;//everytime we remove a project, the length must down one 
                    return true;
                } else {
                    length--;
                    top = null;
                }
            } else {//if the project to remove is not in top
                Node aux = top;
                while (aux.getDown() != null) {//once the node after aux is null is because it reached the end of the stack
                    if (aux.getDown().getProject().equals(project)) {
                        aux.setDown(aux.getDown().getDown());
                        length--;
                        return true;
                        //if the project wanted to be removed is after the aux we delete that node from the stack
                    } else {
                        aux = aux.getDown();
                    }
                }
            }

        } else {
            return false;//if there are no projects
        }
        return false;//if the method gets here, it is because the project is not in the queue
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
    
    /**
     * this method is necessary for the FX
     * @return the length of the stack
     */
    public int getLength() {
        return length;
    }
    
    /**
     * this method is useful to get a project and access to its tasks
     * @param position
     * @return the project in the position indicated in the parameter
     */
    public Project getProject(int position){
        int counter = 0;//the counter will be compared with the position variable to get the right project
        if (top != null) {//if the stack is not empty
            Node aux = top;
            while (aux != null) {//once the aux is null is because it reached the end of the stack
                if (counter == position) {//if the counter gets to the position value we return the project
                    return aux.getProject();
                } else {
                    aux = aux.getDown();
                    counter++;
                }
            }
            return null;//if the counter never got the position value it means that the project wanted does not exist
        } else {
            return null;//if there are no projects we return null
        }
    }
}
