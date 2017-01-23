import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Eugene on 18.01.2017.
 */
import repositories.*;
import querys.*;
import entities.*;

import java.util.List;


public class CustomerRepositoryTest extends RepositoryTestBase {
	@Test
	public void persistTest() {
		ICustomerRepository sut = this.context().customer();
		long countBefore = sut.count();
		Customer customer = new Customer();
		customer.setName("Bob");
		customer.setDiscountRate(0);
		sut.persist(customer);
		flush();
		Customer persisted = sut.getById(customer.getId());
		Assert.assertEquals(customer.getName(), persisted.getName());
		long countAfter = sut.count();
		Assert.assertEquals(countBefore + 1, countAfter);
	}
	
	@Test
	public void getByQuery() {
		ICustomerRepository sut = this.context().customer();
		long countBefore = sut.count();
		CustomerQuery emptyQuery = new CustomerQuery();
		List<Customer> customersBeforeEmptyQuery = sut.getByQuery(emptyQuery);
		Assert.assertEquals(countBefore, customersBeforeEmptyQuery.size());
		Customer customer = new Customer();
		customer.setName("Bob");
		customer.setDiscountRate(0);
		sut.persist(customer);
		flush();
		CustomerQuery selectiveQuery = new CustomerQuery();
		selectiveQuery.name = "Bob";
		List<Customer> customersAfterSelectiveQuery = sut.getByQuery(emptyQuery);
		Assert.assertEquals(1, customersAfterSelectiveQuery.size());
		Assert.assertEquals(customer.getName(), customersAfterSelectiveQuery.get(0).getName());
	}
	
}
