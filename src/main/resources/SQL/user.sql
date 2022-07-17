insert into user(name, account, tel, password) VALUES ('管理员','18290780118','18290780118','1bbd886460827015e5d605ed44252251');

insert into user(name, account, tel, password) VALUES ('a','15099291135','18290780118','1bbd886460827015e5d605ed44252251');
insert into user(name, account, tel, password) VALUES ('b','13579121212','18290780118','1bbd886460827015e5d605ed44252251');
insert into user(name, account, tel, password) VALUES ('c','18299997777','18290780118','1bbd886460827015e5d605ed44252251');

select * from user limit 1,2;
# (pageNum-1)*pageSize,pageSize
# limit a,b a起始位置，从0开始  b查询几条