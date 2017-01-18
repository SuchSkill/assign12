package repositories;

public interface IRepository<TEntity>{
	
	TEntity getById(int id);
	void persist(TEntity entity);
	void delete(TEntity entity);
	long count();
}