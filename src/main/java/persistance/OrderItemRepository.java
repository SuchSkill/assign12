package persistance;

import entities.OrderItem;
import querys.OrderItemQuery;
import repositories.IOrderItemRepository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public class OrderItemRepository  extends RepositoryBase<OrderItem> implements
		IOrderItemRepository {
	
	protected OrderItemRepository(Context context) {
		super(context, OrderItem.class);
	}
	

	
	@Override
	public List<OrderItem> getByQuery(OrderItemQuery query) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<OrderItem> criteria = this.criteria(builder);
		Root<OrderItem> orderItem = this.getRoot(criteria);
		if (query.hasId()) {
			criteria.where(builder.equal(orderItem.get("id"), query.id));
		}
		if (query.hasOrder()) {
			criteria.where(builder.equal(orderItem.get("order"), query.order));
		}
		if (query.hasProduct()) {
			criteria.where(builder.equal(orderItem.get("product"), query.product));
		}
		if (query.hasCount()) {
			criteria.where(builder.equal(orderItem.get("count"), query.count));
		}
		Query criteriaQuery = this.entityManager().createQuery(criteria);
		return (List<OrderItem>) criteriaQuery.getResultList();
	}
	
	
}
