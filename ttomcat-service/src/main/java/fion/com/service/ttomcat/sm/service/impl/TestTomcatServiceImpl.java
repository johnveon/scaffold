package fion.com.service.ttomcat.sm.service.impl;

import org.springframework.stereotype.Service;

import fion.com.dao.ttomcat.sm.dao.TestTomcatDao;
import fion.com.service.ttomcat.sm.service.TestTomcatService;
import fion.com.vo.ttomcat.sm.vo.TestTomcatVO;

@Service("testTomcatService")
public class TestTomcatServiceImpl implements TestTomcatService {

	public String say(TestTomcatVO testTomcatVO, String word) {
		return new TestTomcatDao().say(testTomcatVO, word);
	}
}
