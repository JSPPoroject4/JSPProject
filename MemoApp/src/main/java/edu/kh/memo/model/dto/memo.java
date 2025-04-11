package edu.kh.memo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Memo {
    private Long memoNo;
    private String memoTitle;
    private String memoContent;
    private Date createDate;
    private Date modifyDate;
    private Long memberNo;
	public void setMemberId(String userId) {
		// TODO Auto-generated method stub
		
	}
}