
package src.DataModels;

import src.DataStructures.Queue;


public class Project {
    
    private String name, description;
    private int priority, month, day, year;
    private Queue tasks;

    public Project(String name, int priority, int month, int day, int year) {
        this.name = name;
        this.priority = priority;
        this.month = month;
        this.day = day;
        this.year = year;
        this.tasks = new Queue();
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Queue getTasks() {
        return tasks;
    }

    public void setTasks(Queue queue) {
        this.tasks = queue;
    }
    
    
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
