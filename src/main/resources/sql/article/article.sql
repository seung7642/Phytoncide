-- 게시글 테이블
CREATE TABLE article (
    article_no INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(128) NOT NULL,
    content TEXT NULL,
    writer VARCHAR(64) NOT NULL,
    reg_date TIMESTAMP NOT NULL DEFAULT NOW(),
    view_cnt INT DEFAULT 0,
    reply_cnt INT DEFAULT 0,
    PRIMARY KEY (article_no)
);