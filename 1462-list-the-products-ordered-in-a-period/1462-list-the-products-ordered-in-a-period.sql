/* Write your PL/SQL query statement below */
select product_name , sum(unit) as unit
from products p left outer join orders o
on p.product_id = o.product_id
where order_date like '2020-02%'
group by p.product_name
having sum(unit) >= 100;