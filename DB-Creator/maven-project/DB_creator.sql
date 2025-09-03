create database lixiong01;
-----------------------------------------------------------
create table dept
(
    id          int unsigned auto_increment comment '主键ID'
        primary key,
    name        varchar(10) not null comment '部门名',
    create_time datetime    null comment '创建时间',
    update_time datetime    null comment '更新时间',
    constraint name
        unique (name)
)
    engine = InnoDB;
	
	-------------------------------
	insert into dept (id, name, create_time, update_time)
values ();
============================================================================================
create table emp
(
    id          int unsigned auto_increment comment 'ID,主键'
        primary key,
    username    varchar(20)                       not null comment '用户名',
    password    varchar(50)      default '123456' null comment '密码',
    name        varchar(10)                       not null comment '姓名',
    gender      tinyint unsigned default '1'      not null comment '性别',
    phone       char(11)                          not null comment '手机号',
    job         tinyint unsigned                  null comment '职位，1 班主任，2 讲师， 3 学工主管，4，教研主任',
    salary      int unsigned                      null comment '薪资',
    entry_date  date                              null comment '入职日期',
    image       varchar(300)                      null comment '头像',
    create_time datetime                          null comment '创建时间',
    update_time datetime                          null comment '更新时间',
    dept_id     int unsigned                      null comment '部门ID',
    constraint phone
        unique (phone),
    constraint username
        unique (username),
    constraint fk_emp_dept_id
        foreign key (dept_id) references dept (id)
)
    comment '员工表' engine = InnoDB;
	
	---------------------------------
insert into emp (id, username, password, name, gender, phone, job, salary, entry_date, image, create_time, update_time,
                 dept_id)
values ();



===============================================================================================
create table user
(
    id       int auto_increment comment 'ID'
        primary key,
    username varchar(30)       not null comment '用户名',
    name     varchar(10)       not null comment '姓名',
    age      int               null comment '年龄',
    gender   char default '男' null comment '性别',
    dept_id  int               null comment '部门ID',
    constraint username
        unique (username)
)
    comment '用户表' engine = InnoDB;

create index fk_user_dept_id
    on user (dept_id);

------------------------------------------------
insert into lixiong01.user (id, username, name, age, gender, dept_id)
values ();

===============================================================================================
create table emp_expr
(
    id      int unsigned auto_increment comment 'ID，主键'
        primary key,
    begin   date         null comment '开始日期',
    end     date         null comment '结束日期',
    company varchar(50)  null comment '公司名',
    job     varchar(50)  null comment '职位',
    emp_id  int unsigned null comment '员工ID'
)
    comment '工作经历表' engine = InnoDB;

-------------------------------------
insert into emp_expr (id, "begin", "end", company, job, emp_id)
values ();

INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (1, '2013-03-01', '2016-06-30', 'IBM', 'SE', 16);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (2, '2017-03-01', '2020-06-30', '爱神则', 'PM', 16);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (3, '2010-01-01', '2013-02-01', '东吴', '军师', 17);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (4, '2014-01-01', '2019-02-01', '西蜀', '军师辅佐', 17);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (7, '2010-01-01', '2013-02-01', '西凉军团', '马超之弟', 23);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (8, '2014-01-01', '2019-02-01', '西蜀', '猛将', 23);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (19, '2025-07-01', '2025-08-31', '西蜀', '2代将军，关羽之子', 33);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (23, '2025-08-03', '2025-09-26', '西蜀', '刘备联盟', 36);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (26, '2022-08-01', '2022-09-30', '西蜀', '西蜀创立者', null);
INSERT INTO lixiong01.emp_expr (id, begin, end, company, job, emp_id) VALUES (27, '2025-06-01', '2025-07-31', '西蜀', '称帝', null);


===============================================================================================
create table emp_log
(
    id           int unsigned auto_increment comment 'ID主键'
        primary key,
    operate_time datetime      null comment '操作时间',
    info         varchar(2000) null comment '日志信息'
)
    engine = InnoDB;

----------------------------------
insert into emp_log (id, operate_time, info)
values ();



===============================================================================================
------------------------------------------------------------------------
insert into dept values (
                        1,'教研部','2025-07-12 12:00:00','2025-07-12 12:00:00'
                        ),
                        (
                            2,'学工部','2025-07-12 12:00:00','2025-07-12 12:00:00'
                        ),
                        (
                            3,'研发部','2025-07-12 12:00:00','2025-07-12 12:00:00'
                        ),
                        (
                            4,'人事部','2025-07-12 12:00:00','2025-07-12 12:00:00'
                        ),
                        (5,'行政部','2025-07-12 12:00:00','2025-07-12 12:00:00'
                        ),
                        (
                            6,'后勤部','2025-07-12 12:00:00','2025-07-12 12:00:00'
                        ),
                        (7, '统战部', '2025-07-12 12:00:00', '2025-07-12 12:00:00');
insert into  emp values
                     (2,'GunaYu','123456','关羽',1,13672398766,1,8888,'2008-08-08','','2008-08-08 12:00:00','2008-08-08 12:00:00',2),
                     (3,'ZhangFei','123456','张飞',1,13672398767,1,8888,'2008-08-08','','2008-08-08 12:00:00','2008-08-08 12:00:00',2),
                     (4,'CaoCao','123456','曹操',1,13672398768,1,8888,'2008-08-08','','2008-08-08 12:00:00','2008-08-08 12:00:00',8),
                     (5,'SunQuan','123456','孙权',1,13672398769,1,8888,'2008-08-08','','2008-08-08 12:00:00','2008-08-08 12:00:00',8),
                     (6,'ZhaoYun','123456','赵云',1,13672398760,1,8888,'2008-08-08','','2008-08-08 12:00:00','2008-08-08 12:00:00',2),
                     (7,'Macao','123456','马超',1,13672398761,1,8888,'2008-08-08','','2008-08-08 12:00:00','2008-08-08 12:00:00',2),
                     (8,'Shimayi','123456','司马懿',1,13672398762,1,8888,'2008-08-08','','2008-08-08 12:00:00','2008-08-08 12:00:00',2)
