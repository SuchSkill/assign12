package entities;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "OrderItem")
public class OrderItem {
	@Id
	@GeneratedValue(//
			strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ITEM_ID", nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn( //
			name = "ORDER_ID", //
			nullable = false, //
			foreignKey = @ForeignKey(name = "ORDER_ITEM_ORDER_FK"))
	private Order order;
	
	@ManyToOne
	@JoinColumn( //
			name = "PRODUCT_ID", //
			nullable = false, //
			foreignKey = @ForeignKey(name = "ORDER_ITEM_PRODUCT_FK"))
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
