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