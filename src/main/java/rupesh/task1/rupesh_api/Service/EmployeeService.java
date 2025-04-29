package rupesh.task1.rupesh_api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rupesh.task1.rupesh_api.Employee_Repo.E_repo;
import rupesh.task1.rupesh_api.Employee_Repo.Task_repo;
import rupesh.task1.rupesh_api.Entity.Employee;
import rupesh.task1.rupesh_api.Entity.Task;

import java.util.List;

@Service
public class EmployeeService {

    public final E_repo eRepo;
    public final Task_repo tRepo;

    @Autowired
    public EmployeeService(E_repo eRepo, Task_repo tRepo) {
        this.eRepo = eRepo;
        this.tRepo = tRepo;
    }

    // Employee creation and task assignement along with it from one API.

    public String empCreationTask(Employee emp) {
        Employee emp1 = new Employee();
        emp1.setId(emp.getId());
        emp1.setName(emp.getName());
        emp1.setRole(emp.getRole());
        eRepo.save(emp1);

        Task task = new Task();
        for (Task t1 : emp.getTasks()) {
            task.setId(t1.getId());
            task.setTask(t1.getTask());
            task.setEmp(emp1);
            task.setStatus(0);
            tRepo.save(task);
        }

        return "Employee Created and task assigned";
    }

    // Get all the tasks assigned to the emp.

    public List<Task> empTasks(Integer id) {
        return eRepo.taskOfEmployee(id);
    }

    // Get all emp feature pagination.

    public List<Employee> allEmployees(int pageNumber, int rowNumber) {
        PageRequest page = PageRequest.of(pageNumber, rowNumber);
        return eRepo.findAll(page).getContent();
    }

    // Task status change.

    public String statusChange(Integer empId, Integer id) {
        Task t1 = tRepo.find_By_Id(empId, id);
        t1.setStatus(1);
        tRepo.save(t1);
        return "Task" + " " + id + " " + "status changed to completed";
    }

    // List of completed tasks of employee.

    public List<Task> completedTasks(Integer id, int status) {
        return eRepo.completedTaskList(id, status);
    }
}
