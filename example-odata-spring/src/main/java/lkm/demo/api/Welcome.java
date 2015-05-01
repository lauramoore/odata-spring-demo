package lkm.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Welcome {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("Welcome", HttpStatus.OK);
	}
}
