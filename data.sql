# 班级类
drop table if exists `t_classes`;
create table `t_classes`(
    `id` int(11) NOT NULL primary key auto_increment,
    `name` varchar(11) default null
);
# 学生类
drop table if exists `t_student`;
create table `t_student`(
    `id` int(11) NOT NULL primary key auto_increment,
    `name` varchar(11) default null,
    `cid` int(11) default null,
    key `cid` (`cid`),
    constraint `t_student_ibfk_1` foreign key (`cid`) references `t_classes`(`id`)
);
# 账户类
drop table if exists `t_account`;
create table `t_account`(
    `id` int(11) NOT NULL primary key auto_increment,
    `name` varchar(11) default null
);
# 课程类
drop table if exists `t_course`;
create table `t_course`(
    `id` int(11) NOT NULL primary key auto_increment,
    `name` varchar(11) default null
);
# 关联表
drop table if exists `account_course`;
create table `account_course`(
    `id` int(11) NOT NULL primary key auto_increment,
    `aid` int(11) default null,
    `cid` int(11) default null,
    key `aid`(`aid`),
    key `cid`(`cid`),
    constraint `account_course_ibfk_1` foreign key (`aid`) references `t_account`(`id`),
    constraint `account_course_ibfk_2` foreign key (`cid`) references `t_course`(`id`)
);
# 客户表
drop table if exists `customer`;
create table `customer`(
    `id` int(11) NOT NULL primary key auto_increment,
    `name` varchar(11) default null
);
# 订单表
drop table if exists `order`;
create table `order`(
    `id` int(11) NOT NULL primary key auto_increment,
    `name` varchar(11) default null,
    `cid` int(11) default null,
    key `cid` (`cid`),
    constraint `order_ibfk_1` foreign key (`cid`) references `customer`(`id`)
);
# 用户表
drop table if exists `t_user`;
create table `t_user`(
    `id` int(11) NOT NULL primary key auto_increment,
    `username` varchar(11) default null,
    `password` varchar(11) default null,
    `age` int(11) default null
);
# 查询语句
select s.id,s.name,c.id cid,c.name from t_student s, t_classes c where s.id = 1 and s.cid = c.id;
select c.id cid,c.name cname,s.id sid,s.name sname from t_classes c, t_student s where c.id = 1 and c.id = s.cid;
select a.id aid,a.name aname,c.id cid,c.name cname from t_account a,t_course c,account_course ac where a.id = 1 and a.id = ac.aid and c.id = ac.cid;
select c.id cid,c.name cname,a.id aid,a.name aname from t_course c,t_account a,account_course ac where c.id = 1 and a.id = ac.aid and c.id = ac.cid;
