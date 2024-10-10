package in.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.ProductIdEntity;

public interface ProductRepository extends JpaRepository<ProductIdEntity, Serializable>{

}
