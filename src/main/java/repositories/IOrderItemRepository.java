package repositories;

import entities.Customer;
import entities.OrderItem;
import querys.OrderItemQuery;
import querys.OrderQuery;

import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public interface IOrderItemRepository extends IRepository<OrderItem> {
	List<OrderItem> getByQuery(OrderItemQuery query);
	
}
