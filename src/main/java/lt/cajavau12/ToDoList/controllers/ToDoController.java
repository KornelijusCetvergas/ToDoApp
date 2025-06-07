package lt.cajavau12.ToDoList.controllers;

import lt.cajavau12.ToDoList.dto.ToDoDTO;
import lt.cajavau12.ToDoList.servicies.ToDoService;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/todo")
public class ToDoController {
	
	private final ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ToDoDTO>> getAll() {
		return ResponseEntity.ok( toDoService.getAll() );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ToDoDTO> getById(@PathVariable Long id) {
		return ResponseEntity.of( toDoService.getById(id) );
	}
	
	@PostMapping
	public ResponseEntity<ToDoDTO> create(@RequestBody ToDoDTO dto) {
		return ResponseEntity.status(HttpStatusCode.valueOf(201))
				.body(toDoService.create(dto));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ToDoDTO> update(@PathVariable Long id, @RequestBody ToDoDTO dto) {
		return ResponseEntity.ok( toDoService.update(id, dto) );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		toDoService.delete(id);
		return ResponseEntity.status(HttpStatusCode.valueOf(204))
				.body(null);
	}
	
	@PatchMapping("/{id}/toggle")
	public ResponseEntity<ToDoDTO> update(@PathVariable Long id) {
		return ResponseEntity.ok( toDoService.toggle(id) );
	}
	
	@DeleteMapping("/alldone")
	public ResponseEntity<Boolean> deleteAllDone() {
		toDoService.deleteAllDone();
		return ResponseEntity.status(HttpStatusCode.valueOf(204))
				.body(null);
	}
}
