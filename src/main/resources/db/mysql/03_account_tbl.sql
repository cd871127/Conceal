CREATE TABLE ACCOUNT_TBL
(
  id               INT UNSIGNED           NOT NULL PRIMARY KEY AUTO_INCREMENT,
  owner_id         INT UNSIGNED           NOT NULL REFERENCES user_tbl (id),
  account_name     VARCHAR(32)            NOT NULL,
  account_password VARCHAR(32)            NOT NULL,
  account_desc     VARCHAR(256)           NOT NULL,
  account_url      VARCHAR(256)           NOT NULL,
  account_type     VARCHAR(1)             NOT NULL,
  create_date      DATETIME,
  update_date      DATETIME,
  data_state       VARCHAR(2) DEFAULT '1' NOT NULL
)
  AUTO_INCREMENT = 1;