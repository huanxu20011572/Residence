/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : orcl

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2015-12-07 18:38:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL default '0',
  `title` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `owner` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '论文学', '文学是美的体现', '张三');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL default '0',
  `content` varchar(255) default NULL,
  `bid` int(11) default NULL,
  `contentD` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '文学应该是历史文化的积累', '1', '2015-11-21');
INSERT INTO `comment` VALUES ('2', '文学是种艺术', '1', '2015-11-12');

-- ----------------------------
-- Table structure for `tb_house`
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `hId` varchar(200) character set utf8 collate utf8_bin NOT NULL default '',
  `hAddr` varchar(200) default NULL,
  `hName` varchar(200) default NULL,
  `hBuildingNum` varchar(200) default NULL,
  `hUnitNum` varchar(300) default NULL,
  `hRoomNum` varchar(200) default NULL,
  `realAddress` varchar(200) default NULL,
  `hFloorNum` varchar(200) default NULL,
  `hStructure` varchar(200) default NULL,
  `hPropertyRight` varchar(200) default NULL,
  `hSecurityStatus` varchar(200) default NULL,
  `rentalTime` varchar(300) default NULL,
  `rentalArea` varchar(100) default NULL,
  `rentalRoomNum` varchar(100) default NULL,
  `rentalRoomDate` varchar(200) default NULL,
  `rentType` varchar(200) default NULL,
  `policeOperateArea` varchar(200) default NULL,
  `operateRow` varchar(200) default NULL,
  `chargePoliceNum` varchar(200) default NULL,
  `landlordId` varchar(200) NOT NULL,
  `imageUrls` varchar(300) default NULL,
  `layoutDiagramUrl` varchar(300) default NULL,
  `version` int(20) default NULL,
  PRIMARY KEY  (`hId`),
  KEY `house_residentpopulation` (`landlordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('3acdd5f4d3af4b92b339c1a91d338939', 'hhhh', 'h', 'hhh', 'hhh', 'hhhh', 'hhhh', 'bbbb', 'hhhh', 'bhh', 'bbb', '2015-12-06', 'bbbbh', 'hhhh', '2015-12-06', 'hhhh', 'P1021', 'hhhhhh', '程喆', 'f5f766324a914be6a07178fcc4e40830', '2165d1eb571a4090834deffa02d43a09;null', '9494bb31130a4e00b279a8cc966bd7f6', '4');

-- ----------------------------
-- Table structure for `tb_manageuser`
-- ----------------------------
DROP TABLE IF EXISTS `tb_manageuser`;
CREATE TABLE `tb_manageuser` (
  `id` char(32) NOT NULL,
  `uName` char(20) default NULL,
  `password` char(20) default NULL,
  `certificateType` char(10) default NULL,
  `certificateNum` char(50) default NULL,
  `telephone` char(20) default NULL,
  `email` char(20) default NULL,
  `qqNum` char(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_manageuser
-- ----------------------------
INSERT INTO `tb_manageuser` VALUES ('011217d03f1b426f97840d26efe56454', '张三', '123', '身份证', '123123123', '15678353126', '345123', '345123');
INSERT INTO `tb_manageuser` VALUES ('d6de866767cf447497e1fa06edc5d0a6', '123', '123', '身份证', '123321123', '13272574859', '123673', '123673');

-- ----------------------------
-- Table structure for `tb_mediafile`
-- ----------------------------
DROP TABLE IF EXISTS `tb_mediafile`;
CREATE TABLE `tb_mediafile` (
  `id` varchar(255) NOT NULL default '',
  `modeId` varchar(255) default NULL,
  `source` varchar(255) default NULL,
  `fileName` varchar(255) default NULL,
  `physicalName` varchar(255) default NULL,
  `relativePathServer` varchar(255) default NULL,
  `relativePathApp` varchar(255) default NULL,
  `length` bigint(20) default NULL,
  `remark` varchar(255) default NULL,
  `version` int(11) default NULL,
  `type` int(11) default NULL,
  `valid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_mediafile
-- ----------------------------
INSERT INTO `tb_mediafile` VALUES ('2165d1eb571a4090834deffa02d43a09', '3acdd5f4d3af4b92b339c1a91d338939', '201', '1449410627872.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/c77f72d85e6b45d693d6ba345750c5d6person-1.jpg', '/storage/emulated/0/DCIM/Camera/person-1.jpg', '7537', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('3ee5bf9671814ff295b81587ed6fedb5', '5ec3a514a96f408eb65dbedfec030c44', '104', '1449410447577.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/b6a39f9062ea4c859ff7ea6cb9a783ffIMG_20151120_170301_2.jpg', '/storage/emulated/0/DCIM/Camera/QuickCapture/IMG', '1129721', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('5ea65e45368048b5be3e34e60f46b66c', 'e260c8fb26984a6caf7c88513edd396c', '101', '1449410447590.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/1860db2f22ab4b779e5ec180e66027e5IMG_20151120_170301_1.jpg', '/storage/emulated/0/DCIM/Camera/QuickCapture/IMG', '2038042', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('62a1b56f35e84f568344118cfcf82931', '43673e5b4b494c02af995fac160f0752', '102', '1449410447554.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/471b84e693aa43d1aedbbf5b279c2bd2person-1.jpg', '/storage/emulated/0/DCIM/Camera/person-1.jpg', '7537', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('9494bb31130a4e00b279a8cc966bd7f6', '3acdd5f4d3af4b92b339c1a91d338939', '200', '1449410627850.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/56fd7e5588a8442dbf6f5587e11e3511gh.jpg', '/storage/emulated/0/Draw//output/gh.jpg', '39589', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('d55e080b59244bf09f03337ebcb3604d', 'f5f766324a914be6a07178fcc4e40830', '202', '1449410627861.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/cfe8f4457e8d40b387d391329b52a71fperson-1.jpg', '/storage/emulated/0/DCIM/Camera/person-1.jpg', '7537', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('e35c88048ee54d038d20c9cf07ef9b77', '1f44e91e918d4aa0ae3a61bbcb739824', '103', '1449410447538.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/f1a358c1c92a4499becac6625a777c5aperson-1.jpg', '/storage/emulated/0/DCIM/Camera/person-1.jpg', '7537', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('ecdd939a7cd6459393345de18c5fd358', 'd0666a85c3f047198a7d9d62b028666e', '203', '1449410627838.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/bc936638898b4e259e141759682ab07dperson-1.jpg', '/storage/emulated/0/DCIM/Camera/person-1.jpg', '7537', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('ecf3ca07c3ff4d4d82fcd76907278fe4', 'e260c8fb26984a6caf7c88513edd396c', '100', '1449410447565.jpg', 'person.jpg', 'http://192.168.1.115:8080/Residence/image/0932d0f85acf4c65b5ed6a76040a8c99wen.jpg', '/storage/emulated/0/Draw//output/wen.jpg', '65719', '', '0', '0', '1');

-- ----------------------------
-- Table structure for `tb_residentpopulation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_residentpopulation`;
CREATE TABLE `tb_residentpopulation` (
  `Id` varchar(200) NOT NULL,
  `hId` varchar(200) default NULL,
  `pType` int(20) NOT NULL,
  `name` varchar(200) default NULL,
  `oldName` varchar(200) default NULL,
  `sex` varchar(200) default NULL,
  `nation` varchar(200) default NULL,
  `certificateNum` varchar(200) default NULL,
  `birthday` varchar(200) default NULL,
  `degreeEducation` varchar(200) default NULL,
  `maritalSta` varchar(200) default NULL,
  `militarySta` varchar(200) default NULL,
  `tempLiveNo` varchar(200) default NULL,
  `relation` varchar(200) default NULL,
  `tempEndDateCheck` int(11) default NULL,
  `tempEndDate` varchar(200) default NULL,
  `tempLiveDate` varchar(200) default NULL,
  `bloodType` varchar(200) default NULL,
  `height` varchar(200) default NULL,
  `occupation` varchar(200) default NULL,
  `post` varchar(200) default NULL,
  `houseRegist` varchar(200) default NULL,
  `serviceAddr` varchar(200) default NULL,
  `landLine` varchar(200) default NULL,
  `actualLiveAddr` varchar(200) default NULL,
  `telephone` varchar(200) default NULL,
  `qqNum` varchar(200) default NULL,
  `weChatNum` varchar(200) default NULL,
  `imgPersonUrl` varchar(300) default '',
  `rentalTime` varchar(200) default NULL,
  `rentReason` varchar(200) default NULL,
  `liveDate` varchar(200) default NULL,
  `version` int(20) default NULL,
  `personType` varchar(255) default NULL,
  `criminal` varchar(100) default '',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_residentpopulation
-- ----------------------------
INSERT INTO `tb_residentpopulation` VALUES ('d0666a85c3f047198a7d9d62b028666e', '3acdd5f4d3af4b92b339c1a91d338939', '2', 'hh', 'hhh', '男', 'hhh', 'hhh', '2015-12-06', '小学', '未婚', 'bbb', 'hhhjj', 'jjjjj', '0', null, '2015-12-06', 'A型', 'bbbb', 'bbbbb', 'hhh', 'hhhh', 'hhhh', 'hhhhh', 'hhhh', 'hhhh', 'hhhh', 'hhh', 'ecdd939a7cd6459393345de18c5fd358', 'hhh', 'hhhh', 'hhhh', '1', '常住人口', '');
INSERT INTO `tb_residentpopulation` VALUES ('f5f766324a914be6a07178fcc4e40830', '3acdd5f4d3af4b92b339c1a91d338939', '1', 'hhhh', 'hbbhbb', '男', 'hhhbh', 'hhhh', '2015-12-06', '小学', '未婚', 'hhh', '', '', '0', null, '2015-11-06', 'A型', 'hhhh', '', '', 'hhhhh', 'hhhhhh', 'hhhh', 'hhhh', 'hhh', 'hhh', 'hhhh', 'd55e080b59244bf09f03337ebcb3604d', '2015-11-11', '', '', '1', '流动人口', '上访');

-- ----------------------------
-- Table structure for `tb_unit`
-- ----------------------------
DROP TABLE IF EXISTS `tb_unit`;
CREATE TABLE `tb_unit` (
  `id` varchar(200) NOT NULL,
  `uName` varchar(200) default NULL,
  `uAddr` varchar(200) default NULL,
  `uProperty` varchar(200) default NULL,
  `uOperateRange` varchar(200) default NULL,
  `uOperateArea` varchar(100) default NULL,
  `rent` varchar(100) default NULL,
  `uCategory` varchar(200) default NULL,
  `LinkNumber` varchar(200) default NULL,
  `securityPersonId` varchar(200) default NULL,
  `uPersonNum` varchar(200) default NULL,
  `uTelephone` varchar(200) default NULL,
  `bussinessNum` varchar(200) default NULL,
  `regesistMoney` varchar(100) default NULL,
  `regesistTime` varchar(200) default NULL,
  `openningTime` varchar(200) default NULL,
  `closeTime` varchar(200) default NULL,
  `orgNum` varchar(200) default NULL,
  `legalRepresentId` varchar(200) default NULL,
  `landlordId` varchar(200) default NULL,
  `imageUrls` varchar(300) default NULL,
  `layoutDiagramUrl` varchar(300) default NULL,
  `version` int(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_unit
-- ----------------------------
INSERT INTO `tb_unit` VALUES ('e260c8fb26984a6caf7c88513edd396c', 'h', 'v', '国有企业', 'b', 'v', 'g', 'g', 'h', 'h', 'g', null, 'h', 'v', '2015-12-06', '2015-12-06', '2015-12-06', 'h', '1f44e91e918d4aa0ae3a61bbcb739824', '43673e5b4b494c02af995fac160f0752', '5ea65e45368048b5be3e34e60f46b66c;null', 'ecf3ca07c3ff4d4d82fcd76907278fe4', '5');

-- ----------------------------
-- Table structure for `tb_unitpopulation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_unitpopulation`;
CREATE TABLE `tb_unitpopulation` (
  `Id` varchar(200) NOT NULL,
  `uId` varchar(200) default NULL,
  `pType` int(11) default NULL,
  `hBuildingNum` varchar(200) default NULL,
  `hUnitNum` varchar(200) default NULL,
  `hFloorNum` varchar(100) default NULL,
  `roomNumber` varchar(100) default NULL,
  `name` varchar(200) default NULL,
  `oldName` varchar(200) default NULL,
  `birthday` varchar(200) default NULL,
  `sex` varchar(200) default NULL,
  `nation` varchar(200) default NULL,
  `certificateNum` varchar(200) default NULL,
  `degreeEducation` varchar(200) default NULL,
  `maritalSta` varchar(200) default NULL,
  `militarySta` varchar(200) default NULL,
  `bloodType` varchar(200) default NULL,
  `height` varchar(100) default NULL,
  `rentDate` varchar(200) default NULL,
  `workDate` varchar(200) default NULL,
  `IdType` varchar(200) default NULL,
  `residenceId` varchar(200) default NULL,
  `occupation` varchar(200) default NULL,
  `post` varchar(200) default NULL,
  `houseRegist` varchar(200) default NULL,
  `serviceAddr` varchar(200) default NULL,
  `landLine` varchar(200) default NULL,
  `actualLiveAddr` varchar(200) default NULL,
  `telephone` varchar(200) default NULL,
  `qqNum` varchar(200) default NULL,
  `weChatNum` varchar(200) default NULL,
  `imgPersonUrl` varchar(300) default NULL,
  `version` int(20) default NULL,
  `personType` varchar(11) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_unitpopulation
-- ----------------------------
INSERT INTO `tb_unitpopulation` VALUES ('1f44e91e918d4aa0ae3a61bbcb739824', 'e260c8fb26984a6caf7c88513edd396c', '2', '', '', '', '', 'h', 'h', '2015-12-06', '男', 'h', 'h', '小学', '未婚', 'h', 'A型', 'h', '', '2015-12-06', '农业户口', 'h', '', 'g', 'g', '', 'b', '', 'h', 'h', 'h', 'e35c88048ee54d038d20c9cf07ef9b77', '1', null);
INSERT INTO `tb_unitpopulation` VALUES ('43673e5b4b494c02af995fac160f0752', 'e260c8fb26984a6caf7c88513edd396c', '1', 'h', 'h', 'h', 'h', 'h', 'hh', '', '男', 'h', 'hh', '小学', '未婚', 'hhhh', 'A型', 'hhh', '2015-12-06', '', '', '', 'b', 'b', 'h', 'h', 'h', 'h', 'h', 'h', 'hh', '62a1b56f35e84f568344118cfcf82931', '1', null);
INSERT INTO `tb_unitpopulation` VALUES ('5ec3a514a96f408eb65dbedfec030c44', 'e260c8fb26984a6caf7c88513edd396c', '3', '', '', '', '', 'h', 'hh', '2015-12-06', '男', 'h', 'h', '小学', '未婚', 'h', 'A型', 'h', '', '2015-12-06', '农业户口', 'hhhhh', '', 'b', 'b', '', 'bb', '', 'hhh', 'hhhhh', 'hhh', '3ee5bf9671814ff295b81587ed6fedb5', '1', null);
