package org.sejonghacker.botum.Crawling;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LectureDAO {
	
	@Resource
	SqlSessionTemplate sqlSession;
	
	
	public ArrayList<Lecture> getAllList(String id) {
		List<Lecture> list;
		list = sqlSession.selectList("getAllList", id);
		return (ArrayList<Lecture>)list;
		
	}

}
