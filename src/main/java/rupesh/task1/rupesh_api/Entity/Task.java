package rupesh.task1.rupesh_api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
    @Id
    private Integer id;
    private String task;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee emp;
    @JsonIgnore
    private int status;

    public Task() {
    }

    public Task(String task, Employee emp, int status) {

        this.task = task;
        this.emp = emp;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id +
                ", \"task\": \"" + task + "\"" +
                '}';
    }

}
