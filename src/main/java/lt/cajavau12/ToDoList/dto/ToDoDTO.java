package lt.cajavau12.ToDoList.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoDTO {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;
	
	private String description;
	private Boolean isDone;
	
	public ToDoDTO() {}
	
	//Constructor
	public ToDoDTO(Long id, String description, Boolean isDone) {
		this.id = id;
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
