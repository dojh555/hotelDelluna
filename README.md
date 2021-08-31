# **목차**

[1\. 목적](#1-목적)  
[2\. 개요](#2-개요)  
[3\. 개발환경](#3-개발환경)  
[4\. 설계](#4-설계)  
[5\. spring 구조](#5-spring-구조)  
[6\. 기능 설명](#6-기능-설명)  
[7\. 후기](#7-후기)

\* '파라다이스호텔 부산' 을 벤치마킹한 프로젝트입니다!

사이트 주소 : [https://www.busanparadisehotel.co.kr/front](https://www.busanparadisehotel.co.kr/front)

-   hotel Delluna 사이트 : [http://3.38.102.192:8080/](http://3.38.102.192:8080/)
-   github 사이트 : [https://github.com/dojh555/hotelDelluna](https://github.com/dojh555/hotelDelluna)

---

## **[1\. 목적](#index)**

-   호텔 예약과 예약 내역을 확인할 수 있는 프로그램 제작텔 예약과 예약 내역을 확인할 수 있는 프로그램 제작
-   eclipse 툴을 이용해 spring framework 사용
-   MVC 패턴 활용
-   myBatis와 Mysql 을 이용한 DB 연동 및 조작

---

## **[2\. 개요](#index)**

#### 1) 수행기간

2021.06.15 ~ 2021.07.16

#### 2) 수행인원

총 4명 ( 국가 교육기관 그룹 프로젝트 )

#### 3) 기능 개요

#### 3-1) 클라이언트

-   회원가입과 로그인이 가능하다.
-   로그인시 레스토랑, 호텔예약 가능하다.
-   예약시 포인트의 사용과 적립이 가능하다.
-   예약내역 확인 및 취소가 가능하다.
-   로그인시 질의응답이 가능하다.

#### 3-2) 관리자

-   전체 회원의 목록을 확인 및 회원의 정보(등급, 상태 등)를 수정할 수 있다.
-   예약의 실제 상품인 룸을 등록할 수 있다.
-   룸을 예약 패키지로 등록하여 검색의 결과로 출력할 수 있다.
-   레스토랑, 호텔의 예약한 내역을 확인 및 변경이 가능하다.
-   등록된 고객질문 내역에 대한 조회 및 답변이 가능하다.

---

## **[3\. 개발환경](#index)**

-   Windows 10
-   JAVA JDK 1.8.0\_40
-   Eclipse 2020-06
-   Springframework 5.0.2
-   Tomcat 8.5
-   Mysql 8.0- Mysql-Jdbc 8.0.24
-   mybatis 3.4.1

---

## **[4\. 설계](#index)**

#### 1) ERD ( mysql workbench 사용 )

-   Total ERD

[##_Image|kage@t80Jw/btrdIl5iq0X/rPPnwtQid9GkJ6uFg8grL1/img.png|alignCenter|data-origin-width="1223" data-origin-height="597" data-ke-mobilestyle="widthOrigin"|||_##]

-   예약 ERD

[##_Image|kage@8G23H/btrdJ4hrRxr/LOlutithf1pqMkxKJKcZi0/img.png|alignCenter|data-origin-width="807" data-origin-height="642" data-ke-mobilestyle="widthOrigin"|||_##]

#### 2) UML ( startUML 사용 )

2-1) Package Diagram

[##_Image|kage@bcRKRh/btrdC5JpBXR/vNvsN67k7O5OPAmgFQsRiK/img.png|alignCenter|data-origin-width="995" data-origin-height="442" data-ke-mobilestyle="widthOrigin"|||_##]

2-2) Class Diagram (Business Layer, Presentation Layer)

-   member

[##_Image|kage@bzYiGU/btrdJjFUCB0/PRVlcuof5WbtpXKL25tHkk/img.png|alignCenter|data-origin-width="998" data-origin-height="635" data-ke-mobilestyle="widthOrigin"|||_##]

-   room, reservation

[##_Image|kage@cCLsDs/btrdFnCyAGO/lQu1yKS1jj6gjW6y8Qtfdk/img.png|alignCenter|data-origin-width="957" data-origin-height="629" data-ke-mobilestyle="widthOrigin"|||_##]

-   point

[##_Image|kage@cdiZJb/btrdC4DIgFJ/2FadzKR1LKrQMKwAVFi5jK/img.png|alignCenter|data-origin-width="708" data-origin-height="565" data-ke-mobilestyle="widthOrigin"|||_##]

---

## **[5\. spring 구조](#index)**

[##_Image|kage@dmoIHx/btrdInB3cCD/6wq37TQ8CQT8LjjxbDuIBK/img.png|alignCenter|data-origin-width="1234" data-origin-height="640" data-ke-mobilestyle="widthOrigin"|||_##]

---

## **[6\. 기능 설명](#index)**

#### 1) 클라이언트

-   회원가입1 - 본인인증

[##_Image|kage@533ZL/btrdFmRcw7V/c2XgMgMK6URqRE4nyr18aK/img.png|alignCenter|data-origin-width="995" data-origin-height="622" data-ke-mobilestyle="widthOrigin"|||_##]

<table style="border-collapse: collapse; width: 69.1842%; height: 40px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 576.969px; height: 10px; text-align: center;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">예약에 사용될 회원의 개인정보에 관한 약관 안내 및 동의</span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">2</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">이메일 : &nbsp;javax.mail1.6.1 ver, ajax 로 요청</span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">3</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">Ajax 로 서버 session에 저장한 인증코드와 일치여부 확인</span></td></tr></tbody></table>

  
  

-   회원 가입2 - 회원 정보입력

[##_Image|kage@xEdGF/btrdK7rsuKd/AdztRhfEYlEbeIqKPuQtWk/img.png|alignCenter|data-origin-width="945" data-origin-height="626" data-ke-mobilestyle="widthOrigin"|||_##]

<table style="border-collapse: collapse; width: 69.1842%; height: 30px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 576.969px; text-align: center; height: 10px;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">필수 입력항목 유효성 검사</span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">2</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">다음 우편번호<span>&nbsp;</span>API<span>&nbsp;</span>를 사용하여 우편번호 검색<span>&nbsp;</span></span><span style="color: #000000;">가능</span></td></tr></tbody></table>

  
  

-   로그인

[##_Image|kage@zKh4d/btrdJ4BJECd/hdRkBrDy6jPXYetbBKBKh0/img.png|alignCenter|data-origin-width="985" data-origin-height="584" data-ke-mobilestyle="widthOrigin"|||_##]

<table style="border-collapse: collapse; width: 69.1842%; height: 50px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr><td style="width: 99.8316%; text-align: center; height: 10px;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr><td style="width: 5.38721%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.4444%; height: 10px;"><span><span style="color: #000000;">Ajax</span><span style="color: #000000;">를 이용하여 </span><span style="color: #000000;">id,pw </span><span style="color: #000000;">일치하는 </span><span style="color: #000000;">회원 확인</span><span style="color: #000000;"></span></span></td></tr></tbody></table>

  
  

-   예약1 - 옵션선택

[##_Image|kage@VIYZU/btrdHfqI3Ey/cy8JcfWvKyvBwjNK8Ohcs0/img.png|alignCenter|data-origin-width="870" data-origin-height="661" data-ke-mobilestyle="widthOrigin"|||_##]

<table style="border-collapse: collapse; width: 68.3177%; height: 40px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="height: 10px; text-align: center; width: 99.8296%;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="height: 10px; width: 5.62181%;" height="10px"><span style="color: #000000;">1</span></td><td style="height: 10px; width: 94.2078%;"><span style="color: #000000;">날짜</span><span style="color: #000000;">, </span><span style="color: #000000;">인원수 선택 후 </span><span style="color: #000000;">검색 시</span><span style="color: #000000;">,</span><span style="color: #000000;"> </span><span style="color: #000000;">DB</span><span style="color: #000000;">에</span><span style="color: #000000;"> </span><span style="color: #000000;">저장된 예약 가능 상품 출력</span></td></tr><tr style="height: 10px;"><td style="height: 10px; width: 5.62181%;"><span style="color: #000000;">2</span></td><td style="height: 10px; width: 94.2078%;"><span><span style="color: #000000;">예약할 객실타입</span><span style="color: #000000;">,</span><span style="color: #000000;">옵션 </span><span style="color: #000000;">선택 후 가격 출력</span></span><span style="color: #000000;"><br></span><span style="color: #000000;">옵션</span><span style="color: #000000;">: </span><span style="color: #000000;">뷰</span><span style="color: #000000;">, </span><span style="color: #000000;">위치</span><span style="color: #000000;">, </span><span style="color: #000000;">타입으로 순서대로 하위 옵션들을 </span><span style="color: #000000;">ajax </span><span style="color: #000000;">를 통해 출력한다</span><span style="color: #000000;">.</span></td></tr><tr style="height: 10px;"><td style="height: 10px; width: 5.62181%;"><span style="color: #000000;">3</span></td><td style="height: 10px; width: 94.2078%;"><span style="color: #000000;">마지막</span><span style="color: #000000;"> </span><span style="color: #000000;">옵션 선택시 </span><span style="color: #000000;">ajax </span><span style="color: #000000;">를 통해 가격을 출력한다</span><span style="color: #000000;">.</span></td></tr></tbody></table>

  
  

-   예약2 - 결제&포인트

[##_Image|kage@b1ewZi/btrdJj0dKeZ/LyJl0VKMZkGEqyBsW7BMe0/img.png|alignCenter|data-origin-width="762" data-origin-height="641" data-ke-mobilestyle="widthOrigin"|||_##]

<table style="border-collapse: collapse; width: 68.3177%; height: 40px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 99.8296%; height: 10px; text-align: center;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">우측 예약정보들은 이전페이지에서 선택한 옵션들을 출력</span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;"><span style="color: #000000;">2</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">회원의 경우 보유한 포인트로 </span><span style="color: #000000;">차감결제</span><span style="color: #000000;"> 가능</span></td></tr></tbody></table>

  
  

-   예약3 - 예약내역

[##_Image|kage@b4RSZG/btrdJkEPROZ/0zNRY46wPIlcrEcvn3Qao0/img.png|alignCenter|data-origin-width="968" data-origin-height="623" data-ke-mobilestyle="widthOrigin"|||_##]

<table style="border-collapse: collapse; width: 68.3177%; height: 70px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 99.8296%; height: 10px; text-align: center;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">예약 후 예약정보 확인가능</span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;"><span style="color: #000000;">2</span></td><td style="width: 94.2078%; height: 10px;"><span><span style="color: #000000;">포인트 조회 가능<br></span><span style="color: #000000;"><br></span><span style="color: #000000;">적립 </span><span style="color: #000000;">: </span><span style="color: #000000;">예약 후 </span><span style="color: #000000;">결제액의</span><span style="color: #000000;"><span>&nbsp; </span></span><span style="color: #000000;">0.03%</span><span style="color: #000000;"> </span><span style="color: #000000;">포인트 적립</span></span><br><span><span style="color: #000000;">소멸 </span><span style="color: #000000;">: 1</span><span style="color: #000000;">년의 유효기간 경과 후 포인트 소멸</span></span><br><span style="color: #000000;">사용 </span><span style="color: #000000;">: </span><span style="color: #000000;">예약 시 사용가능</span></td></tr></tbody></table>

#### 2) 관리자

-   등록 - 회원,객실

[##_Image|kage@edabfu/btrdJkdLXvf/AVasNv8NzHoMvvFnHq9GK0/img.png|alignCenter|data-origin-width="789" data-origin-height="588" data-ke-mobilestyle="widthOrigin"|||_##]

<table style="border-collapse: collapse; width: 68.3177%; height: 70px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 99.8296%; height: 10px; text-align: center;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">예약에 필요한 객실 타입과 객실 등록 가능</span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;"><span style="color: #000000;">2</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">예약 패키지 등록 가능</span></td></tr><tr><td style="width: 5.62181%;"><span style="color: #000000;">3</span></td><td style="width: 94.2078%;"><span style="color: #000000;"><span style="color: #000000;">예약 패키지 </span><span style="color: #000000;">부가시설</span><span style="color: #000000;"> 등록 가능</span></span></td></tr></tbody></table>

-   조회 - 회원, 예약상품, 예약내역[##_Image|kage@beoqHN/btrdIMVVm5W/deafrJ917Crp9X8d7zkwX1/img.png|alignCenter|data-origin-width="999" data-origin-height="633" data-ke-mobilestyle="widthOrigin"|||_##]

<table style="border-collapse: collapse; width: 68.3177%; height: 70px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 99.8296%; height: 10px;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.2078%; height: 10px;">가입한 회원 리스트,&nbsp;<span style="color: #000000;">상세정보 확인가능</span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;"><span style="color: #000000;">2</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">등록한<span>&nbsp;</span></span><span style="color: #000000;">객실목록</span><span style="color: #000000;"><span>&nbsp;</span>확인 가능</span><span style="color: #000000;"><br></span><span style="color: #000000;">각 옵션</span><span style="color: #000000;">,<span>&nbsp;</span></span><span style="color: #000000;">상태별로</span><span style="color: #000000;"><span>&nbsp;</span>필터링</span><span style="color: #000000;">하여 검색 가능</span></td></tr><tr><td style="width: 5.62181%;"><span style="color: #000000;">3</span></td><td style="width: 94.2078%;"><span><span style="color: #000000;">회원 예약내역 확인 가능</span><span style="color: #000000;"></span></span></td></tr><tr><td style="width: 5.62181%;"><span style="color: #000000;">4</span></td><td style="width: 94.2078%;"><span style="color: #000000;">예약 패키지의 여가시설 확인 가능</span></td></tr></tbody></table>

---

## **[7\. 후기](#index)**

#### **느낀 점 😁**

처음으로 제작한 자바기반의 프로젝트이자 그룹 프로젝트 였는데  
"국가교육기관에서 배운 이론과 코드만으로 프로젝트를 잘 진행할 수 있을까",  
"그룹으로 프로젝트를 해나가면서 역할배분과 의견조율을 어떻게 해야할까"  
많은 기대와 걱정을 가지고 출발했다.  
하지만 우려와 달리 좋은 분위기로 서로 많은 지식을 공유하며 생각한 것보다 보람있는 결과를 낼 수 있었다😊

우리 그룹은 먼저 공통, 개인 일정표를 정한 후에  
일정표에 맞춰 사이트맵, UI, UML 등 설계작업을 하고,  
각자 맡은 메뉴를 중심으로 마크업, java 소스코드, JS 부가기능을 구현하였고,  
주요 기능인 예약 시스템 같은 경우는 함께 진행했다.

개인 프로젝트를 먼저 시작했더라면 알지 못했을 기초설계나 유익한 기능들을 알아갈 수 있었고  
서로 다른 생각을 어떤식으로 잘 융합하여 좋은 방향을 이끌어 나갈지 배울 수 있는 유익한 시간이였다.

#### **개선해야 할 점 🐱‍👓**

DB는 설계부터 많은 고민을 하지 않으면 복잡하고 중복적인 코드가 나올 수 밖에 없다는 걸 깨달을 수 있었다. 😢  
예약시스템의 객실옵션 테이블은 설계하면서 많은 회의가 있었지만 경험과 지식이 부족해 일단 진행해보기로 했다.  
하지만 그 결과로 소스코드에서 많은 난관에 부딪힐 수 밖에 없었다.  
각 튜플의 데이터가 중복되었고, 여러번 DB에 연결하며 중복되는 코드가 나오게 되었다.  
그래서 현재 좋은 설계의 DB를 위해 서적을 구비해 따로 공부하고 있으며,  
공부와 함께 앞으로 실무의 경험과 예시로 부족한 부분을 채워나가기로 했다!  
공부중인 서적 : [관계형 데이터 모델링 프리미엄 가이드 이론과 실무를 겸비한 최고의 전략서](https://book.naver.com/bookdb/book_detail.nhn?bid=16590658)
<br/><br/><br/>
시간과 지식이 많이 부족해 프론트엔드단은 벤치마킹한 사이트를 클론코딩으로 구현하다보니 직접 html 과 css 를 구현해보지 못한 것이 아쉬웠다.  
하지만 프론트단에 경력이 있는 조원덕분에 공통부분인 헤더,푸터등의 큰 골격과 어떤식으로 css 가 적용되는지 많이 배워갈 수 있었다.  
다음부터는 부족하더라도 직접 구현해봐야겠다!
