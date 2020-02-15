package ide.apps.board.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class BoardDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Integer boardIdx;

    public String title;

    public String content;

    public int hitCnt;

    public String regId;

    public String regDate;
    
}
