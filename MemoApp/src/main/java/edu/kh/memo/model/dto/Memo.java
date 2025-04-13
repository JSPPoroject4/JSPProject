package edu.kh.memo.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
		// TODO Auto-generated method stubasdasd
		
	}
}