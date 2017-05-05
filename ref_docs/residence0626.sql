/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : orcl

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2016-06-26 11:07:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL default '0',
  `content` varchar(255) default NULL,
  `owner` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'ÎÄÑ§ÊÇÃÀµÄÌåÏÖ', 'ÕÅÈý');

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
INSERT INTO `comment` VALUES ('1', 'ÎÄÑ§Ó¦¸ÃÊÇÀúÊ·ÎÄ»¯µÄ»ýÀÛ', '1', '2015-11-21');
INSERT INTO `comment` VALUES ('2', 'ÎÄÑ§ÊÇÖÖÒÕÊõ', '1', '2015-11-12');

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
INSERT INTO `tb_mediafile` VALUES ('04edbcb516564b29ba99bfd6bceb9cf3', '1f68888ce27745d9980c41d3addc6c34', '104', '1466908436690.jpg', '6fc09dd04aff482cae0924ff01910d02imagesdb17b22767004bb09e4da760935e91f2images095c29352ef947109ad3a7d35ee1a945_UnitEmp_20160626100502.jpg', '/Residence/image/743a9879a85a4f9c9c1acbaa7bd9f997_UnitEmp_20160626100502.jpg', '/storage/emulated/0/draw/images/unit/userHead/', '26782', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('07f57f586c9f4ee4971b2dbf1fdc6053', 'b23090ae742d4478a8653e47068c3e53', '104', '1466907924308.jpg', '06ca824c3bf248198f72b33185e6c79bimages70ebfbde12a442728bf8eeb1150fbe89images1015656a8ca24efc938135cca7d03d5e_UnitEmp_20160626100608.jpg', '/Residence/image/34b7293610814e7e8a9769a38d67f102_UnitEmp_20160626100608.jpg', '/storage/emulated/0/draw/images/unit/userHead/', '30998', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('08ac32d491e0461db6bc002973279bd5', '3ba32d830051403d8e26c8fa6830ccf6', '104', '1466906645012.jpg', 'd7beed921d6f427197e63cad588e1b70imagesfa6c087e7dbf48baaa23e962c4870e86_UnitEmp_20160625093445.jpg', '/Residence/image/d7beed921d6f427197e63cad588e1b70imagesfa6c087e7dbf48baaa23e962c4870e86_UnitEmp_20160625093445.jpg', '/storage/sdcard0/draw/imagesfa6c087e7dbf48baaa23e962c4870e86', '79340', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('1614f6a0220d4a57958df42bfad1948f', '085d65b7253c49c3bfec63a014fb2f8b', '104', '1466908436600.jpg', 'c7fe8667a835432c948eb6110719db36imagesd2d1f9f2d4db4fb493c94a277ebc54e8imagesbb44dd60562448edb0c130cfae000276_UnitEmp_20160626100331.jpg', '/Residence/image/c086a2ff495b498ab9d52cef92c0411b_UnitEmp_20160626100331.jpg', '/storage/emulated/0/draw/images/unit/userHead/', '20639', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('52e3f6d079614aa190c6232d41319d21', 'a5a7c84428674e689f5fd73fc65f9c57', '100', '1466907234904.jpg', 'b82abfbdba2640c2953b6cc02c8329b7_UnitLayout_1.jpg', '/Residence/image/1140694c8f6c499585766eb966b55aa5_UnitLayout_1.jpg', '/storage/emulated/0/draw/images/unit/layout/', '23462', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('55bc24d45403467b95555264ff47f56f', '1437b788e8de4a59a4d3f3321995d082', '101', '1466906645290.jpg', '070977c6c1e8458fad16b51aa914e778imagesba9d5dbeca3348f4bdf7317b0d450664_UnitAttach_20160625093617.jpg', '/Residence/image/070977c6c1e8458fad16b51aa914e778imagesba9d5dbeca3348f4bdf7317b0d450664_UnitAttach_20160625093617.jpg', '/storage/sdcard0/draw/imagesba9d5dbeca3348f4bdf7317b0d450664', '275008', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('58f06be2361d41d1a9f00186b7a55e8d', '1437b788e8de4a59a4d3f3321995d082', '101', '1466906645329.jpg', '5ace77c86dcc4f1e8edf3e7785a215caimages7b5ed0e373684b4295691ae32fcac777_UnitAttach_20160625093604.jpg', '/Residence/image/5ace77c86dcc4f1e8edf3e7785a215caimages7b5ed0e373684b4295691ae32fcac777_UnitAttach_20160625093604.jpg', '/storage/sdcard0/draw/images7b5ed0e373684b4295691ae32fcac777', '254256', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('5b4b2312f8454fbab7a4fe165ee7a71d', 'daa16a0db1984e2fac37523335c9cb4c', '103', '1466908436726.jpg', 'cd223207c9b04c2f9aae6a0c3d63da4fimages8025dd842c5740c8ae8322db87519db6imagesc131b8556c1f4b58a1823c6c1ced3617_UnitCorp_20160626100259.jpg', '/Residence/image/48c2a76b7191499083a157850104fb13_UnitCorp_20160626100259.jpg', '/storage/emulated/0/draw/images/unit/userHead/', '21492', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('6bcb170ffcb04c6ab56a1ca708898dce', '3329962fcd85481bbd810a7d01fadaf4', '104', '1466906645412.jpg', '172b06d468284c81bd10871b80a30c37images2e9aca0636f64086810f228a9e8459fe_UnitEmp_20160625093328.jpg', '/Residence/image/172b06d468284c81bd10871b80a30c37images2e9aca0636f64086810f228a9e8459fe_UnitEmp_20160625093328.jpg', '/storage/sdcard0/draw/images2e9aca0636f64086810f228a9e8459fe', '80571', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('6fc5af2fa7a647ab81a815adf7aa9c27', '96b719f7ea674e1b986163af0774662b', '103', '1466906645253.jpg', '923db37e8c4e479da570bdb050aa9b11imagesecf07fd8ef1a4e35aa99439a135c8ca8_UnitCorp_20160625093227.jpg', '/Residence/image/923db37e8c4e479da570bdb050aa9b11imagesecf07fd8ef1a4e35aa99439a135c8ca8_UnitCorp_20160625093227.jpg', '/storage/sdcard0/draw/imagesecf07fd8ef1a4e35aa99439a135c8ca8', '72083', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('729f100593524c9aaa0ec5beb2be47fb', '4a5955e1a43e412bbd12cb959fb702f6', '104', '1466908436651.jpg', 'dd02cfc9bc6e494fa60dbe4b85b29bdfimages357445ad15254f1486ef1383a622caacimagesaa10c851d3c4483cb8607e94473f10d4_UnitEmp_20160626100528.jpg', '/Residence/image/88d23a59976641cdbc6576d1951d53e3_UnitEmp_20160626100528.jpg', '/storage/emulated/0/draw/images/unit/userHead/', '38851', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('81ae057a4d3e486fa03b6348ed92ee76', '1437b788e8de4a59a4d3f3321995d082', '100', '1466906645174.jpg', '469258b150b34143876048eea974f70dimagesc8663816159246b78017c5e69580bfec_UnitLayout_快.jpg', '/Residence/image/469258b150b34143876048eea974f70dimagesc8663816159246b78017c5e69580bfec_UnitLayout_快.jpg', '/storage/sdcard0/draw/imagesc8663816159246b78017c5e69580bfec', '15575', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('95b3bc3ac38c4af48444c0edd6e75519', '7c938a858f0a420c9fb763d35c331cb7', '102', '1466906645373.jpg', 'e576d8348af747aa9425c7923c22286fimages6a976da5318f4004b211a679bcb6a670_UnitOwner_20160625093052.jpg', '/Residence/image/e576d8348af747aa9425c7923c22286fimages6a976da5318f4004b211a679bcb6a670_UnitOwner_20160625093052.jpg', '/storage/sdcard0/draw/images6a976da5318f4004b211a679bcb6a670', '59015', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('9e203f7571cb495495e4e93fda5b678d', 'b2841191c8244d8e86ecfff59acde8c2', '102', '1466908436543.jpg', '449a9f35cd5f482285f3574225b21c12imagesa37e305ce2b347668d22bada28741d91images70600a8dac914fa7b6495240508762c9_UnitOwner_20160626100231.jpg', '/Residence/image/5ea4bd96ea0248299c641ecb235e5f7c_UnitOwner_20160626100231.jpg', '/storage/emulated/0/draw/images/unit/userHead/', '22605', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('d1bf145a806944b1a3bed125afa8019c', 'b23090ae742d4478a8653e47068c3e53', '104', '1466908436506.jpg', '04b6a06c7553479ea8f492e794083d49_UnitEmp_20160626103333.jpg', '/Residence/image/04b6a06c7553479ea8f492e794083d49_UnitEmp_20160626103333.jpg', '/storage/emulated/0/draw/images/unit/userHead/', '23256', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('e61d58a559c34483bb88b9727b2e6c0d', 'a5a7c84428674e689f5fd73fc65f9c57', '101', '1466908436765.jpg', '5b3dd59bf7b94e11ba9da85c5156437fimages12e7820726ae4a229a96ba9942826e8dimagesd565882cea134d06ac434bd8f886c1ea_UnitAttach_20160626100647.jpg', '/Residence/image/d4d0f656a00f43cfa68c4bbf81f3dd4e_UnitAttach_20160626100647.jpg', '/storage/emulated/0/draw/images/unit/attchment/', '70349', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('e8973f017c8c4a79838c6ac47167b313', 'a5a7c84428674e689f5fd73fc65f9c57', '101', '1466908436801.jpg', 'edade6a18e5c4c748ac7e8c43ccda50e_UnitAttach_20160626102409.jpg', '/Residence/image/bf5633b8c57e48ee97a298d86d40dc76_UnitAttach_20160626102409.jpg', '/storage/emulated/0/draw/images/unit/attchment/', '76058', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('eaa4d07a28d74fb8a1545343d6867c2a', 'a5a7c84428674e689f5fd73fc65f9c57', '100', '1466908436431.jpg', 'f832dde6e09c4724a72d638fd0a3cdd1_UnitLayout_请问.jpg', '/Residence/image/5c349d4f59bb46a8a1eddd6af4a4dcb6_UnitLayout_请问.jpg', '/storage/emulated/0/draw/images/unit/layout/', '129323', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('fa1e2f5b2c24432cbcb884321ea2e5e6', '145800b4f9504253a142fb4159e426f5', '104', '1466908436468.jpg', 'bba964699dd640278cae292c13bb4531imagesc1651f6865d64090b219c2b8c11e831eimages4cb79c1ca02a4acdbfb0d6b801703e0e_UnitEmp_20160626100359.jpg', '/Residence/image/4e8dbb62fe9342a393effc0d1b78bdd4_UnitEmp_20160626100359.jpg', '/storage/emulated/0/draw/images/unit/userHead/', '12497', '', '0', '0', '1');
INSERT INTO `tb_mediafile` VALUES ('fc38a184586f4df4afb538ca6d5d81fa', 'a5a7c84428674e689f5fd73fc65f9c57', '100', '1466907580174.jpg', 'd6736c5082514f718a4853da779f4361_UnitLayout_123456.jpg', '/Residence/image/d6736c5082514f718a4853da779f4361_UnitLayout_123456.jpg', '/storage/emulated/0/draw/images/unit/layout/', '88425', '', '0', '0', '1');

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
  `rentDate` varchar(100) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_residentpopulation
-- ----------------------------

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
  `validTime` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_unit
-- ----------------------------
INSERT INTO `tb_unit` VALUES ('1437b788e8de4a59a4d3f3321995d082', '单位名称12', '单位地址', '国有企业', '经营范围', '150', '123', '单位类别', '联系电话', '治安责任人', '100', null, '工商卡', '33', '2016-06-25', '2016-06-25', '2016-06-25', '组织机构代码', '96b719f7ea674e1b986163af0774662b', '7c938a858f0a420c9fb763d35c331cb7', '55bc24d45403467b95555264ff47f56f;58f06be2361d41d1a9f00186b7a55e8d;null', '81ae057a4d3e486fa03b6348ed92ee76', '6', '2016-06-25');
INSERT INTO `tb_unit` VALUES ('a5a7c84428674e689f5fd73fc65f9c57', '单位81new', '地址', '国有企业', '范围', '', '', '类别', '电话', '责任人', '', null, '', '', '2016-06-26', '2016-06-26', '2016-06-26', '', 'daa16a0db1984e2fac37523335c9cb4c', 'b2841191c8244d8e86ecfff59acde8c2', 'e61d58a559c34483bb88b9727b2e6c0d;null', '52e3f6d079614aa190c6232d41319d21', '15', '2016-06-26');

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
INSERT INTO `tb_unitpopulation` VALUES ('085d65b7253c49c3bfec63a014fb2f8b', 'a5a7c84428674e689f5fd73fc65f9c57', '3', '', '', '', '', '职工1', '', '', '男', '汉族', '130406198610012152', '小学', '未婚', '', 'A型', '125', '', '', '农业户口', '', '', '', '', '', '', '', '13012345678', '', '', '1614f6a0220d4a57958df42bfad1948f', '1', null);
INSERT INTO `tb_unitpopulation` VALUES ('145800b4f9504253a142fb4159e426f5', 'a5a7c84428674e689f5fd73fc65f9c57', '3', '', '', '', '', '职工2', '', '', '男', '汉族', '130406198610012152', '小学', '未婚', '', 'A型', '150', '', '', '农业户口', '', '', '', '', '', '', '', '13012345678', '', '', 'fa1e2f5b2c24432cbcb884321ea2e5e6', '1', null);
INSERT INTO `tb_unitpopulation` VALUES ('1f68888ce27745d9980c41d3addc6c34', 'a5a7c84428674e689f5fd73fc65f9c57', '3', '', '', '', '', '职工3new', '', '', '男', '汉族', '130406198610012152', '小学', '未婚', '', 'A型', '130', '', '', '农业户口', '', '', '', '', '', '', '', '15012345678', '', '', '04edbcb516564b29ba99bfd6bceb9cf3', '2', null);
INSERT INTO `tb_unitpopulation` VALUES ('3329962fcd85481bbd810a7d01fadaf4', '1437b788e8de4a59a4d3f3321995d082', '3', '', '', '', '', '职工1', '纯爷们', '2016-06-25', '男', '汉族', '130406198610012152', '小学', '未婚', '现住址', 'A型', '150', '', '2016-06-25', '农业户口', '居住证', '', '职务', '户籍详细', '', '固定电话', '', '13012345678', '123456', '微信', '6bcb170ffcb04c6ab56a1ca708898dce', '1', null);
INSERT INTO `tb_unitpopulation` VALUES ('3ba32d830051403d8e26c8fa6830ccf6', '1437b788e8de4a59a4d3f3321995d082', '3', '', '', '', '', '职工2', '曾用吗', '2016-06-25', '男', '汉族', '130406198610012152', '小学', '未婚', '现住址', 'A型', '130', '', '2016-06-25', '农业户口', '居住证', '', '职务', '户籍详细', '', '固定电话', '', '15612345678', '66', '微信', '08ac32d491e0461db6bc002973279bd5', '1', null);
INSERT INTO `tb_unitpopulation` VALUES ('4a5955e1a43e412bbd12cb959fb702f6', 'a5a7c84428674e689f5fd73fc65f9c57', '3', '', '', '', '', '职工5new', '', '', '男', '汉族', '130406198610012152', '小学', '未婚', '', 'A型', '150', '', '', '农业户口', '', '', '', '', '', '', '', '13012345678', '', '', '729f100593524c9aaa0ec5beb2be47fb', '2', null);
INSERT INTO `tb_unitpopulation` VALUES ('7c938a858f0a420c9fb763d35c331cb7', '1437b788e8de4a59a4d3f3321995d082', '1', '房栋号', '单元号', '楼层号', '房间号', '屋主姓名', '纯爷们', '', '男', '汉族', '130406198610012152', '小学', '未婚', '兵役状况', 'A型', '180', '2016-06-25', '', '', '', '职业', '职务', '户籍详细', '服务住所', '固定电话', '实际住址', '13012345678', '12345678', '微信', '95b3bc3ac38c4af48444c0edd6e75519', '1', null);
INSERT INTO `tb_unitpopulation` VALUES ('96b719f7ea674e1b986163af0774662b', '1437b788e8de4a59a4d3f3321995d082', '2', '', '', '', '', '法人姓名', '纯爷们', '2016-06-25', '男', '汉族', '130406198610012152', '小学', '未婚', '现住址', 'A型', '150', '', '2016-06-25', '农业户口', '居住证', '', '职务', '户籍详细', '', '固定电话', '', '15612345678', '123456', '微信', '6fc5af2fa7a647ab81a815adf7aa9c27', '1', null);
INSERT INTO `tb_unitpopulation` VALUES ('b23090ae742d4478a8653e47068c3e53', 'a5a7c84428674e689f5fd73fc65f9c57', '3', '', '', '', '', '职工8new', '', '', '男', '汉族', '130406198610012152', '本科', '已婚', '', 'A型', '130', '', '', '非农业户口', '', '', '', '', '', '', '', '13012345678', '', '', '07f57f586c9f4ee4971b2dbf1fdc6053', '3', null);
INSERT INTO `tb_unitpopulation` VALUES ('b2841191c8244d8e86ecfff59acde8c2', 'a5a7c84428674e689f5fd73fc65f9c57', '1', '', '', '', '', '房屋姓名new', '', '', '男', '汉族', '130406198610012152', '小学', '未婚', '', 'A型', '125', '', '', '', '', '', '', '', '', '', '', '13012345678', '', '', '9e203f7571cb495495e4e93fda5b678d', '2', null);
INSERT INTO `tb_unitpopulation` VALUES ('daa16a0db1984e2fac37523335c9cb4c', 'a5a7c84428674e689f5fd73fc65f9c57', '2', '', '', '', '', '法人姓名', '', '', '男', '汉族', '130406198610012152', '小学', '未婚', '', 'A型', '135', '', '', '农业户口', '', '', '', '', '', '', '', '13012345678', '', '', '5b4b2312f8454fbab7a4fe165ee7a71d', '1', null);
