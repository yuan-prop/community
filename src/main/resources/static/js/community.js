/**
 * 提交一级评论
 */
function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2Target(questionId, 1, content);
}

/**
* 提交二级评论
*/
function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-"+commentId).val();
    comment2Target(commentId, 2, content);
}

function comment2Target(targetId, type, content) {

    if(!content){
        alert("不能回复空内容~~");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId":targetId,
            "content":content,
            "type":type
        }),
        success: function (response) {
            if(response.code == 200){
                //$("#comment_section").hide();
                window.location.reload();
            }else{
                if(response.code == 2003){
                    var isAccepted = confirm(response.message);
                    if(isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=85c7e97a8145959f1706&redirect_uri=http://localhost:8080/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                }else{
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
}

/**
 * 展开二级评论
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);

    //获取二级评论展开状态
    if(comments.hasClass("in")){
        //折叠二级评论
        comments.removeClass("in");
    }else{
        var subCommentContainer = $("#comment-"+id);
        if(subCommentContainer.children().length !=1) {
            //展开二级评论
            comments.addClass("in");
        }else{
            //加载二级评论的数据后渲染到页面
            $.getJSON( "/comment/"+id, function(data) {
                $.each( data.data.reverse(), function(index, comment) {
                    var mediaLeftEle = $( "<div/>", {
                        "class": "media-left"
                    }).append($( "<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.avatarUrl
                    }));

                    var mediaBodyEle = $( "<div/>", {
                        "class": "media-body"
                    }).append($( "<h5/>", {
                        "class": "media-heading",
                        "html": comment.user.name
                    })).append($( "<div/>", {
                        "html": comment.content
                    })).append($( "<div/>", {
                        "class": "menu"
                    })).append($( "<span/>", {
                        "class": "pull-right",
                        "html": moment(comment.gmtCreate).format('YYYY-MM-DD')
                    }));

                    var mediaEle = $( "<div/>", {
                        "class": "media"
                    }).append(mediaLeftEle).append(mediaBodyEle);

                    var commentElement = $( "<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments"
                    }).append(mediaEle);
                    subCommentContainer.prepend(commentElement);
                });
            });
            //展开二级评论
            comments.addClass("in");
        }
    }
    $(e).toggleClass("active");//图标变色
    //console.log(id);
}

function showSelectTag() {
    $("#select-tag").show();
}

function selectTag(e){
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();
    if(previous.indexOf(value)==-1){
        if(previous){
            $("#tag").val(previous + ','+value);
        }else{
            $("#tag").val(value);
        }
    }
}