# NewsProject-docker-compose


這是一個包含前.後端新聞網頁的專案<br />
並架設在 docker-compose 上快速部屬 <br />
包含客戶端顯示,以及後臺登入 增.刪.改.查<br />


## 使用套件:

後端:   1.MyBatis-Plus
        2.flyway
        3.spring boot security
        
        
前端:   1.bootstrap 2.JavaScript 3.jquery

## 使用說明:

**需先行安裝 docekr & docker-compose**<br />
**測試帳號:root **<br />
**測試密碼:123456 **<br />


1.  下載 mydocker 資料夾

2.  使用CMD cd mydocker  到 mydocker 裡

3.  輸入 docker-compose up -d 啟動

4.  第一次啟動時 Spring boot - flyway 會先丟資料到 mysql 後停止

5.  docker-compose up -d  再次啟動


如成功啟動: 網址 : 宿主機IP:8080  

# 範例圖:

![image](https://github.com/lzz0826/NewsProject-docker-compose/blob/main/%E7%AF%84%E4%BE%8B%E5%9C%96/%E7%99%BB%E5%85%A5.jpg)
# 新增
![image](https://github.com/lzz0826/NewsProject-docker-compose/blob/main/%E7%AF%84%E4%BE%8B%E5%9C%96/%E6%96%B0%E5%A2%9E.jpg)
# 修改
![image](https://github.com/lzz0826/NewsProject-docker-compose/blob/main/%E7%AF%84%E4%BE%8B%E5%9C%96/%E4%BF%AE%E6%94%B9.png)
# 上下架
![image](https://github.com/lzz0826/NewsProject-docker-compose/blob/main/%E7%AF%84%E4%BE%8B%E5%9C%96/%E5%88%AA%E9%99%A4.jpg)
# 首頁
![image](https://github.com/lzz0826/NewsProject-docker-compose/blob/main/%E7%AF%84%E4%BE%8B%E5%9C%96/001.jpg)
# 內容
![image](https://github.com/lzz0826/NewsProject-docker-compose/blob/main/%E7%AF%84%E4%BE%8B%E5%9C%96/003.png)









