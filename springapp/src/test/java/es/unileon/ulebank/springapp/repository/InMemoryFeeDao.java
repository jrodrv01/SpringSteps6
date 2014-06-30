package es.unileon.ulebank.springapp.repository;

import java.util.List;

import es.unileon.ulebank.springapp.domain.Fee;

public class InMemoryFeeDao implements FeeDao {

    private List<Fee> feeList;

    public InMemoryFeeDao(List<Fee> feeList) {
        this.feeList = feeList;
    }

	@Override
	public List<Fee> getFeeList() {
		return feeList;
	}

	@Override
	public void saveFees(Fee comm) {
		// TODO Auto-generated method stub
		
	}

}