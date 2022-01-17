package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.ConsumerDAO;
import vo.ConsumerVO;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	ConsumerDAO dao;
	
	@Override
	public List<ConsumerVO> selectList(ConsumerVO vo) {
		return dao.selectList(vo);
	}
	
	@Override
	public List<ConsumerVO> selectItemList(ConsumerVO vo) {
		return dao.selectItemList(vo);
	}
	
	@Override
	public ConsumerVO selectOne(ConsumerVO vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int insert(ConsumerVO vo) {
		return dao.insert(vo);
	}
	
}
