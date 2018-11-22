
package proyectroestructuras;


public class Usuario {
    
    private String username, password ;
    private ColaProyecto tareas;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.tareas = new ColaProyecto();
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

    public ColaProyecto getTareas() {
        return tareas;
    }

    public void setTareas(ColaProyecto tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return username;
    }

    
    
    
    
}
