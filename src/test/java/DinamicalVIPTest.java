import entities.*;
import entities.Order;
import entities.Product;
import org.junit.Assert;
import org.junit.Test;
import persistance.Context;
import querys.CustomerQuery;
import querys.OrderItemQuery;
import repositories.ICustomerRepository;
import repositories.IOrderItemRepository;
import repositories.IOrderRepository;
import repositories.IProductRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public class DinamicalVIPTest extends RepositoryTestBase {
	@Test
	public void DinamicalVIPTest() {
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
		orderItem.setCount(5001);
		orderItem.setProduct(product);
		orderItemRepository.persist(orderItem);
		flush();
		
		Order order2 = new Order();
		order2.setCustomer(customer);
		order2.setDate(LocalDate.now());
		orderRepository.persist(order2);
		flush();
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setOrder(order2);
		orderItem2.setCount(5001);
		orderItem2.setProduct(product);
		orderItemRepository.persist(orderItem2);
		flush();
		List<Customer> CustomersVIP = customerRepository.getVIPCustomers();
		Assert.assertEquals(10, CustomersVIP.get(0).getDiscountRate());
		
		
	}
	
}
