package com.delluna.hotels.ui_adm;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.delluna.hotels.common_notice.Qna;
import com.delluna.hotels.dataservice_notice.IQnaDAO;

@Controller
public class NoticeAdmController {
	@Autowired IQnaDAO qnaDAO;
	
	
	@RequestMapping("/adm/adm-qna-list")
	public ModelAndView gotoAdmRestaurantsList(
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "kwd", required = false) String kwd,
			@RequestParam(value = "col", required = false) String col) {
	//	List<Qna> qnaList = br.
		
		List<Qna> rtList = qnaDAO.selectAll();
		//Paging paging = new Paging();

		//paging = pagingService.makeBlock(page);
		//List<Restaurants> rtList = null;
		//if (kwd == null) {
		//	pagingService.makeLastPageNum(paging, "rastaurants");
		//	rtList = restaurantsDAO.selectPage(page, 5, "restaurant_name", "");
		//} else {
		//	pagingService.makeLastPageNum(paging, "rastaurants", kwd, col);
		//	rtList = restaurantsDAO.selectPage(page, 5, col, kwd);
		//}
		//Integer blockStartNum = paging.getBlockStartNum();
		//Integer blockLastNum = paging.getBlockLastNum();
		//Integer lastPageNum = paging.getLastPageNum();

		ModelAndView mv = new ModelAndView();
		//mv.addObject("blockStartNum", blockStartNum);
		//mv.addObject("blockLastNum", blockLastNum);
		//mv.addObject("lastPageNum", lastPageNum);
//		mv.addObject("rtList", rtList);
		mv.addObject("css", "adm/adm.css");
		mv.addObject("js", "adm/adm.js");
		mv.addObject("css", "adm/adm.css");
		mv.addObject("js", "adm/adm.js");
		mv.setViewName("adm/adm-qna-list");
		return mv;
	}
}