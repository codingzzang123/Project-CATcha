package com.ib.cat.acc.member;

public interface MemberDao {
	public void insert(MemberDto md);
	public int idCheck(String id);
	public int nameCheck(String name);
}
