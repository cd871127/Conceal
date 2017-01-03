CREATE TABLE data_dict_tbl
(
  id          INT UNSIGNED           NOT NULL PRIMARY KEY AUTO_INCREMENT,
  column_name VARCHAR(32)            NOT NULL,
  column_code VARCHAR(2)             NOT NULL,
  column_desc VARCHAR(16)            NOT NULL,
  data_state  VARCHAR(2) DEFAULT '1' NOT NULL
)
  AUTO_INCREMENT = 1;