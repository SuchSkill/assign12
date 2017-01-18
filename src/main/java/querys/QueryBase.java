package querys;

/**
 * Created by Eugene on 18.01.2017.
 */
public abstract class QueryBase implements IQuery {
	
	public Integer id;
	
	public final boolean hasId() {
		return this.isSet(id);
	}
}