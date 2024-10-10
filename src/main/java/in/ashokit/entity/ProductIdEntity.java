package in.ashokit.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Table(name= "PRODUCT_DETAILS")
@Data
public class ProductIdEntity 
{
	@Id
	@Column(name="PRODUCT_ID")
	@GenericGenerator(name="product_id_gen", strategy = "in.ashokit.generator.ProductIdGenerator")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_id_gen")
	private String prodId;
	
	@Column(name= "PRODUCT_NAME")
	private String prodName;
	
	
	private Double product_Price;
	
	@Column(name= "PRODUCT_MF_DATE")
	@Temporal(TemporalType.DATE)
	private Date prodMfDate;
}
