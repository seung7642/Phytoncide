package com.pangtrue.spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) { // 요청받은 이메일이 존재하면
			throw new DuplicateMemberException("dup email " + req.getEmail()); // 중복 이메일에 대한 예외를 던진다.
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
