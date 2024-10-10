package in.ashokit;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.ProductIdEntity;
import in.ashokit.repo.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ProductRepository bean = context.getBean(ProductRepository.class);
		
		ProductIdEntity entity = new ProductIdEntity();
		
		entity.setProdName("Speaker");
		entity.setProduct_Price(37040.55);
		entity.setProdMfDate(new Date());
		
		ProductIdEntity saveEntity = bean.save(entity);
		
		System.out.println(saveEntity);
		
		context.close();
	}

}
