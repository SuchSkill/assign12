package entities;

import persistance.EntityBase;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "OrderItem")
public class OrderItem extends EntityBase implements Serializable {
	@Id
	@GeneratedValue(//
			strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ITEM_ID")
	private int id;
	
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn( //
			name = "ORDER_ITEM_ORDER_FK", //
			nullable = false //
//			foreignKey = @ForeignKey(name = "ORDER_ID"),
//			referencedColumnName = "ORDER_ID"
	)
	private Order order;
	
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn( //
			name = "ORDER_ITEM_PRODUCT_FK", //
			nullable = false //
//			foreignKey = @ForeignKey(name = "PRODUCT_ID"),
//			referencedColumnName = "PRODUCT_ID"
	
	)
	private Product product;
	
	@Column(name = "ORDER_ITEM_COUNT")
	private int count;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
