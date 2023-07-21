package rupesh.task1.rupesh_api.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String role;
    @OneToMany(mappedBy = "emp")
    private List<Task> tasks;

    public Employee() {
    }

    public Employee(Integer id, String name, String role, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.tasks = tasks;
    }

    public Employee(String name, String role, List<Task> tasks) {
        this.name = name;
        this.role = role;
        this.tasks = tasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id +
                ", \"tasks\": " + tasks +
                '}';
    }
}
