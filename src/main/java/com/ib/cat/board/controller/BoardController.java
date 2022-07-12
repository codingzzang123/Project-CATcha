package com.ib.cat.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ib.cat.board.model.BoardVo;
import com.ib.cat.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//글 목록
	@RequestMapping(value="/board")
	public String list(Model model) {
		List<BoardVo> list = new ArrayList<>();
		list = boardService.list();
		
		for(BoardVo v : list)
			System.out.println(v.toString());
		
		model.addAttribute("boardlist", list);
		return "/board/list";
	}
	
	//새글 작성 위한 요청처리
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write(@ModelAttribute("BoardVo") BoardVo boardVo, Model model)throws Exception {
		boardVo.setTitle("제목을 입력해주세요.");
		boardVo.setContent("내용을 입력해주세요.");
		return "/board/write";
	}
	
	//새글 등록 위한 요청처리
	@RequestMapping(value="/board/list", method=RequestMethod.POST)
		public String write(@Valid BoardVo boardVo, BindingResult bindingResult) {
		boardService.boardinsert(boardVo);
		return "redirect:/board";
	}
	
	//세부사항 보기기능
	@RequestMapping("/board/detail/{no}")
	public String detail(@PathVariable("no") int no, Model model) {
		System.out.println("no = " + no);
		BoardVo boardVo = boardService.selectById(no);
		model.addAttribute("boardVo", boardVo);
		return "/board/detail";
	}
	
//	/* 페이지 수정 */
//    @PostMapping("/board/edit")
//    public String boardModifyPOST(BoardVo boardVo, RedirectAttributes rttr) {
//        
//        boardService.update(boardVo);
//        
//        rttr.addFlashAttribute("result", "update success");
//        
//        return "redirect:/board/edit";
//        
//    }
	//글 수정 기능
	@RequestMapping(value="/board/edit/{no}", method=RequestMethod.GET)
	public String edit(@PathVariable int no, Model model, BoardVo boardVo) {
		System.out.println("no = " + no);
//		boardService.update(boardVo);
		model.addAttribute("boardVo", boardService.selectById(no));
		return "/board/edit";
	}
	
	/* 글 수정 완료*/
	
//	@RequestMapping(value="/board/edit/{no}", method=RequestMethod.POST)
//	public String delete(@PathVariable("no") int no,HttpServletRequest request) {
//		System.out.println("cate = "+ request.getParameter("cate"));
//		System.out.println("title = "+ request.getParameter("title"));
//		System.out.println("content = "+ request.getParameter("content"));
////		boardService.update(boardVo);
//		return "redirect:/board";
//	}
	
	//글 삭제 기능
//	@ResponseBody
//	@RequestMapping(value="/board/edit", method=RequestMethod.GET)
//	public String delete(@PathVariable("no") int no, Model model) {
//		System.out.println("no = " + no);
//		boardService.delete(no);
//		model.addAttribute("boardVo", no);
//		return "/board/list";
//	}
	
}
	