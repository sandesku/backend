--Export Mysql Dump
mysqldump -u root -p'root' demo > demo_mysql_dump.sql

--Import Mysql Dump
mysql -u root -p'root'
drop database demo;
create database demo;
exit
mysql -u root -p'root' demo < demo_mysql_dump.sql