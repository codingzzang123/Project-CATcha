package com.ib.cat.board.model;

import java.util.List;

public interface BoardDao {
	
	public abstract List<BoardVo> list();
	
	public abstract int delete(BoardVo boardVo);
	
	public abstract int deleteAll();
	
	public abstract int update(BoardVo boardVo);
	
	public abstract void insert(BoardVo boardVo);
	
	public abstract BoardVo select(int seq);
	
	public abstract int updateReadCount(int seq);

}
