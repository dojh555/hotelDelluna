package com.delluna.hotels.ui_mypage;



import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.delluna.hotels.common_member.Member;
import com.delluna.hotels.common_notice.Qna;
import com.delluna.hotels.common_notice.Qnares;
import com.delluna.hotels.common_point.PointEvent;
import com.delluna.hotels.common_reservation.Reservation;
import com.delluna.hotels.common_restaurants.Restaurants;
import com.delluna.hotels.common_restaurants.RestaurantsNon;
import com.delluna.hotels.dataservice_member.IMemberDAO;
import com.delluna.hotels.dataservice_member.IMemberMapper;
import com.delluna.hotels.dataservice_notice.IQnaMapper;
import com.delluna.hotels.dataservice_point.IPointDetailDAO;
import com.delluna.hotels.dataservice_point.IPointEventDAO;
import com.delluna.hotels.dataservice_reservation.IReservationDAO;
import com.delluna.hotels.dataservice_restaurants.IRestaurantsMapper;

@Controller
public class MypageController {
	
	@Autowired IPointEventDAO pointEventDAO;
	@Autowired IPointDetailDAO pointDetailDAO;
	@Autowired IMemberMapper memberMapper;
	@Autowired IReservationDAO reservationDAO;
	@Autowired IRestaurantsMapper restaurantsMapper;
	@Autowired IQnaMapper qnaMapper;

