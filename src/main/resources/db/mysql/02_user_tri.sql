DELIMITER /
CREATE TRIGGER bi_tri_user_tbl
BEFORE INSERT
  ON USER_TBL
FOR EACH ROW
  BEGIN
    SET new.create_date = sysdate(), new.update_date = sysdate();
  END /

CREATE TRIGGER bu_tri_user_tbl
BEFORE UPDATE
  ON USER_TBL
FOR EACH ROW
  BEGIN
    SET new.update_date = sysdate();
  END /
DELIMITER ;