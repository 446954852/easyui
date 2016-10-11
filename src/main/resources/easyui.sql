//添加唯一约束
alter table user add constraint username_uni unique(username);
// 删除约束
alter table user drop index username_uni;
// user表增加日期字段
alter table user add createDateTime date;
alter table user add modifyDateTime date;
alter table user MODIFY createDateTime datetime;
alter table user MODIFY modifyDateTime datetime;