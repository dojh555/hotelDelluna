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

<br/><br/><br/>

## **[1\. 목적](#목차)**

-   호텔 예약과 예약 내역을 확인할 수 있는 프로그램 제작텔 예약과 예약 내역을 확인할 수 있는 프로그램 제작
-   eclipse 툴을 이용해 spring framework 사용
-   MVC 패턴 활용
-   myBatis와 Mysql 을 이용한 DB 연동 및 조작

---

<br/><br/><br/>

## **[2\. 개요](#목차)**

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

<br/><br/><br/>

## **[3\. 개발환경](#목차)**

-   Front-end 언어
 JSP, HTML, CSS, JS, jQeury, Ajax
-   Back-end 언어
 JAVA, Spring, Mybatis, Mysql
-   커뮤니케이션
 Git/ Github

---

<br/><br/><br/>

## **[4\. 설계](#목차)**

#### 1) ERD ( mysql workbench 사용 )

-   Total ERD

![image](https://user-images.githubusercontent.com/84883330/131537374-afb78967-37a9-43c8-bb14-67a4089d6730.png)

-   예약 ERD

![image](https://user-images.githubusercontent.com/84883330/131537390-bb88230c-e7b2-4c77-af26-be6ec83716e2.png)

#### 2) UML ( startUML 사용 )

2-1) Package Diagram

![image](https://user-images.githubusercontent.com/84883330/131537411-922a9218-9419-4f64-979a-c932655f3ee1.png)

2-2) Class Diagram (Business Layer, Presentation Layer)

-   member

![image](https://user-images.githubusercontent.com/84883330/131537428-967c23cd-976b-43ed-8578-c14d32504e44.png)

-   room, reservation

![image](https://user-images.githubusercontent.com/84883330/131537443-34fd3a0d-85e2-4c52-8f61-f63bc5220cd8.png)

-   point

![image](https://user-images.githubusercontent.com/84883330/131537459-3e9898e3-de73-4987-9d50-04dcac8fb8a2.png)

---

## **[5\. spring 구조](#목차)**

<br/><br/><br/>

![image](https://user-images.githubusercontent.com/84883330/131537471-64c2a0af-5747-4e98-8063-22a192cfa850.png)

---

<br/><br/><br/>

## **[6\. 기능 설명](#목차)**

#### 1) 클라이언트

-   회원가입1 - 본인인증

![image](https://user-images.githubusercontent.com/84883330/131537498-ee1a385c-8866-4d12-941f-000df48cf6a5.png)

<table style="border-collapse: collapse; width: 69.1842%; height: 40px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 576.969px; height: 10px; text-align: center;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">예약에 사용될 회원의 개인정보에 관한 약관 안내 및 동의</span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">2</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">이메일 : &nbsp;javax.mail1.6.1 ver, ajax 로 요청</span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">3</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">Ajax 로 서버 session에 저장한 인증코드와 일치여부 확인</span></td></tr></tbody></table>

  
  

-   회원 가입2 - 회원 정보입력

![image](https://user-images.githubusercontent.com/84883330/131537520-e480e80e-1b1e-4bd1-a0dd-9a8bd9030af7.png)

<table style="border-collapse: collapse; width: 69.1842%; height: 30px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 576.969px; text-align: center; height: 10px;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">필수 입력항목 유효성 검사</span></td></tr><tr style="height: 10px;"><td style="width: 15.2969px; height: 10px;" height="10px"><span style="color: #000000;">2</span></td><td style="width: 544.672px; height: 10px;"><span style="color: #000000;">다음 우편번호<span>&nbsp;</span>API<span>&nbsp;</span>를 사용하여 우편번호 검색<span>&nbsp;</span></span><span style="color: #000000;">가능</span></td></tr></tbody></table>

  
  

-   로그인

![image](https://user-images.githubusercontent.com/84883330/131537536-fe9d5347-ea6e-4fdb-95ed-e57ec2933d06.png)

<table style="border-collapse: collapse; width: 69.1842%; height: 50px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr><td style="width: 99.8316%; text-align: center; height: 10px;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr><td style="width: 5.38721%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.4444%; height: 10px;"><span><span style="color: #000000;">Ajax</span><span style="color: #000000;">를 이용하여 </span><span style="color: #000000;">id,pw </span><span style="color: #000000;">일치하는 </span><span style="color: #000000;">회원 확인</span><span style="color: #000000;"></span></span></td></tr></tbody></table>

  
  

-   예약1 - 옵션선택

![image](https://user-images.githubusercontent.com/84883330/131537549-24b57b40-5535-4b76-ba63-644ed878a5c6.png)

<table style="border-collapse: collapse; width: 68.3177%; height: 40px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="height: 10px; text-align: center; width: 99.8296%;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="height: 10px; width: 5.62181%;" height="10px"><span style="color: #000000;">1</span></td><td style="height: 10px; width: 94.2078%;"><span style="color: #000000;">날짜</span><span style="color: #000000;">, </span><span style="color: #000000;">인원수 선택 후 </span><span style="color: #000000;">검색 시</span><span style="color: #000000;">,</span><span style="color: #000000;"> </span><span style="color: #000000;">DB</span><span style="color: #000000;">에</span><span style="color: #000000;"> </span><span style="color: #000000;">저장된 예약 가능 상품 출력</span></td></tr><tr style="height: 10px;"><td style="height: 10px; width: 5.62181%;"><span style="color: #000000;">2</span></td><td style="height: 10px; width: 94.2078%;"><span><span style="color: #000000;">예약할 객실타입</span><span style="color: #000000;">,</span><span style="color: #000000;">옵션 </span><span style="color: #000000;">선택 후 가격 출력</span></span><span style="color: #000000;"><br></span><span style="color: #000000;">옵션</span><span style="color: #000000;">: </span><span style="color: #000000;">뷰</span><span style="color: #000000;">, </span><span style="color: #000000;">위치</span><span style="color: #000000;">, </span><span style="color: #000000;">타입으로 순서대로 하위 옵션들을 </span><span style="color: #000000;">ajax </span><span style="color: #000000;">를 통해 출력한다</span><span style="color: #000000;">.</span></td></tr><tr style="height: 10px;"><td style="height: 10px; width: 5.62181%;"><span style="color: #000000;">3</span></td><td style="height: 10px; width: 94.2078%;"><span style="color: #000000;">마지막</span><span style="color: #000000;"> </span><span style="color: #000000;">옵션 선택시 </span><span style="color: #000000;">ajax </span><span style="color: #000000;">를 통해 가격을 출력한다</span><span style="color: #000000;">.</span></td></tr></tbody></table>

  
  

-   예약2 - 결제&포인트

![image](https://user-images.githubusercontent.com/84883330/131537571-786c5976-3660-40fd-9513-076965b9ce65.png)

<table style="border-collapse: collapse; width: 68.3177%; height: 40px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 99.8296%; height: 10px; text-align: center;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">우측 예약정보들은 이전페이지에서 선택한 옵션들을 출력</span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;"><span style="color: #000000;">2</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">회원의 경우 보유한 포인트로 </span><span style="color: #000000;">차감결제</span><span style="color: #000000;"> 가능</span></td></tr></tbody></table>

  
  

-   예약3 - 예약내역

![image](https://user-images.githubusercontent.com/84883330/131537591-09f915b8-1339-41d7-92a6-568a1f69368b.png)

<table style="border-collapse: collapse; width: 68.3177%; height: 70px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 99.8296%; height: 10px; text-align: center;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">예약 후 예약정보 확인가능</span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;"><span style="color: #000000;">2</span></td><td style="width: 94.2078%; height: 10px;"><span><span style="color: #000000;">포인트 조회 가능<br></span><span style="color: #000000;"><br></span><span style="color: #000000;">적립 </span><span style="color: #000000;">: </span><span style="color: #000000;">예약 후 </span><span style="color: #000000;">결제액의</span><span style="color: #000000;"><span>&nbsp; </span></span><span style="color: #000000;">0.03%</span><span style="color: #000000;"> </span><span style="color: #000000;">포인트 적립</span></span><br><span><span style="color: #000000;">소멸 </span><span style="color: #000000;">: 1</span><span style="color: #000000;">년의 유효기간 경과 후 포인트 소멸</span></span><br><span style="color: #000000;">사용 </span><span style="color: #000000;">: </span><span style="color: #000000;">예약 시 사용가능</span></td></tr></tbody></table>

#### 2) 관리자

-   등록 - 회원,객실

![image](https://user-images.githubusercontent.com/84883330/131537609-d39cc735-ebe5-4ad7-9767-17465d474e1e.png)

<table style="border-collapse: collapse; width: 68.3177%; height: 70px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 99.8296%; height: 10px; text-align: center;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">예약에 필요한 객실 타입과 객실 등록 가능</span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;"><span style="color: #000000;">2</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">예약 패키지 등록 가능</span></td></tr><tr><td style="width: 5.62181%;"><span style="color: #000000;">3</span></td><td style="width: 94.2078%;"><span style="color: #000000;"><span style="color: #000000;">예약 패키지 </span><span style="color: #000000;">부가시설</span><span style="color: #000000;"> 등록 가능</span></span></td></tr></tbody></table>

-   조회 - 회원, 예약상품, 예약내역

![image](https://user-images.githubusercontent.com/84883330/131537633-cc89bc5a-6116-4b01-869f-b9e3d21c9087.png)

<table style="border-collapse: collapse; width: 68.3177%; height: 70px;" border="1" width="219" data-ke-align="alignLeft" data-ke-style="style3"><tbody><tr style="height: 10px;"><td style="width: 99.8296%; height: 10px;" colspan="2"><span style="color: #000000;"><b>DEVELOP Description</b><br></span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;" height="10px"><span style="color: #000000;">1</span></td><td style="width: 94.2078%; height: 10px;">가입한 회원 리스트,&nbsp;<span style="color: #000000;">상세정보 확인가능</span></td></tr><tr style="height: 10px;"><td style="width: 5.62181%; height: 10px;"><span style="color: #000000;">2</span></td><td style="width: 94.2078%; height: 10px;"><span style="color: #000000;">등록한<span>&nbsp;</span></span><span style="color: #000000;">객실목록</span><span style="color: #000000;"><span>&nbsp;</span>확인 가능</span><span style="color: #000000;"><br></span><span style="color: #000000;">각 옵션</span><span style="color: #000000;">,<span>&nbsp;</span></span><span style="color: #000000;">상태별로</span><span style="color: #000000;"><span>&nbsp;</span>필터링</span><span style="color: #000000;">하여 검색 가능</span></td></tr><tr><td style="width: 5.62181%;"><span style="color: #000000;">3</span></td><td style="width: 94.2078%;"><span><span style="color: #000000;">회원 예약내역 확인 가능</span><span style="color: #000000;"></span></span></td></tr><tr><td style="width: 5.62181%;"><span style="color: #000000;">4</span></td><td style="width: 94.2078%;"><span style="color: #000000;">예약 패키지의 여가시설 확인 가능</span></td></tr></tbody></table>

---

<br/><br/><br/>

## **[7\. 후기](#목차)**

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
하지만 클론코딩을 통해서 외부 js 라이브러리를 사용해 동적인 부가기능을 구현하는 법과 공통적인 css 적용을 위한 html 의 id, class 속성설정하기 등 배울 수 있었고,  
프론트단에 경력이 있는 조원덕분에 공통부분인 헤더,푸터등의 큰 골격들을 위한 html 과 css 구성등을 많이 배워갈 수 있었다.  
앞으로 프로젝트에는 직접 깔끔한 레이아웃을 구현할 수 있도록 클론코딩과 서적을 통해 많은 공부가 필요할 거 같다.
