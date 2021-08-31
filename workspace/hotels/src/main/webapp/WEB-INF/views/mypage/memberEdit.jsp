<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 헤더  -->
<jsp:include page="../common/common_header.jsp"></jsp:include>
<!-- 헤더끝  -->

<section id="container">

<!-- 서브헤더 : 필요시 사용! -->
	<jsp:include page="../common/common_subHeader.jsp">
		<jsp:param value="mypage" name="submenu" />

		<jsp:param value="reservation" name="ssubmenu1" />
		<jsp:param value="point" name="ssubmenu2" />
        <jsp:param value="service" name="ssubmenu3" />
        <jsp:param value="edit" name="ssubmenu4" />
        <jsp:param value="delete" name="ssubmenu5" />

	</jsp:include>
<!-- 서브헤더 끝  -->

	<div class="hotelParadiseWrap">
		<div class="innerBox">
		
			<div class="contTitle">
				<span>회원정보 수정</span>
				<h1>
				델루나 부산 회원님의 개인 정보를
				수정 하실 수 있습니다.
				</h1>
			</div>
			
			<form method="post" name="form1" id="form1" action="/mypage/edit/check/complete">
			<div class="fullBg">
				<div class="innerBox formJoinWrap">
					<!-- 아이디 및 비밀번호 -->
					<div class="formJoin">
						<h2>아이디 및 비밀번호</h2>
						<p class="formImportant"><span class="color">*</span> 필수 입력항목</p>
						<dl class="idDl">
							<dt><label for="id">아이디 <span class="color">*</span></label></dt>
							<dd>
								<div class="inp">
									<input type="text" id="id" name="id" value="${member.id}"  maxlength="12" placeholder="" title="아이디" onkeydown="checkSpacebar();" autocomplete='off' readonly='readonly'>
									<button type="button" class="btnDelete" style="display: none;">삭제</button>
								</div>
								<div class="errorText" id="errorId">
									<!-- 에러 메시지 -->
								</div>
							</dd>
						</dl>
						
						<dl class="pwd">
							<dt><label for="pw">비밀번호 <span class="color">*</span></label></dt>
							<!-- 에러시 dd의 error 클래스 추가 -->
							<dd class="pw1">
								<div class="inp">
									<input type="password" id="pw" name="pw"  maxlength="20" title="비밀번호" placeholder="" onkeydown="checkSpacebar();" autocomplete='off'>
									<button type="button" class="btnDelete" style="display: none;">삭제</button>
								</div>
								
								<div class="errorText">
									<!-- 에러 메시지 -->
								</div>
							</dd>
						</dl>
						<dl class="pwd">
							<dt><label for="pw2">비밀번호 확인 <span class="color">*</span></label></dt>
							<!-- 에러시 dd의 error 클래스 추가 -->
							<dd class="pw2">
								<div class="inp">
									<input type="password" id="pw2" name="pw2"  maxlength="20" title="비밀번호 확인" onkeydown="checkSpacebar();" autocomplete='off'>
									<button type="button" class="btnDelete" style="display: none;">삭제</button>
								</div>
								<div class="errorText">
									<!-- 에러 메시지 -->
								</div>	
							</dd>
						</dl>
					</div>
					<!-- //아이디 및 비밀번호 -->
					
					<!-- 기본정보 -->
					<div class="formInfo clearFixed">
						<h2>기본 정보</h2>
						<p class="formImportant"><span class="color">*</span> 필수 입력항목</p>
						
						
						<div class="left">
							<dl class="nameType1">
								<dt><label for="name">이름(한글) <span class="color">*</span></label></dt>
								<!-- 에러시 dd의 error 클래스 추가 -->
								<dd>
									<div class="inp">
										<input type="text" id="name" name="name" value="${member.name}"  maxlength="50" title="이름(한글)" onkeydown="checkSpacebar();" autocomplete='off'>
									</div>
									<div class="errorText">
										<!-- 에러 메시지 -->
									</div>
								</dd>
							</dl>
							<dl class="birthday">
								<dt><label for="birth">생년월일(8자리) <span class="color">*</span></label></dt>
								<dd>
									<div class="inp">
										<input type="text" id="birth" name="birth" value="${member.birth}" maxlength="8" title="생년월일8자리" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" autocomplete='off' readonly='readonly'>
									</div>
									<div class="errorText">
										<!-- 에러 메시지 -->
									</div>
								</dd>
							</dl>
							<dl class="phone type1">
								<dt><label for="tel">휴대폰 번호</label></dt>
								<dd>
									<div class="inp">
										<input type="tel" id="tel" name="tel" value="${member.tel}"  placeholder="구분기호(-)없이 입력해주세요" maxlength="11" title="휴대 전화번호" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
									</div>
									<div class="errorText">
										<!-- 에러 메시지 -->
									</div>
								</dd>
							</dl>
							
							<dl class="email">
								<dt><label for="email">이메일<span class="color">*</span></label></dt>
								<dd>
									<div class="inp">
									<input type="email" id="email" name="email" value="${member.email}"  placeholder="" title="Email" readonly="readonly" maxlength="64">
										<button type="button" class="btnDelete" style="display: none;">삭제</button>
									</div>
									<div class="errorText">
										<!-- 에러 메시지 -->
									</div>
									<p class="text">일부 도메인은 수신에 제한이 있을 수 있습니다. <br>스팸메일함으로도 수신이 되지 않을 경우, 다른 이메일을 사용하시기 바랍니다. </p>
								</dd>
							</dl>
						</div>
						<div class="right">
							<dl class="nameType2">
								<dt><label for="first_name">이름(영문)</label></dt>
								<dd>
									<div class="inp">
										<input type="text" id="first_name" name="first_name" value="${member.first_name}" maxlength="50" placeholder="First Name(이름)" title="First Name(이름)" onkeydown="checkSpacebar();">
										<button type="button" class="btnDelete">삭제</button>
									</div>
									<div class="inp">
										<input type="text" id="last_name" name="last_name" value="${member.last_name}" maxlength="50" placeholder="Last Name(성)" title="Last Name(성)" onkeydown="checkSpacebar();">
										<button type="button" class="btnDelete">삭제</button>
									</div>
									
									<div class="errorText">
										<!-- 에러 메시지 -->
										
									</div>
								</dd>
							</dl>
							<dl class="address">
								<dt><label for="address">주소</label></dt>
								<dd>
									<div class="post">
										<div class="inp">
											<input type="text" id="post" name="post" value="${member.post}" placeholder="" title="post" readonly="readonly">
											<button type="button" class="btnDelete">삭제</button>
										</div>
										<input type="button" onclick="sample6_execDaumPostcode()" class="btn small" value="우편번호 검색">
									</div>
									<div class="inp">
										<input type="text" id="address1" name="address1" value="${member.address}" readonly="readonly">
									</div>
									<div class="inp">
										<input type="text" id="address2" name="address2" title="상세주소" readonly="readonly">
										<button type="button" class="btnDelete">삭제</button>
									</div>
									<input type="hidden" id="address" name="address"/>
									<div class="inp">
										<input type="text" id="detail_address" name="detail_address" value="${member.detail_address}"  title="상세주소" placeholder="상세주소">
									</div>
									<div class="errorText">
										<!-- 에러 메시지 -->
									</div>
									<input type="hidden" name="no" id="no" value="${member.no }"/>
								</dd>
							</dl>
						</div>
					</div>	
					<!-- //기본정보 -->
				</div>
				<div class="btnJoin">
					<!-- 비활성화 시  disabled="disabled" 추가 -->
					<button onclick="return submitInfo();" class="btn btnFull"><span>수정하기</span></button>
				</div>
			</div>
		</form>
		
		</div>
	</div>
</section>
	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            } else {
            }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('post').value = data.zonecode;
                document.getElementById("address1").value = addr;
                document.getElementById("address2").value = extraAddr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detail_address").focus();
            }
        }).open();
    }
</script>
<!-- 푸터  -->
<jsp:include page="../common/footer.jsp"></jsp:include>
<!-- 푸터 끝  -->