package fion.com.worker.ttomcat.sm.worker;

import fion.com.service.ttomcat.sm.service.TestTomcatService;
import fion.com.service.ttomcat.sm.service.impl.TestTomcatServiceImpl;

public class TestTomcatWorker {

	public void say() {

		TestTomcatService testTomcatService = new TestTomcatServiceImpl();
		System.out.println(testTomcatService.say(null, "11fd12"));
	}
}
