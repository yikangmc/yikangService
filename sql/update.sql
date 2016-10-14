
--  已发版  2016年09月08日18:27
select * from taglibs where tag_name like '%心脑%';
select * from taglibs where tag_name like '%慢病%';

update taglibs set is_delete=1 WHERE taglib_id=10;
update taglibs set is_delete=1 WHERE taglib_id=9;

--


-- 修改一级标签
update taglibs set orders =0 where tag_name='1'; 
update taglibs set orders =3 where tag_name='2'; 
update taglibs set orders =5 where tag_name='运动康复'; 
update taglibs set orders =7 where tag_name='体态矫正'; 
update taglibs set orders =9 where tag_name='中医'; 
update taglibs set orders =11 where tag_name='激情备孕'; 
update taglibs set orders =13 where tag_name='言语康复'; 
update taglibs set orders =15 where tag_name='老年康复'; 
update taglibs set orders =17 where tag_name='护理'; 
update taglibs set orders =19 where tag_name='综合';


--增加专家解答评论关系表
CREATE TABLE `question_answers_comment` (
  `question_answers_comment_id` bigint(20) 		NOT NULL AUTO_INCREMENT,
  `question_answer_id` 			bigint(20) 		NOT NULL COMMENT '帖子id',
  `create_user_id` 				bigint(20) 		NOT NULL COMMENT '回复者id',
  `to_user_id` 					bigint(20) 		NOT NULL DEFAULT '-2' COMMENT '二级评论被评论人的用户id',
  `content`						varchar(1100) 	CHARACTER SET utf8 NOT NULL COMMENT '评论内容',
  `answer_to` 					tinyint(2) 		NOT NULL COMMENT '评论给谁\n1:解答\n2:个人及解答',
  `create_time` 					datetime 		NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`question_answers_comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='问题解答评论表';

--  上面已经发版




---以下未发版---


ALTER TABLE user_infos 			ADD COLUMN bind_mobile_number varchar(25)  DEFAULT ''  COMMENT '绑定手机号';

ALTER TABLE user_service_infos  ADD COLUMN auth_mobile_number varchar(25)  DEFAULT ''  COMMENT '职位认证手机号';

INSERT INTO adepts(adept_name,  create_time, update_time, is_delete,  type)
     VALUES ('运动康复',  20160630092121, 20160630092121, 0,  6);

INSERT INTO adepts(adept_name,  create_time, update_time,  is_delete, type)
     VALUES ('言语康复', 20160630092121,  20160630092121, 0,  6);

INSERT INTO adepts(adept_name,  create_time, update_time,  is_delete, type)
     VALUES ('作业康复', 20160630092121,  20160630092121, 0,  6);

INSERT INTO adepts(adept_name, create_time, update_time,  is_delete, type)
     VALUES ('体态矫正', 20160630092121,  20160630092121, 0,  6);








