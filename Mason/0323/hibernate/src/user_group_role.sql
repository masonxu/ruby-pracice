CREATE TABLE `userinfo` ( 
  `user_id` int(11) NOT NULL auto_increment, 
  `username` varchar(50) default NULL, 
  PRIMARY KEY  (`user_id`) 
) ENGINE=InnoDB DEFAULT CHARSET=gbk; 

CREATE TABLE `groupinfo` (
	`group_id` int(11) NOT NULL auto_increment,
	`group_type` varchar(50) default NULL,
	PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

CREATE TABLE `role` (
	`role_id` int(11) NOT NULL auto_increment,
	`role_type` varchar(50) default NULL,
	PRIMARY KEY (`role_id`) 
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

CREATE TABLE `join_user_authority`(
	`user_id` int(11) NOT NULL,
	`group_id` int(11) NOT NULL,
	PRIMARY KEY (`user_id`,`group_id`),
	FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`user_id`),
	FOREIGN KEY (`group_id`) REFERENCES `groupinfo` (`group_id`)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

CREATE TABLE `join_group_role` (
	`group_id` int(11) NOT NULL,
	`role_id` int(11) NOT NULL,
	PRIMARY KEY (`group_id`,`role_id`),
	FOREIGN KEY (`group_id`) REFERENCES `groupinfo` (`group_id`),
	FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

/**
 *  The following is to initialize the tables
 */
INSERT INTO userinfo (username) VALUE ("xiaoer");
INSERT INTO userinfo (username) VALUE ("zhangsan");
INSERT INTO userinfo (username) VALUE ("lisi");
INSERT INTO userinfo (username) VALUE ("wangwu");
INSERT INTO userinfo (username) VALUE ("houli");
INSERT INTO userinfo (username) VALUE ("qianqi");
INSERT INTO userinfo (username) VALUE ("zhouba");
INSERT INTO userinfo (username) VALUE ("laojiu");
INSERT INTO userinfo (username) VALUE ("longshi");

INSERT INTO groupinfo (group_type) VALUE ("admin");
INSERT INTO groupinfo (group_type) VALUE ("vice");
INSERT INTO groupinfo (group_type) VALUE ("member");
INSERT INTO groupinfo (group_type) VALUE ("trainee");
INSERT INTO groupinfo (group_type) VALUE ("baby");

INSERT INTO role (role_type) VALUE ("first door");
INSERT INTO role (role_type) VALUE ("second door");
INSERT INTO role (role_type) VALUE ("third door");
INSERT INTO role (role_type) VALUE ("fourth door");
INSERT INTO role (role_type) VALUE ("fifth door");
INSERT INTO role (role_type) VALUE ("sixth door");

INSERT INTO join_user_authority VALUES (1,1);
INSERT INTO join_user_authority VALUES (2,2);
INSERT INTO join_user_authority VALUES (3,2);
INSERT INTO join_user_authority VALUES (4,3);
INSERT INTO join_user_authority VALUES (5,3);
INSERT INTO join_user_authority VALUES (6,4);
INSERT INTO join_user_authority VALUES (7,4);
INSERT INTO join_user_authority VALUES (8,4);
INSERT INTO join_user_authority VALUES (9,5);

INSERT INTO join_group_role VALUES (1,1);
INSERT INTO join_group_role VALUES (1,2);
INSERT INTO join_group_role VALUES (1,3);
INSERT INTO join_group_role VALUES (1,4);
INSERT INTO join_group_role VALUES (1,5);
INSERT INTO join_group_role VALUES (2,1);
INSERT INTO join_group_role VALUES (2,2);
INSERT INTO join_group_role VALUES (2,3);
INSERT INTO join_group_role VALUES (2,4);
INSERT INTO join_group_role VALUES (3,1);
INSERT INTO join_group_role VALUES (3,2);
INSERT INTO join_group_role VALUES (3,3);
INSERT INTO join_group_role VALUES (4,1);
INSERT INTO join_group_role VALUES (4,2);

