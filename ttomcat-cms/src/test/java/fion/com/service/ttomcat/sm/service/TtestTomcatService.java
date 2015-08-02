package fion.com.service.ttomcat.sm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TtestTomcatService {

	@Autowired
	private TestTomcatService testTomcatService;
	
	@Test public void testSay(){
		
		System.out.println(testTomcatService.say(null, "测试"));
	}
}
