<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li>
           <img src="${base}/img/jd-logo.jpg">
        </li>
        <li class="sidebar-brand">
            <a href="#">
                后台
            </a>
        </li>
        <li>
            <a href="${base}/admin/index">首页</a>
        </li>
        <li>
            <a href="/sell/seller/order/list"><i class="fa fa-fw fa-list-alt"></i> 订单</a>
        </li>
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 博客 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="${base}/admin/article">列表</a></li>
                <li><a href="${base}/admin/article/add">新增</a></li>
            </ul>
        </li>
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 类目 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="${base}/admin/category">列表</a></li>
                <li><a href="${base}/admin/category/add">新增</a></li>
            </ul>
        </li>

        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 管理员权限
                <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li class="dropdown-header">操作</li>
                <li><a href="${base}/admin/category">列表</a></li>
                <li><a href="${base}/admin/category/add">新增</a></li>
            </ul>
        </li>

       <li>
           ${(user.nickName)!"奥术大师多"}
       </li>

        <li>
            <a href="${base}/admin/logout"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
        </li>
    </ul>
</nav>