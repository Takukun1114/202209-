DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE IF NOT EXISTS `t_employee` (
`employee_id` INT(5) NOT NULL AUTO_INCREMENT=10000 COMMENT '社員ID',
`employee_name` VARCHAR(100) NOT NULL COMMENT '社員名称',
`password` VARCHAR(8) NOT NULL COMMENT 'パスワード',
`dept_id` VARCHAR(10) COMMENT '所属部門ID',
`del_flg` INT(1) DEFAULT '0' COMMENT '削除フラグ',
`create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
`create_user_id` INT(5) COMMENT '作成者id',
`update_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
`update_user_id` INT(5) COMMENT '更新者id',
`employee_email` VARCHAR(50) DEFAULT NULL COMMENT '社員メールアドレス',
PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
SET FOREIGN_KEY_CHECKS = 1;


DROP TABLE IF EXISTS `t_attendance`;
CREATE TABLE IF NOT EXISTS `t_attendance` (
  `record_id` varchar(15) NOT NULL COMMENT '記録番号',
  `attendance_date` varchar(10) DEFAULT NULL COMMENT '日付',
  `start_time` varchar(5) DEFAULT NULL COMMENT '出勤時間',
  `end_time` varchar(5) DEFAULT NULL COMMENT '退勤時間',
  `rest_hours` decimal(3,1) DEFAULT NULL COMMENT '休憩時間',
  `working_hours` decimal(3,1) DEFAULT NULL COMMENT '作業時間',
  `overtime_hours` decimal(3,1) DEFAULT NULL COMMENT '残業時間',
  `absence_hours` decimal(3,1) DEFAULT NULL COMMENT '欠勤時間',
  `working_status_id` int DEFAULT NULL COMMENT '状態ID',
  `working_details` varchar(200) DEFAULT NULL COMMENT '作業内容',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` int DEFAULT NULL COMMENT '作成者id',
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user_id` int DEFAULT NULL COMMENT '更新者id',
  `flow_status_id` int DEFAULT NULL COMMENT 'フロー状態ID',
  `rec_del_flg` int DEFAULT NULL COMMENT '削除フラグ',
  `version` int DEFAULT '1' COMMENT '乐观锁',
  PRIMARY KEY (`record_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `m_dept`;
CREATE TABLE IF NOT EXISTS `m_dept` (
`dept_id` VARCHAR(10) NOT NULL COMMENT '部門ID',
`dept_name` VARCHAR(100) COMMENT '部門名称',
`del_flg` INT(1) DEFAULT '0' COMMENT '削除フラグ',
`create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
`create_user_id` INT COMMENT '作成者id',
`update_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
`update_user_id` INT COMMENT '更新者id',
PRIMARY KEY (`dept_id`)
);

DROP TABLE IF EXISTS `m_calendar`;
CREATE TABLE IF NOT EXISTS `m_calendar` (
`calendar_date` VARCHAR(10) NOT NULL COMMENT '年月日',
`weekday` VARCHAR(2) COMMENT '曜日',
`holiday_flg` INT(1) DEFAULT '0' COMMENT '休日フラグ',
`del_flg` INT(1) DEFAULT '0' COMMENT '削除フラグ',
`create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
`create_user_id` INT COMMENT '作成者id',
`update_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
`update_user_id` INT COMMENT '更新者id',
PRIMARY KEY (`calendar_date`)
);

DROP TABLE IF EXISTS `m_status`;
CREATE TABLE IF NOT EXISTS `m_status` (
`flow_status_id` INT(1) DEFAULT '0' NOT NULL COMMENT 'フロー状態ID',
`flow_status_name` VARCHAR(100) COMMENT '状態名称',
`del_flg` INT(1) DEFAULT '0' COMMENT '削除フラグ',
`create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
`create_user_id` INT COMMENT '作成者id',
`update_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
`update_user_id` INT COMMENT '更新者id',
PRIMARY KEY (`flow_status_id`)
);

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

