Select customer_id, max(purchase_amount) from orders group by customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders group by 
customer_id,order_date HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);