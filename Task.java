class Task {
    private String name;
    private String description;
    private String deadline;
    private boolean isCompleted;
    private int priority;

    public Task(String name, String deadline, String description, boolean isCompleted, int priority){
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.isCompleted = false;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public String getDeadline() {
        return deadline;
    }
    public boolean getState() {
        return isCompleted;
    }
    public int getPriority(){
        return priority;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }
    public void updateTask() {
        isCompleted = true;
    }

    public String toString(){
        if(isCompleted) {
            return name + "\nStatus: Completed" + "\nDeadline: " + deadline + "\nDescription: " + description;
        }else{
            return name + "\nStatus: In progress" + "\nDeadline: " + deadline + "\nDescription: " + description;
        }
    }
}

