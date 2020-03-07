package ide.apps.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ide.apps.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	int selectBoardListCnt() throws Exception;
	
	List<BoardDto> selectBoardList() throws Exception;
	
}