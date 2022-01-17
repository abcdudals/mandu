package util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.ManduVO;

@Repository
public class ManduDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "mandu.mapper.ManduMapper.";
	
//---------------------------------------------------------------
	
	//** selectName
	public ManduVO selectName(ManduVO vo) {
		return sqlSession.selectOne(NS+"selectName", vo);
	}
	
	//** selectOne
	public ManduVO selectOne(ManduVO vo) {
		return sqlSession.selectOne(NS+"selectOne", vo);
	} //selectOne
	
	//** insert
	public int insert(ManduVO vo) {
		return sqlSession.insert(NS+"insert", vo);
	}//insert
	
	//** delete
	public int delete(ManduVO vo) {
		return sqlSession.delete(NS+"delete", vo);
	}
	
}
