package com.ib.cat.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ib.cat.board.model.BoardVo;
import com.ib.cat.board.service.BoardService;

@Controller
public class BoardController {
	private BoardService boardService;
	
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/board")
	public String list(Model model) {
		List<BoardVo> list = new ArrayList<>();
		list = boardService.list();
		
		for(BoardVo v : list)
			System.out.println(v.toString());
		
		model.addAttribute("boardlist", list);
		return "/board/list";
	}
	
	@RequestMapping(value="/board/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("boardVo", boardService.read(seq));
		return "/board/read";
	}
	
	//새글 작성 위한 요청처리
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write() {
		return "/board/write";
	}
	
	//새글 등록 위한 요청처리
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
		public String write(@Valid BoardVo boardVo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/board/write";
		}
		boardService.write(boardVo);
		return "redirect:/board/list";
	}
	
	//글 수정 기능
	@RequestMapping(value="/board/edit/{seq}", method=RequestMethod.GET)
	public String edit(@PathVariable int seq, Model model) {
		BoardVo boardVo = boardService.read(seq);
		model.addAttribute("boardVo", boardVo);
		return "/board/edit";
	}

}
