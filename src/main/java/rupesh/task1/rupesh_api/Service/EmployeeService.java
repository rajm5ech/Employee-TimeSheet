package rupesh.task1.rupesh_api.Service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import rupesh.task1.rupesh_api.Employee_Repo.E_repo;
import rupesh.task1.rupesh_api.Employee_Repo.Task_repo;
import rupesh.task1.rupesh_api.Entity.Employee;
import rupesh.task1.rupesh_api.Entity.Task;

@Service
public class EmployeeService {
    public E_repo e_repo;
    public Task_repo t_repo;

    public EmployeeService(E_repo e_repo, Task_repo t_repo) {
        this.e_repo = e_repo;
        this.t_repo = t_repo;
    }

    // Employee creation and task assignement along with it from one API.

    public String emp_Creation_task(Employee emp) {
        Employee emp1 = new Employee();
        emp1.setId(emp.getId());
        emp1.setName(emp.getName());
        emp1.setRole(emp.getRole());
        e_repo.save(emp1);

        Task task = new Task();
        for (Task t1 : emp.getTasks()) {
            task.setId(t1.getId());
            task.setTask(t1.getTask());
            task.setEmp(emp1);
            t_repo.save(task);
        }

        return "Employee Created and task assigned";
    }

    // Get all the tasks assigned to the emp.

    public List<Task> emp_tasks(Integer id) {
        List<Task> tasks = e_repo.taskOfEmployee(id);
        return tasks;
    }

    // Get all emp feature pagination.

    public List<Employee> all_Employees(int page_Number, int row_Number) {
        PageRequest page = PageRequest.of(page_Number, row_Number);
        List<Employee> emp = e_repo.findAll(page).getContent();
        return emp;
    }
}
