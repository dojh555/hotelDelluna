package com.delluna.hotels.dataservice_notice;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.delluna.hotels.common_notice.Qna;
import com.delluna.hotels.common_notice.Qnares;

@Mapper
public interface IQnaMapper {

	
		// qna : 번호, 질문유형, 제목, 내용, 날짜, 작성자
		// rqna: 저장 - 번호, 응답내용, 작성자(회원번호), 상태(대기(평소에는), 완료)
	
	
	//클라이언트 단
	
	//질문 저장
	@Insert("insert into qna(question, title, contents, writer) values(#{question},#{title},#{contents}, #{writer.no})")
	int save(Qna qna); 
	
	//질문 목록 찾기
	@Select("select * from qna where writer = #{writer} order by no desc")
	List<Qna> selectAll(@Param("writer")int writer);
	
	//질문 번호로 질문 찾기
    @Select("select * from qna where no=#{no}")
    Qna findByNo(@Param("no")int no);
    
	//질문 삭제(마이페이지에서 하시면 됩니다)
    @Delete("delete from qna where no=#{no}")
	void delete(@Param("no")int no);
	
	//관리자 단 
		
    //답변 저장하기
	
	  @Select("select * from rqna where qno=#{qno}") 
	  Qnares findByQno(@Param("qno")int qno);
		 
	
}
