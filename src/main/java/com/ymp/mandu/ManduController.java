package com.ymp.mandu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.ConsumerService;
import service.ManduService;
import service.SellerService;
import vo.ConsumerVO;
import vo.ManduVO;
import vo.SellerVO;

@Controller
public class ManduController {

	@Autowired
	ManduService service;
	@Autowired
	SellerService sellerservice;
	@Autowired
	ConsumerService consumerservice;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		rttr.addFlashAttribute("message", "Sign Out is completed");
		mv.setViewName("redirect:home");
		return mv;
	}
	
	@RequestMapping(value="/profile")
	public ModelAndView profile(HttpServletRequest request, ModelAndView mv, ManduVO vo) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("loginID")!=null) {
			vo.setId((String)session.getAttribute("loginID"));
			if(request.getParameter("id")!=null) vo.setId(request.getParameter("id"));
			vo=service.selectOne(vo);
			if(vo!=null) {
				if("U".equals(request.getParameter("jcode"))) {
					// 내 정보 수정
					mv.setViewName("");
					vo.setPassword((String)session.getAttribute("loginPW"));
				}else {
					mv.setViewName("manduProfilePage");
					vo.setPassword("********");
				}
				mv.addObject("ManduPerson", vo);
			}else {
				mv.addObject("message", "You don't have Mandu information");
				mv.setViewName("loginFormPage");
			}
		}else {
			mv.addObject("message", "You need Sign In");
			mv.setViewName("loginFormPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/loginform")
	public ModelAndView loginform(ModelAndView mv) {
		mv.setViewName("loginFormPage");
		return mv;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request, 
			ModelAndView mv, ManduVO vo) {
		String password = vo.getPassword();
		vo = service.selectOne(vo);
		if(vo!=null) {
			if(passwordEncoder.matches(password, vo.getPassword())) {
				request.getSession().setAttribute("loginID", vo.getId());
				request.getSession().setAttribute("loginName", vo.getName());
				request.getSession().setAttribute("loginPW", password);
				mv.setViewName("redirect:home");
			}else {
				mv.addObject("pmessage", "Wrong password");
				mv.setViewName("loginFormPage");
			}
		}else {
			mv.addObject("emessage", "Wrong E-mail");
			mv.setViewName("loginFormPage");
		}
		return mv;
	}//login
	
	@RequestMapping(value="/joinform")
	public ModelAndView joinform(ModelAndView mv) {
		mv.setViewName("joinFormPage");
		return mv;
	}//joinform
	
	@RequestMapping(value="/emailCheck")
	public ModelAndView emailCheck(ModelAndView mv, ManduVO vo) {
		mv.addObject("newID", vo.getId());
		if(service.selectOne(vo) != null) mv.addObject("idUse", "F");
		else mv.addObject("idUse", "T");
		mv.setViewName("emailDupCheck");
		return mv;
	}
	
	@RequestMapping(value="/join")
	public ModelAndView join(ModelAndView mv, ManduVO vo, HttpServletRequest request) throws IOException{
		//Image
		String realPath = request.getRealPath("/");
		System.out.println("join_realPath => "+realPath);
		if(realPath.contains(".eclipse."))
			realPath = "C:/MTest/MyWork/Mandu/src/main/webapp/resources/uploadImage/";
		else realPath += "resources\\uploadImage\\";
		File f1 = new File(realPath);
		if(!f1.exists()) f1.mkdir();
		String file1, file2 = "resources/uploadImage/basic.jpg";
		MultipartFile myImagef = vo.getMyImagef();
		if(myImagef != null && !myImagef.isEmpty()) {
			file1 = realPath + myImagef.getOriginalFilename();
			myImagef.transferTo(new File(file1));
			file2 = "resources/uploadImage/"+myImagef.getOriginalFilename();
		}
		vo.setMyImage(file2);
		
		//Password
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		
		//Join
		if(service.insert(vo) > 0) {
			mv.addObject("message", "Try Sign In");
			mv.setViewName("loginFormPage");
		}else {
			mv.addObject("message", "Sign Up Fail, Please try again");
			mv.setViewName("joinFormPage");
		}
		return mv;
	}

	@RequestMapping(value="/mdelete")
	public ModelAndView mdelete(HttpServletRequest request, ModelAndView mv, ManduVO vo, SellerVO svo, ConsumerVO cvo, RedirectAttributes rttr) {
		HttpSession session = request.getSession(false);
		String loginID = (String)session.getAttribute("loginID");
		if(session!=null && loginID!=null) {
			//Seller table 확인 ForeignKey
			svo.setId(loginID);
			cvo.setId(loginID);
			List<SellerVO> list = sellerservice.selectList(svo);
			List<ConsumerVO> clist = consumerservice.selectList(cvo);
			System.out.println("svo*****=> "+list);
			System.out.println("svo*****=> "+list.size());
			if(list.size()>0) {
				rttr.addFlashAttribute("message", "You must remove Sale Item first");
				mv.setViewName("redirect:profile");
			}else if(clist.size()>0) {
				rttr.addFlashAttribute("message", "You must remove Purchase Item first");
				mv.setViewName("redirect:profile");
			}else {
				vo.setId(loginID);
				vo=service.selectOne(vo);
				//myImage 삭제
				if(vo!=null) {
					String fileName = vo.getMyImage().substring(vo.getMyImage().lastIndexOf("/")+1);
					String realPath = request.getRealPath("/");
					if(realPath.contains(".eclipse.")) 
						realPath = "C:/MTest/MyWork/Mandu/src/main/webapp/resources/uploadImage/"+fileName;
					else realPath += "resources\\uploadImage\\"+fileName;
					File delF = new File(realPath);
					if(delF.exists()) delF.delete();
				}
				//id 삭제
				if(service.delete(vo) > 0) {
					session.invalidate();
					rttr.addFlashAttribute("message", "Account Removed");
					mv.setViewName("redirect:home");
				}else {
					rttr.addFlashAttribute("message", "Remove Fail");
					mv.setViewName("redirect:profile?id="+vo.getId());
				}
			}	
		}else {
			mv.addObject("message","No Data");
			mv.setViewName("loginFormPage");
		}
		return mv;
	}
	
}
