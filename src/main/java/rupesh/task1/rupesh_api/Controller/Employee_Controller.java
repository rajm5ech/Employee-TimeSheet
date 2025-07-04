package rupesh.task1.rupesh_api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rupesh.task1.rupesh_api.Entity.Employee;
import rupesh.task1.rupesh_api.Entity.Task;
import rupesh.task1.rupesh_api.Service.EmployeeService;

@RestController
public class Employee_Controller {

    @Autowired
    public EmployeeService e_service;

    @PostMapping("/emp/creation/tasks")
    public ResponseEntity<String> employeecreation(@RequestBody Employee emp) {
        String s1 = e_service.emp_Creation_task(emp);
        return ResponseEntity.ok().body(s1);

    }

    @GetMapping("/emp/id/{id}/tasks")
    public List<Task> getTask(@PathVariable Integer id) {

        return e_service.emp_tasks(id);

    }

    @GetMapping("/emp/all")
    public List<Employee> all_Emp(@RequestParam int page_Number, @RequestParam int row_Number) {

        return e_service.all_Employees(page_Number, row_Number);

    }

    @GetMapping("/emp/task/status")
    public ResponseEntity<String> statusChange(@RequestParam Integer emp_Id, @RequestParam Integer id) {
        String s1 = e_service.statusChange(emp_Id, id);
        return ResponseEntity.ok().body(s1);
    }

    @GetMapping("/emp/id/{id}/task")
    public List<Task> completedTask(@PathVariable Integer id, @RequestParam int status) {
        return e_service.completedTasks(id, status);

    }
}
