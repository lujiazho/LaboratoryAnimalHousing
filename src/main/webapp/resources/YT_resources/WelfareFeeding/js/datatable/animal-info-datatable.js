function init(func) {
    const table = layui.table;

    let lastTr = null;

    renderTable();

    // 单击事件
    table.on('row(animal-info-datatable)', function(obj){
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
        elem: '#animal-info-datatable',
        height: 'full-200',
        url: './../../../../welfare-feeding/temp-animal-record-info', //数据接口
        page: true, //开启分页
        limit: 16,
        limits: [4, 8, 12, 16, 20, 24],
        cols: [[ //表头
            {field: 'animalnumber', title: '动物编号', width: 220, fixed: 'left'},
            {field: 'pigage', title: '年龄', width: 200},
            {field: 'pigsex', title: '性别', width: 200},
        ]]
    });
}
export default { init };