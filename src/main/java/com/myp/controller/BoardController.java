package com.myp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myp.domain.BoardVO;
import com.myp.service.BoardService;

@Controller
@RequestMapping(value="/") 
public class BoardController {
	

	@Inject //주입 명시
	
	private BoardService service; //service 호출을 위한 객체 생성
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET) //주소 호출 명시
	public void listAll(Model model)throws Exception { 
		
		model.addAttribute("list", service.listAll()); //jsp에 주입할 내역(서비스 호출)
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET) //GET방식 페이지 호출
	public void registerGET(BoardVO board, Model model) throws Exception{

	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST) //POST방식으로 내용 전송
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		// 인자값으로 REDIRECT 사용
		service.regist(board);
		
	return "redirect:/listAll"; 
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET) //GET방식으로 페이지 호출
	public void read( @RequestParam("bno")int bno, Model model) throws Exception{
		// 인자값은 파라미터 값으로 기본키인 글번호를 기준으로 Model을 사용하여 불러옴
		model.addAttribute(service.read(bno)); // read 서비스 호출
	}
}
