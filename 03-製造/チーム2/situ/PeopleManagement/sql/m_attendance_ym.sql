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

 Date: 27/09/2022 15:26:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_attendance_ym
-- ----------------------------
DROP TABLE IF EXISTS `m_attendance_ym`;
CREATE TABLE `m_attendance_ym` (
  `id` int DEFAULT NULL AUTO_INCREMENT=1 COMMENT '主键',
  `attendance_ym` varchar(7) NOT NULL COMMENT '勤怠年月',
  `display_flg` int DEFAULT NULL COMMENT '表示フラグ',
  `del_flg` int DEFAULT '0' COMMENT '削除フラグ',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `create_user_id` int DEFAULT NULL COMMENT '作成者id',
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  `update_user_id` int DEFAULT NULL COMMENT '更新者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of m_attendance_ym
-- ----------------------------
BEGIN;
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202110', 0, 0, '2022-09-27 10:12:41', 10001, '2022-09-27 10:12:41', NULL, 12);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202111', 0, 0, '2022-09-27 10:12:26', 10001, '2022-09-27 10:12:26', NULL, 11);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202112', 0, 0, '2022-09-27 09:41:46', 10001, '2022-09-27 09:41:46', NULL, 10);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202201', 0, 0, '2022-09-27 09:41:34', 10001, '2022-09-27 09:41:34', NULL, 9);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202202', 0, 0, '2022-09-27 09:41:23', 10001, '2022-09-27 09:41:23', NULL, 8);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202203', 0, 0, '2022-09-27 09:41:13', 10001, '2022-09-27 09:41:13', NULL, 7);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202204', 0, 0, '2022-09-27 09:41:02', 10001, '2022-09-27 09:41:02', NULL, 6);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202205', 0, 0, '2022-09-27 09:40:52', 10001, '2022-09-27 09:40:52', NULL, 5);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202206', 0, 0, '2022-09-27 09:40:42', 10001, '2022-09-27 09:40:42', NULL, 4);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202207', 0, 0, '2022-09-27 09:40:26', 10001, '2022-09-27 09:40:26', NULL, 3);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202208', 0, 0, '2022-09-27 09:40:14', 10001, '2022-09-27 09:40:14', NULL, 2);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202209', 0, 0, '2022-09-27 09:39:56', 10001, '2022-09-27 09:39:56', NULL, 1);
INSERT INTO `m_attendance_ym` (`attendance_ym`, `display_flg`, `del_flg`, `create_date`, `create_user_id`, `update_date`, `update_user_id`, `id`) VALUES ('202209', 0, 0, '2022-09-27 15:16:30', 10002, '2022-09-27 15:16:30', NULL, 13);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
