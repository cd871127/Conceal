DELETE FROM account_tbl;
DELETE FROM user_tbl;
INSERT INTO user_tbl (user_name, pass_word, e_mail, telephone)
VALUES ('cd871127', 'cdcdcd', 'chendong@163.com', '18575688662');


INSERT INTO account_tbl (owner_id, account_name, account_password, account_desc, account_url, account_type) SELECT
                                                                                                              id,
                                                                                                              'cdistc@163.com',
                                                                                                              'password',
                                                                                                              '有道',
                                                                                                              'www.163.com',
                                                                                                              '0'
                                                                                                            FROM
                                                                                                              user_tbl;
INSERT INTO account_tbl (owner_id, account_name, account_password, account_desc, account_url, account_type) SELECT
                                                                                                              id,
                                                                                                              'cdistc',
                                                                                                              'password2',
                                                                                                              '百度',
                                                                                                              'www.baidu.com',
                                                                                                              '1'
                                                                                                            FROM
                                                                                                              user_tbl;


