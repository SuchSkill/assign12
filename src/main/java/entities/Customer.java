package entities;

import javax.persistence.*;
/**
 * Created by Eugene on 17.01.2017.
 */
import persistance.EntityBase;

import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends EntityBase implements Serializable {
	@Id
	@GeneratedValue(//
			strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "discountRate")
	private int discountRate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDiscountRate() {
		return discountRate;
	}
	
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", discountRate=" + discountRate +
				'}';
	}
}
