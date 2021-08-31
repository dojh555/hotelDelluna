<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="adm-header.jsp"></jsp:include>
	<div class="wrapper">
    <jsp:include page="adm-nav.jsp"></jsp:include>
        <div class="adm_content">
        	<div class="list_wrap">
	            <form onsubmit="" action="" name="admRsvList" id="admRsvList"
	                enctype="multipart/form-data" method="post">
	                <input type="hidden" name="page" value="1">
	                <!-- 예약 리스트 페이지 정보 시작 { -->
	              <%--   <div class="list_top">
	                    <div class="list_total">
	                        <span>Total ${lastPageNum}건</span> ${curPageNum} 페이지
	                    </div>
	                    <div class="btn_top">
	                            <ul class="btn_wrap">
	                                <li>
	                                </li>
	                            </ul>
	                        </div>
	                </div> --%>
	                
	                <!-- 예약 리스트 페이지 정보 끝 -->
	                <!-- 예약 목록 시작 {-->
	                <div class="list_table">
	                    <table>
	                        <caption>질문 목록</caption>
	                        	<div>준비중입니다.</div>
	               <!--         <thead>
	                            <tr>
	                                <th scope="col" class="chk_all_box">
	                                	<input type="checkbox" id="chk_all" class="chk_all">
	                                    <label for="chk_all"><b class="">게시물 전체선택</b></label>
	                                </th>
	                                <th scope="col">번호</th>
	                                <th scope="col">이름</th>
	                                <th scope="col">
		                                <select onchange="chageLangSelect(this)" name="type">
		                                	<option ${kwd eq "전체" ? "selected": ""} value="전체">질문유형</option>
		                                	<option ${kwd eq "서비스" ? "selected": ""} value="서비스" >서비스</option>
		                                	<option ${kwd eq "객실" ? "selected": ""} value="객실">객실</option>
		                                	<option ${kwd eq "기타" ? "selected": ""} value="기타">기타</option>
		                                </select>
	                                </th>
	                                <th scope="col">제목</th>
	                                <th scope="col">
		                                <select onchange="chageLangSelect(this)" name="room_view">
		                                	<option ${kwd eq "전체" ? "selected": ""} value="전체">날짜</option>
		                                	<option ${kwd eq "최신순" ? "selected": ""} value="최신순">최신순</option>
		                                	<option ${kwd eq "오래된 순" ? "selected": ""} value="오래된 순">오래된 순</option>
		                                </select>
	                                </th>
	                                <th scope="col">
		                                <select onchange="chageLangSelect(this)" name="room_view">
		                                	<option ${kwd eq "전체" ? "selected": ""} value="전체">답변상태</option>
		                                	<option ${kwd eq "답변대기" ? "selected": ""} value="최신순">답변대기</option>
		                                	<option ${kwd eq "답변완료" ? "selected": ""} value="오래된 순">답변완료</option>
		                                </select>
	                                </th>
		                        
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <c:forEach var="room" items="${rooms}" varStatus="status">
	                                <tr class="list_block">
	                                    <td class="chk_box">
		                                    <label for="chk_id_${status.count}"> 
		                                    	<input type="checkbox" name="chk_id[]" value="${status.count}" id="chk_id_${status.count}" class="selec_chk">
		                                    </label>
	                                    </td>
	                                    <td class="list_num">${status.count}</td>
	                                    <td class="list_room_num">${member.name}</td>
	                                    <td class="list_room_type">${qna.question}</td>
	                                    <td class="list_view">${qna.title}</td>
	                                    <td class="list_location">${qnares.state}</td>
	                                   
	                                </tr>
	                            </c:forEach>
	                        </tbody> --> 
	                    </table>
	                </div>
	            </form>
        	</div>
            <!-- 예약 목록 끝 -->
            
		    <!-- 페이징 시작 -->
			<%-- <div class="pager">
			    <ul>
   			        <c:choose>
				        <c:when test="${ curPageNum > 5 && !empty kwd && !empty col}">
				            <li><a href="/adm/rooms/list?page=${ blockStartNum - 1 }&col=${ col }&kwd=${ kwd }">◀</a></li>
				        </c:when>
				        
				        <c:when test="${ curPageNum > 5 }">
				            <li><a href="/adm/rooms/list?page=${ blockStartNum - 1 }">◀</a></li>
				        </c:when>
			        </c:choose>
			        <c:forEach var="i" begin="${blockStartNum}" end="${blockLastNum}">
			            <c:choose>
			                <c:when test="${ i > lastPageNum }">
			                    <li style="color:rgba(0,0,0,0.3);">${ i }</li>
			                </c:when>
			                <c:when test="${ i == curPageNum }">
			                    <li class="selected" style="color:red;">${ i }</li>
			                </c:when>
			                <c:when test="${ !empty kwd and !empty col}">
			                    <li><a href="/adm/rooms/list?a=search&page=${ i }&col=${ col }&kwd=${ kwd }">${ i }</a></li>
			                </c:when>
			                <c:otherwise>
			                    <li><a href="/adm/rooms/list?page=${ i }">${ i }</a></li>
			                </c:otherwise>
			            </c:choose>
			        </c:forEach>
			        <c:choose>
				        <c:when test="${ lastPageNum > blockLastNum && !empty kwd && !empty col}">
				            <li><a href="/adm/rooms/list?a=search&page=${ blockLastNum + 1 }&col=${ col }&kwd=${ kwd }">▶</a></li>
				        </c:when>
				        
				        <c:when test="${ lastPageNum > blockLastNum }">
				            <li><a href="/adm/rooms/list?page=${ blockLastNum + 1 }">▶</a></li>
				        </c:when>
			        </c:choose>
			    </ul>
			</div>   --%>
            <!-- 페이징 끝 -->
        </div>
  	</div>
<jsp:include page="../common/footer.jsp"></jsp:include>