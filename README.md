# NewsProject-docker-compose


這是一個包含前.後端新聞網頁的專案<br />
並架設在 docker-compose 上快速部屬 <br />
包含客戶端顯示,以及後臺登入 增.刪.改.查<br />


## 使用套件:

後端:   1.MyBatis-Plus
        2.flyway
        3.spring boot security
        
        
前端:   1.bootstrap 2.JavaScript 3.jquery

## 實例使用說明:

**需先行安裝 docekr & docker-compose**<br />
**測試帳號:root **<br />
**測試密碼:123456 **<br />


1.  mkdir /mydocker    **創一個路徑**

2.  mkdir opt     **進到/mydocker後再創 opt 路徑**

3.  cd opt       **到opt 路徑內把 (news.jar) 檔放進去  -可以先安裝 yum install lrzsz 使用拖拉功能**

4. cd ..    **回到 mydocker路徑再把 (docker-compose.yml) 放進去**

5.  docker-compose up -d    **啟動 dokcer-compose**

**如出現以下問題<br />
ERROR: for mysql  Cannot start service mysql: failed to create shim task: OCI runtime create 
failed: runc create failed: unable to start container process: error during container init: 
error mounting "/app/mysql/conf/my.cnf" to rootfs at "/etc/my.cnf": mount /app/mysql/conf/my.
cnf:/etc/my.cnf (via /proc/self/fd/6), flags: 0x5000: not a directory: unknown: Are you trying
to mount a directory onto a file (or vice-versa)? Check if the specified host path exists and 
is the expected type

這是因為掛出來的(宿主機)路徑下的 my.cnf 並不是文件檔,mysql無法取得 my.cnf 裡的設定

**

6. cd /app/mysql/conf    **進到 宿主機下的 conf路徑**

7. rm -r my.cnf    **刪除 my.cnf 路徑(我們要的是文件檔)**

8. vim my.cnf     **建立一個 my.cnf 檔 輸入以下內容**
--------------------------------------------------------
[mysqld]<br />
datadir=/var/lib/mysql<br />
socket=/var/lib/mysql/mysql.sock<br />
#Disabling symbolic-links is recommended to prevent assorted security risks<br />
symbolic-links=0<br />
#Settings user and group are ignored when systemd is used.<br />
#If you need to run mysqld under a different user or group,<br />
#customize your systemd unit file for mariadb according to the<br />
#instructions in http://fedoraproject.org/wiki/Systemd<br />

[mysqld_safe]<br />
log-error=/var/log/mariadb/mariadb.log<br />
pid-file=/var/run/mariadb/mariadb.pid<br />

#include all files from the config directory<br />
!includedir /etc/my.cnf.d<br />

------------------------------------------------------------------


9. cd /app     **再回到 app 路徑下**

10. mkdir java     **創建 java 目錄在把 (application.yml) 放到裡面**

11. cd /mydocker     **回到 mydocker 路徑下**

12. docker-compose down     **先關閉所有容器**

13. docker-compose up -d    **重新啟動**

14. docker ps  **查看容器是否正常啟動** 

*第一次在創建 'flywayInitializer' 資料表時 有可能失敗


15. docker-compose down  & docker-compose up -d   **再次重啟 docker-compose**

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









