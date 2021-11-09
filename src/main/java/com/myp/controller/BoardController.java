package com.myp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myp.service.BoardService;

@Controller
@RequestMapping(value="/") // 주소패턴
public class BoardController {

	@Inject //주입 명시
	private BoardService service; //service 호출을 위한 객체 생성
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET) // 주소 호출 명시. 호출하려는 주소와 REST 방식 설정(GET)
	public void listAll(Model model)throws Exception { 
		model.addAttribute("list", service.listAll()); //jsp에 심부름할 내역(서비스 호출)
	}
}
