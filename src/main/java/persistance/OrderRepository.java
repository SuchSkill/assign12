package persistance;

import entities.Order;
import entities.OrderItem;
import querys.OrderItemQuery;
import querys.OrderQuery;
import repositories.IOrderRepository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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
	public void persist(Order entity) {
		int id = entity.getCustomer().getId();
		int productAmountSinceYear = getProductAmountSinceYear(id);
		System.out.println(" my method "+ productAmountSinceYear);
		if (productAmountSinceYear > 1000 && productAmountSinceYear < 5000){
//			setDiscountRate(5, id);
			entity.getCustomer().setDiscountRate(5);
		}
		if (productAmountSinceYear > 5000){
//			setDiscountRate(10, id);
			entity.getCustomer().setDiscountRate(10);
			
		}
		this.entityManager().persist(entity);
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
	
	private int getProductAmountSinceYear(int i) {
//		CriteriaBuilder builder = this.criteriaBuilder();
//		CriteriaQuery<Order> criteria = this.criteria(builder);
//		Root<Order> orderItem = this.getRoot(criteria);
		
		Query sumQuery = this.entityManager()
				.createNativeQuery(
						"select sum(order_item_count) from customer,ordert,orderitem where customer_id = "+ i +
								" and order_customer_fk = customer_id " +
								"and order_id = order_item_order_fk"
				);
		
		Object singleResult = sumQuery.getSingleResult();
		System.out.println(singleResult);
		if (singleResult == null) {
			return 0;
		}
		BigDecimal b = (BigDecimal) singleResult;
		return b.intValue();
	}
}
