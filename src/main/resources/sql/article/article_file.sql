-- 게시글 첨부파일 테이블
CREATE TABLE article_file (
    file_name VARCHAR(256) NOT NULL,
    article_no INT NOT NULL,
    reg_date TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (file_name)
    CONSTRAINT article_file_fk FOREIGN KEY (article_no) REFERENCES article (article_no)
);

-- 첨부파일 갯수 칼럼 추가
ALTER TABLE article_file ADD COLUMN file_cnt INT DEFAULT 0;