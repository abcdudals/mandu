package com.ymp.mandu;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import criTest.PageMaker;
import criTest.SearchCriteria;
import service.ManduService;
import service.SellerService;
import vo.ManduVO;
import vo.SellerVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	SellerService sellerservice;
	
	@Autowired
	ManduService manduservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model, ModelAndView mv) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// Home Sale List
		List<SellerVO> list = sellerservice.selectHomeList();
		if(list != null) {
			mv.addObject("HomeSaleList", list);
		}else {
			mv.addObject("message", "No item");
		}
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="item")
	public ModelAndView item(ModelAndView mv, SellerVO svo, ManduVO mvo) {
		svo=sellerservice.selectOne(svo);
		String sellerId = svo.getId();
		mvo.setId(sellerId);
		mvo=manduservice.selectName(mvo);
		svo=sellerservice.selectHomeOne(svo);
		if(svo!=null && mvo!=null) {
			mv.addObject("HomeItemName", mvo);
			mv.addObject("HomeItem", svo);
			mv.setViewName("manduItemPage");
		}else {
			mv.addObject("message", "There is no Data");
			mv.setViewName("redirect:home");
		}
		return mv;
	}
	
	@RequestMapping(value="category")
	public ModelAndView category(ModelAndView mv, SellerVO svo) {
		List<SellerVO> list = sellerservice.selectCategoryList(svo);
		if(list != null) {
			mv.addObject("HomeSaleList", list);
			mv.setViewName("homeCategory");
		}else {
			mv.addObject("message", "No item");
			mv.setViewName("home");
		}
		return mv;
	}
	
	@RequestMapping(value="searchlist")
	public ModelAndView searchlist(ModelAndView mv, SearchCriteria cri) {
		mv.addObject("HomeSaleList", sellerservice.searchList(cri));
		mv.setViewName("homeCategory");
		return mv;
	}
	
}//class
