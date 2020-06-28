package com.spring.helloworld.persistence;

import java.util.List;

import com.spring.helloworld.domain.FrcBoardVO;


public interface FrcBoardDAO {
   
   public abstract List<FrcBoardVO> select_all(String home_id);
   
   public abstract FrcBoardVO select(int frc_bno);
   
   public abstract FrcBoardVO check_already_written(FrcBoardVO vo);
   
   public abstract int insert(FrcBoardVO vo);
   
   public abstract int update(FrcBoardVO vo);
   
   public abstract int delete(int frc_bno);
   
   public abstract int getTotalNumsOfRecords();
   
   
   public abstract int updateReplycnt(int amount, int frc_bno);

}
