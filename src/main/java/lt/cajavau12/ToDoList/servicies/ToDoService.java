package lt.cajavau12.ToDoList.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lt.cajavau12.ToDoList.dto.ToDoDTO;
import lt.cajavau12.ToDoList.entities.ToDo;
import lt.cajavau12.ToDoList.mappers.ToDoMapper;
import lt.cajavau12.ToDoList.repositories.ToDoRepository;

@Service
public class ToDoService {
	
	final private ToDoRepository toDoRepository;
	final private ToDoMapper toDoMapper;
	
	public ToDoService(ToDoRepository toDoRepository,ToDoMapper toDoMapper) {
		this.toDoRepository = toDoRepository;
		this.toDoMapper = toDoMapper;
	}
	
	public List<ToDoDTO> getAll() {
		return toDoRepository
				.findAll()
				.stream()
				.map(toDoMapper::toDTO)
				.toList();
	}

	public Optional<ToDoDTO> getById(Long id) {
		return toDoRepository
				.findById(id)
				.map(toDoMapper::toDTO);
	}

	public ToDoDTO create(ToDoDTO dto) {
		ToDo entity = toDoMapper.toEntity(dto);
		
		return toDoMapper.toDTO( toDoRepository.save(entity) );
	}

	public ToDoDTO update(Long id, ToDoDTO dto) {
		ToDo existing = toDoRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("ToDo with the ID:" + id + " not found.") );
		
		existing.setDescription(dto.getDescription());
		existing.setIsDone(dto.getIsDone());
		
		return toDoMapper.toDTO(toDoRepository.save(existing));
	}
	
	public void delete(Long id) {
		toDoRepository.deleteById(id);
	}

	public ToDoDTO toggle(Long id) {
		ToDo existing = toDoRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("ToDo with the ID:" + id + " not found.") );
		if(existing.getIsDone()) {
			existing.setIsDone(false);
		} else {
			existing.setIsDone(true);
		}
		return toDoMapper.toDTO(toDoRepository.save(existing));
	}
	
}
