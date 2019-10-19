/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : coursedb

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-08-03 18:33:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_no` char(10) NOT NULL,
  `password` char(20) NOT NULL DEFAULT '123456',
  `admin_name` char(10) NOT NULL,
  `admin_contact` char(11) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`admin_no`),
  UNIQUE KEY `admin_contact` (`admin_contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('201500', '123456', 'admin', '18774529662', '2018-07-27 15:30:23');

-- ----------------------------
-- Table structure for choose
-- ----------------------------
DROP TABLE IF EXISTS `choose`;
CREATE TABLE `choose` (
  `choose_no` int(11) NOT NULL AUTO_INCREMENT,
  `student_no` char(11) NOT NULL,
  `course_no` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  `choose_time` datetime DEFAULT NULL,
  PRIMARY KEY (`choose_no`),
  KEY `choose_student` (`student_no`),
  KEY `choose_course` (`course_no`),
  CONSTRAINT `choose_course` FOREIGN KEY (`course_no`) REFERENCES `course` (`course_no`),
  CONSTRAINT `choose_student` FOREIGN KEY (`student_no`) REFERENCES `student` (`student_no`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choose
-- ----------------------------
INSERT INTO `choose` VALUES ('9', '2015001', '7', '99', '2018-07-22 00:00:00');
INSERT INTO `choose` VALUES ('10', '2016001', '1', '100', '2018-08-07 20:23:40');
INSERT INTO `choose` VALUES ('11', '2016001', '3', '67', '2018-08-22 20:23:55');
INSERT INTO `choose` VALUES ('12', '2016001', '5', '76', '2018-08-13 20:24:18');
INSERT INTO `choose` VALUES ('13', '2016002', '7', '88', '2018-08-01 13:36:27');
INSERT INTO `choose` VALUES ('14', '2016004', '1', '12', '2018-08-03 13:36:46');
INSERT INTO `choose` VALUES ('15', '2016005', '4', null, '2018-08-03 13:37:01');
INSERT INTO `choose` VALUES ('16', '2016006', '1', '69', '2018-08-03 13:37:25');
INSERT INTO `choose` VALUES ('17', '2016007', '1', null, '2018-08-03 13:37:38');
INSERT INTO `choose` VALUES ('18', '2015001', '3', null, '2018-08-03 13:37:51');
INSERT INTO `choose` VALUES ('19', '2015001', '4', null, '2018-08-09 13:38:08');
INSERT INTO `choose` VALUES ('20', '2015001', '6', null, '2018-08-03 13:38:21');
INSERT INTO `choose` VALUES ('21', '2019003', '7', '100', '2018-08-03 13:39:26');
INSERT INTO `choose` VALUES ('22', '2019002', '7', '59', '2018-08-03 13:39:41');
INSERT INTO `choose` VALUES ('23', '2016005', '7', null, '2018-08-03 13:39:54');
INSERT INTO `choose` VALUES ('24', '2016026', '3', null, '2018-08-03 16:01:58');
INSERT INTO `choose` VALUES ('25', '2016007', '3', null, '2018-08-03 16:02:15');
INSERT INTO `choose` VALUES ('26', '2016008', '5', null, '2018-08-03 16:04:47');
INSERT INTO `choose` VALUES ('27', '2015001', '5', null, '2018-08-03 16:05:02');
INSERT INTO `choose` VALUES ('28', '2016002', '5', null, '2018-08-03 16:05:13');
INSERT INTO `choose` VALUES ('29', '2016019', '5', null, '2018-08-03 16:05:35');
INSERT INTO `choose` VALUES ('30', '2016026', '5', null, '2018-08-22 16:05:55');
INSERT INTO `choose` VALUES ('31', '2016001', '4', null, '2018-08-03 00:00:00');
INSERT INTO `choose` VALUES ('32', '2016001', '6', null, '2018-08-03 00:00:00');
INSERT INTO `choose` VALUES ('33', '2015001', '1', null, '2018-08-03 00:00:00');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `class_no` int(10) NOT NULL AUTO_INCREMENT,
  `class_name` char(20) NOT NULL,
  `depart_name` char(20) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`class_no`),
  UNIQUE KEY `class_name` (`class_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '2012自动化1班', '机电工程系', '2018-07-20 10:36:37');
INSERT INTO `classes` VALUES ('2', '2012自动化2班', '机电工程系', '2018-07-20 10:36:37');
INSERT INTO `classes` VALUES ('3', '2012软件工程1班', '软件工程系', '2018-07-20 10:36:38');
INSERT INTO `classes` VALUES ('4', '2012软件工程2班', '软件工程系', '2018-07-20 10:36:38');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_no` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` char(20) NOT NULL,
  `up_limit` int(11) DEFAULT '60',
  `course_status` char(6) DEFAULT '未审核',
  `teacher_no` char(10) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`course_no`),
  KEY `course_teacher` (`teacher_no`),
  CONSTRAINT `course_teacher` FOREIGN KEY (`teacher_no`) REFERENCES `teacher` (`teacher_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'java课程设计', '60', '已审核', '001', '2018-07-20 10:44:18');
INSERT INTO `course` VALUES ('3', 'JavaWeb', '120', '已审核', '003', '2018-07-20 10:49:32');
INSERT INTO `course` VALUES ('4', 'c语言', '60', '已审核', '004', '2018-07-20 10:49:32');
INSERT INTO `course` VALUES ('5', 'c++', '60', '已审核', '001', '2018-07-21 00:00:00');
INSERT INTO `course` VALUES ('6', 'python', '80', '未审核', '003', '2018-07-21 00:00:00');
INSERT INTO `course` VALUES ('7', 'android', '100', '已审核', '001', '2018-07-22 00:00:00');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_no` char(11) NOT NULL,
  `student_name` char(20) NOT NULL,
  `student_contact` char(20) NOT NULL,
  `class_no` int(11) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `password` char(20) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`student_no`),
  KEY `student_classes` (`class_no`),
  CONSTRAINT `student_classes` FOREIGN KEY (`class_no`) REFERENCES `classes` (`class_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2015001', '华晨宇', '18774529663', '3', '2018-07-22 00:00:00', '111111');
INSERT INTO `student` VALUES ('2016001', '张三', '15912344950', '2', '2018-07-29 20:17:58', '123456');
INSERT INTO `student` VALUES ('2016002', '李四', '15912344952', '1', '2018-07-29 20:20:24', '123456');
INSERT INTO `student` VALUES ('2016004', '马六', '15912344954', '2', '2018-07-29 20:20:24', '123456');
INSERT INTO `student` VALUES ('2016005', '田七', '15912344955', '3', '2018-07-29 20:20:24', '123456');
INSERT INTO `student` VALUES ('2016006', '王八', '15912344956', '4', '2018-07-29 20:20:25', '123456');
INSERT INTO `student` VALUES ('2016007', '九毛', '15912344957', '4', '2018-07-29 20:20:25', '123456');
INSERT INTO `student` VALUES ('2016008', '王二', '15912344952', '1', '2018-07-29 20:20:25', '123456');
INSERT INTO `student` VALUES ('2016009', '谢玉方', '15912344953', '2', '2018-07-29 20:20:25', '123456');
INSERT INTO `student` VALUES ('2016010', '王杰', '15912344954', '2', '2018-07-29 20:20:25', '123456');
INSERT INTO `student` VALUES ('2016011', '赵云', '15912344955', '3', '2018-07-29 20:20:25', '123456');
INSERT INTO `student` VALUES ('2016012', '马汉', '15912344956', '4', '2018-07-29 20:20:25', '123456');
INSERT INTO `student` VALUES ('2016014', '许婉如', '15912344957', '4', '2018-07-29 20:20:25', '123456');
INSERT INTO `student` VALUES ('2016015', '蔡徐坤', '15912341111', '4', '2018-08-02 11:13:13', '123456');
INSERT INTO `student` VALUES ('2016016', '陈立农', '15912342222', '1', '2018-08-02 11:13:13', '123456');
INSERT INTO `student` VALUES ('2016017', '范丞丞', '15912343333', '2', '2018-08-02 11:13:13', '123456');
INSERT INTO `student` VALUES ('2016018', '黄明昊', '15912340010', '2', '2018-08-02 11:13:13', '123456');
INSERT INTO `student` VALUES ('2016019', '林彦俊', '15912340011', '3', '2018-08-02 11:13:14', '123456');
INSERT INTO `student` VALUES ('2016020', '朱正廷', '15912340012', '4', '2018-08-02 11:13:14', '123456');
INSERT INTO `student` VALUES ('2016021', '王子怡', '15912340013', '4', '2018-08-02 11:13:14', '123456');
INSERT INTO `student` VALUES ('2016022', '王琳凯', '15912340014', '1', '2018-08-02 11:13:14', '123456');
INSERT INTO `student` VALUES ('2016023', '尤长靖', '15912340015', '2', '2018-08-02 11:13:14', '123456');
INSERT INTO `student` VALUES ('2016024', '吴宣仪', '15912340016', '2', '2018-08-02 11:13:14', '123456');
INSERT INTO `student` VALUES ('2016025', '段奥娟', '15912344001', '3', '2018-08-02 11:13:14', '123456');
INSERT INTO `student` VALUES ('2016026', '杨超越', '15912344002', '4', '2018-08-02 11:13:14', '123456');
INSERT INTO `student` VALUES ('201603', '王五', '15912344953', '2', '2018-07-29 20:20:24', '123456');
INSERT INTO `student` VALUES ('2019001', '郑爽', '19982901234', '1', '2018-08-03 00:00:00', '123456');
INSERT INTO `student` VALUES ('2019002', '赵鸽', '1234567', '3', '2018-08-03 00:00:00', '123456');
INSERT INTO `student` VALUES ('2019003', '王旭', '188888888', '4', '2018-08-03 00:00:00', '123456');
INSERT INTO `student` VALUES ('2019007', '张宇', '18774523456', '1', '2018-08-03 00:00:00', '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_no` char(10) NOT NULL,
  `teacher_name` char(10) NOT NULL,
  `teacher_contact` char(11) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `password` char(20) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`teacher_no`),
  UNIQUE KEY `teacher_contact` (`teacher_contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('001', '张灵', '18774529665', '2018-07-20 10:29:16', '123456');
INSERT INTO `teacher` VALUES ('003', '李鹏', '13913413452', '2018-07-20 10:31:42', '123456');
INSERT INTO `teacher` VALUES ('004', '王晓璐', '13913413453', '2018-07-20 10:32:00', '123456');
INSERT INTO `teacher` VALUES ('005', '林丹', '18951118765', '2018-08-02 11:05:59', '123456');
INSERT INTO `teacher` VALUES ('006', '谢逊', '13913413450', '2018-08-02 11:05:59', '123456');
INSERT INTO `teacher` VALUES ('007', '王清', '13913413459', '2018-08-02 11:06:40', '123456');
