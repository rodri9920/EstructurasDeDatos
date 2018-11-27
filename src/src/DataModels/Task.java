
package src.DataModels;


public class Task {
    
    private String title, description;
    private int priority, month, day, year;
    private boolean finished;

    public Task(String title, String description, int priority, int month, int day, int year) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.month = month;
        this.day = day;
        this.year = year;
        this.finished=false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

   
    

    @Override
    public String toString() {
        return title;
    }
    
    
    
}
