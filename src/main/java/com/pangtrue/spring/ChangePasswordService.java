package com.pangtrue.spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {

    private MemberDao memberDao;

    @Transactional // 트랜잭션 범위에서 실행한다.
    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);
        if (member == null)
            throw new MemberNotFoundException();

        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

}
