package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import criTest.SearchCriteria;
import vo.SellerVO;

@Repository
public class SellerDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "mandu.mapper.SellerMapper.";
	
	public List<SellerVO> searchList(SearchCriteria cri){
		return sqlSession.selectList(NS+"searchList", cri);
	}
	
	public List<SellerVO> selectCategoryList(SellerVO vo){
		return sqlSession.selectList(NS+"selectCategoryList", vo);
	}
	
	public SellerVO selectHomeOne(SellerVO vo) {
		return sqlSession.selectOne(NS+"selectHomeOne", vo);
	}
	
	public List<SellerVO> selectHomeList(){
		return sqlSession.selectList(NS+"selectHomeList");
	}
	
	public int insert(SellerVO vo) {
		return sqlSession.insert(NS+"insert",vo);
	}
	
	public List<SellerVO> selectList(SellerVO vo){
		return sqlSession.selectList(NS+"selectList",vo);
	}
	
	public SellerVO selectOne(SellerVO vo) {
		return sqlSession.selectOne(NS+"selectOne",vo);
	}
	
	public int update(SellerVO vo) {
		return sqlSession.update(NS+"update", vo);
	}
	
	public int delete(SellerVO vo) {
		return sqlSession.delete(NS+"delete", vo);
	}
}
