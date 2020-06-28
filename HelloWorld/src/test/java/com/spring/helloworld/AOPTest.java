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




@RunWith(SpringJUnit4ClassRunner.class)// JUnit �׽�Ʈ Ŭ������ �����ų ȯ��(Ŭ����)
@WebAppConfiguration
// �� ���ø����̼��� ȯ�� ���� ����(��: web.xml)�� �����
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
) // ���ø����̼�, ���� ���ؽ�Ʈ(ȯ�漳��) �� �����
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
		System.out.println("�׽�Ʈ ����");
	}
}
