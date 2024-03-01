public class Main {
    public static void main(String[] args){
        ManageTask manageTask = new ManageTask();
        Display display = new Display(manageTask);
        display.start();
    }
}
