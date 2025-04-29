package rupesh.task1.rupesh_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rupesh.task1.rupesh_api.Entity.Employee;
import rupesh.task1.rupesh_api.Entity.Task;
import rupesh.task1.rupesh_api.Service.EmployeeService;

import java.util.List;

@RestController
public class Employee_Controller {


    public final EmployeeService eService;

    @Autowired
    public Employee_Controller(EmployeeService eService)
    {
        this.eService = eService;
    }

    @PostMapping("/emp/creation/tasks")
    public ResponseEntity<String> employeeCreation(@RequestBody Employee emp) {
        String s1 = eService.empCreationTask(emp);
        return ResponseEntity.ok().body(s1);

    }

    @GetMapping("/emp/id/{id}/tasks")
    public List<Task> getTask(@PathVariable Integer id) {

        return eService.empTasks(id);

    }

    @GetMapping("/emp/all")
    public List<Employee> allEmp(@RequestParam int pageNumber, @RequestParam int rowNumber) {

        return eService.allEmployees(pageNumber, rowNumber);

    }

    @GetMapping("/emp/task/status")
    public ResponseEntity<String> statusChange(@RequestParam Integer empId, @RequestParam Integer id) {
        String s1 = eService.statusChange(empId, id);
        return ResponseEntity.ok().body(s1);
    }

    @GetMapping("/emp/id/{id}/task")
    public List<Task> completedTask(@PathVariable Integer id, @RequestParam int status) {
        return eService.completedTasks(id, status);

    }
}
