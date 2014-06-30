package es.unileon.ulebank.springapp.repository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.springapp.domain.Fee;

public class JPAFeeDaoTests {

	private ApplicationContext context;
	private FeeDao feeDao;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath:test-context.xml");
		feeDao = (FeeDao) context.getBean("feeDao");
	}

	@Test
	public void testGetFeeList() {
		List<Fee> fees = feeDao.getFeeList();
		assertEquals(fees.size(), 3, 0);
	}

	@Test
	public void testSaveFee() {
		List<Fee> fees = feeDao.getFeeList();

		
		Fee p = fees.get(0);
		Double commision = p.getFee().doubleValue();
		p.setFee(new BigDecimal(2.50));
		feeDao.saveFees(p);

		List<Fee> updatedFees = feeDao.getFeeList();
		Fee p2 = updatedFees.get(0);
		assertEquals(p2.getFee().doubleValue(), 2.50, 0);

		p2.setFee(new BigDecimal(commision));
		feeDao.saveFees(p2);
	}
}