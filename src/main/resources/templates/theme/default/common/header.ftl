<#macro header title>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <title>Onion</title>

    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">

    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="icon" type="image/png" href="/static/img/favicon.png">
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="apple-touch-icon-precomposed" href="/static/img/app-icon.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="/static/plugins/amazeui/i/app-icon72x72@2x.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="assets/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <link rel="stylesheet" href="/static/plugins/amazeui/css/amazeui.min.css">
    <link rel="stylesheet" href="/templates/theme/default/common/css/app.css">
</head>
<body>
<header class="am-topbar am-topbar-inverse">
    <div class="container">
        <h1 class="am-topbar-brand">
            <a href="#">Onion</a>
        </h1>
        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
                data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
                class="am-icon-bars"></span></button>
        <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li class="am-active"><a href="/">首页</a></li>
                <li><a href="#">项目</a></li>
                <li class="am-dropdown" data-am-dropdown>
                    <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                        下拉 <span class="am-icon-caret-down"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li class="am-dropdown-header">标题</li>
                        <li><a href="#">1. 去月球</a></li>
                        <li class="am-active"><a href="#">2. 去火星</a></li>
                        <li><a href="#">3. 还是回地球</a></li>
                        <li class="am-disabled"><a href="#">4. 下地狱</a></li>
                        <li class="am-divider"></li>
                        <li><a href="#">5. 桥头一回首</a></li>
                    </ul>
                </li>
                <#if sec.isLogin()>
                    <li><a href="/topic/add">发布话题</a></li>
                </#if>
            </ul>

            <form class="am-topbar-form am-topbar-left am-form-inline" role="search">
                <div class="am-form-group">
                    <input type="text" class="am-form-field am-input-sm" placeholder="搜索">
                </div>
            </form>

            <div class="am-topbar-right">
                <div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
                    <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm am-dropdown-toggle"
                            data-am-dropdown-toggle>其他 <span class="am-icon-caret-down"></span></button>
                    <ul class="am-dropdown-content">
                        <#if sec.isLogin()>
                            <li><a href="/user/logout">退出</a></li>
                        </#if>
                        <li><a href="#">随便看看</a></li>
                    </ul>
                </div>
            </div>

            <div class="am-topbar-right">
                <ul class="am-nav am-nav-pills am-topbar-nav">
                    <#if !sec.isLogin()>
                        <li><a href="/user/login">登录</a></li>
                        <li><a href="/user/reg">注册</a></li>
                    <#else >
                        <li><a href="#">您好，${onion.currentUser().nickname!}</a></li>
                    </#if>
                </ul>
            </div>
        </div>
    </div>
</header>
</#macro>