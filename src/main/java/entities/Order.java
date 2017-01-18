package entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *
 */

@Entity
@Table(name = "ORDERt")
public class Order {
	
	@Id
	@GeneratedValue(//
			strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID", nullable = false)
	private int id;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@ManyToOne
	@JoinColumn( //
			name = "CUSTOMER_ID", //
			nullable = false, //
			foreignKey = @ForeignKey(name = "ORDER_CUSTOMER_FK"))
	private Customer customer;
	
	@Column(name="ORDER_DATE")
	private LocalDate date;
	
	
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
