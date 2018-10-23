<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <#include "./common/include.ftl">
    <link type="text/css" href="../editormd/lib/codemirror/codemirror.min.css">
    <script type="text/javascript" src="../editormd/lib/jquery-3.1.1/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="../editormd/src/editormd.js"></script>
    <link rel="stylesheet" href="../editormd/css/editormd.min.css">

</head>
<body>
<h1 style="text-align: center">发布文章</h1>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/article/publish" method="post" novalidate="novalidate">
                <div class="form-group">
                    <input type="text" name="title" value="文章标题" />
                </div>
                <div id="my-editormd" class="form-group">
                    <textarea id="my-text" name="my-text" style="display:none;"></textarea>
                </div>

                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>



        <#--<form action="/article/publish" method="post" novalidate="novalidate">-->
            <#--<input id="title" name="title" value="标题" style="display: none">-->
            <#--&lt;#&ndash;<input id="content" name="content" style="display: none">&ndash;&gt;-->
            <#--<div id="my-editormd">-->
                <#--<textarea id="my-text" name="my-text" style="display:none;"></textarea>-->
                <#--<!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 &ndash;&gt;-->
                <#--&lt;#&ndash;<textarea id="text" name="text" style="display:none;"></textarea>&ndash;&gt;-->
            <#--</div>-->
            <#--<button type="submit" id="submit-btn" >提交</button>-->
        <#--</form>-->
</div>
<script type="text/javascript">
    var my_editormd;
    $(function () {
        my_editormd = editormd("my-editormd", {//注意1：这里的就是上面的DIV的id属性值
            width: "90%",
            height: 640,
            markdown: "editing",
            path: 'editormd/lib/',//注意2：你的路径
            saveHTMLToTextarea : true,//注意3：这个配置，方便post提交表单
            syncScrolling : "single",// 同步滚动
            theme        : "lesser-dark",// 工具栏风格
            previewTheme : "dark",// 预览页面风格
            editorTheme  : "paraiso-dark",// 设置编辑页面风格
            /**上传图片相关配置如下*/
            imageUpload : true,//开启本地图片上传
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "${base}/article/upload",//图片上传地址
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
