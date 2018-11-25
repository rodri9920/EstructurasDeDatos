
package src.DataModels;

import src.DataStructures.Stack;


public class User {
    
    private String username, password ;
    private Stack projects;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.projects = new Stack();
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

    public Stack getProjects() {
        return projects;
    }

    public void setProjects(Stack projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return username;
    }

    
    
    
    
}
