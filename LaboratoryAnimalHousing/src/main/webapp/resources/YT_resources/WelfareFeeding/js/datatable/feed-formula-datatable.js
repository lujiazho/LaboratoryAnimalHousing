function init(setFeedNumber) {
    const table = layui.table;

    renderTable();

    // 单击事件
    table.on('row(feed-formula-datatable)', function (obj) {
        setFeedNumber(obj.data.feednumber);
    });


}

function renderTable() {

    const table = layui.table;

    //渲染表格
    table.render({
        elem: '#feed-formula-datatable',
        url: './../../../../welfare-feeding/animal-feed-formula/all', //数据接口
        page: true, //开启分页
        limit: 14,
        limits: [4, 8, 12, 14, 16, 20, 24],
        cols: [[ //表头
            {field: 'feednumber', title: '饲料编号', width: 160, fixed: 'left'},
            {field: 'feedtype', title: '饲料类型', width: 130},
            {
                field: 'instructions',
                title: '使用说明',
                width: 260
            },
            {field: 'ingredients', title: '配料表', width: 160},
            {field: 'preservationconditions', title: '保存条件', width: 160}
        ]]
    });
}

export default {init};