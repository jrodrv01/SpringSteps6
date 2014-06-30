package es.unileon.ulebank.springapp.web;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.springapp.domain.Fee;
import es.unileon.ulebank.springapp.repository.InMemoryFeeDao;
import es.unileon.ulebank.springapp.service.SimpleChangeFeeManager;
import es.unileon.ulebank.springapp.web.ChangeSearchFeesController;

public class ChangeSearchFeesControllerTest {

	@Test
	public void testHandleRequestView() throws ServletException, IOException {
		ChangeSearchFeesController controller = new ChangeSearchFeesController();
		SimpleChangeFeeManager sm = new SimpleChangeFeeManager();
		
       // sm.setFeeDao(new InMemoryFeeDao(new List<Fee>()));
        controller.setFeeManager(sm);
       
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello.jsp", modelAndView.getViewName());
		 assertNotNull(modelAndView.getModel());
		 Map modelMap = (Map) modelAndView.getModel().get("model");
	        List<Fee> myFees = (List<Fee>) modelMap.get("fees");
	        assertNotNull(myFees);
	}
	

}
