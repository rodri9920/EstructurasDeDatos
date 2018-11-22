
package Package;


public class Usuario {
    
    private String username, password ;
    private Queue tareas;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.tareas = new Queue();
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

    public Queue getTareas() {
        return tareas;
    }

    public void setTareas(Queue tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return username;
    }

    
    
    
    
}
