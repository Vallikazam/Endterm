import java.util.ArrayList;
import java.util.List;

public class ManageTask {
    private List<Task> allTasks;
    public ManageTask(){
        allTasks = new ArrayList<>();
    }
    public void addTask(Task task, int priority){
        task.setPriority(priority);
        allTasks.add(task);
    }
    public void deleteTask(int id){
        allTasks.remove(id);
    }
    public List<Task> getAllTasks(){
        return allTasks;
    }
    public List<Task> getCompletedTasks(){
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : allTasks){
            if (task.getState()){
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }
    public List<Task> getUncompletedTasks() {
        List<Task> uncompletedTasks = new ArrayList<>();
        for (Task task : allTasks) {
            if (!task.getState()) {
                uncompletedTasks.add(task);
            }
        }
        return uncompletedTasks;
    }
}
