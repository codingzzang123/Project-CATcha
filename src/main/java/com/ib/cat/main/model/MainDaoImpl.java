package com.ib.cat.main.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib.cat.main.dto.MainDTO;
import com.ib.cat.main.dto.SearchBoardDTO;

@Service
public class MainDaoImpl implements MainDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<MainDTO> getTopFive() {
		return sqlSessionTemplate.selectList("main.dtd.selectTopFive");
	}
	
	@Override
	public int getToday() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("main.dtd.selectVisitToday");
	}
	
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("main.dtd.selectVisitTotal");
	}
	
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("main.dtd.insertVisit");
	}
	
	@Override
	public int searchBoardCount(String query) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("countBoardFromSearch",query);
	}
	
	@Override
	public List<MainDTO> searchBoard(SearchBoardDTO sbd) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("selectBoardFromSearch",sbd);
	}
}
