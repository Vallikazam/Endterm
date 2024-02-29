import java.util.List;
import java.util.Scanner;

class Display{
    private ManageTask manageTask;
    private Scanner scanner;

    public Display(ManageTask manageTask){
        this.manageTask = manageTask;
        scanner = new Scanner(System.in);
    }
    public void menu(){
        System.out.println("1. Add task");
        System.out.println("2. Show all tasks");
        System.out.println("3. Show completed tasks");
        System.out.println("4. Show uncompleted tasks");
        System.out.println("5. Complete task");
        System.out.println("6. Remove task");
        System.out.println("7. Exit");
    }
    private void addTask(){
        System.out.println("Enter name of task: ");
        String name = scanner.nextLine();
        System.out.println("Enter deadline of task: ");
        String deadline = scanner.nextLine();
        System.out.println("Enter description for task: ");
        String description = scanner.nextLine();
        Task task = new Task(name, deadline, description, false);
        manageTask.addTask(task);
        System.out.println("\tTask added!");
    }
    private void showAllTasks(){
        List<Task> tasks = manageTask.getAllTasks();
        if (tasks.isEmpty()){
            System.out.println("\nThere is no tasks!");
        }else{
            System.out.println("\nAll tasks: ");
            for (int i = 0; i < tasks.size(); i++){
                System.out.println("\n" + (i+1) + ". " + tasks.get(i));
            }
        }
    }
    private void showCompletedTasks(){
        List<Task> completedTasks = manageTask.getCompletedTasks();
        if (completedTasks.isEmpty()){
            System.out.println("\nThere is no tasks!");
        }else{
            System.out.println("\nAll completed tasks: ");
            for (int i = 0; i < completedTasks.size(); i++){
                System.out.println("\n" + (i+1) + ". " + completedTasks.get(i));
            }
        }
    }
    private void showUncompletedTasks(){
        List<Task> uncompletedTasks = manageTask.getUncompletedTasks();
        if (uncompletedTasks.isEmpty()){
            System.out.println("\nThere is no tasks!");
        }else{
            System.out.println("\nAll uncompleted tasks");
            for (int i = 0; i < uncompletedTasks.size(); i++){
                System.out.println("\n" + (i+1) + ". " + uncompletedTasks.get(i));
            }
        }
    }
    private void updateTask(){
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
    private void deleteTask(){
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
    public void start(){
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
                    updateTask();
                    break;
                case 6:
                    deleteTask();
                    break;
                case 7:
                    System.out.println("\n\t\tSee you later!");
                    break;
                default:
                    System.out.println("Invalid choice. \n\tTry again!\n");
            }
        }while(choice != 7);
    }
}