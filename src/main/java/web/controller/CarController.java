package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceimpl;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarService carService;
    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> result = carService.getCars(count);
        model.addAttribute("result", result);

        return "cars";
    }
}
