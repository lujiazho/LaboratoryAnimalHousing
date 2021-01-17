const laytpl = layui.laytpl;
const loadingTemplate = `
<div class="layui-table-init" style="background-color: transparent; {{d.style}}">
<i class="layui-icon layui-icon-loading layui-anim layui-anim-rotate layui-anim-loop"></i>
</div>`
const animalDetailsTemplate = `
<fieldset class="layui-elem-field">
    <legend>动物信息</legend>
    <div class="layui-field-box">
        动物编号:{{d.animalInfo.animalnumber}}<br>
        年龄:{{d.animalInfo.pigage}}<br>
        性别:{{d.animalInfo.pigsex}}
    </div>
</fieldset>
<fieldset class="layui-elem-field">
    <legend>饲养方案</legend>
    <div class="layui-field-box">
        {{# if(d.feedingPlan){ }}
        饲养方案编号:{{d.feedingPlan.feedingplannumber}}<br>
        饲料用量:{{d.feedingPlan.feeddosage}}<br>
        水用量:{{d.feedingPlan.waterconsumption}}<br>
        建议通风时间:{{d.feedingPlan.recommendedventilationtime}}<br>
        更换垫料时间:{{d.feedingPlan.paddingreplacingtime}}
        {{# } else{}}
        饲养方案未确定
        {{# } }}
    </div>
</fieldset>
<fieldset class="layui-elem-field">
    <legend>饲料详情</legend>
    <div class="layui-field-box">
        {{# if(d.feedFormula){ }}
        饲料编号:{{d.feedFormula.feednumber}}<br>
        饲料类型:{{d.feedFormula.feedtype}}<br>
        配料表:{{d.feedFormula.ingredients}}<br>
        说明:{{d.feedFormula.instructions}}<br>
        {{# } else{}}
        饲料未确定
        {{# } }}
    </div>
</fieldset>
<fieldset class="layui-elem-field">
    <legend>动物行为</legend>
    <div class="layui-field-box">
        {{ d.estrus}}
    </div>
</fieldset>
<button id="btn-feeding-plan-task" class="layui-btn layui-hide"></button>
<button id="btn-feeding-plan" class="layui-btn layui-hide">修改饲养方案</button>
<button id="btn-environmental-standard-task" class="layui-btn layui-hide"></button>
<button id="btn-room-allocation-standard-task" class="layui-btn layui-hide"></button>
<button id="btn-environmental-standard" class="layui-btn layui-hide">修改环境标准</button>
<button id="btn-room-allocation-standard" class="layui-btn layui-hide">修改房间分配标准</button>`;

