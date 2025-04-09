-- 12 c 버전 이전 문법 허용 구문
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
-- 계정 생성 구문(username : kh / password : kh1234)
CREATE USER user01 IDENTIFIED BY pass01 ;


GRANT RESOURCE, CONNECT TO user01;
-- 사용자 계정 권한 부여 설정
-- RESOURCE : 테이블이나 인덱스 같은 DB 객체를 생성할 권한
-- CONNECT : DB에 연결하고 로그인 할 수 있는 권한

ALTER USER user01 DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM ;
-- 객체가 생성될 수 있는 공간 할당량 무제한 지정

-- 회원 테이블 생성
CREATE TABLE MEMBER (
    MEMBER_NO       NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY, -- 회원번호 (PK)
    MEMBER_ID       VARCHAR2(30) CONSTRAINT MEMBER_ID_UQ UNIQUE NOT NULL, -- 아이디 (UQ, NOT NULL)
    MEMBER_PW       VARCHAR2(100) NOT NULL, -- 비밀번호 (NOT NULL) - 실제로는 암호화된 값 저장 권장
    MEMBER_NICKNAME VARCHAR2(30) NOT NULL  -- 이름(닉네임) (NOT NULL)
);




-- 회원 번호 생성을 위한 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

-- 메모장 테이블 생성
CREATE TABLE MEMO (
    MEMO_NO         NUMBER CONSTRAINT MEMO_PK PRIMARY KEY, -- 메모번호 (PK)
    MEMO_TITLE      VARCHAR2(100) NOT NULL,              -- 제목 (NOT NULL)
    MEMO_CONTENT    VARCHAR2(4000),                     -- 내용
    CREATE_DATE     DATE DEFAULT SYSDATE NOT NULL,       -- 작성일 (기본값: 현재시간, NOT NULL)
    MODIFY_DATE     DATE,                               -- 수정일
    MEMBER_NO       NUMBER CONSTRAINT MEMO_MEMBER_FK REFERENCES MEMBER(MEMBER_NO) NOT NULL -- 회원번호 (FK, NOT NULL)
);


-- 메모 번호 생성을 위한 시퀀스 생성
CREATE SEQUENCE SEQ_MEMO_NO
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

-- 회원 테이블 샘플 데이터 (비밀번호는 'pass01'을 그대로 넣었지만, 실제로는 암호화 필요)
INSERT INTO MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PW, MEMBER_NICKNAME)
VALUES (SEQ_MEMBER_NO.NEXTVAL, 'test_user1', 'pass01', '테스트유저일');

INSERT INTO MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PW, MEMBER_NICKNAME)
VALUES (SEQ_MEMBER_NO.NEXTVAL, 'test_user2', 'pass02', '테스트유저이');

-- MEMBER 테이블 확인
SELECT * FROM MEMBER;


-- 메모장 테이블 샘플 데이터 (위에서 생성된 회원의 MEMBER_NO 확인 후 입력)
-- 만약 위 INSERT 결과 MEMBER_NO가 1, 2로 생성되었다면:
INSERT INTO MEMO (MEMO_NO, MEMO_TITLE, MEMO_CONTENT, MEMBER_NO)
VALUES (SEQ_MEMO_NO.NEXTVAL, '첫 번째 테스트 메모', '테스트 메모 내용입니다.', 1); -- 1번 회원이 작성

INSERT INTO MEMO (MEMO_NO, MEMO_TITLE, MEMO_CONTENT, MEMBER_NO)
VALUES (SEQ_MEMO_NO.NEXTVAL, '두 번째 테스트 메모', '다른 테스트 내용.', 2); -- 2번 회원이 작성

-- MEMO 테이블 확인
SELECT * FROM MEMO;