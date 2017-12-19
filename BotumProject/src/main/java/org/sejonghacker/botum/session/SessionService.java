package org.sejonghacker.botum.session;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class SessionService {
	@Resource
	private SessionDAO sessionDAO;
	
	public MemberVO login(String id, String pw) {
		return sessionDAO.pwCheck(id, pw)? sessionDAO.getMVO(id) : null;			
	}

	public boolean register(MemberVO mvo) {
		sessionDAO.registerMVO(mvo);
		return sessionDAO.pwCheck(mvo.getMember_id(), mvo.getMember_pwd());
	}
}
