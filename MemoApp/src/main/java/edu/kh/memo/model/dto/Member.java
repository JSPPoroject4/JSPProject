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
public class Member {
	//private int no;
	private String id;
	private String pw;
	private String nickname;
	public Long getMemberNo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
