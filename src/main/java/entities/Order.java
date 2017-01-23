package entities;

import org.hibernate.annotations.Type;
import persistance.EntityBase;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 */

@Entity
@Table(name = "ORDERt")
public class Order extends EntityBase implements Serializable {
	
	@Id
	@GeneratedValue(//
			strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
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
	
	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", customer=" + customer +
				", date=" + date +
				'}';
	}
	
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn( //
			name = "ORDER_CUSTOMER_FK", //
			nullable = false //
//			foreignKey = @ForeignKey(name = "CUSTOMER_ID")
//			referencedColumnName = "CUSTOMER_ID"
	)
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
