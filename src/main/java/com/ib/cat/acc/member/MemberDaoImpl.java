package com.ib.cat.acc.member;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDaoImpl implements MemberDao{
	private SqlSessionTemplate sst;
	
	public MemberDaoImpl(SqlSessionTemplate sst) {
		super();
		this.sst = sst;
	}

	@Override
	public void insert(MemberDto md) {
		sst.insert("insert", md);
	}
	
	
}
