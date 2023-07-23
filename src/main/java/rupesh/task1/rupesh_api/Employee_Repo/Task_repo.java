package rupesh.task1.rupesh_api.Employee_Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import rupesh.task1.rupesh_api.Entity.Task;

@Transactional
public interface Task_repo extends JpaRepository<Task, Integer> {

    @Query("Select t FROM Task t WHERE t.emp.id = :emp_Id AND t.id = :id")
    public Task find_By_Id(Integer emp_Id, Integer id);
}
