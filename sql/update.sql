
--  未发版  2016年09月08日18:27
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


