-- 회원 테이블
CREATE TABLE user (
    user_name VARCHAR(128) NOT NULL,
    user_email VARCHAR(64) NOT NULL,
    user_pw VARCHAR(128) NOT NULL,
    session_key VARCHAR(64) NOT NULL DEFAULT 'none',
    session_limit TIMESTAMP,
    user_img VARCHAR(128) NOT NULL DEFAULT 'user/default-user.png',
    user_join_date TIMESTAMP NOT NULL DEFAULT NOW(),
    user_login_date TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (user_id)
);

-- 회원 추가
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user00', 'user00@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user10', 'user01@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user20', 'user02@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user30', 'user03@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user40', 'user04@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user50', 'user05@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user60', 'user06@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user70', 'user07@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user80', 'user08@mail.com', '1234');
INSERT INTO user (user_pw, user_name, user_email) VALUES ('user90', 'user09@mail.com', '1234');