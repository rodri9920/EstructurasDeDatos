
package Package.DataModels;

import Package.DataStructures.Queue;
import Package.DataStructures.Queue;


public class User {
    
    private String username, password ;
    private Queue tasks;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.tasks = new Queue();
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

    public Queue getTasks() {
        return tasks;
    }

    public void setTasks(Queue tareas) {
        this.tasks = tareas;
    }

    @Override
    public String toString() {
        return username;
    }

    
    
    
    
}
