package com.spring.helloworld;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.helloworld.domain.GuestBoardVO;
import com.spring.helloworld.persistence.GuestBoardDAO;




@RunWith(SpringJUnit4ClassRunner.class)// JUnit 테스트 클래스를 실행시킬 환경(클래스)
@WebAppConfiguration
// 웹 어플리케이션의 환경 설정 정보(예: web.xml)를 사용함
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
) // 애플리케이션, 서블릿 컨텍스트(환경설정) 을 사용함
public class AOPTest {
	 private static final Logger logger = 
	         LoggerFactory.getLogger(AOPTest.class);
	   
	@Autowired
	private GuestBoardDAO  dao;
	
	@Test
	public void doTest() {
		testSelectAll();
		
	}

	private void testSelectAll() {
		System.out.println("테스트 들어옴");
	}
}
