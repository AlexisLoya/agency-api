package mx.com.agency.service;

import mx.com.agency.entity.Car;
import mx.com.agency.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return (List<Car>) carRepository.findAll();
    }

    public Optional<Car> getByid(String id) {
        return carRepository.findById(id);
    }

    public Car save(Car entity) {
        return carRepository.save(entity);
    }

    public Car update(Car entity) {
        Optional<Car> updatedCar = carRepository.findById(entity.get_id());
        if (updatedCar.get() != null){
            return carRepository.save(entity);
        }
        return null;
    }


    public Boolean delete(String id) {
        return getByid(id).map(entity -> {
            carRepository.delete(entity);
            return true;
        }).orElse(false);
    }
}
