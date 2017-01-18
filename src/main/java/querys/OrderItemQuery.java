package querys;

import entities.Order;
import entities.Product;

/**
 * Created by Eugene on 18.01.2017.
 */
public class OrderItemQuery extends QueryBase {
	
	public Order order;
	public Product product;
	public Integer count;
	public boolean hasOrder() {
		return this.isSet(order);
	}
	public boolean hasProduct() {
		return this.isSet(product);
	}
	public final boolean hasCount() { return this.isSet(count); }
	
	@Override
	public void clear() {
		id = null;
		
	}
}
