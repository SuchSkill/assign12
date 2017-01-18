package querys;

/**
 * Created by Eugene on 18.01.2017.
 */
public interface IQuery {
	void clear();
	
	default public boolean isSet(String property) {
		return property != null && !property.isEmpty();
	}
	default public boolean isSet(Object property) {
		return property != null;
	}
	
	default public boolean isSet(Integer property) {
		return property != null;
	}
}
