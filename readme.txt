http://localhost:8080/tedustore-ssm/index.jsp

完成了前台和后台

步骤：
1. 创建库，导入数据
	mysql 8
	mysql数据库名：
    	tedu_store
    docs/
		01-init-create database tedu_store.sql
		02-data-tedu_store-20190111-0838.sql

2. 修改数据库配置中的密码
	配置文件在：db.properties
	
3. 	当前工程使用的是Spring 3.2.8，是针对jdk1.7设计的。
	因此工程的编译版本，必须设置为1.7