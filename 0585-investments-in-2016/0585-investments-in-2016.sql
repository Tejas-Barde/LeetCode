/* Write your PL/SQL query statement below */
with cte as (
    select tiv_2016
    from insurance i1
    where tiv_2015 in (select tiv_2015 from insurance i2 where i1.pid <> i2.pid )
    and (lat , lon) not in (select lat,lon from insurance i2 where i1.pid<>i2.pid)
)

select tiv_2016
from (
    select sum(tiv_2016) over (order by tiv_2016) as tiv_2016 
    from cte
    order by tiv_2016 desc 
)
where rownum = 1;