package dev.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Seat {
	@Id
	@Column(name = "SEAT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	@Column(name = "SEAT_NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "AUDITORIUM_ID")
	private Auditorium auditorium;

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(Long id, String name, Auditorium auditorium) {
		super();
		this.id = id;
		this.name = name;
		this.auditorium = auditorium;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", name=" + name + ", auditorium=" + auditorium + "]";
	}
	
	
}
