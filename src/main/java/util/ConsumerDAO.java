package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.ConsumerVO;

@Repository
public class ConsumerDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "mandu.mapper.ConsumerMapper.";
	
//------------------------------------------------------------------
	
	//** selectItemList
	public List<ConsumerVO> selectItemList(ConsumerVO vo) {
		return sqlSession.selectList(NS+"selectItemList", vo);
	}
	
	//** selectList
	public List<ConsumerVO> selectList(ConsumerVO vo){
		return sqlSession.selectList(NS+"selectList", vo);
	}
	
	//** selectOne
	public ConsumerVO selectOne(ConsumerVO vo) {
		return sqlSession.selectOne(NS+"selectOne", vo);
	}
	
	//** insert
	public int insert(ConsumerVO vo) {
		return sqlSession.insert(NS+"insert", vo);
	}
	
}
