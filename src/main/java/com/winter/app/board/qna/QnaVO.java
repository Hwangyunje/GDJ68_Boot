package com.winter.app.board.qna;

import java.util.List;

import com.winter.app.board.BoardVO;
import com.winter.app.board.notice.NoticeFileVO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class QnaVO extends BoardVO {

	private List<NoticeFileVO> list;
}
