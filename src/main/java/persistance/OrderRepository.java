package persistance;

import entities.Order;
import querys.OrderQuery;
import repositories.IOrderRepository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public class OrderRepository  extends RepositoryBase<Order> implements
		IOrderRepository {
	
	protected OrderRepository(Context context) {
		super(context, Order.class);
	}
	
	@Override
	public List<Order> getByQuery(OrderQuery query) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<Order> criteria = this.criteria(builder);
		Root<Order> order = this.getRoot(criteria);
		if (query.hasId()) {
			criteria.where(builder.equal(order.get("id"), query.id));
		}
		if (query.hasCustomer()) {
			criteria.where(builder.equal(order.get("customer"), query.customer));
		}
		if (query.hasDate()) {
			criteria.where(builder.equal(order.get("date"), query.date));
		}
		Query criteriaQuery = this.entityManager().createQuery(criteria);
		return (List<Order>) criteriaQuery.getResultList();
	}
	
	@Override
	public int getProductAmountSince(OrderQuery query) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<Order> criteria = this.criteria(builder);
		Root<Order> order = this.getRoot(criteria);
		
		Query sumQuery = this.entityManager()
				.createQuery("SELECT SUM(oi.ORDER_ITEM_COUNT) " +
						"FROM orderitem oi, ordert o " +
						"WHERE oi.ORDER_ITEM_ORDER_FK = o.ORDER_ID " +
						"and o.order_date >=" + query.date +" " +
						"and o.ORDER_CUSTOMER_FK = "+ query.customer);
		
		Object singleResult = sumQuery.getSingleResult();
		System.out.println((Integer) singleResult);
		return (Integer) singleResult;
	}
}
