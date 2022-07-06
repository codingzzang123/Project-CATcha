package com.ib.cat.acc.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;


@Service
public class MemberDaoImpl implements MemberDao{
	private SqlSessionTemplate sst;
	
	public MemberDaoImpl(SqlSessionTemplate sst) {
		this.sst = sst;
	}

	@Override
	public void insert(MemberDto md) {
		sst.insert("insert", md);
	}

	@Override
	public int idCheck(String id) {
		return sst.selectOne("idCheck", id);
	}

	@Override
	public int nameCheck(String name) {
		return sst.selectOne("nameCheck", name);
	}
	
	
}
