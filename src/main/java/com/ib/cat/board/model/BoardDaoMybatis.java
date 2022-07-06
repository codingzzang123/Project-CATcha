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
		return sqlSessionTemplate.selectList("list");
	}
	@Override
	public int delete(BoardVo boardVo) {
		return sqlSessionTemplate.delete("delete", boardVo);
	}
	
	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("deleteAll");
	}
	
	@Override
	public int update(BoardVo boardVo) {
		return sqlSessionTemplate.update("update", boardVo);
	}
	
	@Override
	public void insert(BoardVo boardVo) {
		sqlSessionTemplate.update("insert", boardVo);
	}
	
	@Override
	public BoardVo select(int seq) {
		BoardVo vo = (BoardVo) sqlSessionTemplate.selectOne("select", seq);
		return vo;
	}
	
	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("updateCount", seq);
	}
}
