import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display implements TaskAddition, TaskDisplay, TaskUpdate {
    private ManageTask manageTask;
    private Scanner scanner;

    public Display(ManageTask manageTask){
        this.manageTask = manageTask;
        scanner = new Scanner(System.in);
    }

    @Override
    public void addTask() {
        System.out.println("Enter name of task: ");
        String name = scanner.nextLine();
        System.out.println("Enter priority for task(1-3): ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter deadline of task: ");
        String deadline = scanner.nextLine();
        System.out.println("Enter description for task: ");
        String description = scanner.nextLine();
        Task task = new Task(name, deadline, description, false, priority);
        manageTask.addTask(task, priority);
        System.out.println("\tTask added!");
    }

    @Override
    public void showAllTasks() {
        List<Task> tasks = manageTask.getAllTasks();
        if (tasks.isEmpty()){
            System.out.println("\nThere are no tasks!");
        }else{
            System.out.println("\nAll tasks: ");
            for (int i = 0; i < tasks.size(); i++){
                System.out.println("\n" + (i+1) + ". " + tasks.get(i));
            }
        }
    }

    @Override
    public void showCompletedTasks() {
        List<Task> completedTasks = manageTask.getCompletedTasks();
        if (completedTasks.isEmpty()){
            System.out.println("\nThere are no completed tasks!");
        }else{
            System.out.println("\nAll completed tasks: ");
            for (int i = 0; i < completedTasks.size(); i++){
                System.out.println("\n" + (i+1) + ". " + completedTasks.get(i));
            }
        }
    }

    @Override
    public void showUncompletedTasks() {
        List<Task> uncompletedTasks = manageTask.getUncompletedTasks();
        if (uncompletedTasks.isEmpty()){
            System.out.println("\nThere are no uncompleted tasks!");
        }else{
            System.out.println("\nAll uncompleted tasks: ");
            for (int i = 0; i < uncompletedTasks.size(); i++){
                System.out.println("\n" + (i+1) + ". " + uncompletedTasks.get(i));
            }
        }
    }

    @Override
    public void showPriorityTasks() {
        System.out.println("Priority tasks: ");
        for (int priority = 1; priority <= 3; priority++){
            List<Task> tasks = getPriorityTasks(priority);
            if (!tasks.isEmpty()){
                System.out.println("Priority " + priority + ":");
                for (int i = 0; i < tasks.size(); i++){
                    System.out.println((i+1) + ". " + tasks.get(i));
                }
            }
        }
    }

    private List<Task> getPriorityTasks(int priority){
        List<Task> priorityTasks = new ArrayList<>();
        for (Task task : manageTask.getAllTasks()){
            if (task.getPriority() == priority){
                priorityTasks.add(task);
            }
        }
        return priorityTasks;
    }

    @Override
    public void updateTask() {
        System.out.println("Enter task id that you completed: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        List<Task> tasks = manageTask.getAllTasks();
        if(id >= 1 && id <= tasks.size()){
            Task task = tasks.get(id - 1);
            task.updateTask();
            System.out.println("Task is completed!");
        }else{
            System.out.println("Entered ID is wrong!");
        }
    }

    @Override
    public void deleteTask() {
        System.out.println("Enter task id that you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        List<Task> tasks = manageTask.getAllTasks();
        if(id >= 1 && id <= tasks.size()){
            Task task = tasks.get(id - 1);
            tasks.remove(id - 1);
            System.out.println("Task is deleted!");
        }else{
            System.out.println("Entered ID is wrong!");
        }
    }
    public void start() {
        int choice;
        do {
            menu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    showAllTasks();
                    break;
                case 3:
                    showCompletedTasks();
                    break;
                case 4:
                    showUncompletedTasks();
                    break;
                case 5:
                    showPriorityTasks();
                    break;
                case 6:
                    updateTask();
                    break;
                case 7:
                    deleteTask();
                    break;
                case 8:
                    System.out.println("\n\t\tSee you later!");
                    break;
                default:
                    System.out.println("Invalid choice. \n\tTry again!\n");
            }
        }while(choice != 8);
    }
    private void menu() {
        System.out.println("\t*** Menu ***");
        System.out.println("1. Add task");
        System.out.println("2. Show all tasks");
        System.out.println("3. Show completed tasks");
        System.out.println("4. Show uncompleted tasks");
        System.out.println("5. Show priority tasks");
        System.out.println("6. Complete task");
        System.out.println("7. Remove task");
        System.out.println("8. Exit");
    }
}

interface TaskAddition {
    void addTask();
}

interface TaskDisplay {
    void showAllTasks();
    void showCompletedTasks();
    void showUncompletedTasks();
    void showPriorityTasks();
}

interface TaskUpdate {
    void updateTask();
    void deleteTask();
}
