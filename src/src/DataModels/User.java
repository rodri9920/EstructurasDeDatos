
package src.DataModels;

import src.DataStructures.Queue;


public class User {
    
    private String username, password ;
    private Queue projects;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.projects = new Queue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Queue getProjects() {
        return projects;
    }

    public void setProjects(Queue tareas) {
        this.projects = tareas;
    }

    @Override
    public String toString() {
        return username;
    }

    
    
    
    
}
