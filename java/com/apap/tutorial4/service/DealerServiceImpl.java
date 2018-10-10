package com.apap.tutorial4.service;

import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.DealerDb;

import java.util.List;

@Service
@Transactional
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerDb dealerDb;
	
	@Override
	public Optional<DealerModel> getDealerDetailById(Long id){
		return dealerDb.findById(id);
	}
	
	@Override
	public void addDealer(DealerModel dealer) {
		dealerDb.save(dealer);
	}
	
	@Override
	public void deleteDealer(DealerModel dealer) {
		// TODO Auto-generated method stub
		dealerDb.delete(dealer);
		
	}
	
	@Override
	public List<DealerModel> allDealer() {
		// TODO Auto-generated method stub
		return dealerDb.findAll();
	}
}
