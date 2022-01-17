package com.ymp.mandu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.SellerService;
import vo.SellerVO;

@Controller
public class SellerController {

	@Autowired
	SellerService service;
	
	@RequestMapping(value="saledelete")
	public ModelAndView saledelete(ModelAndView mv, SellerVO vo, RedirectAttributes rttr) {
		if(service.delete(vo)>0) {
			rttr.addFlashAttribute("message","Sale Item is Deleted");
			mv.setViewName("redirect:seller");
		}else {
			rttr.addFlashAttribute("message","Delete Fail");
			mv.setViewName("redirect:saledetail?itemNo="+vo.getItemNo());
		}
		return mv;
	}
	
	@RequestMapping(value="saleupdate")
	public ModelAndView saleupdate(HttpServletRequest request, ModelAndView mv,
			SellerVO vo, RedirectAttributes rttr) throws IOException {
		String realPath = request.getRealPath("/");
		if(realPath.contains(".eclipse."))
			realPath = "C:/MTest/MyWork/Mandu/src/main/webapp/resources/uploadImage/";
		else realPath += "resources\\uploadImage\\";
		File f1 = new File(realPath);
		if(!f1.exists()) f1.mkdir();
		String file1, file2 = "resources/uploadImage/basic.jpg";
		MultipartFile itemImagef = vo.getItemImagef();
		if(itemImagef != null && !itemImagef.isEmpty()) {
			file1 = realPath + itemImagef.getOriginalFilename();
			itemImagef.transferTo(new File(file1));
			file2 = "resources/uploadImage/"+itemImagef.getOriginalFilename();
		}else {
			file2 = vo.getItemImage();
		}
		vo.setItemImage(file2);
		if(service.update(vo)>0) {
			rttr.addFlashAttribute("message", "Updated Sale Item");
			mv.setViewName("redirect:seller");
		}else {
			rttr.addFlashAttribute("message", "Try again");
			mv.setViewName("redirect:saledetail?itemNo="+vo.getItemNo());
		}
		return mv;
	}
	
	@RequestMapping(value="saledetail")
	public ModelAndView saledetail(HttpServletRequest request, ModelAndView mv, SellerVO vo) {
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("loginID")!=null) {
			vo=service.selectOne(vo);
			mv.setViewName("manduSellerItemPage");
			mv.addObject("SaleList", vo);
		}else {
			mv.addObject("message", "You need Sign In");
			mv.setViewName("loginFormPage");
		}
		return mv;
	}
	
	@RequestMapping(value="newsaleinsert")
	public ModelAndView newsaleinsert(HttpServletRequest request, ModelAndView mv, SellerVO vo, RedirectAttributes rttr) throws IOException{
		HttpSession session = request.getSession(false);
		vo.setId((String)session.getAttribute("loginID"));
		//Image
		String realPath = request.getRealPath("/");
		System.out.println("join_realPath => "+realPath);
		if(realPath.contains(".eclipse."))
			realPath = "C:/MTest/MyWork/Mandu/src/main/webapp/resources/uploadImage/";
		else realPath += "resources\\uploadImage\\";
		File f1 = new File(realPath);
		if(!f1.exists()) f1.mkdir();
		String file1, file2 = "resources/uploadImage/basic.jpg";
		MultipartFile itemImagef = vo.getItemImagef();
		if(itemImagef != null && !itemImagef.isEmpty()) {
			file1 = realPath + itemImagef.getOriginalFilename();
			itemImagef.transferTo(new File(file1));
			file2 = "resources/uploadImage/"+itemImagef.getOriginalFilename();
		}
		vo.setItemImage(file2);
		if(service.insert(vo) > 0) {
			rttr.addFlashAttribute("message", "Completed New Sale");
			mv.setViewName("redirect:seller");
		}else {
			mv.addObject("message", "Fail New Sale");
			mv.setViewName("manduNewSalePage");
		}
		return mv;
	}
	
	@RequestMapping(value="newsale")
	public ModelAndView newsale(HttpServletRequest request, ModelAndView mv) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("loginID") != null) {
			mv.setViewName("manduNewSalePage");
		}else {
			mv.addObject("message", "You need Sign In");
			mv.setViewName("loginFormPage");
		}
		return mv;
	}
	
	@RequestMapping(value="seller")
	public ModelAndView seller(HttpServletRequest request, ModelAndView mv,
			SellerVO vo) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("loginID") != null) {
			vo.setId((String)session.getAttribute("loginID"));
			List<SellerVO> list = service.selectList(vo);
			if(list != null) {
				mv.addObject("SaleList", list);
			}else {
				mv.addObject("message", "No item");
			}
			mv.setViewName("manduSellerPage");
			return mv;
		}else {
			mv.addObject("message", "You need Sign In");
			mv.setViewName("loginFormPage");
		}
		return mv;
	}	
}//class