	@RequestMapping("/mypage")
	public ModelAndView mypage(HttpSession session) {
		
		int memberNo = (Integer)session.getAttribute("no");
		Member member = memberMapper.findByNo(memberNo);
		List<Restaurants> rtL = restaurantsMapper.selectAllByMemberNo((Integer)session.getAttribute("no"));
		List<Reservation>  rvL = reservationDAO.selectAllByMemberNo((Integer)session.getAttribute("no"));
		List<Qna> qnaList = qnaMapper.selectAll(memberNo);
		
		int remainPoint = pointEventDAO.totalPoint(memberNo, 0);
		int soonExpirePoint = pointDetailDAO.soonExpireAmount(memberNo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/mypage");
		mv.addObject("remainPoint", remainPoint);
		mv.addObject("soonExpirePoint", soonExpirePoint);
		mv.addObject("css", "mypage/mypage.css");
		mv.addObject("rtL", rtL);
		mv.addObject("rvL", rvL);
		mv.addObject("qnaList", qnaList);
		
		mv.addObject("name", member.getName());
		mv.addObject("no", session.getAttribute("no"));
		
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------??? ????????? ??????????????? ??????????????????.-------------------------------------------------------------
	@GetMapping("/mypage/reservation")
	public ModelAndView mypageReservation(HttpSession session) {
		List<Reservation>  rvL = reservationDAO.selectAllByMemberNo((Integer)session.getAttribute("no"));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/reservation");
		mv.addObject("name", session.getAttribute("name"));
		mv.addObject("rvL", rvL);
		
		mv.addObject("css", "mypage/reservation.css");
		
		return mv;
	} 
	 
	@GetMapping("/mypage/reservationCheck/{no}")
	public ModelAndView mypageReservationCheck(@PathVariable("no") int no, HttpSession session) {
		
		Reservation rv = reservationDAO.findByNo(no);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/reservationCheck");
		mv.addObject("rv", rv);
		
		mv.addObject("css", "mypage/reservationDin.css");
		
		return mv;
	}
	
	@GetMapping("/mypage/reservationCheck/delete/{no}")
	public ModelAndView mypageReservationDelete(@PathVariable int no ,HttpSession session) {
		String msg = "????????? ?????????????????????. ?????? ??????????????????";
		String script = "location.href = '/index'";
			
		
		if(no != 0) {
		reservationDAO.updateState("????????????", no);
		msg = "????????? ?????????????????????.";
		script = "location.href = '/mypage/reservation'";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/memberCheck");
		mv.addObject("msg", msg);
		mv.addObject("script", script);
		
		return mv;
	}
	
	@GetMapping("/mypage/reservationBox")
	public ModelAndView mypageReservationBox(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/reservationBox");
		mv.addObject("name", session.getAttribute("name"));
		
		mv.addObject("css", "mypage/reservationBox.css");
		
		return mv;
	}
	
	@GetMapping("/mypage/reservationDin")
	public ModelAndView mypageReservationDin(HttpSession session) {
	/*	List<Restaurants> rtL = restaurantsMapper.selectAllByMemberNo((Integer)session.getAttribute("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/reservationDin");
		mv.addObject("rtL", rtL);
		
		mv.addObject("css", "mypage/reservationDin.css");
		
		return mv;*/
		if(session.getAttribute("no")==null)
		{
			
			String uname = (String)session.getAttribute("uname");
			String utel = (String)session.getAttribute("utel");
			List<RestaurantsNon> rtL = restaurantsMapper.selectNonAll(uname, utel);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/mypage/reservationDin");
			mv.addObject("rtL", rtL);
			
			mv.addObject("css", "mypage/reservationDin.css");
			
			return mv;
		}
		List<Restaurants> rtL = restaurantsMapper.selectAllByMemberNo((Integer)session.getAttribute("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/reservationDin");
		mv.addObject("rtL", rtL);
		
		mv.addObject("css", "mypage/reservationDin.css");
		
		return mv;
	}
	
	@GetMapping("/mypage/reservationDinCheck/{no}")
	public ModelAndView mypageReservationDinCheck(@PathVariable int no ,HttpSession session) {
		
	/*	Restaurants rt = restaurantsMapper.findByNo(no);
		Member member = memberMapper.findByNo((Integer)session.getAttribute("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/reservationDinCheck");
		mv.addObject("rt", rt);
		mv.addObject("member", member);
		
		mv.addObject("css", "mypage/reservationDin.css"); 
		
		return mv;*/
		if(session.getAttribute("no")==null)
		{	
			String uname = (String)session.getAttribute("uname");
			String utel = (String)session.getAttribute("utel");
			RestaurantsNon rt = restaurantsMapper.selectNonall(uname, utel);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/mypage/reservationDinCheck");
			mv.addObject("rt", rt);
			
			mv.addObject("css", "mypage/reservationDin.css"); 
			
			return mv;
		}
		else {
			Restaurants rt = restaurantsMapper.findByNo(no);
		
		Member member = memberMapper.findByNo((Integer)session.getAttribute("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/reservationDinCheck");
		mv.addObject("rt", rt);
		mv.addObject("member", member);
		
		mv.addObject("css", "mypage/reservationDin.css"); 
		
		return mv;
		}
	}
	
	@GetMapping("/mypage/reservationDinCheck/delete/{no}")
	public ModelAndView mypageReservationDinDelete(@PathVariable int no ,HttpSession session) {
		String msg = "????????? ?????????????????????. ?????? ??????????????????";
		String script = "location.href = '/index'";
		String state = "????????????";
		
		if(no != 0) {
		restaurantsMapper.updateRt(state, no);
		msg = "????????? ?????????????????????.";
		script = "location.href = '/mypage/reservationDin'";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/memberCheck");
		mv.addObject("msg", msg);
		mv.addObject("script", script);
		
		return mv;
	}
	//?????? ?????? ?????????????????? Post
			@PostMapping("/mypage/reservationDinNon")
			public ModelAndView nonmypageReservationDin(HttpSession session)
			{			
					String uname = (String)session.getAttribute("uname");
					String utel = (String)session.getAttribute("utel");
					List<RestaurantsNon> rtL = restaurantsMapper.selectNonAll(uname,utel);
					
					ModelAndView mv = new ModelAndView();
					mv.addObject("rtL", rtL);
					mv.addObject("css", "mypage/reservationDin.css");
					mv.setViewName("/mypage/reservationDin");
					return mv;
			}
	// ----------------------------------------------------------------------------------------------------------------------res--------------------------------------------------------------------
	@GetMapping("/mypage/point")
	public ModelAndView mypagePoint(HttpServletRequest request,HttpSession session) {
		
		int member = (Integer)session.getAttribute("no");
				
		//????????? ??????
		String col = "all";
		Date startDate = null;
		Date endDate = null;
		int totalPoint = pointEventDAO.totalPoint(member, 1);
		int usedPoint = -(pointEventDAO.totalPoint(member, 2));
		int remainPoint = pointEventDAO.totalPoint(member, 0);
		int soonExpirePoint = pointDetailDAO.soonExpireAmount(member);
		if(request.getParameter("col") != null) {
			col = request.getParameter("col");
		}
				
		//????????? ???????????????
		pointDetailDAO.expired(member); 
		pointEventDAO.expired(member);
				
		ModelAndView mv = new ModelAndView();
		//????????? ??????????????? ???????????? ?????? ???(????????? ?????????)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
		//????????? ????????? ??????????????? ???????????? ??????
		try {
			if(request.getParameter("startDate") != "") {
				startDate = new Date(sdf.parse(request.getParameter("startDate")).getTime());
			}
			if(request.getParameter("endDate") != "") {
				endDate = new Date(sdf.parse(request.getParameter("endDate")).getTime());
			}
			if(startDate!=null && endDate!=null) {
				mv.addObject("startDate", startDate);
				mv.addObject("endDate", endDate);
				}
			} catch (Exception e) {
				e.printStackTrace();
				}
				
				//????????? ??????
		List<PointEvent> pointList = null;
		if(!pointEventDAO.pointList(member,col,startDate,endDate).isEmpty()) {
			pointList = pointEventDAO.pointList(member,col,startDate,endDate);
			mv.addObject("pointList", pointList);
		}
				
				//?????? ??????
		mv.setViewName("/mypage/point");
		mv.addObject("css", "mypage/point.css");
		
		mv.addObject("totalPoint", totalPoint);
		mv.addObject("usedPoint", usedPoint);
		mv.addObject("remainPoint", remainPoint);
		mv.addObject("soonExpirePoint", soonExpirePoint);
		mv.addObject("col", col);
				
				
		return mv;
	}
	
	@GetMapping("/mypage/pointExchange")
	public ModelAndView mypagePointExchange(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/pointExchange");
		mv.addObject("name", session.getAttribute("name"));
		
		mv.addObject("css", "mypage/pointExchange.css");
		
		return mv;
	}
	
	@GetMapping("/mypage/service")
	public ModelAndView mypageVoc(HttpSession session) {
		List<Qna> qnaList = qnaMapper.selectAll((Integer)session.getAttribute("no"));
		Member member = memberMapper.findByNo((Integer)session.getAttribute("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/voc");
		mv.addObject("member", member);
		mv.addObject("qnaList", qnaList);
		
		mv.addObject("css", "mypage/voc.css");
		mv.addObject("js", "mypage/voc.js");
		
		return mv;
	}
	
	@GetMapping("/mypage/service/{no}")
	public ModelAndView mypageVocView(@PathVariable int no,HttpSession session) {
		Qna qna = qnaMapper.findByNo(no);
		Qnares qnares = qnaMapper.findByQno(qna.getNo());
		Member member = memberMapper.findByNo((Integer)session.getAttribute("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/vocView");
		mv.addObject("member", member);
		mv.addObject("qna", qna);
		mv.addObject("qnares", qnares);
		
		mv.addObject("css", "mypage/voc.css");
		mv.addObject("js", "mypage/voc.js");
		
		return mv;
	}
	
	@GetMapping("/mypage/service/delete/{no}")
	public ModelAndView mypageVocDelete(@PathVariable int no,HttpSession session) {
		String msg = "????????? ?????????????????????. ?????? ??????????????????";
		String script = "location.href = '/index'";
		
		if(no != 0) {
			qnaMapper.delete(no);
			msg = "????????? ?????????????????????.";
			script = "location.href = '/mypage/service'";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/memberCheck");	
		mv.addObject("css", "mypage/voc.css");
		mv.addObject("js", "mypage/voc.js");
		mv.addObject("msg", msg);
		mv.addObject("script", script);
		
		return mv;
	}
	
	@PostMapping("/mypage/service")
	public ModelAndView mypageVocSave(Qna qna, HttpSession session) {
		qna.setWriter(memberMapper.findByNo((Integer)session.getAttribute("no")));
		int check = qnaMapper.save(qna);
		
		ModelAndView mv = new ModelAndView();
		if(check != 0) {
			mv.addObject("msg", "????????? ?????????????????????.");
			mv.addObject("script", "history.back();");
		}
		
		mv.setViewName("/mypage/memberCheck");
		mv.addObject("msg", "????????? ?????????????????????.");
		mv.addObject("script", "location.href = '/mypage/service'");
		mv.addObject("css", "mypage/voc.css");
		mv.addObject("js", "mypage/voc.js");
		
		return mv;
	}
	
	@GetMapping("/mypage/edit")
	public ModelAndView mypageValidationPwd(HttpSession session) {
		
		Member member = null;
		member = memberMapper.findByNo((Integer)session.getAttribute("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/memberEdit");
		mv.addObject("member", member);
		
		mv.setViewName("/mypage/validationPwd");
		mv.addObject("css", "mypage/validationPwd.css");
		
		return mv;
	}
	
	@PostMapping("/mypage/edit")
	public ModelAndView mypageValidationPwdCheck(HttpServletRequest request, HttpSession session) {
		String msg = "??????????????? ???????????????."; 
		String script = "history.back()";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
				
		boolean isin = memberMapper.isIn(id, pw,"??????",1);
		
		
		if(isin != false){
			script = "location.href='/mypage/edit/check'";
			msg = "?????????????????????.";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/memberCheck");
		mv.addObject("name", session.getAttribute("name"));
		mv.addObject("msg", msg);
		mv.addObject("script", script);
		//??????????????? ??????
		mv.addObject("id", "TestID");
		//??????????????? ???
		
		mv.addObject("css", "mypage/validationPwd.css");
		
		return mv;
	}
	
	@GetMapping("/mypage/edit/check")
	public ModelAndView mypageMemberEditReady(HttpSession session) {
		Member member = null;
		member = memberMapper.findByNo((Integer)session.getAttribute("no"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/memberEdit");
		mv.addObject("member", member);
		
		mv.addObject("css", "mypage/validationPwd.css");
		mv.addObject("js", "mypage/edit.js");
		
		return mv;
	}
	
	@PostMapping("/mypage/edit/check/complete")
	public ModelAndView mypageMemberEdit(Member member, HttpSession session) {
		String msg = "????????? ????????? ?????????????????????. ?????? ??????????????????";
		String script = "location.href='/index'";

		if(member != null){
			memberMapper.updateMypage(member);
			msg = "??????????????? ?????????????????????.";
			script = "location.href='/mypage'";
		} 
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/memberCheck");
		mv.addObject("msg", msg);
		mv.addObject("script", script);
		
		return mv;
	}
	
	@GetMapping("/mypage/delete")
	public ModelAndView mypageMemberDropReady(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/memberDrop");
		mv.addObject("name", session.getAttribute("name"));
		
		mv.addObject("css", "mypage/memberDrop.css");
		
		return mv;
	}
	
	@PostMapping("/mypage/delete")
	public ModelAndView mypageMemberDropCheck(HttpServletRequest request, HttpSession session) {
		String msg = "???????????? ?????? ??????????????? ??????????????? ???????????????."; 
		String script = "history.back()";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
				
		boolean isin = memberMapper.isIn(id,pw,"??????",1);
		
		ModelAndView mv = new ModelAndView();
		
		if(isin != false){
			mv.setViewName("/mypage/memberCheck");
			msg = "?????????????????????.";
			script = "location.href='/mypage/delete/complete'";
		}
		else {
			mv.setViewName("/mypage/memberCheck");
		}
		
		mv.addObject("msg",msg);
		mv.addObject("script",script);
		
		
		return mv;
	}
	
	@PostMapping("/mypage/delete/complete")
	public ModelAndView mypageMemberDrop(HttpServletRequest request, HttpSession session) {
		String msg = "?????? ???????????????.";
		String script = "location.href='/index'";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
				
		boolean isin = memberMapper.isIn(id,pw,"??????",1);
		
		ModelAndView mv = new ModelAndView();
		
		if(isin != false){
			int member_no = (Integer)session.getAttribute("no");
			memberMapper.approvalAdm("??????", member_no);
			session.invalidate();
		}
		else {
			mv.setViewName("/mypage/delete");
			msg = "?????????????????? ??????????????? ??????????????? ???????????????.";
			script = "history.back();";
		}
		
		mv.setViewName("/mypage/memberCheck");
		mv.addObject("msg", msg);
		mv.addObject("script", script);
		
		return mv;
	}
	
	//?????? ?????????
	@GetMapping("/pointsave")
    public ModelAndView test(HttpSession session) {
		
	//??????????????? ??????
	Reservation rv = reservationDAO.findByRsvNo(1);
	System.out.println(rv);
	
	//?????? ????????? ??????
	Member member =  memberMapper.findByNo((Integer)session.getAttribute("no"));

	//?????????????????? ??? ????????? ??????
	PointEvent pointEvent = new PointEvent();
	pointEvent.setReservation_no(rv);//??????
	pointEvent.setMember_no(member);//??????
	pointEvent.setAmount(3000);//????????????
	
	//????????? ??????????????? ????????? -1??????
	int ??????????????????????????? = pointEventDAO.save(pointEvent);
	
	//?????????????????? ????????? ??????
	com.delluna.hotels.common_point.PointDetail pointDetail = new com.delluna.hotels.common_point.PointDetail();
	pointDetail.setMember_no(member.getNo());//?????? ??????
	pointDetail.setAmount(3000);//????????????
	
	//????????? -1(??????)??? ???????????? ?????????
	if(??????????????????????????? != -1){
	pointDetail.setPointEventNo(pointEventDAO.findByNo(??????????????????????????? , 1));
	}
	
	//?????????????????? ?????? ????????? 1??????
	int ???????????? = pointDetailDAO.save(pointDetail);
	
	if(???????????? == -1){
		//?????? ?????????
		return null;
	}
	
	ModelAndView mv = new ModelAndView();
	mv.setViewName("/mypage/memberCheck");
	
	return mv;
	}
	
	
	
	
	//?????? ?????????
	@GetMapping("/pointpay")
    public ModelAndView test2(HttpSession session) {
		
	//??????????????? ??????
	Reservation rv = reservationDAO.findByRsvNo(1);
	
	//?????? ????????? ??????
	Member member =  memberMapper.findByNo((Integer)session.getAttribute("no"));

	int ????????????????????? = 300;
	
	//?????????????????? ??? ????????? ??????
	PointEvent pointEvent = new PointEvent();
	pointEvent.setReservation_no(rv);//??????
	pointEvent.setMember_no(member);//??????
	pointEvent.setAmount(-(?????????????????????));//????????????
	
	//?????????????????? ????????? ???????????? ????????? ??????
	if(pointEventDAO.totalPoint(member.getNo(), 0) > ?????????????????????) {
		
		//????????? ??????????????? ????????? -1??????
		int ????????????1 = pointEventDAO.pay(pointEvent);
		
		//?????????????????? ?????? ????????? 1??????
		int ???????????? = pointDetailDAO.pay((Integer)session.getAttribute("no"), ?????????????????????);
		
		if(???????????? == -1 || ????????????1 == -1){
			//?????? ?????????
			return null;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mypage/pointpay");
		
		return mv;
		
	}
	
	//????????? ?????? ?????????????????? ?????? ???????????? (????????????)
	ModelAndView mv = new ModelAndView();
	mv.setViewName("/mypage");
	
	return mv;
	}
}
