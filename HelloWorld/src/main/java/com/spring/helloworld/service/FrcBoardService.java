package com.spring.helloworld.service;

import java.util.List;

import com.spring.helloworld.domain.FrcBoardVO;


public interface FrcBoardService {
   public abstract List<FrcBoardVO> read(String home_id);
   public abstract FrcBoardVO check_already_written(FrcBoardVO vo);
   public abstract FrcBoardVO read(int frc_bno);
   public abstract int create(FrcBoardVO vo);
   public abstract int update(FrcBoardVO vo);
   public abstract int delete(int frc_bno);
   public abstract int getTotalNumsOfRecords();
} // end FrcBoardService