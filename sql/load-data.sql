DROP TABLE IF EXISTS names;

CREATE TABLE names(
	id int unsigned AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	age int unsigned NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO names (id, name,age) VALUES (1, "鈴木",26);
INSERT INTO names (id, name,age) VALUES (2, "山田",34);
INSERT INTO names (id, name,age) VALUES (3, "田中",40);
INSERT INTO names (id, name,age) VALUES (4, "佐藤",28);
INSERT INTO names (id, name,age) VALUES (5, "高橋",28);
INSERT INTO names (id, name,age) VALUES (6, "後藤",28);
