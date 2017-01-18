package querys;

/**
 * Created by Eugene on 18.01.2017.
 */
public class ProductQuery extends QueryBase{
	
	public String name;
	
	public boolean hasName() {
		return this.isSet(name);
	}
	
	@Override
	public void clear() {
		id = null;
		name = null;
	}
}
