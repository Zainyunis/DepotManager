drop table if exists goods;

drop table if exists house;

drop table if exists shelf;

drop table if exists storage_location;

drop table if exists title;

drop table if exists user;

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
    id                   int not null auto_increment,
    SN                   nvarchar(500) not null,
    name                 nvarchar(500) not null,
    specification        nvarchar(500) comment '“包装规格”要素，应注明具体包装和规格（单位包装容量×每包装单位数/包装单位），如750毫升×6瓶 /箱。',
    unit                 varchar(50),
    unit_weight          float,
    notes                nvarchar(500),
    is_deleted           int not null default 0,
    primary key (id)
);

/*==============================================================*/
/* Table: house                                                 */
/*==============================================================*/
create table house
(
    id                   int not null auto_increment comment '表主键',
    name                 nvarchar(500) not null,
    SN                   nvarchar(500) not null,
    notes                nvarchar(500),
    is_deleted           int not null default 0 comment '逻辑删除，1表示删除，0表示未删除',
    primary key (id)
);

alter table house comment '仓库信息';

/*==============================================================*/
/* Table: shelf                                                 */
/*==============================================================*/
create table shelf
(
    id                   int not null auto_increment,
    SN                   nvarchar(500) not null,
    total_row            int not null default 3,
    total_cal            int not null default 1,
    max_load             float,
    positionX            float not null default 0,
    positionZ            float not null default 0,
    bottom_height        float not null default 0,
    bin_length           float not null default 0,
    bin_width            float not null default 0,
    bin_height           float not null default 0,
    house_id             int not null,
    primary key (id)
);

/*==============================================================*/
/* Table: storage_location                                      */
/*==============================================================*/
create table storage_location
(
    id                   int not null auto_increment,
    shelf_id             int not null,
    row                  int not null default 1,
    col                  int not null default 1,
    SN                   nvarchar(500) not null,
    positionY            float not null default 0,
    is_load              int not null default 0,
    max_load             float,
    goods_SN             nvarchar(500) not null,
    amount               int,
    operation_date       time,
    primary key (id)
);

/*==============================================================*/
/* Table: title                                                 */
/*==============================================================*/
create table title
(
    id                   int not null auto_increment,
    title                nvarchar(50) not null,
    primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
    id                   int not null auto_increment,
    name                 nvarchar(50),
    account              char(11) not null,
    tel                  char(11),
    password             char(32) not null,
    visit_power          int not null default 0,
    is_deleted           int not null default 0,
    creat_time           timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    title_id             int not null default 0,
    primary key (id)
);
