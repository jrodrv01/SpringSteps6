package es.unileon.ulebank.springapp.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.springapp.domain.Fee;

public interface ChangeFeeManager extends Serializable {

	public void decreaseFee(double percentage);

	public void decreaseFee(String idAccount, double percentage);

	public List<Fee> sharesFee();

}
