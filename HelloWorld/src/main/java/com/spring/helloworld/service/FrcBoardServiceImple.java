package com.spring.helloworld.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.helloworld.domain.FrcBoardVO;
import com.spring.helloworld.persistence.FrcBoardDAO;

@Service // @Component

public class FrcBoardServiceImple implements FrcBoardService {
   private static final Logger logger = 
         LoggerFactory.getLogger(FrcBoardServiceImple.class);
   
   @Autowired
   private FrcBoardDAO frcBoardDao; // ������

   @Override
   public List<FrcBoardVO> read(String home_id) {
      logger.info("read() ȣ��");
      return frcBoardDao.select_all(home_id);
   }
   
   @Override
   public FrcBoardVO check_already_written(FrcBoardVO vo) {
   	// TODO Auto-generated method stub
   	return frcBoardDao.check_already_written(vo);
   }


   @Override
   public FrcBoardVO read(int frc_bno) {
      logger.info("read() ȣ�� : bno =" + frc_bno);
      return frcBoardDao.select(frc_bno);
   }

   @Override   
   public int create(FrcBoardVO vo) {
      logger.info("create() ȣ��");
      return frcBoardDao.insert(vo);

   }

   @Override
   public int update(FrcBoardVO vo) {
      logger.info("update() ȣ��");
      return frcBoardDao.update(vo);
   }

   @Override
   public int delete(int frc_bno) {
      logger.info("delete() ȣ��");
      return frcBoardDao.delete(frc_bno);
   }

   @Override
   public int getTotalNumsOfRecords() {
      logger.info("getTotalNumsOfRecords() ȣ��");
      return frcBoardDao.getTotalNumsOfRecords();
   }










}