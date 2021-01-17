const roomAllocationStandardFormTemplate = `
<form id="room-allocation-standard-form" class="layui-form" lay-filter="room-allocation-standard-form" action="javascript:">
    <div class="layui-form-item">
        <label class="layui-form-label" for="animal-number">动物编号</label>
        <div class="layui-input-block">
            <input type="text" id="animal-number" name="animalnumber" required 
            lay-verify="required" placeholder="动物编号" autocomplete="off"
            value="{{d.animalNumber}}" {{# if(d.animalNumber) { }} disabled="disabled" {{# } }} class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" for="living-space-requirements">生活空间</label>
        <div class="layui-input-block">
            <input type="text" id="living-space-requirements" name="livingspacerequirements" required 
            lay-verify="required" placeholder="生活空间" autocomplete="off"
            class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label" for="additional-allocation-requirements">其它要求</label>
        <div class="layui-input-block">
            <textarea id="additional-allocation-requirements" name="additionalallocationrequirements" placeholder="其它要求" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="room-allocation-standard-submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>`;
function init(animalNumber) {
    const form = layui.form;
    const laytpl = layui.laytpl;
    const element = document.getElementById('room-allocation-standard-form-container');
    element.innerHTML = laytpl(roomAllocationStandardFormTemplate).render({animalNumber:animalNumber});
    // 渲染表单
    layui.form.render(null, 'room-allocation-standard-form');
    //监听提交
    form.on('submit(room-allocation-standard-submit)', async function(data){
        await fetch('./../../../../welfare-feeding/room-allocation-standard',
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