async function render(data, {
    feeding_plan_task_btn = false,
    feeding_plan_btn = false,
    environmental_standard_task_btn = false,
    environmental_standard_btn = false,
    room_allocation_standard_task_btn = false,
    room_allocation_standard_btn = false,
    task_filter = false
}) {
    const ele = document.getElementById('animal-details');
    ele.innerHTML = laytpl(loadingTemplate).render({style: ''});
    let animal = {animalInfo: data, feedingPlan: null, feedFormula:null, estrus:null, task:null};
    let response = await fetch('./../../../../welfare-feeding/temp-animal-record-info/animalNumber?animal_number=' + data.animalnumber, {method: 'GET'});
    if(response.status === 200){
        animal.animalInfo = await response.json();
        response = await fetch('./../../../../welfare-feeding/animal-feeding-plan?animal_number=' + data.animalnumber, {method: 'GET'});
        if (response.status === 200) {
            animal.feedingPlan = await response.json();
            response = await fetch('./../../../../welfare-feeding/animal-feed-formula?feed_number=' + animal.feedingPlan.feednumber, {method: 'GET'});
            if (response.status === 200) {
                animal.feedFormula = await response.json();
            }
        }
        response = await fetch('./../../../../welfare-feeding/estrus?animal_number=' + data.animalnumber, {method: 'GET'});
        if(response.status === 200){
            animal.estrus = [...reanderEstrus(await response.json())].join('');
            console.log(animal.estrus)
        }
        response = await fetch('./../../../../welfare-feeding/welfare-feeding-task?animal_number=' + data.animalnumber, {method: 'GET'});
        if (response.status === 200) {
            animal.task = await response.json();
        }
    }
    ele.innerHTML = laytpl(animalDetailsTemplate).render(animal);
    let task = animal.task;
    if(task === null){
        task = {animalnumber: data.animalnumber, task:''};
    }
    if (feeding_plan_task_btn) {
        let btn = document.getElementById('btn-feeding-plan-task');
        btn.classList.remove('layui-hide');

        renderStateButton(btn, task.task.indexOf('feeding_plan') !== -1, '饲养方案');
        btn.onclick = async () => {
            btn.innerHTML = `<i class="layui-icon layui-icon-loading layui-anim layui-anim-rotate layui-anim-loop"></i>`;
            await changeState(task, 'feeding_plan');
            btn.innerHTML = '';
            renderStateButton(btn, task.task.indexOf('feeding_plan') !== -1, '饲养方案');
        }
    }
    if(feeding_plan_btn){
        let btn = document.getElementById('btn-feeding-plan');
        btn.classList.remove('layui-hide');
        btn.onclick = () => feeding_plan_btn(data.animalnumber);
    }
    if(environmental_standard_task_btn){
        let btn = document.getElementById('btn-environmental-standard-task');
        btn.classList.remove('layui-hide');
        renderStateButton(btn, task.task.indexOf('environmental_standard') !== -1, '环境标准');
        btn.onclick = async () => {
            btn.innerHTML = `<i class="layui-icon layui-icon-loading layui-anim layui-anim-rotate layui-anim-loop"></i>`;
            await changeState(task, 'environmental_standard');
            btn.innerHTML = '';
            renderStateButton(btn, task.task.indexOf('environmental_standard')!== -1, '环境标准');
        }
    }
    if(environmental_standard_btn && (!task_filter || task.task.indexOf('environmental_standard') !== -1)){
        let btn = document.getElementById('btn-environmental-standard');
        btn.classList.remove('layui-hide');
        btn.onclick = () => environmental_standard_btn(data.animalnumber);
    }
    if(room_allocation_standard_task_btn){
        let btn = document.getElementById('btn-room-allocation-standard-task');
        btn.classList.remove('layui-hide');
        renderStateButton(btn, task.task.indexOf('room_allocation_standard') !== -1, '房间分配标准');
        btn.onclick = async () => {
            btn.innerHTML = `<i class="layui-icon layui-icon-loading layui-anim layui-anim-rotate layui-anim-loop"></i>`;
            await changeState(task, 'room_allocation_standard');
            btn.innerHTML = '';
            renderStateButton(btn, task.task.indexOf('room_allocation_standard') !== -1, '房间分配标准');
        }
    }
    if(room_allocation_standard_btn && (!task_filter || task.task.indexOf('room_allocation_standard') !== -1)){
        let btn = document.getElementById('btn-room-allocation-standard');
        btn.classList.remove('layui-hide');
        btn.onclick = () => room_allocation_standard_btn(data.animalnumber);
    }
}
function *reanderEstrus(estruses){
    estruses = estruses.sort((a,b)=>a.behaviorstarttime - b.behaviorstarttime);
    yield '<ul class="layui-timeline">';
    for(const estrus of estruses){
        yield `
<li class="layui-timeline-item">
<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
<div class="layui-timeline-content layui-text">
  <h3 class="layui-timeline-title">`
        +estrus.behaviorstarttime.replace(/\d{4}0?/,'').replace(/(\d)(\d\d)/,'$1月$2日')
        +`</h3>
  <p>`+estrus.behaviordescription+
        `</p>
</div>
</li>`;
    }
    yield '</ul>';
}

function renderStateButton(button, state, taskName) {
    if (state) {
        button.innerText = '取消'+taskName+'任务';
        button.classList.add('layui-btn-warm');
    } else {
        button.innerText = '标记'+taskName+'任务';
        button.classList.remove('layui-btn-warm');
    }
}

async function changeState(task, state) {
    if(task.task.indexOf(state) !== -1){
        task.task = task.task.split(',').filter(x=>x !== state).join(',');
    }
    else{
        if(task.task === ''){
            task.task = state;
        }else{
            task.task = task.task.split(',').concat(state).join(',');
        }
    }
    await fetch('./../../../../welfare-feeding/welfare-feeding-task',
        {
            method: 'POST', body: JSON.stringify(task),
            headers: {'Content-Type': 'application/json'}
        });
}

export default {render}