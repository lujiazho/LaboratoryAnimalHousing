function init(func) {
    const table = layui.table;
    let lastTr = null;

    renderTable();

    // 单击事件
    table.on('row(task-datatable)', function(obj){
        if(lastTr){
            for (const tr of lastTr){
                tr.classList.remove('selected-tr');
            }
        }
        lastTr = obj.tr;
        for(const tr of obj.tr){
            tr.classList.add('selected-tr');
        }
        func(obj.data);
    });


}
function renderTable(){

    const table = layui.table;

    //渲染表格
    table.render({
        elem: '#task-datatable',
        height: 'full-200',
        url: './../../../../welfare-feeding/welfare-feeding-task/all', //数据接口
        page: true, //开启分页
        limit: 16,
        limits: [4, 8, 12, 16, 20, 24],
        cols: [[ //表头
            {field: 'animalnumber', title: '动物编号', width: 120, sort: true, fixed: 'left'},
            {field: 'task', title: '任务', width: 160, templet: d => taskToString(d.task)},
            {
                field: 'lastupdated',
                title: '上次更新',
                width: 120,
                templet: d => new Date(d.lastupdated).toLocaleDateString()
            },
        ]]
    });
}
function taskToString(task){
    const dict = {'feeding_plan':'饲养方案', 'environmental_standard':'环境标准', 'room_allocation_standard':'房间分配标准'}
    return task.split(',').map(x=>dict[x]).join(',');
}
export default {init};