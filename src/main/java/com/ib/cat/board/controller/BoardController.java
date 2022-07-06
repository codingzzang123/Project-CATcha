package com.ib.cat.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ib.cat.board.model.BoardVo;
import com.ib.cat.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="/board")
	public String list(Model model) {
		//model.addAttribute("boardList", boardService.list());
		return "/board/list";
	}
	@RequestMapping(value="/board/read/{req}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("boardVo", boardService.read(seq));
		return "/board/read";
	}
	//새 글 작성을 위한 요청을 처리
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write() {
		return "/board/write";
	}
	//새 글 등록을 위한 요청을 처리
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String write(@Valid BoardVo boardVo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/board/write";
		}
		boardService.write(boardVo);
		return "redirect:/board/board";
	}
	
	@RequestMapping(value="/board/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable int seq, Model model) {
		BoardVo boardVo = boardService.read(seq);
		model.addAttribute("boardVo", boardVo);
		return "/board/detail";
	}
	
	@RequestMapping(value="/board/detail/{seq}", method=RequestMethod.POST)
	public String detail(@ModelAttribute BoardVo boardVo) {
		return "/board/detail";
	}
}
