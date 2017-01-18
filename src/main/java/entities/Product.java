package entities;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(//
			strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String name;
	
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
}
