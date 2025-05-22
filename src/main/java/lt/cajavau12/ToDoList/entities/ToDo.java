package lt.cajavau12.ToDoList.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Boolean isDone;
	
	public ToDo() {}
	
	//Constructors
	public ToDo(Long id, String description, Boolean isDone) {
		this.id = id;
		this.description = description;
		this.isDone = isDone;
	}
	
	public ToDo(String description, Boolean isDone) {
		this.description = description;
		this.isDone = isDone;
	}
	
	//Getters, Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	
}
