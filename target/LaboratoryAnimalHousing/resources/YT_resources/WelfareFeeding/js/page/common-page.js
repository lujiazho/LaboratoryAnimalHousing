const template = `
<div class="logo"><a href="">{{d.name}}</a></div>
<ul class="layui-nav right">
    <li class="layui-inline">
        <i class="layui-icon"><span id="nowTime" style="text-align: center"></span></i>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:"><img src="../images/profile.jpg" class="layui-nav-img"><span id="username"></span></a>
        <dl class="layui-nav-child">
            <dd><a href="../../../../login/loginOut">切换帐号</a></dd>
            <dd><a href="../../../../login/loginOut">退出</a></dd>
        </dl>
        <span class="layui-nav-more"></span>
    </li>
    <li class="layui-nav-item to-index"><a href="../../../../login/loginOut">前台首页</a></li>
</ul>`
const laytpl = layui.laytpl;
const element = layui.element;
const layer = layui.layer;

async function init(name) {
    const ele = document.getElementsByClassName('container').item(0);
    ele.innerHTML = laytpl(template).render({name: name});
    element.render('nav');
    setInterval(setTime, 1000);
    let response = await fetch('./../../../../user/current', {method: 'GET'});
    let user = null;
    if (response.status === 200) {
        user = await response.json();
    } else {
        window.location.replace("../../../../login/loginOut");
    }
    const span = document.getElementById('username');
    span.innerText = user.username;
    layer.ready(function () {
        layer.msg('欢迎登录！', {icon: 6});
    })
}

function setTime() {
    const date = new Date().toLocaleString();
    const div = document.getElementById("nowTime");
    div.innerHTML = date;
}

export default {init};