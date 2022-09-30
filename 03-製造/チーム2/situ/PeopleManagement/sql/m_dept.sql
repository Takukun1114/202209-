/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 27/09/2022 00:58:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_dept
-- ----------------------------
DROP TABLE IF EXISTS `m_dept`;
CREATE TABLE IF NOT EXISTS `m_dept` (
`dept_id` VARCHAR(10) NOT NULL COMMENT '部門ID',
`dept_name` VARCHAR(100) COMMENT '部門名称',
`del_flg` TINYINT(1) DEFAULT '0' COMMENT '削除フラグ',
`create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
`create_user_id` INT COMMENT '作成者id',
`update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
`update_user_id` INT COMMENT '更新者id',
PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_dept
-- ----------------------------
BEGIN;
INSERT INTO `m_dept` (`dept_id`, `dept_name`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`) VALUES ('1', '総務部', 0, '2022-09-22 02:14:03', 10001, '2022-09-22 02:14:03', 10001);
INSERT INTO `m_dept` (`dept_id`, `dept_name`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`) VALUES ('2', '開発部', 0, '2022-09-22 02:22:15', 10001, '2022-09-22 02:22:15', 10001);
INSERT INTO `m_dept` (`dept_id`, `dept_name`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`) VALUES ('3', '設計部', 0, '2022-09-22 02:23:52', 10001, '2022-09-22 02:23:52', 10001);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
