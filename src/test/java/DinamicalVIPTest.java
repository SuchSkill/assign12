import entities.*;
import entities.Order;
import entities.Product;
import org.junit.Assert;
import org.junit.Test;
import persistance.Context;
import repositories.ICustomerRepository;
import repositories.IOrderItemRepository;
import repositories.IOrderRepository;
import repositories.IProductRepository;

import java.time.LocalDate;

/**
 * Created by Eugene on 18.01.2017.
 */
public class DinamicalVIPTest extends RepositoryTestBase {
	@Test
	public void getCount() {
		Context context = this.context();
		ICustomerRepository customerRepository = context.customer();
		Customer customer = new Customer();
		customer.setName("Igor");
		customer.setDiscountRate(0);
		customerRepository.persist(customer);
		flush();
		
		IProductRepository productRepository = context.product();
		Product product = new Product();
		product.setName("Pizza");
		productRepository.persist(product);
		flush();
		IOrderRepository orderRepository = context.order();
		Order order = new Order();
		order.setCustomer(customer);
		order.setDate(LocalDate.now());
		orderRepository.persist(order);
		flush();
		IOrderItemRepository orderItemRepository = context.orderItem();
		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(order);
		orderItem.setCount(1000);
		orderItem.setProduct(product);
		orderItemRepository.persist(orderItem);
		flush();
		
	}
	
}
