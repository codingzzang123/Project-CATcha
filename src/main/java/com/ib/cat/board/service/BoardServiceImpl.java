package com.ib.cat.board.service;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ib.cat.board.model.BoardDao;
import com.ib.cat.board.model.BoardVo;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private SqlSessionTemplate sst;
	
	//전체 회원 조회
	@Override
	public List<BoardVo> list(){
		return sst.selectList("list");
	}
	
	//정보 입력
	@Override
	public void boardinsert(BoardVo boardVo) {
		sst.insert("boardinsert", boardVo);
	}
	
	//정보 삭제
	@Override
	public void delete(int no) {
		sst.delete("delete", no);
	}
	
	//정보 수정
	@Override
	public void update(BoardVo boardVo) {
		sst.update("update", boardVo);
	}
	
	//상세 조회
	@Override
	public int detail(BoardVo boardVo) {
		return sst.selectOne("detail");
	}
	
	//목록중 하나만 조회
	@Override
	public BoardVo selectById(int no) {
		return sst.selectOne("board.Dao.selectById", no);
	}
	
	//조회수 카운트
	@Override
	public int updateReadCount(int no) {
		return sst.update("update");
	}
}
