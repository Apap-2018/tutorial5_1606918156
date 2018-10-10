package com.apap.tutorial4.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.CarDb;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	
	@Override
	public void addCar(CarModel car) {
		carDb.save(car);
	}
	
	@Override
	public Optional<CarModel> getCarDetailById(Long id) {
		// TODO Auto-generated method stub
		return carDb.findById(id);
	}
	
	@Override
	public void deleteCar(CarModel car){
		// TODO Auto-generated method stub
		carDb.delete(car);
		
	}
	
	@Override
	public List<CarModel> allCarDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		List<CarModel> cars = carDb.findAll();
		return cars.stream().filter(car -> car.getDealer().getId() == dealer.getId()).collect(Collectors.toList());
	}
}
