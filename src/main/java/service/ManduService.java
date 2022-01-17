package service;

import vo.ManduVO;

public interface ManduService {
	
	public ManduVO selectName(ManduVO vo);
	
	ManduVO selectOne(ManduVO vo); //selectOne
	
	int insert(ManduVO vo); //insert
	
	int delete(ManduVO vo); //delete
}
