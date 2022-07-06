package com.ib.cat.board.service;

import java.util.List;

import com.ib.cat.board.model.BoardVo;

public interface BoardService {
	
	public abstract List<BoardVo> list();
	
	public abstract int delete(BoardVo boardVo);
	
	public abstract int detail(BoardVo boardVo);
	
	public abstract void write(BoardVo boardVo);
	
	public abstract BoardVo read(int seq);

}
