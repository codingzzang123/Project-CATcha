package com.ib.cat.board.model;

import java.util.List;

public interface BoardDao {
	
	//전체 회원 목록 조희
	public abstract List<BoardVo> list();
	
	//정보 입력
	public abstract void boardinsert(BoardVo boardVo);
	
	//정보삭제
	public abstract int delete(BoardVo boardVo);
	
	//정보수정
	public abstract int update(BoardVo boardVo);
	

	public abstract BoardVo select(int no);
	
	
	public abstract BoardVo selectById(int no);
	
	//조회수 카운트
	public abstract int updateReadCount(int no);

}
