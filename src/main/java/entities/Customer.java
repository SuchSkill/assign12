package entities;

import javax.persistence.*;
/**
 * Created by Eugene on 17.01.2017.
 */
import persistance.EntityBase;
@Entity
@Table(name = "CUSTOMER")
public class Customer extends EntityBase{
	
	
	@Id
	@GeneratedValue(//
			strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false)
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
}
