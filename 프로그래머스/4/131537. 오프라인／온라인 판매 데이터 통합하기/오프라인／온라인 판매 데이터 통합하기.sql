select date_format(sales_date,"%Y-%m-%d") AS SALES_DATE,
       PRODUCT_ID,
       USER_ID,
       SALES_AMOUNT
from online_sale
where sales_date like '2022-03%'
union all
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d'),
       PRODUCT_ID,
       NULL,
       SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE LIKE '2022-03%'
ORDER BY 1, 2, 3