package rupesh.task1.rupesh_api.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rupesh.task1.rupesh_api.Employee_Repo.E_repo;
import rupesh.task1.rupesh_api.Employee_Repo.Task_repo;
import rupesh.task1.rupesh_api.Entity.Employee;
import rupesh.task1.rupesh_api.Entity.Task;

@RestController
public class Employee_Controller {
    public E_repo e_repo;
    public Task_repo t_repo;

    @Autowired
    public Employee_Controller(E_repo e_repo, Task_repo t_repo) {
        this.e_repo = e_repo;
        this.t_repo = t_repo;
    }

    @PostMapping("/employee")
    public ResponseEntity<String> employeecreation(@RequestBody Employee emp) {

        Employee emp1 = new Employee();
        emp1.setName(emp.getName());
        emp1.setRole(emp.getRole());
        e_repo.save(emp1);

        for (Task t1 : emp.getTasks()) {
            Task task1 = new Task();

            task1.setTask(t1.getTask());
            task1.setId(t1.getId());
            task1.setEmp(emp1);
            t_repo.save(task1);

        }

        return ResponseEntity.ok().body("Employee and its task inserted.");

    }

    @GetMapping("/emp/id/{id}/tasks")
    public List<Task> getTask(@PathVariable Integer id) {
        List<Task> task = e_repo.taskOfEmployee(id);
        return task;
    }
}
