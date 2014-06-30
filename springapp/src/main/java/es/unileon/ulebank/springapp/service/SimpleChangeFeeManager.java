package es.unileon.ulebank.springapp.service;

import java.math.BigDecimal;
import java.util.List;

import es.unileon.ulebank.springapp.domain.Fee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.ulebank.springapp.repository.FeeDao;

@Component
public class SimpleChangeFeeManager implements ChangeFeeManager {

	@Autowired
	private FeeDao feeDao;

	public FeeDao getFeeDao() {
		return feeDao;
	}

	public void setFeeDao(FeeDao feeDao) {
		this.feeDao = feeDao;
	}

	private static final long serialVersionUID = 1L;

	private List<Fee> shareFees;

	public List<Fee> getShareFees() {
		return feeDao.getFeeList();
	}

	public void decreaseFee(double percentage) {

		List<Fee> shareFees = feeDao.getFeeList();
		if (shareFees != null) {
			for (Fee commision : shareFees) {
				double newFee = commision.getFee().doubleValue()
						* (100 - percentage) / 100;
				commision.setFee(new BigDecimal(newFee));
				feeDao.saveFees(commision);
			}
		}
	}

	public void setShareFees(List<Fee> shareFees) {
		this.shareFees = shareFees;
	}

	public List<Fee> sharesFee() {
		return this.shareFees;
	}

	@Override
	public void decreaseFee(String idAccount, double percentage) {
		List<Fee> shareFees = feeDao.getFeeList();
		if (shareFees != null) {
			boolean foundFee = false;
			for (int i = 0; i < shareFees.size() && !foundFee; i++) {
				Fee commision = shareFees.get(i);
				if (commision.getIdAccount().equals(idAccount)) {
					double newFee = commision.getFee().doubleValue()
							* (100 - percentage) / 100;
					commision.setFee(new BigDecimal(newFee));
					feeDao.saveFees(commision);
					foundFee = true;
					
				}
			}
		}

	}
}