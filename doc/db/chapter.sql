SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_id` char(8) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '课程Id',
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
