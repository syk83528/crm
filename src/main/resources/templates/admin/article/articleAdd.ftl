<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <#--通用样式-->
    <#include "../../common/include.ftl">
    <#--md相关-->
    <link rel="stylesheet" href="${base}/editormd/lib/codemirror/codemirror.min.css">
    <script type="text/javascript" src="${base}/editormd/src/editormd.js"></script>
    <link rel="stylesheet" href="${base}/editormd/css/editormd.min.css">
    <#--less处理-->
    <link rel="stylesheet/less" type="text/css" href="${base}/less/articleAdd.less" />
    <script src="${base}/less/less.js" type="text/javascript"></script>
</head>
<body>
<h1 style="text-align: center">发布文章</h1>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <form action="${base}/api/admin/article/publish" method="post" enctype="multipart/form-data">
            <div id="content">

                <div class="title input form-group">
                    <input type="text" name="title" class="form-control" placeholder="请输入标题">
                </div>

                <div class="head input form-group">
                    <select name="category" class="form-control">
                        <#list categoryList as category>
                            <option value="${category.categoryType}">
                                ${category.categoryName}
                            </option>
                        </#list>
                    </select>
                    <input type="text" name="type" class="form-control" placeholder="请输入类型">
                </div>

                <div id="my-editormd" class="form-group">
                    <textarea id="my-text" name="my-text" style="display:none;"></textarea>
                </div>

                <button type="submit" class="btn btn-default">提交</button>
            </div>
            </form>
        </div>
    </div>
</div>

</div>
<script type="text/javascript">

    var my_editormd;
    $(function () {
        my_editormd = editormd("my-editormd", {//注意1：这里的就是上面的DIV的id属性值
            width: "90%",
            height: 640,
            markdown: "editing",
            path: '/editormd/lib/',//注意2：你的路径
            saveHTMLToTextarea : true,//注意3：这个配置，方便post提交表单
            syncScrolling : "single",// 同步滚动
            theme        : "lesser-dark",// 工具栏风格
            previewTheme : "dark",// 预览页面风格
            editorTheme  : "paraiso-dark",// 设置编辑页面风格
            /**上传图片相关配置如下*/
            imageUpload : true,//开启本地图片上传
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "${base}/api/admin/article/upload",//图片上传地址
            onload : function() {//上传成功之后的回调
                console.log('正在上传', this);
            }
        });

        $("#submit-btn").click(function(){
            //赋值给form中contentget-md-btn
            var content = $('.editormd-markdown-textarea').val();

            content = $('.editormd-html-textarea').val();

            console.log(content);
            // if (content == '') {
            //     alert("请输入文章内容");
            //     return
            // }
            $("#content").val(content);

            // console.log(params);
            var params = {
              "content": content,
              "title": "cool"
            };


            var url = "${base}/article/publish";
            $.ajax({
                url: url,
                data: params,    //返回数据类型  //请求数据编码类型
                success: function (result) {
                    if (result && result.code == 0) {
                        $.alert("创建成功");
                    } else {
                        $.alert("创建失败")
                    }
                }
            });
        });
    });
</script>
</body>
<#--<#if productInfo.categoryType?? && productInfo.categoryType == category.categoryType>-->
                            <#--<option value="${category.categoryType}" selected>${category.categoryName}</option>-->
<#--<#else >-->
                            <#--<option value="${category.categoryType}">${category.categoryName}</option>-->
<#--</#if>-->