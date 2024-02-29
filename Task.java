class Task {
    private String name;
    private String description;
    private String deadline;
    private boolean isCompleted;

    public Task(String name, String deadline, String description, boolean isCompleted){
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.isCompleted = false;
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

