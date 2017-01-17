import javax.persistence.*;

/**
 * Created by Eugene on 17.01.2017.
 */
public class Customer {
	
	@Id
	@GeneratedValue(//
			strategy = GenerationType.AUTO, //
			generator = "Customer_SEQ")
	@SequenceGenerator(name = "Customer_SEQ", sequenceName = "Customer_SEQ", allocationSize = 1)
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	private int id;
	
	
	
	@Column(name = "discountRate")
	private int discountRate;
}
