# Write your MySQL query statement below
# select name as customers from customers 
# left join orders on orders.id=customers.id 
# having orders.id=null;
SELECT Name AS Customers
FROM CUSTOMERS
LEFT JOIN ORDERS
ON ORDERS.CustomerID = Customers.Id
WHERE Orders.CustomerID IS NULL