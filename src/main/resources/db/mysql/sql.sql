select * from account_tbl where owner_id=(select id from user_tbl where user_name='cd871127') LIMIT 1,1;

