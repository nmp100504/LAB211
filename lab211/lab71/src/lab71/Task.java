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
public class Task {

    int id;
    String typeId;
    String requireName;
    String date;
    double planFrom;
    double planTo;
    String assignee;
    String reviewer;

    public Task() {
    }

    public Task(int id, String typeId, String requireName, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.typeId = typeId;
        this.requireName = requireName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getRequireName() {
        return requireName;
    }

    public void setRequireName(String requireName) {
        this.requireName = requireName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", typeId=" + typeId + ", requireName=" + requireName + ", date=" + date + ", planFrom=" + planFrom + ", planTo=" + planTo + ", assignee=" + assignee + ", reviewer=" + reviewer + '}';
    }
    TaskManagement tm = new TaskManagement();
    Validate validate = new Validate();

    public void inputTask() {
        if (tm.getTasks().isEmpty()) {
            id = 1;
        } else {
            id = tm.getTasks().get(tm.getTasks().size() - 1).getId() + 1;
        }
        typeId = getTaskTypeId();
        requireName = validate.getString("name :", "[A-Za-z\\s]+");
        date = validate.getDate("date: ", "dd-MM-yyyy");
        planFrom = validate.getDouble("plan from ", 8, 17.5);
        planTo = validate.getDouble("plan to", 0.5, 17.5);
        assignee = validate.getString("assignee ", "[A-Za-z\\s]+");
        reviewer = validate.getString("reviewer ", "[A-Za-z\\s]+");
    }

    String getTaskTypeId() {
        System.out.println("1.Code 2.Test 3.Design 4.Review");
        int choice = validate.getInt("Your choice: ", 1, 4);
        String result = "";
        switch (choice) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;

        }
        return result;
    }
}
