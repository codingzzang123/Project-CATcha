package com.ib.cat.main.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainDaoImpl implements MainDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<MainDTO> getTopFive() {
		return sqlSessionTemplate.selectList("main.dtd.selectTopFive");
	}
}
