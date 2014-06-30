package es.unileon.ulebank.springapp.web;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.springapp.domain.Fee;
import es.unileon.ulebank.springapp.repository.InMemoryFeeDao;
import es.unileon.ulebank.springapp.service.SimpleChangeFeeManager;
import es.unileon.ulebank.springapp.web.ChangeSearchFeesController;

public class ChangeSearchFeesControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {
		ChangeSearchFeesController controller = new ChangeSearchFeesController();
		SimpleChangeFeeManager spm = new SimpleChangeFeeManager();
      //  spm.setFeeDao(new InMemoryFeeDao(new List<Fee>()));
      //  controller.setChangeFeeManager;
        //controller.setProductManager(new SimpleProductManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello.jsp", modelAndView.getViewName());
	}

}
