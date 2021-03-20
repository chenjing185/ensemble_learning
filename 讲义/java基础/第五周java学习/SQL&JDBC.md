# SQL&JDBC

## SQL

```sql
-- 插入数据
insert into emp(empno,ename,sal,hiredate,comm,job,deptid) values(7839,'JAMES',3000,'2019-02-23',null,'DEVELOPER',1);

-- 经理编号为7820(mgr)
update emp set mgr=7820 where empno=7839

-- 查询所有的员工信息
select * from emp

-- 查询员工编号和姓名
select empno,ename from emp

-- 别名
select empno 编号,ename 姓名 from emp

-- 按照工资从高到低排列所有员工信息(desc 高->低 asc 低->高)
select empno,ename,sal from emp order by sal desc

-- 查询部门编号为1的员工信息
select empno,ename,deptid from emp where deptid=1

-- 查找员工James的相关信息
select empno,ename,sal from emp where ename='JAMES'

-- 查询员工工作岗位(唯一显示)
select distinct job from emp 

-- 查询工资在3000-5000的员工信息
select empno,ename,sal from emp where sal>=3000 and sal<=5000;
-- between and包含临界值
select empno,ename,sal from emp where sal between 3000 and 5000;

-- 查询工作是销售和开发人员的信息
select empno,ename,job from emp where job='SALESMAN' or job='DEVELOPER'
-- in
select empno,ename,job from emp where job in ('SALESMAN','DEVELOPER')
-- 查询部门编号为1,2,3部门员工的信息
select empno,ename,deptid from emp where deptid in (1,2,3)

-- 名字中带有A字母的员工信息(%通配符 _通配单个字母)
select empno,ename from emp where ename like '%A%'

-- 第二个字母为A的员工信息
select empno,ename from emp where ename like '_A%';

-- 求公司的平均工资 (聚合函数)
select avg(sal) from emp;
-- 总工资
select sum(sal) from emp;
-- 总人数
select count(*) from emp;
-- 公司的总奖金
select sum(comm) from emp;
-- 公司的平均奖金,聚合函数会忽略所有空值
select avg(comm) from emp;

-- 每个部门的平均工资
select deptid,avg(sal) from emp group by deptid

-- 求平均工资高于等于4000的部门编号
select deptid,avg(sal) from emp group by deptid having avg(sal)>=4000 ORDER BY 2
```

## JDBC

数据库连接接口,它规定了一系列的接口,来规范数据库的连接操作.

* Connection:数据库连接
* PreparedStatement:预编译SQL语句
* ResultSet:结果集

连接步骤

1. 注册驱动
2. 通过驱动获取数据库连接
3. 通过连接来创建预编译sql语句
4. 执行操作
5. 获取结果
6. 关闭数据库连接对象

### 下载驱动

baidu:maven mysql jdbc



选择5.1.49即可.

