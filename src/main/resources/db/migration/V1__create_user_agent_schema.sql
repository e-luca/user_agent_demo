CREATE TABLE user_agent (
    id          BIGINT          PRIMARY KEY AUTO_INCREMENT,
    browser     VARCHAR(255)    NOT NULL,
    created     TIMESTAMP       DEFAULT CURRENT_TIMESTAMP
);