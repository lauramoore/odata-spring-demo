package lkm.demo.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lkm.demo.odata.CarsEdmProvider;
import lkm.demo.odata.CarsProcessor;
import lkm.demo.odata.DataProvider;

import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.edmx.EdmxReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarDemo {
	
	ODataHttpHandler handler;
	public CarDemo() {
		  OData odata = OData.newInstance();
	      ServiceMetadata edm = odata.createServiceMetadata(new CarsEdmProvider(), new ArrayList<EdmxReference>());
	      handler = odata.createHandler(edm);
	      handler.register(new CarsProcessor(new DataProvider()));
	}
	
	@RequestMapping(value = "/Cars**", method = RequestMethod.GET)
	public void car(HttpServletRequest req, HttpServletResponse resp){
		//the olingo http handler serializes and outputs the response data.
		//can look at approaches to decouple this and get better handling with Spring
	      handler.process(req, resp);
	}

}
