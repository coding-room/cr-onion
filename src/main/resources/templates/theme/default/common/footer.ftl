<#macro footer>
<footer data-am-widget="footer"
        class="am-footer am-footer-default"
        data-am-footer="{  }">
    <div class="am-footer-switch">
    <span class="am-footer-ysp" data-rel="mobile"
          data-am-modal="{target: '#am-switch-mode'}">
          手机版
    </span>
        <span class="am-footer-divider"> | </span>
        <a id="godesktop" data-rel="desktop" class="am-footer-desktop" href="javascript:">
            电脑版
        </a>
    </div>
    <div class="am-footer-miscs ">

        <p>由 <a href="http://beldon.me/" title="Beldon" target="_blank" class="">Beldon</a>提供技术支持</p>
        <p>CopyRight©2017 Beldon Inc.</p>
        <p>粤ICP备xxxx</p>
    </div>
</footer>

<script src="/static/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="/static/plugins/modernizr.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script src="/static/plugins/amazeui/js/amazeui.ie8polyfill.min.js"></script>
<script src="/static/plugins/amazeui/js/amazeui.min.js"></script>
    ${javascript!}
</body>
</html>
</#macro>