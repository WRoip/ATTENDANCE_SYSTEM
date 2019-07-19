begin transaction
update name 
SET n_sex='男',n_name='下周',n_year='19000' 
where n_id='003'
if @@Error>0
rollback transaction
else
commit transaction

alter table Attendance
alter column qiandao char(19)

alter table Attendance
alter column shichang char(12)

alter table Attendance
alter column id char(2)

alter table Attendance
add id char(1)

select * from Attendance
where gonghao='000' and qiantui=''

alter table Attendance
drop column id

alter table Salary
alter column zong float

select *
from Attendance
where gonghao='000' and riqi>='20180516' and riqi<='20180615' and qiantui<>'0'

select *
from name,Attendance
where Attendance.gonghao=name.n_id

select distinct n_id
from name,Attendance
where Attendance.gonghao=name.n_id
select *
from name,Attendance
where Attendance.gonghao=name.n_id and n_id='000'

select *,n_name rowid
from name,Attendance
where Attendance.gonghao=name.n_id

select * from Salary,name
where Salary.gonghao=n_id

select distinct gonghao
from Salary

SELECT distinct gonghao FROM Salary

delete Salary
where zhongzhi='20180901'

select * from Salary
where gonghao='000' and zhongzhi=(select MAX(zhongzhi) from Salary 
                                  where gonghao='000' and zhongzhi<>(select MAX(zhongzhi) from Salary 
                                                                      where gonghao='000'))
                                                                      
select * from Salary
where gonghao='000' and zhongzhi=(select MAX(zhongzhi) from Salary 
                                  where gonghao='000')



select distinct Salary.gonghao 工号,n_name as 姓名,qishi as 起始时间,zhongzhi 终止时间,zong 本周期总时长
from Salary,Attendance,name
where Salary.gonghao=Attendance.gonghao and name.n_id=Salary.gonghao and zhongzhi in(select max(zhongzhi) from Salary group by gonghao)

select distinct Salary.gonghao 工号,n_name as 姓名,qishi as 起始时间,zhongzhi 终止时间
from Salary,Attendance,name
where Salary.gonghao=Attendance.gonghao and name.n_id=Salary.gonghao
group by Salary.gonghao,n_name


select Salary.gonghao 工号,n_name as 姓名,max(qishi) as 起始时间,max(zhongzhi) 终止时间 
from Salary,Attendance,name
where exists (select gonghao,max(zhongzhi) from Salary group by gonghao)
group by Salary.gonghao,n_name





where  zhongzhi in (select distinct MAX(zhongzhi) from Salary group  by zhongzhi having COUNT(zhongzhi)>1)
group by zhongzhi,gonghao

select Salary.gonghao 工号,n_name 姓名,qishi 起始时间,zhongzhi 终止时间
from Salary,Attendance,name
group  by Salary.gonghao,n_name,qishi,zhongzhi
having COUNT(*)>1

begin transaction
update Salary
SET zong=52.5
where gonghao='000' and zhongzhi=(select MAX(zhongzhi) from Salary where gonghao='000')
if @@Error>0
rollback transaction
else
commit transaction

alter table Salary
alter column zong float