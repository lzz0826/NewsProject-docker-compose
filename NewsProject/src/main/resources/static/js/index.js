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
            url: 'api/News/search/getNewsManyByPublic/' + page,
            type: 'get',
            success: function(res) {
                let tbody = $("#newsMain");
                let tbodyPage = $("#pages");
                newRecord = res['data']['records'];
                pageRecord = res['data'];
                console.log(newRecord);
                console.log(pageRecord.size);
                console.log(res.magmessage);

                for (i in newRecord) {
                    let div;
                    div =
                        '<div class="news-list-item clearfix">' +
                        '<div class="col-xs-12">' +
                        '<a href="news?no=' + newRecord[i].id + '" class="title">' + newRecord[i].title + '</a>' +
                        '<div>' + '標籤:' + newRecord[i].tag + '</div>' +
                        '<div class="info">' +
                        '<span>' + ' ID:' + newRecord[i].id + '</span>' +
                        '<span>' + ' 作者:' + newRecord[i].author + '</span>' +
                        '<span>' + ' 創建時間:' + newRecord[i].createTime + '</span>' +
                        '</div>' +
                        '</div>' +
                        '</div>';
                    tbody.append('<div>' + div + '</div>');
                };
                for (let i = 1; i < pageRecord.pages + 1; i++) {
                    let a;
                    a =
                        '<a href="index?no=' + [i] + '" class="btn btn-primary" role="button" >' + [i] + '<span>' + '.' + '</span>' + '</a>';
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
            url: 'api/News/search/getNewsManyByTag/' + tag + '/' + page,
            type: 'get',
            dataType: 'json',
            success: function(res) {
                let tbody = $("#newsMain");
                let tbodyPage = $("#pages");
                newRecord = res['data']['records'];
                pageRecord = res['data'];
                console.log(newRecord);
                console.log(pageRecord.size);
                console.log(res.magmessage);
                for (i in newRecord) {
                    let div;
                    div =
                        '<div class="news-list-item clearfix">' +
                        '<div class="col-xs-12">' +
                        '<a href="news?no=' + newRecord[i].id + '" class="title">' + newRecord[i].title + '</a>' +
                        '<div>' + '標籤:' + newRecord[i].tag + '</div>' +
                        '<div class="info">' +
                        '<span>' + ' ID:' + newRecord[i].id + '</span>' +
                        '<span>' + ' 作者:' + newRecord[i].author + '</span>' +
                        '<span>' + ' 創建時間:' + newRecord[i].createTime + '</span>' +
                        '</div>' +
                        '</div>' +
                        '</div>';
                    tbody.append('<div>' + div + '</div>');
                };
                for (let i = 1; i < pageRecord.pages + 1; i++) {
                    let a;
                    a =
                        '<a href="index?no=' + [i] + '&' + tag + '" class="btn btn-primary" role="button">' + [i] + '<span>' + '.' + '</span>' + '</a>';
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
        let page = 1;

        try {
            tag = window.location.search.toString().split("=")[1].split("&")[1];
        } catch (e) {
            tag = null;
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
        let page = 1;

        try {
            tag = window.location.search.toString().split("=")[1].split("&")[1];
        } catch (e) {
            tag = null;
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
        let page = 1;

        try {
            tag = window.location.search.toString().split("=")[1].split("&")[1];
        } catch (e) {
            tag = null;
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
        let page = 1;

        try {
            tag = window.location.search.toString().split("=")[1].split("&")[1];
        } catch (e) {
            tag = null;
        }
        if (tag == null) {

            tag = '娛樂';
        }
        tagPage(page, tag);
    });








    // 修改
    $("#updateNewsById").click(function() {
        $.ajax({
            url: 'API_updateNewsById',
            type: 'POST',
            dataType: 'json',
            data: {
                "id": 1
            },
            success: function(result) {
                console.log(result);
            },
            error: function(msg) {
                console.log(msg);
            }
        });
    });
    // 刪除
    $("#deleteNewsById").click(function() {
        $.ajax({
            url: 'API_deleteNewsById',
            type: 'POST',
            dataType: 'json',
            data: {
                "id": 1
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