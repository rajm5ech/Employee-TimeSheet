package rupesh.task1.rupesh_api.Employee_Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import rupesh.task1.rupesh_api.Entity.Task;

@Repository
@Transactional
public interface Task_repo extends JpaRepository<Task, Integer> {

}
