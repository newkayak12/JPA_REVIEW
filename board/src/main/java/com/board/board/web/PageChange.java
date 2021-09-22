package com.board.board.web;

import javax.servlet.http.HttpSession;

import com.board.board.service.BoardService;
import com.board.board.web.dto.BoardDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PageChange {
	@Autowired
	BoardService service;

	@RequestMapping("/")
	public String index(){
		log.error("index");
		return "index";
	}

	@RequestMapping("/goto/main")
	public String gotoMain(String userId, Model model, HttpSession session){
		if(session.getAttribute("userId")==null){
			// model.addAttribute("userId", userId);
			session.setAttribute("userId", userId);
		}
		model.addAttribute("boards", service.getBoardList());
		return "/member/main";
	}	


	@GetMapping("/api/v1/board/{boardNumber}")
	public String boardUpdate(@PathVariable Long boardNumber, Model model){
		
		BoardDto result =service.getBoartdOne(boardNumber);
		model.addAttribute("boardOne", result);
		return "/member/boardDetail";
	}

	@RequestMapping("/goto/writeForm")
	public String gotoWriteForm(){
		return "/member/writeForm";
	}

	@RequestMapping("/goto/logout")
	public String logout(HttpSession session){
		session.removeAttribute("userId");
		return "/";
	}

	@RequestMapping("/goto/sinupForm")
	public String signupForm(){
		return "/member/signupForm";
	}
}
