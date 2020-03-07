package ide.apps.board.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ide.apps.board.dto.BoardDto;
import ide.apps.board.mapper.BoardMapper;
import ide.com.dao.CommonDao;

@Service
public class BoardServiceImpl implements BoardService {

//	@Autowired
//	private BoardMapper boardMapper;
//	
//	public int selectBoardListCnt(HttpServletRequest request, BoardDto boardDto) throws Exception {
//		return boardMapper.selectBoardListCnt();
//	}
//
//	public List<BoardDto> selectBoardList(HttpServletRequest request, BoardDto boardDto) throws Exception {
//		return boardMapper.selectBoardList();
//	}
	
//	@Autowired
//	private BoardDao boardDao;
	
	@Resource(name="cmDao")
	private CommonDao cmDao;
	
	public int selectBoardListCnt(HttpServletRequest request, BoardDto boardDto) throws Exception {
		return cmDao.selectListCnt("Board.selectBoardListCnt", boardDto);
	}
	
	public List<BoardDto> selectBoardList(HttpServletRequest request, BoardDto boardDto) throws Exception {
		return cmDao.selectList("Board.selectBoardList", boardDto);
	}
	
	public BoardDto selectBoard(HttpServletRequest request, int boardIdx) throws Exception {
		return cmDao.select("Board.selectBoard", boardIdx);
	}
	
	public int insertBoard(HttpServletRequest request, BoardDto boardDto) throws Exception {
		return cmDao.insert("Board.insertBoard", boardDto);
	}
	
	public int updateBoard(HttpServletRequest request, BoardDto boardDto) throws Exception {
		return cmDao.update("Board.updateBoard", boardDto);
	}

	public int deleteBoard(HttpServletRequest request, int boardIdx) {
		return cmDao.delete("Board.updateBoard", boardIdx);
	}

	
}