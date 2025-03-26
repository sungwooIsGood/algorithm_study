# select cart_id
# from cart_products
# where name in('Milk','Yogurt')
# group by cart_id
# having count(cart_id) >= 2

SELECT
    CART_ID
FROM
    CART_PRODUCTS
where name in('Milk','Yogurt')
GROUP BY
    CART_ID
HAVING
    COUNT(DISTINCT NAME) >= 2