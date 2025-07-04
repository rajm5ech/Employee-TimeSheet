package rupesh.task1.rupesh_api.Employee_Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import rupesh.task1.rupesh_api.Entity.Employee;
import rupesh.task1.rupesh_api.Entity.Task;

@Transactional
public interface E_repo extends JpaRepository<Employee, Integer> {

    @Query("SELECT t FROM Task t WHERE t.emp.id = :id")
    public List<Task> taskOfEmployee(Integer id);

    @Query("Select t FROM Task t WHERE t.emp.id = :id AND status = :status")
    public List<Task> completed_TaskList(@Param("id") Integer id, @Param("status") int status);
}
