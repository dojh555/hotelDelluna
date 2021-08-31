package com.delluna.hotels.dataservice_notice;

import java.util.List;

import com.delluna.hotels.common_notice.Qna;

public interface IQnaDAO {
	//질문 저장(
	int save(Qna qna);
	//관리자 - 답변하기(위해 게시물 찾기)
	List<Qna> selectAll();
	//
	public List<Qna> selectByMemberNo(int member_no);
	//질문 찾기
	Qna findByNo(int qno);
	
	void delete(int no);
}
