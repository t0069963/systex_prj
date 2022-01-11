-- 全部查詢
SELECT * FROM agriproductstranstype2;
-- 查詢最新一筆
SELECT * FROM fisheryproductstranstype ORDER BY TransDate DESC LIMIT 1;
-- 查詢最早一筆
SELECT * FROM fisheryproductstranstype ORDER BY TransDate ASC LIMIT 1;
-- 設置連結束為1000否則爬蟲會報錯Too many connections
set global max_connections=1000;
show variables like 'max_connections';

CREATE TABLE IF NOT EXISTS agriproductstranstype(id int NOT NULL AUTO_INCREMENT, TransDate date, 
CropCode varchar(10), 
CropName varchar(20),
MarketCode int(3),
MarketName varchar(10),
Avg_Price DOUBLE,
Trans_Quantity DOUBLE,
PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS FisheryProductsTransType(id int NOT NULL AUTO_INCREMENT, TransDate date, 
CropCode varchar(10), 
CropName varchar(20),
MarketCode int(3),
MarketName varchar(10),
Avg_Price DOUBLE,
Trans_Quantity DOUBLE,
PRIMARY KEY(id));

INSERT INTO `agriproductstranstype` (`TransDate`, `CropCode`, `CropName`, `MarketCode`, `MarketName`, `Avg_Price`, `Trans_Quantity`) VALUES ('2010-04-01', '0', '0', '0', '0', '0', '0');

-- 起始時間~結束時間農產品查詢"椰子"在"台北二"這個市場中的平均交易量、最大交易量、最低交易量
SELECT CropName,MarketName,AVG(Trans_Quantity),max(Trans_Quantity),min(Trans_Quantity) FROM `agriproductstranstype` where MarketName = "台北二" and CropName = "椰子" and TransDate >='2020-01-02' and TransDate <='2021-10-04' ;


-- 輸入指定日期，顯示這一天漁產品的總交易金額跟農產品交易總交易金額大小。
SELECT TransDate,sum(Trans_Quantity*Avg_Price) From `agriproductstranstype` where TransDate = '2021-07-02';
SELECT TransDate,sum(Trans_Quantity*Avg_Price) From `fisheryproductstranstype` where TransDate = '2021-07-02';


-- 輸入指定日期跟市場與農產品，顯示過去五天的交易量是否為"嚴格遞增"
SELECT Trans_Quantity,TransDate  from `agriproductstranstype` where  TransDate >= date_sub('2021-07-03',INTERVAL 5 DAY) and TransDate <= '2021-07-03'and MarketName ="台北二" and CropName = "椰子" ORDER BY TransDate ASC;
SELECT Trans_Quantity,TransDate  from `agriproductstranstype` where  TransDate >= date_sub('2021-07-03',INTERVAL 2 DAY) and TransDate <= '2021-07-03'and MarketName ="台北二" and CropName = "椰子" ORDER BY TransDate ASC;


-- 輸入指定月份，顯示當月最暢銷（總交易量）前10名的農產品（不分市場）（當月 Example 10月=10月1號~10月31號）。 -- 2021/07
SELECT CropName, sum(Trans_Quantity) AS total_Quantity FROM  `agriproductstranstype` where month(TransDate)='07'and year(TransDate)="2021" GROUP BY CropName ORDER BY total_Quantity DESC Limit 10;


-- 其他
-- select  distinct CropName  from agriproductstranstype where month(TransDate)='07'and year(TransDate)="2021" ORDER BY Trans_Quantity DESC Limit 10;
-- SELECT CropName,SUM(month(TransDate)='07'and year(TransDate) = '2021') AS Trans_Quantity 
-- FROM agriproductstranstype 
-- ORDER BY Trans_Quantity;
-- SELECT Trans_Quantity,TransDate from `agriproductstranstype` where  TransDate >= '2021-07-02' and TransDate <= '2021-07-07'  and MarketName ="台北二" and CropName = "椰子" ORDER BY Trans_Quantity ASC;
-- SELECT DATE_SUB('2021-07-07',INTERVAL 5 DAY);
-- select Trans_Quantity-(ROW_NUMBER() OVER(ORDER BY Trans_Quantity)) from `agriproductstranstype` where  TransDate >= date_sub('2021-07-07',INTERVAL 5 DAY) and TransDate <= '2021-07-07'and MarketName ="台北二" and CropName = "椰子" ORDER BY TransDate ASC;
