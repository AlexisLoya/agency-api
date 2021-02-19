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

    public Optional<Car> update(Car entity) {
        try {
            Optional<Car> updatedCar = carRepository.findById(entity.get_id());
            if (updatedCar.get() != null){
                carRepository.save(entity);
                return carRepository.findById(entity.get_id());
            }
            return updatedCar;
        }catch (Exception exception){
            System.err.println(exception);
        }
        return Optional.empty();
    }


    public Boolean delete(String id) {
        return getByid(id).map(entity -> {
            carRepository.delete(entity);
            return true;
        }).orElse(false);
    }
}
