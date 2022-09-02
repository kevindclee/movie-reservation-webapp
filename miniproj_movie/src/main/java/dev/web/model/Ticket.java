package dev.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TICKET_ID")
	private Long id;

	@Column(name = "TIME_STAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp; // 날짜 & 시간
		
	@OneToOne @MapsId
	private Seat seat; // 좌석조회
		
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	
	
	public Ticket() {
		super();
	}

	public Ticket(Long id, Date timeStamp, Seat seat, User user) {
		super();
		this.id = id;
		this.timeStamp = timeStamp;
		this.seat = seat;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", timeStamp=" + timeStamp + ", seat=" + seat + ", user=" + user + "]";
	}
	
	
}
