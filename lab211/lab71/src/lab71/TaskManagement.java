/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TaskManagement {

    Validate validate = new Validate();
    List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
        System.out.println("added");
    }

    public void deleteTask(int idToDelete) {
        boolean check = false;
        for (Task t : tasks) {
            if (t.getId() == idToDelete) {
                check = true;
                break;
            }
        }
        if (check) {
            tasks.remove(idToDelete - 1);
            System.out.println("deleted");
        } else {
            System.out.println("not found");
        }
    }

    public void displayTask() {
        System.out.println("---Task---");
        System.out.println("ID \t Name \t Task Type \t Date \t Time \t Assignee \t Reviewer");
        for (Task t : tasks) {
            System.out.println(t.getId() + "\t" + t.getRequireName()+ "\t" + t.getTypeId()+ "\t" + t.getDate()+ "\t" + t.getPlanFrom()+ "\t" + t.getAssignee()+ "\t" + t.getReviewer());
        }
    }
}
