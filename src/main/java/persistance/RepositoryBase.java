package persistance;

import repositories.IRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
public abstract class RepositoryBase<TEntity> implements IRepository<TEntity> {

	private final Context context;
	private final Class<TEntity> entityClass;
	
	protected RepositoryBase(Context context, Class<TEntity> entityClass) {
		this.context = context;
		this.entityClass = entityClass;
	}
	
	
	public final void persist(TEntity entity) {
		this.entityManager().persist(entity);
	}
	
	public final void delete(TEntity entity) {
		this.entityManager().remove(entity);
	}
	
	public final TEntity getById(int id) {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<TEntity> criteria = this.criteria(builder);
		Root<TEntity> root = getRoot(criteria);
		criteria.where(builder.equal(root.get("id"), id));
		Query query = this.entityManager().createQuery(criteria);
		return (TEntity) query.getSingleResult();
	}
	
	public final long count() {
		CriteriaBuilder builder = this.criteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		criteria.select(builder.count(criteria.from(this.getEntityClass())));
		Query query = this.entityManager().createQuery(criteria);
		return (long) query.getSingleResult();
	}
	
	protected final Context context() {
		return context;
	}
	
	protected final EntityManager entityManager() {
		return this.context().entityManager();
	}
	
	protected final CriteriaBuilder criteriaBuilder() {
		return this.context().criteriaBuilder();
	}
	
	protected final CriteriaQuery<TEntity> criteria(CriteriaBuilder builder) {
		return builder.createQuery(this.getEntityClass());
	}
	
	protected final Root<TEntity> getRoot(CriteriaQuery<TEntity> criteria) {
		return criteria.from(this.getEntityClass());
	}
	
	protected final Class<TEntity> getEntityClass() {
		return entityClass;
	}
	
	protected final Metamodel metamodel() {
		return this.entityManager().getMetamodel();
	}
	
	protected final <TAnotherEntity> EntityType<TAnotherEntity> entityType(
			Class<TAnotherEntity> anotherEntityClass) {
		return this.metamodel().entity(anotherEntityClass);
	}
}