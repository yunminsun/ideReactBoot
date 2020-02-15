package ide.apps.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ide.apps.board.dto.BoardDto;
import ide.apps.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;

//@Controller
//@RequestMapping("/board")
@RestController
@RequestMapping("/v1/api")
public class BoardController {
	
//	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

//	@RequestMapping("list")
//	public ModelAndView notice(HttpServletRequest request, BoardDto boardDto) throws Exception {
//		
//		ModelAndView mv = new ModelAndView();
//		
//		// 목록 갯수
//		int totalCnt = this.boardService.selectBoardListCnt(request, boardDto);
//		
//		// 목록
//		List<BoardDto> list = null;
//		if(totalCnt > 0){
//			list = this.boardService.selectBoardList(request, boardDto);
//		}
//		
//		// 로그 테스트
////		if(logger.isDebugEnabled()) {
////			logger.debug("test log");
////		}
//		
//		mv.addObject("totalCnt", totalCnt);
//		mv.addObject("list", list);
//		mv.addObject("boardDto", boardDto);
//		return mv;
//	}
	
	@GetMapping("board")
    public List<BoardDto> boardList(HttpServletRequest request, @ModelAttribute BoardDto board) throws Exception {
		return this.boardService.selectBoardList(request, board);
    }

    @GetMapping("board/{boardIdx}")
    public BoardDto detailBoard(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) int boardIdx) throws Exception {
        return this.boardService.selectBoard(request, boardIdx);
    }

    @PostMapping("board")
    public void insertBoard(HttpServletRequest request, @RequestBody BoardDto board) throws Exception {
        this.boardService.insertBoard(request, board);
    }

    @PutMapping("board/{boardIdx}")
    public void updateBoard(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) int boardIdx, @RequestBody BoardDto board) throws Exception {
        board.setBoardIdx(boardIdx);
        this.boardService.updateBoard(request, board);
    }

    @DeleteMapping("board/{boardIdx}")
    public void deleteBoard(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) int boardIdx) throws Exception {
        this.boardService.deleteBoard(request, boardIdx);
    }
	
}