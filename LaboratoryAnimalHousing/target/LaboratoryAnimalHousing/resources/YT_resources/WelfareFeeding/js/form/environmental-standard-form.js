const environmentalStandardFormTemplate = `
<form id="environmental-standard-form" class="layui-form" lay-filter="environmental-standard-form" action="javascript:">
    <div class="layui-form-item">
        <label class="layui-form-label" for="animal-number">动物编号</label>
        <div class="layui-input-block">
            <input type="number" id="animal-number" name="animalnumber" required 
            lay-verify="required|number" placeholder="动物编号" autocomplete="off"
            value="{{d.animalNumber}}" {{# if(d.animalNumber) { }} disabled="disabled" {{# } }} class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">湿度</label>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="humiditylowerlimit" placeholder="%" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
          <div class="layui-form-mid">-</div>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="humidityupperlimit" placeholder="%" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">温度</label>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="temperaturelowerlimit" placeholder="°C" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
          <div class="layui-form-mid">-</div>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="temperatureupperlimit" placeholder="°C" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">静压差</label>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="staticpressuredifferencelowerlimit" placeholder="Pa" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
          <div class="layui-form-mid">-</div>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="staticpressuredifferenceupperlimit" placeholder="Pa" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">光照</label>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="lightlowerlimit" placeholder="lx" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
          <div class="layui-form-mid">-</div>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="lightupperlimit" placeholder="lx" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">噪音</label>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="noiselowerlimit" placeholder="dB" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
          <div class="layui-form-mid">-</div>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="noiseupperlimit" placeholder="dB" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">风量</label>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="airvolumelowerlimit" placeholder="m³/s" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
          <div class="layui-form-mid">-</div>
          <div class="layui-input-inline" style="width: 100px;">
            <input type="number" name="airvolumeupperlimit" placeholder="m³/s" autocomplete="off" class="layui-input" lay-verify="required|number">
          </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="environmental-standard-submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>`;
function init(animalNumber) {
    const form = layui.form;
    const laytpl = layui.laytpl;
    const element = document.getElementById('environmental-standard-form-container');
    element.innerHTML = laytpl(environmentalStandardFormTemplate).render({animalNumber:animalNumber});
    // 渲染表单
    layui.form.render(null, 'environmental-standard-form');
    //监听提交
    form.on('submit(environmental-standard-submit)', async function(data){
        await fetch('./../../../../welfare-feeding/environmental-standard',
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