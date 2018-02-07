/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2018-02-07 13:32:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `accept`
-- ----------------------------
DROP TABLE IF EXISTS `accept`;
CREATE TABLE `accept` (
  `systemid` varchar(50) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `num` varchar(50) DEFAULT NULL,
  `competname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`systemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accept
-- ----------------------------
INSERT INTO `accept` VALUES ('9638fa6c-fcf9-11e7-80cd-4cbb58cdcdc6', 'weifucheng', '1001', 'sasdsad2');
INSERT INTO `accept` VALUES ('das', 'weifucheng2', '1001', 'wdsa');
INSERT INTO `accept` VALUES ('dasa', 'weifucheng1', '1001', 'wdsa');
INSERT INTO `accept` VALUES ('dasdas', 'www', '1001', 'sasdsad2');
INSERT INTO `accept` VALUES ('fsada', 'weifucheng1', '1001', 'sasdsad2');
INSERT INTO `accept` VALUES ('wqwdwwq', 'weifucheng1', '1002', 'sasdsad2');

-- ----------------------------
-- Table structure for `competition`
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `systemid` varchar(50) NOT NULL,
  `competname` varchar(50) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `starttime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `registercount` int(11) DEFAULT NULL,
  PRIMARY KEY (`systemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES ('sasdsad2', '2018新生赛', '红军', '2018-01-09 15:48:02', '2018-01-17 15:48:07', '10', '10');
INSERT INTO `competition` VALUES ('wdsa', '2017新生赛', '红军', '2018-01-08 15:49:04', '2018-01-10 15:49:07', '11', '123');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `systemid` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `detail` varchar(50) NOT NULL,
  `detail2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`systemid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1', 'oj_result', '0', '编译中', null);
INSERT INTO `dictionary` VALUES ('2', 'oj_result', '2', '通过', null);
INSERT INTO `dictionary` VALUES ('3', 'oj_result', '3', '答案错误', null);
INSERT INTO `dictionary` VALUES ('4', 'oj_result', '4', '运行错误', null);
INSERT INTO `dictionary` VALUES ('5', 'oj_result', '5', '内存溢出', null);
INSERT INTO `dictionary` VALUES ('6', 'oj_result', '6', '运行超时', null);
INSERT INTO `dictionary` VALUES ('7', 'oj_result', '7', '编译错误', null);
INSERT INTO `dictionary` VALUES ('8', 'oj_language', '0', 'java', 'java');
INSERT INTO `dictionary` VALUES ('9', 'oj_language', '1', 'c++', 'cpp');
INSERT INTO `dictionary` VALUES ('10', 'oj_result', '1', '运行中', null);
INSERT INTO `dictionary` VALUES ('11', 'oj_language', '2', 'c', 'c');
INSERT INTO `dictionary` VALUES ('12', 'oj_language', '3', 'python', 'py');
INSERT INTO `dictionary` VALUES ('13', 'oj_language', '4', 'c#', null);

-- ----------------------------
-- Table structure for `problem`
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem` (
  `systemid` varchar(50) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  `deteleflag` varchar(1) DEFAULT NULL,
  `lv` varchar(10) DEFAULT NULL,
  `laber` varchar(50) DEFAULT NULL,
  `type` varchar(1) DEFAULT NULL,
  `competname` varchar(50) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `ac` int(11) DEFAULT NULL,
  `error` int(11) DEFAULT NULL,
  `bm` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`systemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES ('2c50b18d420f45f7b455cb4ed36f970e', '1002', '斐波那契数列', '<p>输入n &nbsp;输出第N项的值</p><p>asdsa</p><p>asdsa<img src=\"http://img.baidu.com/hi/jx2/j_0035.gif\"/></p><p>a<strong>sdsa</strong></p><p><strong>asdsa</strong></p><p><span style=\"background-color: rgb(247, 150, 70);\"><strong>asdsa</strong></span></p><p><strong>asdsa</strong></p><p>asdsa</p><p>asdsa<img src=\"http://img.baidu.com/hi/jx2/j_0015.gif\"/></p>', null, null, '0', '3', '递归', '0', 'sasdsad2', null, '3', null, null);
INSERT INTO `problem` VALUES ('924dccd60e57467ba957651c66d3258f', '1001', 'A+B', '输入A+B 输出A+B输入n  输出第N项的值<p>asdsa</p><p>asdsa</p><p>asdsa</p><p>asdsa</p><p>asdsa</p><p>asdsa</p>', null, null, '0', '2', '基础', '0', '', null, '3', null, null);

-- ----------------------------
-- Table structure for `register`
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `systemid` varchar(50) NOT NULL,
  `competname` varchar(50) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `ac` int(11) DEFAULT NULL,
  `error` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  PRIMARY KEY (`systemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('a5ed16f6ee2d415d9ec69731ec481067', 'wdsa', '1', '0', '0', '0');
INSERT INTO `register` VALUES ('asdsa', 'sasdsad2', 'weifucheng', '8', '1', '12');
INSERT INTO `register` VALUES ('qwewq', 'sasdsad2', '1', '1', '1', '1');
INSERT INTO `register` VALUES ('qwewqeq', 'sasdsad2', '2', '6', '1', '1');

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `systemid` varchar(50) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL,
  `state` varchar(5) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `language` varchar(10) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `competname` varchar(50) DEFAULT NULL,
  `bm` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`systemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('0f981d6534b54ad8be5a2c5bb6290447', '1001', 'weifucheng', '7', '2018-01-12 15:32:01', '0', 'dds\n', null, 'sasdsad2', 'C');
INSERT INTO `result` VALUES ('34e8fb21009c44f5b9aa98166edac4a3', '1002', 'weifucheng', '7', '2018-01-18 16:17:30', '0', 'rwerwrwwe\n', null, null, null);
INSERT INTO `result` VALUES ('603475fee1e24f5db2883908023352d1', '1001', 'weifucheng', '7', '2018-01-18 16:17:32', '0', 'sadsa\n', null, 'sasdsad2', 'D');
INSERT INTO `result` VALUES ('7c71e8fb3ec04a8f8202e6082e89c472', '1002', 'weifucheng', '7', '2018-01-18 16:17:33', '0', 'sdfsffs\n', null, null, null);
INSERT INTO `result` VALUES ('861bb19fe69949d79c6ec4fab5d087ef', '1001', 'weifucheng', '7', '2018-01-18 16:17:35', '0', '#include&lt;stdio.h&gt;\nint main(){\n    return 0;\n}\n', null, null, null);
INSERT INTO `result` VALUES ('96a27aa1a0c647fb9eec59002043aa45', '1001', '大咪咪', '7', '2018-01-18 16:29:35', '0', 'fsaffdsf\n', null, null, null);
INSERT INTO `result` VALUES ('9babad15a27d4f4a8b7eabe0ac1b9794', '1002', 'weifucheng', '7', '2018-01-12 14:41:00', '0', 'asdsa\n', null, 'sasdsad2', 'B');
INSERT INTO `result` VALUES ('9d512453214d4234accf8dcda6b48e01', '1002', 'weifucheng', '7', '2018-01-18 16:37:07', '0', 'xzczx\n', null, 'sasdsad2', 'B');
INSERT INTO `result` VALUES ('a6353ceb72104ffb8e170fea5118a605', '1002', 'weifucheng', '7', '2018-01-12 15:32:04', '0', 'zzzzzzzzzzzzzz\n', null, 'sasdsad2', 'E');
INSERT INTO `result` VALUES ('bcf56305006941d98e515d7b64ede5e6', '1002', 'weifucheng', '7', '2018-01-18 16:33:11', '0', 'sadsadsad\n', null, 'sasdsad2', 'A');
INSERT INTO `result` VALUES ('c994b474d919475aad84ddee0b17508d', '1002', 'weifucheng', '7', '2018-01-18 16:17:36', '0', 'eweq\n', null, 'sasdsad2', null);
INSERT INTO `result` VALUES ('d4cc183b9280460aaa2efa1af6f8c9f9', '1001', 'weifucheng', '7', '2018-01-18 16:28:52', '0', '<img src=\"http://img.baidu.com/hi/jx2/j_0002.gif\" _src=\"http://img.baidu.com/hi/jx2/j_0002.gif\">\n', null, 'sasdsad2', null);
INSERT INTO `result` VALUES ('dsadasd', '1001', 'weifucheng', '0', '2018-01-01 16:32:59', '0', 'import java.util.Scanner;\r\n\r\npublic class Main{\r\n    public static void main(String[] args) {\r\n        Scanner scanner = new Scanner(System.in);\r\n        while (scanner.hasNext()) {\r\n            int a = scanner.nextInt();\r\n            int b = scanner.nextInt();\r\n            System.out.println(a + b);\r\n        }\r\n    }\r\n}', '0', 'sasdsad2', null);
INSERT INTO `result` VALUES ('e09aecdb5aa34961b8e26c7b964f911d', '1001', 'weifucheng', '7', '2018-01-18 16:17:37', '0', 'dasd\n', null, 'sasdsad2', 'F');
INSERT INTO `result` VALUES ('eb18c46e25144859a745fce8bc400736', '1001', 'weifucheng', '6', '2018-01-01 16:17:39', '0', 'import java.util.Scanner;\r\n\r\npublic class Main{\r\n    public static void main(String[] args) {\r\n        Scanner scanner = new Scanner(System.in);\r\n        while (scanner.hasNext()) {\r\n            int a = scanner.nextInt();\r\n            int b = scanner.nextInt();\r\n            System.out.println(a + b);\r\n        }\r\n        while(true);\r\n    }\r\n}', null, 'sasdsad2', 'D');
INSERT INTO `result` VALUES ('ewqeeqw', '1001', 'weifucheng', '4', '2018-01-09 16:57:59', '0', 'class Test {\r\n    public static void main(String[] args) {\r\n        System.out.println(\"asadadads\");int a=1/0;\r\n    }\r\n}', '0', 'sasdsad2', null);

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=32224 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');
INSERT INTO `role` VALUES ('2', 'customer');
INSERT INTO `role` VALUES ('32223', '22323');

-- ----------------------------
-- Table structure for `testcase`
-- ----------------------------
DROP TABLE IF EXISTS `testcase`;
CREATE TABLE `testcase` (
  `systemid` varchar(50) NOT NULL,
  `problemid` varchar(50) NOT NULL,
  `input` varchar(5000) DEFAULT NULL,
  `output` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`systemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testcase
-- ----------------------------
INSERT INTO `testcase` VALUES ('dsadas', '1001', '1\n2', '3 ');
INSERT INTO `testcase` VALUES ('dsadasd', '1001', '3\n2', '5');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `ac` int(10) unsigned zerofill DEFAULT NULL,
  `wa` int(11) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `vip` varchar(2) DEFAULT NULL,
  `autograph` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '0000000003', null, '12', '1', '12', null, '12', '21');
INSERT INTO `user` VALUES ('12', '21', '0000000004', null, '12', '12', null, '2018-01-01 00:00:00', null, '张三丰');
INSERT INTO `user` VALUES ('123', '123', '0000000005', null, '1', '1', '1', '2018-01-01 22:51:24', null, '来如风，去如风');
INSERT INTO `user` VALUES ('12323', '1', '0000000002', null, '1', '12', '1', '2001-01-12 01:01:01', '1', '1');
INSERT INTO `user` VALUES ('2312', '32131', '0000000035', null, '12', null, null, '2018-01-01 22:58:30', null, '我是个萌妹子');
INSERT INTO `user` VALUES ('2313', '321', '0000000005', null, null, null, null, '2018-01-01 22:58:30', null, null);
INSERT INTO `user` VALUES ('sd', 'das', '0000000002', '2', '3', '45', '5', '2018-01-01 22:51:11', '1', null);
INSERT INTO `user` VALUES ('weifucheng', '123456', '0000000058', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('www', 'www', '0000000055', null, null, null, null, null, null, '王者不可阻挡');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  KEY `u_fk` (`uid`),
  KEY `r_fk` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');

-- ----------------------------
-- Function structure for `mydecode`
-- ----------------------------
DROP FUNCTION IF EXISTS `mydecode`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `mydecode`(kind1 VARCHAR(255),code1 VARCHAR(255)) RETURNS varchar(255) CHARSET utf8
BEGIN  
DECLARE x VARCHAR(255) DEFAULT '';  
SELECT t.detail into x from dictionary t where t.kind=kind1 and t.code=code1;
RETURN x;  
END
;;
DELIMITER ;
