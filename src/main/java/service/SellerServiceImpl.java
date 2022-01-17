package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import criTest.SearchCriteria;
import util.SellerDAO;
import vo.SellerVO;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerDAO dao;
	
	@Override
	public List<SellerVO> searchList(SearchCriteria cri) {
		return dao.searchList(cri);
	}
	
	@Override
	public List<SellerVO> selectCategoryList(SellerVO vo) {
		return dao.selectCategoryList(vo);
	}
	
	@Override
	public SellerVO selectHomeOne(SellerVO vo) {
		return dao.selectHomeOne(vo);
	}
	
	@Override
	public List<SellerVO> selectHomeList() {
		return dao.selectHomeList();
	}
	
	@Override
	public int insert(SellerVO vo) {
		return dao.insert(vo);
	}
	
	@Override
	public List<SellerVO> selectList(SellerVO vo) {
		return dao.selectList(vo);
	}
	
	@Override
	public SellerVO selectOne(SellerVO vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int update(SellerVO vo) {
		return dao.update(vo);
	}
	
	@Override
	public int delete(SellerVO vo) {
		return dao.delete(vo);
	}
	
}
