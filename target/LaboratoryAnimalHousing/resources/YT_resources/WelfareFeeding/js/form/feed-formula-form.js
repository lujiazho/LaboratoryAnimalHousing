const form = layui.form;
const feedFormulaFormTemplate = `
<form id="feed-formula-form" class="layui-form" lay-filter="feed-formula-form" action="javascript:">
    <div class="layui-form-item">
        <label class="layui-form-label" for="feed-type">饲料类型</label>
        <div class="layui-input-block">
            <input type="text" id="feed-type" name="feedtype" required  lay-verify="required" placeholder="饲料类型" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label" for="ingredients">配料表</label>
        <div class="layui-input-block">
            <textarea id="ingredients" name="ingredients" placeholder="配料表" class="layui-textarea" lay-verify="required" maxlength="255"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label" for="preservation-conditions">保存条件</label>
        <div class="layui-input-block">
            <textarea id="preservation-conditions" name="preservationconditions" placeholder="保存条件" class="layui-textarea" lay-verify="required"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" for="quality-guarantee-period">保质期</label>
        <div class="layui-input-block">
            <input type="number" id="quality-guarantee-period" name="qualityguaranteeperiod" required  lay-verify="required" placeholder="保质期" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label" for="instructions">使用说明</label>
        <div class="layui-input-block">
            <textarea id="instructions" name="instructions" placeholder="使用说明" class="layui-textarea" maxlength="255" lay-verify="required"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="feed-formula-submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>`;
function init() {
    const element = document.getElementById('feed-formula-form-container');
    element.innerHTML = feedFormulaFormTemplate;
    // 渲染表单
    layui.form.render(null, 'feed-formula-form');
    //监听提交
    form.on('submit(feed-formula-submit)', async function(data){
        await fetch('./../../../../welfare-feeding/animal-feed-formula',
            {
                method: 'POST', body: JSON.stringify(data.field),
                headers: {'Content-Type': 'application/json'}
            }).then(
            response=>{
                if (response.status >= 200 && response.status < 300) {
                    layer.msg('提交成功', {icon: 1})
                } else {
                    layer.msg(response.statusText, {icon: 2})
                }
            }
            ).catch(
            reason =>layer.msg(reason, {icon: 2})
        );
        return false;
    });
}
export default {init};