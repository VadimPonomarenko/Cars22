package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceimpl implements CarService {
    List<Car> list = new ArrayList<Car>();
    {
        list.add(new Car("BMW", "black", 220));
        list.add(new Car("Audi", "white", 310));
        list.add(new Car("Kia", "red", 150));
        list.add(new Car("Honda", "green", 176));
        list.add(new Car("Lexus", "purple", 250));
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count > list.size()) {
            count = list.size();
        } else if (count < 0) {
            count = 0;
        }
        return list.stream().limit(count).collect(Collectors.toList());
    }
}
