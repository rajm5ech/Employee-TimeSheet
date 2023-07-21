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

    public Task() {
    }

    public Task(String task, Employee emp) {

        this.task = task;
        this.emp = emp;
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

    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id +
                ", \"task\": \"" + task + "\"" +
                '}';
    }
}
