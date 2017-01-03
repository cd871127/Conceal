CREATE TABLE USER_TBL
(
  id          INT UNSIGNED           NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name   VARCHAR(32)            NOT NULL,
  pass_word   VARCHAR(32)            NOT NULL,
  e_mail      VARCHAR(256)           NOT NULL,
  telephone   VARCHAR(15)            NOT NULL,
  create_date DATETIME,
  update_date DATETIME,
  data_state  VARCHAR(2) DEFAULT '1' NOT NULL
)
  AUTO_INCREMENT = 1;




