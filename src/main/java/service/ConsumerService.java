package service;

import java.util.List;

import vo.ConsumerVO;

public interface ConsumerService {

	List<ConsumerVO> selectList(ConsumerVO vo);
	
	List<ConsumerVO> selectItemList(ConsumerVO vo);
	
	ConsumerVO selectOne(ConsumerVO vo);
	
	int insert(ConsumerVO vo);
	
}
