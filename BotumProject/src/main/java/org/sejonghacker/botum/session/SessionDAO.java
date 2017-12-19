package org.sejonghacker.botum.session;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SessionDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public boolean pwCheck(String id, String pw) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		paramMap.put("pw", pw);

		return ((int)sqlSession.selectOne("pwCheck", paramMap) > 0)? true:false;
	}

	public MemberVO getMVO(String id) {
		return sqlSession.selectOne("getMVO", id);
	}

	public Integer registerMVO(MemberVO mvo) {
		return sqlSession.insert("registerMVO", mvo);
	}
	
}
