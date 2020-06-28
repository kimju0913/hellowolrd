package com.spring.helloworld.domain;

public class CountVO {

	private int memberCount;
	private int announceCount;
	private int questionTotalCount;
	private int questionNotAnswer;

	public  CountVO() {
		
	}
	
	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public int getAnnounceCount() {
		return announceCount;
	}

	public void setAnnounceCount(int announceCount) {
		this.announceCount = announceCount;
	}

	public int getQuestionTotalCount() {
		return questionTotalCount;
	}

	public void setQuestionTotalCount(int questionTotalCount) {
		this.questionTotalCount = questionTotalCount;
	}

	public int getQuestionNotAnswer() {
		return questionNotAnswer;
	}

	public void setQuestionNotAnswer(int questionNotAnswer) {
		this.questionNotAnswer = questionNotAnswer;
	}

	public CountVO(int memberCount, int announceCount, int questionTotalCount, int questionNotAnswer) {
		this.memberCount = memberCount;
		this.announceCount = announceCount;
		this.questionTotalCount = questionTotalCount;
		this.questionNotAnswer = questionNotAnswer;
	}

}
