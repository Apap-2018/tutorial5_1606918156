package com.apap.tutorial4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.service.CarService;
import com.apap.tutorial4.service.DealerService;

import java.util.List;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired 
	private DealerService dealerService;
	
	@RequestMapping(value = "/car/add/{dealerId}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "dealerId") Long dealerId, Model model) {
		CarModel car = new CarModel();
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		car.setDealer(dealer);
		
		model.addAttribute("car", car);
		model.addAttribute("id",car.getDealer().getId());
		return "addCar";
	}
	
	@RequestMapping(value = "/car/add/", method = RequestMethod.POST)
	private String addCarSubmit(@ModelAttribute CarModel car) {
		carService.addCar(car);
		return "add";
	}
	
	@RequestMapping(value = "/car/delete/{carId}", method = RequestMethod.GET)
	private String deleteDealerSubmit(@PathVariable(value = "carId") Long id,Model model) {
		DealerModel updated = dealerService.getDealerDetailById(id).orElse(null);
		List<CarModel> cars = carService.allCarDealer(updated);
		model.addAttribute("cars",cars);
		return "deleteCar";
	}
	
	@RequestMapping(value = "/car/delete/id={carId}", method = RequestMethod.POST)
	private String deleteCarSubmit(@PathVariable(value = "carId") Long id, @ModelAttribute CarModel car) {
		CarModel deleted = carService.getCarDetailById(id).orElse(null);
		carService.deleteCar(deleted);
		return "update";
	}

	@RequestMapping(value = "/car/update/{dealerId}", method = RequestMethod.GET)
	private String update(@PathVariable(value = "dealerId") Long id, Model model) {
		DealerModel updated = dealerService.getDealerDetailById(id).orElse(null);
		List<CarModel> cars = carService.allCarDealer(updated);
		model.addAttribute("cars",cars);
		return "updateCar";
	}
	
	@RequestMapping(value = "/car/update/id={carId}", method = RequestMethod.POST)
	private String updateDealerSubmit(@PathVariable(value = "carId") Long id, @ModelAttribute CarModel car) {
		CarModel updated = carService.getCarDetailById(id).orElse(null);
		updated.setBrand(car.getBrand());
		updated.setType(car.getType());
		updated.setAmount(car.getAmount());
		updated.setPrice(car.getPrice());
		carService.addCar(updated);
		return "update";
	}
	

}
