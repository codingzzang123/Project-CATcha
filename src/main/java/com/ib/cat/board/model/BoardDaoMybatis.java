package com.ib.cat.board.model;

import java.util.List;

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
	
	@Override
	public List<BoardVo> list() {
		return sqlSessionTemplate.selectList("board.Dao.list");
	}
	@Override
	public int delete(BoardVo boardVo) {
		return sqlSessionTemplate.delete("board.Dao.delete", boardVo);
	}
	
	
	@Override
	public int update(BoardVo boardVo) {
		return sqlSessionTemplate.update("board.Dao.update", boardVo);
	}
	
	@Override
	public void insert(BoardVo boardVo) {
		sqlSessionTemplate.update("board.Dao.insert", boardVo);
	}
	
	@Override
	public BoardVo select(int no) {
		BoardVo vo = (BoardVo) sqlSessionTemplate.selectOne("board.Dao.select", no);
		return vo;
	}
	
	@Override
	public int updateReadCount(int no) {
		return sqlSessionTemplate.update("board.Dao.updateCount", no);
	}
}
