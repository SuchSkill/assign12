package persistance;

import entities.Product;
import querys.ProductQuery;
import repositories.IProductRepository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public class ProductRepository extends RepositoryBase<Product> implements
		IProductRepository {
	
	protected ProductRepository(Context context) {
		super(context, Product.class);
	}
	
	@Override
	public List<Product> getByQuery(ProductQuery query) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<Product> criteria = this.criteria(builder);
		Root<Product> product = this.getRoot(criteria);
		if (query.hasId()) {
			criteria.where(builder.equal(product.get("id"), query.id));
		}
		if (query.hasName()) {
			criteria.where(builder.like(product.get("name"), query.name));
		}
		Query criteriaQuery = this.entityManager().createQuery(criteria);
		return (List<Product>) criteriaQuery.getResultList();
	}
}
