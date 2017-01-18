package repositories;

import querys.CustomerQuery;
import entities.Customer;

import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public interface ICustomerRepository extends IRepository<Customer> {
	
	List<Customer> getVIPCustomers();
	List<Customer> getByQuery(CustomerQuery query);
}
