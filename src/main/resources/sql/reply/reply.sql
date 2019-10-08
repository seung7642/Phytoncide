-- 댓글 테이블
CREATE TABLE reply (
    reply_no INT NOT NULL AUTO_INCREMENT,
    article_no INT NOT NULL DEFAULT 0,
    reply_text VARCHAR(1024) NOT NULL,
    reply_writer VARCHAR(64) NOT NULL,
    reg_date TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (reply_no),
    CONSTRAINT reply_fk_article FOREIGN KEY (article_no) REFERENCES article (article_no)
);