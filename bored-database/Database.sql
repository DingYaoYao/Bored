/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.28 : Database - bored
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bored` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bored`;

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `id` int(15) NOT NULL AUTO_INCREMENT COMMENT '申请编号',
  `from_user` bigint(15) DEFAULT NULL COMMENT '申请用户',
  `to_user` bigint(15) DEFAULT NULL COMMENT '被申请用户',
  `message` varchar(50) DEFAULT NULL COMMENT '附加消息',
  `status` int(1) DEFAULT NULL COMMENT '申请状态',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `blacklist` */

DROP TABLE IF EXISTS `blacklist`;

CREATE TABLE `blacklist` (
  `userid` bigint(15) NOT NULL COMMENT '拉黑的人',
  `fouserid` bigint(15) NOT NULL COMMENT '被拉黑的'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `friend` */

DROP TABLE IF EXISTS `friend`;

CREATE TABLE `friend` (
  `userid` bigint(15) DEFAULT NULL COMMENT '用户id',
  `context` varchar(50) NOT NULL COMMENT '内容',
  `Image_path` varchar(500) DEFAULT NULL COMMENT '图片和视频的路径逗号分隔',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `Video_path` varchar(5000) DEFAULT NULL COMMENT '预留的视频路径',
  `like` int(10) DEFAULT NULL COMMENT '点赞'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `friends` */

DROP TABLE IF EXISTS `friends`;

CREATE TABLE `friends` (
  `id` int(15) NOT NULL COMMENT '标识列',
  `userid` bigint(15) NOT NULL COMMENT '用户id',
  `friend_user_id` bigint(15) NOT NULL COMMENT '好友的id',
  `friend_nicename` varchar(50) DEFAULT NULL COMMENT '朋友的备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `groupchat` */

DROP TABLE IF EXISTS `groupchat`;

CREATE TABLE `groupchat` (
  `groupid` int(15) NOT NULL COMMENT '群号',
  `groupname` varchar(20) NOT NULL COMMENT '群名称',
  `groupuserid` bigint(15) NOT NULL COMMENT '群主id',
  `member_list` varchar(300) NOT NULL COMMENT '群组成员id列表',
  `displayname` varchar(300) NOT NULL COMMENT '群成员昵称列表',
  `createtime` datetime DEFAULT NULL COMMENT '群创建时间',
  `grouptopicid` int(50) DEFAULT NULL COMMENT '群主题id',
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(5) NOT NULL,
  `text1` varchar(50) DEFAULT NULL,
  `text2` varchar(50) DEFAULT NULL,
  `text3` varchar(50) DEFAULT NULL,
  `text4` varchar(50) DEFAULT NULL,
  `text5` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sensitiveword` */

DROP TABLE IF EXISTS `sensitiveword`;

CREATE TABLE `sensitiveword` (
  `sensitiveword` varchar(50) DEFAULT NULL COMMENT '敏感词汇',
  `hint` varchar(50) DEFAULT NULL COMMENT '友好提示'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `space` */

DROP TABLE IF EXISTS `space`;

CREATE TABLE `space` (
  `id` int(50) NOT NULL COMMENT '空间编号',
  `titleid` int(50) NOT NULL COMMENT '话题主题id',
  `userId` bigint(15) NOT NULL COMMENT '投放者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(1) DEFAULT NULL COMMENT '1=有效 0=无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '标识列自增加',
  `headline` varchar(50) NOT NULL COMMENT '话题的标题',
  `userid` bigint(15) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(15) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `niceName` varchar(50) NOT NULL COMMENT '昵称',
  `signature` varchar(50) NOT NULL COMMENT '签名',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `sex` int(1) NOT NULL COMMENT '1=男 2=女',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `address_id` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `phone` varchar(20) NOT NULL COMMENT '电话号码',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `picturepath` varchar(200) NOT NULL COMMENT '头像路径',
  `lately_login_date` datetime DEFAULT NULL COMMENT '最近登录时间',
  `loginStat` int(4) DEFAULT NULL COMMENT '登陆状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
