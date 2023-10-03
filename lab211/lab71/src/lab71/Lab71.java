/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

/**
 *
 * @author Admin
 */
public class Lab71 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Validate validate = new Validate();
        TaskManagement tm = new TaskManagement();
        Task task = new Task();
        while(true){
            System.out.println("===Task===");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Display task");
            System.out.println("4. Exit");
            
            int choice = validate.getInt("Your choice: ", 1, 4);
            
            switch(choice){
                case 1:
                    task.inputTask();
                    tm.addTask(task);
                    break;
                case 2:
                    int idToDelete = validate.getInt("id to delete: ", 1, tm.getTasks().size());
                    tm.deleteTask(idToDelete);
                    break;
                case 3:
                    tm.displayTask();
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
