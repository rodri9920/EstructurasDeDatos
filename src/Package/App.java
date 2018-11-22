
package Package;

import Package.AppUI.SignInUI;
import Package.DataModels.User;
import Package.DataModels.Project;
import Package.DataModels.Task;
import Package.DataStructures.UserList;
import Package.DataStructures.Queue;


public class App {


    public static void main(String[] args) {
        UserList list = new UserList();
        list.add(new User("rodri9920", "5"));
        list.add(new User("pepe2000", "*****"));
        list.add(new User("juanito1408", "Hernandez"));
        list.add(new User("anamaria4578", "Zeledon"));
        list.add(new User("rodri9920", "***"));
        System.out.println(list);
        list.signIn("rodri9920", "4");
        Queue queue = new Queue();
        queue.enqueue(new Project("Proyecto", 2, 5));
        queue.enqueue(new Project("Tarea", 3, 4));
        queue.enqueue(new Project("Taller", 7, 7));
        queue.enqueue(new Project("Presentacion", 4, 1));
        queue.enqueue(new Project("Caso", 1, 5));
        queue.orderByPriority();
        System.out.println(queue);
        queue.orderByDate();
        System.out.println(queue);
        queue.removeByName("Tarea");
        System.out.println(queue);
        
//        UserList list = new UserList();
//        list.add(new User("rodri9920", "5"));
//        list.add(new User("pepe2000", "*****"));
//        list.add(new User("juanito1408", "Hernandez"));
//        list.add(new User("anamaria4578", "Zeledon"));
//        list.add(new User("rodri9920", "***"));
//        System.out.println(list);
//        list.signIn("rodri9920", "4");
//        Queue queue = new Queue();
//        queue.enqueue(new Project("Proyecto", 2, 5));
//        queue.enqueue(new Project("Tarea", 3, 4));
//        queue.enqueue(new Project("Taller", 7, 7));
//        queue.enqueue(new Project("Presentacion", 4, 1));
//        queue.enqueue(new Project("Caso", 1, 5));
//        queue.orderByPriority();
//        System.out.println(queue);
//        queue.orderByDate();
//        System.out.println(queue);
//        queue.removeByName("Tarea");
//        System.out.println(queue);
        
    }
    
}
