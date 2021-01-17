const feedFormulaFormTemplate = `
<form id="feed-plan-form" class="layui-form" lay-filter="feed-plan-form" action="javascript:">
    <div class="layui-form-item">
        <label class="layui-form-label" for="animal-number">动物编号</label>
        <div class="layui-input-block">
            <input type="number" id="animal-number" name="animalnumber" required 
            lay-verify="required|number" placeholder="动物编号" autocomplete="off"
            value="{{d.animalNumber}}" {{# if(d.animalNumber) { }} disabled="disabled" {{# } }} class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" for="feed-number">饲料编号</label>
        <button type="button" class="layui-btn layui-btn-warm" id="select-feed">选择饲料</button>
        <div class="layui-input-block  layui-hide">
            <input type="number" id="feed-number" name="feednumber" required 
            lay-verify="required|number" placeholder="饲料编号" autocomplete="off"
            class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" for="feed-dosage">饲料用量</label>
        <div class="layui-input-block">
            <input type="number" id="feed-dosage" name="feeddosage" required 
            lay-verify="required|number" placeholder="饲料用量" autocomplete="off"
            class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" for="water-consumption">饮水用量</label>
        <div class="layui-input-block">
            <input type="number" id="water-consumption" name="waterconsumption" required 
            lay-verify="required|number" placeholder="饮水用量" autocomplete="off"
            class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" for="recommended-ventilation-time">通风时间</label>
        <div class="layui-input-block">
            <input type="number" id="recommended-ventilation-time" name="recommendedventilationtime" required 
            lay-verify="required|number" placeholder="通风时间" autocomplete="off"
            class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" for="padding-replacing-time">换垫料时间</label>
        <div class="layui-input-block">
            <input type="number" id="padding-replacing-time" name="paddingreplacingtime" required 
            lay-verify="required|number" placeholder="换垫料时间" autocomplete="off"
            class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="feed-plan-submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>`;
function init(config, initFeedFormulaDatatable, render) {
    const form = layui.form;
    const laytpl = layui.laytpl;
    const element = document.getElementById('feeding-plan-form-container');
    element.innerHTML = laytpl(feedFormulaFormTemplate).render({animalNumber:config.animalNumber});
    // 渲染表单
    layui.form.render(null, 'feed-plan-form');
    // 选择饲料逻辑
    const btn = document.getElementById('select-feed');
    btn.onclick = ev => {
        const index = layer.open({
            title: '点击表项选择饲料',
            area: ['80vw', '80vh'],
            btn: [],
            content: '<div id="feed-formula-datatable" lay-filter="feed-formula-datatable"></div>'
        });
        initFeedFormulaDatatable(feedNumber=>{
            document.getElementById('feed-number').value = feedNumber;
            btn.innerText = feedNumber;
            layer.close(index);
        });
    }
    //监听提交
    form.on('submit(feed-plan-submit)', async function(data){
        await fetch('./../../../../welfare-feeding/animal-feeding-plan',
            {
                method: 'POST', body: JSON.stringify(data.field),
                headers: {'Content-Type': 'application/json'}
            }).then(
            response=>{
                if (response.status >= 200 && response.status < 300) {
                    layer.msg('提交成功', {icon: 1})
                    render(data.field,{});
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