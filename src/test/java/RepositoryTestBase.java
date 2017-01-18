import org.junit.After;
import org.junit.Before;
import persistance.Context;

import javax.persistence.EntityTransaction;

/**
 * Created by Eugene on 18.01.2017.
 */
public abstract class RepositoryTestBase {
	
	private Context _context;
	protected EntityTransaction _transaction;
	
	@Before
	public final void before() {
		_context = new Context();
		_transaction = _context.transaction();
		_transaction.begin();
	}
	
	@After
	public final void after() {
		_transaction.rollback();
	}
	
	protected Context context() {
		return _context;
	}
	
	protected void flush() {
		this.context().flush();
	}
}