select year(o.sales_date) as year, month(o.sales_date) as month, u.gender as gender, count(distinct u.user_id) as users
from online_sale o
inner join user_info u
on o.user_id = u.user_id
where u.gender is not null
group by year(o.sales_date), month(o.sales_date), u.gender
order by year(o.sales_date) asc, month(o.sales_date) asc, u.gender asc