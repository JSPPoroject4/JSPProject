package edu.kh.memo.model.dto;

import edu.kh.memo.model.dto.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Getter + Setter + toString
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 김동준 멤버 넘버 롱으로 수정
public class Member {
	//private int no;
	public Long MemberNo; 
	private String id;
	private String pw;
	private String nickname;
}	

