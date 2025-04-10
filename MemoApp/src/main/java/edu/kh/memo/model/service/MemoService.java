package edu.kh.memo.model.service;

import edu.kh.memo.model.dto.Memo;

public interface MemoService {

	Memo memoDetail(int memoNo);

	int memoUpdate(int memoNo, String title, String detail);

}
