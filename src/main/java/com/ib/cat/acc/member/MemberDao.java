package com.ib.cat.acc.member;

public interface MemberDao {
	public void memeberInsert(MemberDto md);
	public int idCheck(String id);
	public int nameCheck(String name);
}
