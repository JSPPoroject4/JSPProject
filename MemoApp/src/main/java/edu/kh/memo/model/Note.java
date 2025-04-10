package edu.kh.memo.model;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

public class Note {

	@Getter
	@Setter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public class Note {
	    private Long memoNo;
	    private String title;
	    private String content;
	    private Date creationDate;
	    private Date modificationDate;
	    private Long memberNo;
	}
}
