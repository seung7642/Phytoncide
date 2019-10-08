-- 회원 테이블
CREATE TABLE user (
    user_id VARCHAR(64) NOT NULL,
    user_pw VARCHAR(128) NOT NULL,
    user_name VARCHAR(128) NOT NULL,
    session_key VARCHAR(64) NOT NULL DEFAULT 'none',
    session_limit TIMESTAMP,
    user_img VARCHAR(128) NOT NULL DEFAULT 'user/default-user.png',
    user_email VARCHAR(64) NOT NULL,
    user_join_date TIMESTAMP NOT NULL DEFAULT NOW(),
    user_login_date TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (user_id)
);

-- 회원 추가
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user00', '1234', 'user00', 'user00@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user01', '1234', 'user10', 'user01@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user02', '1234', 'user20', 'user02@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user03', '1234', 'user30', 'user03@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user04', '1234', 'user40', 'user04@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user05', '1234', 'user50', 'user05@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user06', '1234', 'user60', 'user06@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user07', '1234', 'user70', 'user07@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user08', '1234', 'user80', 'user08@mail.com');
INSERT INTO user (user_id, user_pw, user_name, user_email) VALUES ('user09', '1234', 'user90', 'user09@mail.com');