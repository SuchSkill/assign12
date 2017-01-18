package querys;

import entities.Customer;

import java.time.LocalDate;

/**
 * Created by Eugene on 18.01.2017.
 */
public class OrderQuery extends QueryBase {
	
	public Customer customer;
	public LocalDate date;
	
	public boolean hasCustomer() {
		return this.isSet(customer);
	}
	public boolean hasDate() {
		return this.isSet(date);
	}
	
	@Override
	public void clear() {
		id = null;
		customer = null;
	}
}
