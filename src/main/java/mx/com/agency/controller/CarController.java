package mx.com.agency.controller;

import mx.com.agency.entity.Car;
import mx.com.agency.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAll() {
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(
            @PathVariable("id") String carId) {
        return carService.getByid(carId)
                .map(car -> new ResponseEntity<>(car, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Car> save(@RequestBody Car car) {
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Car> update(@RequestBody Car car) {
        return carService.update(car)
                .map(updatedcar -> new ResponseEntity<>(updatedcar, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(
            @PathVariable("id") String productId) {
        if(carService.delete(productId)) return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
