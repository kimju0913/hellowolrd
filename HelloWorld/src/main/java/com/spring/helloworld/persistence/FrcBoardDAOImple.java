package com.spring.helloworld.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helloworld.domain.FrcBoardVO;


   @Repository 
   public class FrcBoardDAOImple implements FrcBoardDAO {
      private static final String NAMESPACE =
            "com.spring.helloworld.FrcBoardMapper";
      private static final Logger logger =
            LoggerFactory.getLogger(FrcBoardDAOImple.class);
      
  
      @Autowired
      private SqlSession sqlSession;
      
      @Override
      public List<FrcBoardVO> select_all(String home_id) {
         logger.info("select() 호출");
         return sqlSession.selectList(NAMESPACE+".select_all" , home_id);
      }
      
      @Override
  	  public FrcBoardVO check_already_written(FrcBoardVO vo) {
  		// TODO Auto-generated method stub
    	  return sqlSession.selectOne(NAMESPACE+".check_frc_alreadyWritten" , vo);
    	}

      @Override
      public FrcBoardVO select(int frc_bno) {
         logger.info("select() 호출 : frc_bno = " + frc_bno);
         return sqlSession.selectOne(NAMESPACE+".select_by_bno", frc_bno);
      }

      @Override
      public int insert(FrcBoardVO vo) {
         logger.info("insert() 호출 : vo = " + vo);
         return sqlSession.insert(NAMESPACE + ".insert", vo);
      }

      @Override
      public int update(FrcBoardVO vo) {
         logger.info("update() 호출 : vo = " + vo);
         return sqlSession.update(NAMESPACE+".update", vo);
      }

      @Override
      public int delete(int frc_bno) {
         logger.info("delete() 호출 : frc_bno = " + frc_bno);
         return sqlSession.delete(NAMESPACE+".delete", frc_bno);
      }

      @Override
      public int getTotalNumsOfRecords() {
         logger.info("getTotalNumsOfRecords() 호출");
         return sqlSession.selectOne(NAMESPACE + ".total_count");
      }

   


      @Override
      public int updateReplycnt(int amount, int frc_bno) {
         Map<String, Integer> args = new HashMap<String, Integer>();
         args.put("amount", amount);
         args.put("frc_bno", frc_bno);
         return sqlSession.update(NAMESPACE + ".update_replycnt", args);
      }

	



   }