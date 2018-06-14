SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `article_user_id` int(10) unsigned DEFAULT '1',
  `article_title` varchar(255) DEFAULT NULL,
  `article_content` mediumtext,
  `article_parent_category_id` int(10) DEFAULT NULL,
  `article_child_category_id` int(10) DEFAULT NULL,
  `article_tag_ids` varchar(50) DEFAULT NULL,
  `article_view_count` int(10) DEFAULT '0',
  `article_comment_count` int(5) DEFAULT '0',
  `article_like_count` int(5) DEFAULT '0',
  `article_post_time` datetime DEFAULT NULL,
  `article_update_time` datetime DEFAULT NULL,
  `article_is_comment` int(2) unsigned DEFAULT NULL,
  `article_status` int(2) unsigned DEFAULT '1',
  `article_order` int(2) unsigned DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;