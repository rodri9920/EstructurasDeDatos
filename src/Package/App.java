
package Package;


public class App {


    public static void main(String[] args) {
        UserList list = new UserList();
        list.add(new Usuario("rodri9920", "5"));
        list.add(new Usuario("pepe2000", "*****"));
        list.add(new Usuario("juanito1408", "Hernandez"));
        list.add(new Usuario("anamaria4578", "Zeledon"));
        list.add(new Usuario("rodri9920", "***"));
        System.out.println(list);
        list.signIn("rodri9920", "4");
        Queue cola = new Queue();
        cola.enqueue(new Project("Proyecto", 2, 5));
        cola.enqueue(new Project("Tarea", 3, 4));
        cola.enqueue(new Project("Taller", 7, 7));
        cola.enqueue(new Project("Presentacion", 4, 1));
        cola.enqueue(new Project("Caso", 1, 5));
        cola.orderByPriority();
        System.out.println(cola);
        cola.orderByDate();
        System.out.println(cola);
        cola.removeByName("Tarea");
        System.out.println(cola);
        
    }
    
}
