package repositories;

import entities.Product;
import querys.ProductQuery;

import java.util.List;

/**
 * Created by Eugene on 18.01.2017.
 */
public interface IProductRepository extends IRepository<Product> {
	List<Product> getByQuery(ProductQuery query);
}
