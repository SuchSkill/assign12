package querys;

/**
 * Created by Eugene on 18.01.2017.
 */
public class CustomerQuery extends QueryBase {
	
	public String name;
	public Integer discountRate;
	
	public boolean hasName() {
		return this.isSet(name);
	}
	public boolean hasDiscount() {
		return this.isSet(discountRate);
	}
	
	
	@Override
	public void clear() {
		id = null;
		name = null;
	}
}
