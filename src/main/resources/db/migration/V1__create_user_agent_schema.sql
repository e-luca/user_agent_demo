CREATE SEQUENCE user_agent_seq INCREMENT BY 1;

CREATE TABLE user_agent (
    id          BIGINT          NOT NULL DEFAULT nextval('user_agent_seq') PRIMARY KEY,
    browser     VARCHAR(255)    NOT NULL,
    created     TIMESTAMP       DEFAULT CURRENT_TIMESTAMP
);