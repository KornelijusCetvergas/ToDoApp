package lt.cajavau12.ToDoList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lt.cajavau12.ToDoList.entities.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long>{
	
	@Transactional
	public void deleteByIsDone(boolean isDone);

}
