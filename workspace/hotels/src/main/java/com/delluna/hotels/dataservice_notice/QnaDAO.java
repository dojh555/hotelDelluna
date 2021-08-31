package com.delluna.hotels.dataservice_notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.delluna.hotels.common_notice.Qna;
@Repository
public class QnaDAO implements IQnaDAO{
	@Autowired IQnaMapper qnaMapper;
	
	@Override
	@Transactional
		public int save(Qna qna) {
			qnaMapper.save(qna);
			return qna.getNo();
	
		}

	@Override
	public List<Qna> selectAll() {
		return null;
	}	
	@Override
	public List<Qna> selectByMemberNo(int member_no) {
		return null;
	}	
	
	@Override
	public Qna findByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int no) {
		qnaMapper.delete(no);
		
	}


}
