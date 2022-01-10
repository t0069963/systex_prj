# Java實作題目
### 題目 : 
從農糧署的API中取得資料存入資料庫，並且做出一介面能針對以下做出查詢

- [x] 1. 輸入起始時間跟結束時間，顯示這段時間農產品中的"椰子"在"台北二"這個市場中的平均交易量、最大交易量、最低交易量。
- [x] 2. 輸入指定日期，顯示這一天漁產品的總交易金額跟農產品交易總交易金額大小。
- [x] 3. 輸入指定日期跟市場與農產品，顯示過去五天的交易量是否為"嚴格遞增"。
- [x] 4. 輸入指定月份，顯示當月最暢銷（總交易量）前10名的農產品（不分市場）（當月 Example 10月=10月1號~10月31號）。
### 目標 : 
呈現方法 可以考慮以下
- [ ] 1. Web UI
- [x] 2. 軟體 UI
- [ ] 3. Web API
- [ ] 4. Command Line
### 想法:
1. 先查看所需API 決定使用 漁產品交易行情 和 農產品交易行情 
- 理由:兩個JSON的架構極為相似除了漁產品少了**MarketCode**其他都可以找到可互換的 
2. 決定不要使用 Foreign Key
- 理由:此題目SQL語法只有 查詢 跟 插入 因此沒有做到修改不需要Foreign Key
- 增加 插入 的效能
3. 決定使用軟體UI
- 理由:較為熟悉
4. 使用MySQL 
- 理由:PostgreSQL沒有使用過不敢冒風險
## 題目分析:
1. 輸入起始時間跟結束時間，顯示這段時間農產品中的"椰子"在"台北二"這個市場中的平均交易量、最大交易量、最低交易量。
- 輸入: 
- 起始時間 、 結束時間 、 產品 、 市場
輸出: 
- 平均交易量 、 最大交易量 、 最低交易量 、(產品)、 (市場)
2. 輸入指定日期，顯示這一天漁產品的總交易金額跟農產品交易總交易金額大小。
- 輸入: 
-  指定的時間
- 輸出:
- 農產品交易總交易金額 、 漁產品的總交易金額
3. 輸入指定日期跟市場與農產品，顯示過去五天的交易量是否為"嚴格遞增"。
- 輸入:
- 指定日期 、 市場 、 農產品
- 輸出:  
- 是 或 否
4. 輸入指定月份，顯示當月最暢銷（總交易量）前10名的農產品（不分市場）（當月 Example 10月=10月1號~10月31號）。
- 輸入:
- 指定月份 、 指定年份
- 輸出:
- 十個農產品 、 (總交易量)
## 架構流程:
主程式:<br>
![流程圖 drawio](https://user-images.githubusercontent.com/77679082/148719897-7eb94d9d-8f8c-4f71-8b06-d9e816a84fbc.png)  
爬蟲程式:<br>
![爬蟲流程圖 drawio](https://user-images.githubusercontent.com/77679082/148483350-85f0dcf4-f9ac-4cf5-b442-0494bd942a7f.png)  
```sql
CREATE TABLE IF NOT EXISTS agriproductstranstype(id int NOT NULL AUTO_INCREMENT, TransDate date, 
CropCode varchar(10), 
CropName varchar(20),
MarketCode int(3),
MarketName varchar(10),
Avg_Price DOUBLE,
Trans_Quantity DOUBLE,
PRIMARY KEY(id));
```
```sql
CREATE TABLE IF NOT EXISTS FisheryProductsTransType(id int NOT NULL AUTO_INCREMENT, TransDate date, 
CropCode varchar(10), 
CropName varchar(20),
MarketCode int(3),
MarketName varchar(10),
Avg_Price DOUBLE,
Trans_Quantity DOUBLE,
PRIMARY KEY(id));
```
- SQL 名稱及使用型態說明  
取一樣名子只是為了修改程式方便.  
TransDate 用data是因為第四題需要分別使用年和月故切割比較方便.  
CropCode 是因為當初不知容量故選比較占容量比較小的varchar.  
CropName 同上.  
MarketCode而是 農產市場資料 這份資料來看沒有超過3.  
MarketName 同CropCode.  
Avg_Price & Trans_Quantity 因為需要計算故使用精度較高的DOUBLE.  
至於原API內的**Upper_Price** 、 **Middle_Price** 、 **Lower_Price** 因為沒用到所以不輸入資料庫.  


## 尚未實現功能
> 開啟主程式並從資料庫爬取最近一天 和 當天作比對假設家同則不進行爬取
## 其他問題
Q:為何要一天一天撈且不再進行三次迴圈撈取更多資料  
A:因為不確定再加上何種參數可以完整撈完資料故統一每次只撈一天  
Q:TLS版本不符合  
javax.net.ssl.SSLException: Connection reset  
A:com 輸入以下
```undefined
java -Dhttps.protocols=SSLv3
```
Q:爬蟲爬到空白頁  
java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0  
A:判斷JSONArray大小為0 結束當次迴圈跳至下一天  
 ```java
 if (a.size()==0){
                    continue;
                }
```
Q:爬蟲時報錯
Too many connections  
A:修改最大連結數 1000是因為爬一天的數量為1000筆  
```sql
set global max_connections=1000;
show variables like 'max_connections';
```
## 所使用版本
MySQL資料庫 -8.0.27
JAVA -11
json-simple-1.1.1
mysql-connector-java-8.0.27
