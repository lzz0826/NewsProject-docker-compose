 // 下架
 function takeDown(id) {
     // let id = $("#takeDown").val();
     $.ajax({
         url: '/api/News/update/stateModify',
         type: 'POST',
         dataType: 'json',
         data: {
             "id": id,
             "releaseState": 1
         },
         success: function(result) {
             console.log(result);
             window.location.reload();
         },
         error: function(msg) {
             console.log(msg);
         }
     });
 }

 // 上架
 function onTheShelf(id) {
     // let id = $("#takeDown").val();
     $.ajax({
         url: '/api/News/update/stateModify',
         type: 'POST',
         dataType: 'json',
         data: {
             "id": id,
             "releaseState": 0
         },
         success: function(result) {
             console.log(result);
             window.location.reload();

         },
         error: function(msg) {
             console.log(msg);
         }
     });
 }

 // 軟刪除
 function falseDel(id) {
     // let id = $("#takeDown").val();
     $.ajax({
         url: '/api/News/update/stateModify',
         type: 'POST',
         dataType: 'json',
         data: {
             "id": id,
             "releaseState": 2
         },
         success: function(result) {
             console.log(result);
             window.location.reload();

         },
         error: function(msg) {
             console.log(msg);
         }
     });
 }

 // 真實刪除
 function delNewsById(id) {
     // let id = $("#takeDown").val();
     $.ajax({
         url: '/api/News/delete/deleteNews',
         type: 'POST',
         dataType: 'json',
         data: {
             "id": id,
         },
         success: function(result) {
             window.location.reload();
             console.log(result['data']);

         },
         error: function(msg) {
             window.location.reload();
             console.log(msg);
         }
     });
 }





 $(function() {
     $('.title').click(function() {})
     $(document).ready(function() {
         let page = window.location.search.toString().split("=")[1];
         let tag;
         try {
             tag = window.location.search.toString().split("=")[1].split("&")[1];
         } catch (e) {
             tag = null;
         }
         if (page == null) {
             page = 1;
         }
         console.log(page);
         $("#newsMain").empty(); // 查詢時清空前次紀錄
         $("#pages").empty();

         if (tag == null) {

             newsList(page);
         } else {
             page = window.location.search.toString().split("=")[1].split("&")[0];
             tag = window.location.search.toString().split("=")[1].split("&")[1];
             if (page == null) {
                 page = 1;
             }

             tagPage(page, tag);
         }
     });

     var newsList = function(page) {
         $.ajax({
             url: 'api/News/search/getAllNews/' + page,
             type: 'get',
             success: function(res) {
                 let tbody = $("#newsMain");
                 let tbodyPage = $("#pages");
                 newRecord = res['data']['records'];
                 pageRecord = res['data'];
                 // console.log(res[0].releaseState);
                 console.log(newRecord);
                 console.log(pageRecord.size);
                 console.log(res.magmessage);

                 for (i in newRecord) {
                     let releaseState = newRecord[i].releaseState;
                     if (releaseState == 0) {
                         releaseState = '上架中';
                     } else {
                         releaseState = '*以下架*';
                     }
                     let div;
                     div =
                         '<div class="news-list-item clearfix">' +
                         '<div class="col-xs-10">' +
                         //  '<h3>' + res[i].title + '</h3>'+
                         '<a href="newsAdmin?no=' + newRecord[i].id + '" class="title">' + newRecord[i].title + '(詳細內容)' + '</a>' +
                         '<div>' + '標籤:' + newRecord[i].tag + '</div>' +
                         '<div class="info">' +
                         '<span>' + ' ID:' + newRecord[i].id + '</span>' +
                         '<span>' + ' 作者:' + newRecord[i].author + '</span>' +
                         '<span>' + ' 創建時間:' + newRecord[i].createTime + '</span>' +
                         '</div>' +
                         '</div>' +
                         '<div class="col-xs-2">' +
                         '<div>' +
                         '<h4>' + releaseState + '</h4>' +
                         '<input type = "button" value = "下架" onclick = "takeDown( ' + newRecord[i].id + ' );">' +
                         '<input type = "button" value = "上架" onclick = "onTheShelf( ' + newRecord[i].id + ' );">' +
                         '<input type = "button" value = "刪除" onclick = "delNewsById( ' + newRecord[i].id + ' );">' +
                         '</div>' +
                         '</div class="col-xs-2">' +
                         '</div>';
                     tbody.append('<div>' + div + '</div>');
                 };
                 for (let i = 1; i < pageRecord.pages + 1; i++) {
                     let a;
                     a =
                         '<a href="indexAdmin?no=' + [i] + '" class="btn btn-primary" role="button">' + [i] + '<span>' + '.' + '</span>' + '</a>';
                     tbodyPage.append('<a>' + a + '</a>');
                 }
             },

             error: function(res) {
                 console.log(res);
             }
         });

     }

     var tagPage = function(page, tag) {
         $.ajax({
             url: 'api/News/search/getNewsManyAllDownByTag/' + tag + '/' + page,
             type: 'get',
             dataType: 'json',
             success: function(res) {
                 let tbody = $("#newsMain");
                 let tbodyPage = $("#pages");
                 newRecord = res['data']['records'];
                 pageRecord = res['data'];
                 // console.log(res[0].releaseState);
                 console.log(newRecord);
                 console.log(pageRecord.size);
                 console.log(res.magmessage);

                 for (i in newRecord) {
                     let releaseState = newRecord[i].releaseState;
                     if (releaseState == 0) {
                         releaseState = '上架中';
                     } else {
                         releaseState = '*以下架*';
                     }
                     let div;
                     div =
                         '<div class="news-list-item clearfix">' +
                         '<div class="col-xs-10">' +
                         //  '<h3>' + res[i].title + '</h3>'+
                         '<a href="newsAdmin?no=' + newRecord[i].id + '" class="title">' + newRecord[i].title + '(詳細內容)' + '</a>' +
                         '<div>' + '標籤:' + newRecord[i].tag + '</div>' +
                         '<div class="info">' +
                         '<span>' + ' ID:' + newRecord[i].id + '</span>' +
                         '<span>' + ' 作者:' + newRecord[i].author + '</span>' +
                         '<span>' + ' 創建時間:' + newRecord[i].createTime + '</span>' +
                         '</div>' +
                         '</div>' +
                         '<div class="col-xs-2">' +
                         '<div>' +
                         '<h4>' + releaseState + '</h4>' +
                         '<input type = "button" value = "下架" onclick = "takeDown( ' + newRecord[i].id + ' );">' +
                         '<input type = "button" value = "上架" onclick = "onTheShelf( ' + newRecord[i].id + ' );">' +
                         '<input type = "button" value = "刪除" onclick = "delNewsById( ' + newRecord[i].id + ' );">' +
                         '</div>' +
                         '</div class="col-xs-2">' +
                         '</div>';
                     tbody.append('<div>' + div + '</div>');
                 };
                 for (let i = 1; i < pageRecord.pages + 1; i++) {
                     let a;
                     a =
                         '<a href="indexAdmin?no=' + [i] + '&' + tag + '" class="btn btn-primary" role="button">' + [i] + '<span>' + '.' + '</span>' + '</a>';
                     tbodyPage.append('<a>' + a + '</a>');
                 }
             },
             error: function(msg) {
                 console.log(msg);
             }
         });
     }




     // TAG sports
     $("#sports").click(function() {
         $("#newsMain").empty(); // 查詢時清空前次紀錄
         $("#pages").empty();
         let page = window.location.search.toString().split("=")[1];

         try {
             tag = window.location.search.toString().split("=")[1].split("&")[1];
         } catch (e) {
             tag = null;
         }
         if (page == null) {
             page = 1;
         }
         if (tag == null) {

             tag = '運動';
         }
         tagPage(page, tag);
     });

     // TAG politicsInput
     $("#politics").click(function() {
         $("#newsMain").empty(); // 查詢時清空前次紀錄
         $("#pages").empty();
         let page = window.location.search.toString().split("=")[1];

         try {
             tag = window.location.search.toString().split("=")[1].split("&")[1];
         } catch (e) {
             tag = null;
         }
         if (page == null) {
             page = 1;
         }
         if (tag == null) {

             tag = '政治';
         }
         tagPage(page, tag);
     });

     // TAG game
     $("#game").click(function() {
         $("#newsMain").empty(); // 查詢時清空前次紀錄
         $("#pages").empty();
         let page = window.location.search.toString().split("=")[1];

         try {
             tag = window.location.search.toString().split("=")[1].split("&")[1];
         } catch (e) {
             tag = null;
         }
         if (page == null) {
             page = 1;
         }
         if (tag == null) {

             tag = '遊戲';
         }
         tagPage(page, tag);
     });


     // TAG entertainment
     $("#entertainment").click(function() {
         $("#newsMain").empty(); // 查詢時清空前次紀錄
         $("#pages").empty();
         let page = window.location.search.toString().split("=")[1];

         try {
             tag = window.location.search.toString().split("=")[1].split("&")[1];
         } catch (e) {
             tag = null;
         }
         if (page == null) {
             page = 1;
         }
         if (tag == null) {

             tag = '娛樂';
         }
         tagPage(page, tag);
     });



     // 新增
     $("#createNewsById").click(function() {

         let title = $("#createTitle").val();
         let author = $("#createAuthor").val();
         let content = $("#createContent").val();


         $.ajax({
             url: 'API_createNewsById',
             type: 'POST',
             dataType: 'json',
             data: {
                 "title": title,
                 "author": author,
                 "content": content,
             },
             success: function(result) {
                 console.log(result);
             },
             error: function(msg) {
                 console.log(msg);
             }
         });
     });
 });