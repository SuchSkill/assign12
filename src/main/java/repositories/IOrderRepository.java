package repositories;

import entities.Customer;
import entities.Order;
import querys.CustomerQuery;
import querys.OrderQuery;

import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public interface IOrderRepository extends IRepository<Order>  {
	List<Order> getByQuery(OrderQuery query);
	int getProductAmountSince(OrderQuery query);
}
