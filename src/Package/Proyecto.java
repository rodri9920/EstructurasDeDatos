
package Package;


public class Proyecto {
    
    private String nombre;
    private int prioridad, mes;

    public Proyecto(String nombre, int prioridad, int mes) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
