package com.apap.tutorial4.service;

import java.util.Optional;

import com.apap.tutorial4.model.DealerModel;

import java.util.List;

public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	
	void addDealer(DealerModel dealer);
	void deleteDealer(DealerModel dealer);
	List<DealerModel> allDealer();

}
