
package proyectroestructuras;


public class ProyectroEstructuras {


    public static void main(String[] args) {
        ListaUsuarios list = new ListaUsuarios();
        list.agregarUsuario(new Usuario("rodri9920", "5"));
        list.agregarUsuario(new Usuario("pepe2000", "*****"));
        list.agregarUsuario(new Usuario("juanito1408", "Hernandez"));
        list.agregarUsuario(new Usuario("anamaria4578", "Zeledon"));
        list.agregarUsuario(new Usuario("rodri9920", "***"));
        System.out.println(list);
        list.iniciarSesion("rodri9920", "4");
        ColaProyecto cola = new ColaProyecto();
        cola.encola(new Proyecto("Proyecto", 2, 5));
        cola.encola(new Proyecto("Tarea", 3, 4));
        cola.encola(new Proyecto("Taller", 7, 7));
        cola.encola(new Proyecto("Presentacion", 4, 1));
        cola.encola(new Proyecto("Caso", 1, 5));
        cola.ordenarPorPrioridad();
        System.out.println(cola);
        cola.ordenarPorFecha();
        System.out.println(cola);
        cola.eliminarProyecto("Tarea");
        System.out.println(cola);
        
    }
    
}
