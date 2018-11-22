
package Package.DataStructures;


public class Project {
    
    private String name;
    private int priority, month;

    public Project(String name, int priority, int month) {
        this.name = name;
        this.priority = priority;
        this.month = month;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
