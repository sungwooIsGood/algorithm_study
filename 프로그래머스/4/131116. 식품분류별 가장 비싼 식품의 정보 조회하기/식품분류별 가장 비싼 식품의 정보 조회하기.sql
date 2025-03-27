select f.category, price as max_price, product_name
from food_product f
where f.category in ("김치","식용유","국","과자")
and f.price = (select max(price) 
                      from food_product b
                      where b.category = f.category)
order by f.price desc