package persistance;

import repositories.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Eugene on 18.01.2017.
 */
public final class Context implements IContext {
	
	private static final String PERSISTENCE_UNIT_NAME = "jpa"; // see
	// persistence.xml
	private static final EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	private final EntityManager entityManager; // created for session
	
	private final ICustomerRepository customer;
	private final IOrderRepository order;
	private final IOrderItemRepository orderItem;
	private final IProductRepository product;
	
	public Context() {
		entityManager = entityManagerFactory.createEntityManager();
		customer = new CustomerRepository(this);
		order = new OrderRepository(this);
		orderItem = new OrderItemRepository(this);
		product = new ProductRepository(this);
	}
	
	@Override
	public ICustomerRepository customer(){
		return customer;
	}
	
	@Override
	public IOrderRepository order() {
		return order;
	}
	
	@Override
	public IOrderItemRepository orderItem() {
		return orderItem;
	}
	
	@Override
	public IProductRepository product() {
		return product;
	}
	
	public EntityManager entityManager() {
		return entityManager;
	}
	
	public CriteriaBuilder criteriaBuilder() {
		return this.entityManager() //
				.getCriteriaBuilder(); //
	}
	
	public EntityTransaction transaction() {
		return this.entityManager() //
				.getTransaction();
	}
	
	public void flush() {
		this.entityManager() //
				.flush();
	}
}