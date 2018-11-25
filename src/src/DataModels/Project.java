
package src.DataModels;

import src.DataStructures.Queue;


public class Project {
    
    private String name, description;
    private int priority;
    private Queue tasks;

    public Project(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.tasks = new Queue();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Queue getTasks() {
        return tasks;
    }

    public void setTasks(Queue queue) {
        this.tasks = queue;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
