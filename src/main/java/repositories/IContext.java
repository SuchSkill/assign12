package repositories;

/**
 * Created by Eugene on 18.01.2017.
 */
public interface IContext {
	
	ICustomerRepository customer();
	IOrderItemRepository orderItem();
	IOrderRepository order();
	IProductRepository product();
}