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

 Date: 30/09/2022 13:44:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_attendance_ym
-- ----------------------------
DROP TABLE IF EXISTS `m_attendance_ym`;
CREATE TABLE `m_attendance_ym` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attendance_ym` VARCHAR(7) NOT NULL COMMENT '勤怠年月',
  `display_flg` TINYINT DEFAULT '0' COMMENT '表示フラグ',
  `del_flg` TINYINT DEFAULT '0' COMMENT '削除フラグ',
  `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `create_user_id` INT DEFAULT NULL COMMENT '作成者id',
  `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `update_user_id` INT DEFAULT NULL COMMENT '更新者id',
	`version` SMALLINT DEFAULT '1' COMMENT '楽観鎖',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_attendance_ym
-- ----------------------------
BEGIN;
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (1, '202209', 0, 0, '2022-09-27 09:39:56', 10001, '2022-09-27 09:39:56', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (2, '202208', 0, 0, '2022-09-27 09:40:14', 10001, '2022-09-27 09:40:14', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (3, '202207', 0, 0, '2022-09-27 09:40:26', 10001, '2022-09-27 09:40:26', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (4, '202206', 0, 0, '2022-09-27 09:40:42', 10001, '2022-09-27 09:40:42', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (5, '202205', 0, 0, '2022-09-27 09:40:52', 10001, '2022-09-27 09:40:52', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (6, '202204', 0, 0, '2022-09-27 09:41:02', 10001, '2022-09-27 09:41:02', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (7, '202203', 0, 0, '2022-09-27 09:41:13', 10001, '2022-09-27 09:41:13', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (8, '202202', 0, 0, '2022-09-27 09:41:23', 10001, '2022-09-27 09:41:23', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (9, '202201', 0, 0, '2022-09-27 09:41:34', 10001, '2022-09-27 09:41:34', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (10, '202112', 0, 0, '2022-09-27 09:41:46', 10001, '2022-09-27 09:41:46', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (11, '202111', 0, 0, '2022-09-27 10:12:26', 10001, '2022-09-27 10:12:26', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (12, '202110', 0, 0, '2022-09-27 10:12:41', 10001, '2022-09-27 10:12:41', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (13, '202209', 0, 0, '2022-09-27 15:16:30', 10002, '2022-09-27 15:16:30', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (14, '202109', 0, 0, '2022-09-30 02:36:53', 10001, '2022-09-30 02:36:53', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (15, '202108', 0, 0, '2022-09-30 02:37:18', 10001, '2022-09-30 02:37:18', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (16, '202107', 0, 0, '2022-09-30 02:37:34', 10001, '2022-09-30 02:37:34', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (17, '202106', 0, 0, '2022-09-30 02:37:44', 10001, '2022-09-30 02:37:44', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (18, '202105', 0, 0, '2022-09-30 11:55:10', 10001, '2022-09-30 11:55:10', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (19, '202104', 0, 0, '2022-09-30 11:55:30', 10001, '2022-09-30 11:55:30', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (20, '202103', 0, 0, '2022-09-30 11:55:40', 10001, '2022-09-30 11:55:40', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (21, '202102', 0, 0, '2022-09-30 11:55:48', 10001, '2022-09-30 11:55:48', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (22, '202101', 0, 0, '2022-09-30 11:55:59', 10001, '2022-09-30 12:05:28', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (23, '202012', 0, 0, '2022-09-30 11:56:10', 10001, '2022-09-30 11:56:10', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (24, '202011', 0, 0, '2022-09-30 13:30:00', 10001, '2022-09-30 13:30:00', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (25, '202010', 0, 0, '2022-09-30 13:30:08', 10001, '2022-09-30 13:30:08', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (26, '202009', 0, 0, '2022-09-30 13:30:28', 10001, '2022-09-30 13:30:28', NULL, 1);
INSERT INTO `m_attendance_ym` (`id`, `attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `version`) VALUES (27, '202008', 0, 0, '2022-09-30 13:30:46', 10001, '2022-09-30 13:30:46', NULL, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
