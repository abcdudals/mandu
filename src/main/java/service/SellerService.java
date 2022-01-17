package service;

import java.util.List;

import criTest.SearchCriteria;
import vo.SellerVO;

public interface SellerService {

	public List<SellerVO> searchList(SearchCriteria cri);
	
	List<SellerVO> selectCategoryList(SellerVO vo);
	
	SellerVO selectHomeOne(SellerVO vo);
	
	List<SellerVO> selectHomeList();
	
	int insert(SellerVO vo);
	
	List<SellerVO> selectList(SellerVO vo);
	
	SellerVO selectOne(SellerVO vo);
	
	int update(SellerVO vo);
	
	int delete(SellerVO vo);
}
