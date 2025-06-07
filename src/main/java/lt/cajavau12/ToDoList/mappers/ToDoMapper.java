package lt.cajavau12.ToDoList.mappers;

import org.springframework.stereotype.Component;

import lt.cajavau12.ToDoList.dto.ToDoDTO;
import lt.cajavau12.ToDoList.entities.ToDo;

@Component
public class ToDoMapper {
	
	public ToDoDTO toDTO(ToDo entity) {
		return new ToDoDTO(
				entity.getId(),
				entity.getDescription(),
				entity.getIsDone()
				);
	}
	
	public ToDo toEntity(ToDoDTO dto) {
		return new ToDo(
				dto.getDescription(),
				false
				);
	}
	
	public ToDo toEntity(ToDoDTO dto, Long id) {
		return new ToDo(
				id,
				dto.getDescription(),
				dto.getIsDone()
				);
	}
	
	
}
