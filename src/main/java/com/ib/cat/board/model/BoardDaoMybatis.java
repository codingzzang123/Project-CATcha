package com.ib.cat.board.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoMybatis implements BoardDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//전체 회원 목록 조희
	@Override
	public List<BoardVo> list() {
		return sqlSessionTemplate.selectList("board.Dao.list");
	}
	
	//정보 입력
	@Override
	public void boardinsert(BoardVo boardVo) {
		sqlSessionTemplate.selectOne("board.Dao.boardinsert", boardVo);
	}
	
	//정보 삭제
	@Override
	public int delete(BoardVo boardVo) {
		return sqlSessionTemplate.delete("board.Dao.delete", boardVo);
	}
	
	//정보 수정
	@Override
	public int update(BoardVo boardVo) {
		return sqlSessionTemplate.update("board.Dao.update", boardVo);
	}
	

	@Override
	public BoardVo select(int no) {
		BoardVo vo = (BoardVo) sqlSessionTemplate.selectOne("board.Dao.select", no);
		return vo;
	}
	
	@Override
	public BoardVo selectById(int no) {
		return sqlSessionTemplate.selectOne("board.Dao.select", no);
	}
	
	//조회수카운트
	@Override
	public int updateReadCount(int no) {
		return sqlSessionTemplate.update("board.Dao.updateCount", no);
	}
}
