package persistance;

import entities.Customer;
import querys.CustomerQuery;
import repositories.ICustomerRepository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public class CustomerRepository extends RepositoryBase<Customer> implements
		ICustomerRepository{
	
	
	protected CustomerRepository(Context context) {
		super(context, Customer.class);
	}
	

	@Override
	public List<Customer> getVIPCustomers() {
		CustomerQuery query = new CustomerQuery();
		query.discountRate = 0;
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<Customer> criteria = this.criteria(builder);
		Root<Customer> customer = this.getRoot(criteria);
		criteria.where(builder.greaterThan(customer.get("discountRate"), query.discountRate));
		Query criteriaQuery = this.entityManager().createQuery(criteria);
		return (List<Customer>) criteriaQuery.getResultList();
	}
	
	@Override
	public List<Customer> getByQuery(CustomerQuery query) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<Customer> criteria = this.criteria(builder);
		Root<Customer> customer = this.getRoot(criteria);
		if (query.hasId()) {
			criteria.where(builder.equal(customer.get("id"), query.id));
		}
		if (query.hasName()) {
			criteria.where(builder.like(customer.get("name"), query.name));
		}
		Query criteriaQuery = this.entityManager().createQuery(criteria);
		return (List<Customer>) criteriaQuery.getResultList();
	}
}
