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
    private Member member; // 필드에 멤버 선언
	public void setMemberId(String userId) {
	
	}
	
	 public void setMember(Member member) {
	        this.member = member;
	    }
	 
	    // toString 메서드 (필요에 따라 수정)
	    @Override
	    public String toString() {
	        return "Memo [memoNo=" + memoNo + ", memoTitle=" + memoTitle + ", memoContent=" + memoContent
	                + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", memberNo=" + memberNo
	                + ", member=" + member + "]";
	    }
}