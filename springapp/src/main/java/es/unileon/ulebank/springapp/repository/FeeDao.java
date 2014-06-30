package es.unileon.ulebank.springapp.repository;

import java.util.List;

import es.unileon.ulebank.springapp.domain.Fee;

public interface FeeDao {

	public List<Fee> getFeeList();

	public void saveFees(Fee comm);

}