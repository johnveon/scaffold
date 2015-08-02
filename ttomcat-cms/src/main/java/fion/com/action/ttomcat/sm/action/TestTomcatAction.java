package fion.com.action.ttomcat.sm.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fion.com.service.ttomcat.sm.service.TestTomcatService;

@Controller
@RequestMapping("/testtomcat")
public class TestTomcatAction {

	@Autowired
	private TestTomcatService testTomcatService;
	
    //@RequestMapping(value="/say",method = RequestMethod.GET)  
	
    @RequestMapping("/{id}/say")//http://localhost:8081/ttomcat-cms/testtomcat/12w/say
    public String say(@PathVariable String id,HttpServletRequest request) {
		
		System.out.println(testTomcatService.say(null, "11123"));
		
		return "login";
	}
	
}
