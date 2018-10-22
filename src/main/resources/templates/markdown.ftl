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
<div id="layout">
    <header>
        <h1>动态创建 Editor.md</h1>
        <p>Dynamic create Editor.md</p>
        <br>
        <div class="btns" style="margin:0;">
            <button id="create-btn">动态创建一个 Editor.md</button>
            <button id="remove-btn">移除 Editor.md</button>
        </div>
    </header>
</div>
<script type="text/javascript">
    var testEditormd;

    $(function () {
        console.log("asddsadasd");
        $("#create-btn").click(function () {

            $("#layout").append("<div id=\"test-editormd\"></div>");

            testEditormd = editormd("test-editormd", {
                width: "90%",
                height: 640,
                emoji: true,
                markdown: "### 动态创建 Editor.md\r\n\r\nDynamic create Editor.md",
                path: 'editormd/lib/'

            });

        });

        $("#remove-btn").click(function () {
            testEditormd.editor.remove();
        });
    });
</script>
</body>
