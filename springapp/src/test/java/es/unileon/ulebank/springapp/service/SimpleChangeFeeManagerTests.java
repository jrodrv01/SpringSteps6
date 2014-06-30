package es.unileon.ulebank.springapp.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.springapp.domain.Fee;
import es.unileon.ulebank.springapp.repository.InMemoryFeeDao;
import es.unileon.ulebank.springapp.repository.FeeDao;

public class SimpleChangeFeeManagerTests {

    private SimpleChangeFeeManager feeManager;
    
    private List<Fee> fees;
    
    private static int FEE_COUNT = 2;
    
    private static Double SELL_BUY_FEES = new Double(20.50);
    private static String SELL_BUY_DESCRIPTION = "Sell and buy fees";
    
    private static String CUSTODY_STOCK_DESCRIPTION = "Custody Stock Fee";
    private static Double CUSTODY_STOCK_FEE = new Double(150.10); 
    
    @Before
    public void setUp() throws Exception {
        feeManager = new SimpleChangeFeeManager();
        fees = new ArrayList<Fee>();
        
        // stub up a list of fees
        Fee fee = new Fee();
        fee.setDescription("Sell and buy fees");
        fee.setFee(new BigDecimal(SELL_BUY_FEES));
        fees.add(fee);
        
        fee = new Fee();
        fee.setDescription("Custody Stock Fee");
        fee.setFee(new BigDecimal(CUSTODY_STOCK_FEE));
        fees.add(fee);
        
        FeeDao feeDao = new InMemoryFeeDao(fees);
        feeManager.setFeeDao(feeDao);
        
     

    }

    @Test
    public void testGetFeesWithNoFees() {
        feeManager = new SimpleChangeFeeManager();
        feeManager.setFeeDao(new InMemoryFeeDao(null));
        assertNull(feeManager.getShareFees());
    }
    /**
     * 
     */
    @Test
    public void testGetFees() {
        List<Fee> fees = feeManager.getShareFees();
        assertNotNull(fees);        
        assertEquals(FEE_COUNT, feeManager.getShareFees().size());
    
        Fee fee = fees.get(0);
        assertEquals(SELL_BUY_DESCRIPTION, fee.getDescription());
        assertEquals(SELL_BUY_FEES, fee.getFee());
        
        fee = fees.get(1);
        assertEquals(CUSTODY_STOCK_DESCRIPTION, fee.getDescription());
        assertEquals(CUSTODY_STOCK_FEE, fee.getFee());      
    }
    
    @Test
    public void testIncreasePriceWithPositivePercentage() {
    	feeManager.decreaseFee(SELL_BUY_DESCRIPTION, FEE_COUNT);
        double expectedSellBuyFeeWithDecrease = 1.00;
        double expectedCustodyFeeWithDecrease = 1.00;
        
        List<Fee> listFees = this.feeManager.getShareFees();
        assertNotNull(listFees);
        assertEquals(2, listFees.size());
        
        List<Fee> fees = feeManager.getShareFees();      
        Fee fee = fees.get(0);
        assertEquals(fee.getFee(), 0);
        
      
    }

}