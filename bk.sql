USE test1;
/**
*文章表
*/
CREATE TABLE article(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,#文章id
	title VARCHAR(255) NOT NULL,#文章标题
	view_count INT(11) DEFAULT 0,#浏览量
	classify_id INT(11),#分类编号
	context_synopsis VARCHAR(255),#文章内容提取
	context TEXT,#文章内容
	create_time DATETIME,#创建时间
	update_time DATETIME#修改时间
);
DROP TABLE article;
INSERT INTO article VALUES(NULL,"第一篇",0,1,"111111111","<h1>111111</h1>",NOW(),NOW());
INSERT INTO article VALUES(NULL,"第二篇",0,1,"111111111","<h1>111111</h1>",NOW(),NOW());
INSERT INTO article VALUES(NULL,"第三篇",0,1,"111111111","<h1>111111</h1>",NOW(),NOW());
INSERT INTO article VALUES(NULL,"第四篇",0,1,"111111111","<h1>111111</h1>",NOW(),NOW());
INSERT INTO article VALUES(NULL,"第五篇",0,1,"111111111","<h1>111111</h1>",NOW(),NOW());
SELECT * FROM article;

/**
*分类表
*/
CREATE TABLE classify(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,#分类id
	class_name VARCHAR(255)#分类名称
);
INSERT INTO classify VALUES(NULL,"技术分享");
INSERT INTO classify VALUES(NULL,"随心笔记");
SELECT * FROM classify;

/**
*文章标签关系表
*/
CREATE TABLE article_label(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,#编号
	article_id INT(11),#文章id
	label_id INT(11)#标签id
);
INSERT INTO article_label VALUES(NULL,1,1);
INSERT INTO article_label VALUES(NULL,1,2);
INSERT INTO article_label VALUES(NULL,1,3);
INSERT INTO article_label VALUES(NULL,2,2);
INSERT INTO article_label VALUES(NULL,2,3);
INSERT INTO article_label VALUES(NULL,3,1);
SELECT * FROM article_label;


/**
*标签表
*/
CREATE TABLE label(
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,#标签id
	label_name VARCHAR(255)#标签名称
);
INSERT INTO label VALUES(NULL,"java");
INSERT INTO label VALUES(NULL,"spring");
INSERT INTO label VALUES(NULL,"环境");
SELECT * FROM label;



SELECT a.id aid,a.title,a.view_count,a.classify_id,a.context_synopsis,DATE_FORMAT(a.create_time,'%Y-%m') acreatetime,a.update_time,l.id lid,l.label_name,c.id cid,c.class_name FROM article a
	LEFT JOIN classify c ON a.classify_id=c.id
		LEFT JOIN article_label al ON a.id = al.article_id
			LEFT JOIN label l ON l.id = al.label_id
				GROUP BY acreatetime;
					ORDER BY acreatetime DESC;
				
SELECT DATE_FORMAT(create_time,'%Y-%m') createTime,COUNT(create_time) FROM article GROUP BY createTime ORDER BY createTime DESC LIMIT 0,12;


SELECT a.id aid,a.title,l.id,l.label_name FROM
	(SELECT id,title FROM article LIMIT 0,5) a
		LEFT JOIN article_label al ON a.id = al.article_id
			LEFT JOIN label l ON l.id = al.label_id
				GROUP BY a.id;


SELECT a.id,a.title,l.id,l.label_name FROM article_label al
	LEFT JOIN article a ON a.id = al.article_id
	LEFT JOIN label l ON l.id = al.label_id 
	GROUP BY a.id;


SELECT a.id articleId,a.title,a.view_count,a.classify_id,a.context_synopsis,a.create_time acreatetime,a.update_time,l.id labelId,l.label_name,c.id classifyId,c.class_name FROM article a LEFT JOIN classify c ON a.classify_id=c.id LEFT JOIN article_label al ON a.id = al.article_id LEFT JOIN label l ON l.id = al.label_id WHERE DATE_FORMAT(a.update_time,'%Y%m')='202101' ORDER BY acreatetime DESC;



UPDATE article SET
	title,
	view_count,
	classify_id,
	context_synopsis,
	context,
	update_time
	WHERE id = 1
	
	DELETE FROM article WHEN id = 1



SELECT COUNT(a.id) a
        FROM article a
            LEFT JOIN classify c ON a.classify_id=c.id
                LEFT JOIN article_label al ON a.id = al.article_id
                    LEFT JOIN label l ON l.id = al.label_id


SELECT id classId,class_name FROM classify WHERE id = 1


SELECT l.* FROM,COUNT(al.article_id) articleTotal FROM label l
            LEFT JOIN article_label al ON l.id = al.label_id
                GROUP BY l.id;
								
								
SELECT c.id,c.class_name,a.id,a.title,DATE_FORMAT(a.update_time,'%Y/%m/%d') FROM classify c LEFT JOIN (SELECT id,title,update_time,classify_id FROM article ORDER BY update_time DESC LIMIT 1,2) a ON c.id = a.classify_id;



