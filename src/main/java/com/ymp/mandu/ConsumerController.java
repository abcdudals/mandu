package com.ymp.mandu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.ConsumerService;
import service.SellerService;
import vo.ConsumerVO;
import vo.ManduVO;
import vo.SellerVO;

@Controller
public class ConsumerController {

	@Autowired
	ConsumerService consumerservice;
	
	@Autowired
	SellerService sellerservice;
	
	@RequestMapping(value="consumer")
	public ModelAndView consumer(HttpServletRequest request, ModelAndView mv,
			ConsumerVO cvo, SellerVO svo) {
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("loginID")!=null) {
			cvo.setId((String)session.getAttribute("loginID"));
			List<ConsumerVO> list = consumerservice.selectItemList(cvo);
			List<SellerVO> outlist = new LinkedList<SellerVO>();
			for(int i=0;i<list.size();i++) {
				String a=list.get(i).getItemNo();
				svo.setItemNo(a);
				System.out.println("******svo=>"+svo);
				outlist.add(sellerservice.selectHomeOne(svo));
				System.out.println("******outlist=>"+outlist);
			}
			System.out.println("******out1list=>"+outlist);
			mv.addObject("BasketItem", outlist);
			mv.setViewName("manduConsumerPage");
		}else {
			mv.addObject("message", "You need Sign In");
			mv.setViewName("loginFormPage");
		}
		return mv;
	}
	
	@RequestMapping(value="basketinsert")
	public ModelAndView basketinsert(ModelAndView mv, ConsumerVO cvo, SellerVO svo, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("loginID")!=null) {
			cvo.setId((String)session.getAttribute("loginID"));
			String itemNo = request.getParameter("itemNo");
			cvo.setItemNo(itemNo);
			System.out.println("***** cvo => "+cvo);
			consumerservice.insert(cvo);
			System.out.println("***** cvo1 => "+cvo);
			mv.addObject("message", "Input Basket");
			mv.setViewName("redirect:home");
		}else {
			mv.addObject("message", "Please Sign In");
			mv.setViewName("loginFormPage");
		}
		
		return mv;
	}
}
