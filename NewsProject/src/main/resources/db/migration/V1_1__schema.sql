DROP TABLE IF EXISTS `account` ;

CREATE TABLE `account` (
	`id` SMALLINT(5) AUTO_INCREMENT COMMENT 'id',
	`username` VARCHAR(15) COMMENT '帳號' COLLATE 'utf8mb4_unicode_ci',
	`password` VARCHAR(100) COMMENT '密碼' COLLATE 'utf8mb4_unicode_ci',
    `permission` VARCHAR(10) NOT NULL DEFAULT 'USER' COMMENT '權限(ADMIN.USER(預設) )' COLLATE 'utf8mb4_unicode_ci',
	`create_time` TIMESTAMP DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '創建時間',
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `username` (`username`) USING BTREE,
	INDEX `password` (`password`) USING BTREE,
    INDEX `permission` (`permission`) USING BTREE,
	INDEX `create_time` (`create_time`) USING BTREE
)
COMMENT='帳號表單'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;


DROP TABLE IF EXISTS `news` ;


CREATE TABLE `news` (
	`id` MEDIUMINT(6) AUTO_INCREMENT COMMENT 'id',
	`tag` VARCHAR(5) COMMENT '標籤' COLLATE 'utf8mb4_unicode_ci',
	`title` VARCHAR(20) COMMENT '標題' COLLATE 'utf8mb4_unicode_ci',
	`author` VARCHAR(10) COMMENT '作者' COLLATE 'utf8mb4_unicode_ci',
	`content` TEXT COMMENT '文章內容' COLLATE 'utf8mb4_unicode_ci',
	`create_time` TIMESTAMP DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '建檔時間',
	`release_state` MEDIUMINT(1) NOT NULL DEFAULT '0' COMMENT '公布狀態 0=上架(預設) 1=下架 2=刪除' COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `tag` (`tag`) USING BTREE,
	INDEX `title` (`title`) USING BTREE,
	INDEX `author` (`author`) USING BTREE,
	INDEX `create_time` (`create_time`) USING BTREE,
	INDEX `release_state` (`release_state`) USING BTREE
)
COMMENT='新聞表單'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;