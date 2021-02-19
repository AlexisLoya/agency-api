package mx.com.agency.repository;

import mx.com.agency.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CarRepository extends MongoRepository<Car, Serializable> {
}
