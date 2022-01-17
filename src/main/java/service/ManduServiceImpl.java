package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.ManduDAO;
import vo.ManduVO;

@Service
public class ManduServiceImpl implements ManduService{
	
	@Autowired
	ManduDAO dao;

	@Override
	public ManduVO selectName(ManduVO vo) {
		return dao.selectName(vo);
	}
	
	@Override
	public int insert(ManduVO vo) {
		return dao.insert(vo);
	}//insert

	@Override
	public ManduVO selectOne(ManduVO vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int delete(ManduVO vo) {
		return dao.delete(vo);
	}
	
}
