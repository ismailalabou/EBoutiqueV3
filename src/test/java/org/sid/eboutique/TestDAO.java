package org.sid.eboutique;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDAO {
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void test() {
	try {
		ClassPathXmlApplicationContext app=
		new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		assertTrue(true);
	} catch (Exception e) {
		assertTrue(e.getMessage(),false);
	}
	}
}
