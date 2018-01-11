function to_index() {
    window.location.href="/competition/index";
}
//时间转换DateTimeFormatter
function DateFormat(value, row, index) {
    var date = new Date();
    date.setTime(value );
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    h = h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    var second = date.getSeconds();
    minute = minute < 10 ? ('0' + minute) : minute;
    second = second < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
}
function to_bm() {
    alert("报名成功");
}
//报名参赛
function register_bm(value, row, index) {
    if (value=="点击报名"){
        return "<button type='button' class='btn btn-info' onclick='to_bm()'>点击报名</button>";
    }
    return "<button type=\"button\" class=\"btn btn-success\">value</button>";
}

//跳转到竞赛主页
function to_CompetIndex(value, row, index) {
    return '<a href="/competition/competIndex?id='+row.systemid+'" >'+value+'</a> ';
}
/*easyui  表单绑定*/
$(function () {
    $('#table').datagrid({
        url:'/competition/getcompetition',
        //每列的标题
        columns:[[
            {field:'systemid',title:'systemid',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'competname',title:'比赛名称',width:300,sortable:true,align:'center', formatter: to_CompetIndex},
			{field:'author',title:'作者',width:100,sortable:true,align:'center'},
			{field:'starttime',title:'开始时间',width:200,sortable:true,align:'center', formatter: DateFormat},
			{field:'endtime',title:'结束时间',width:200,sortable:true,align:'center', formatter: DateFormat},
			{field:'count',title:'题目数量',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'registercount',title:'参赛人数',width:100,sortable:true,align:'center'},
            {field:'register',title:'报名',width:100,align:'center',formatter: register_bm},
            ]
        ],
        fitColumns:true,   //列填满grid
        pagination: true,         //分页
        pageSize:10,       //一页显示的数量
        striped: true,   //条纹
        remoteSort: true,  //服务器排序
        nowrap:false,           //可以多行
        rownumbers: true,  //显示行号
        idField: "systemid",
        singleSelect:true,   //单选
        pageList : [5,10,15,20,25,30,35,40,45,50],
        sortable:true,
        sortName: 'starttime',
        sortOrder:'desc',
        toolbar: "#tb",  //工具锁定  id=tb 的div
    });
});

//增删改查操作
function operation(k) {
    var row = $('#table').datagrid('getSelected');
    if (k!=1 && row==null){
        alert("请选择一条记录!!");
        return;
    }
    if(k==1){  //跳转到增加
        window.location.href="/competition/toAdd";
    }else if(k==2){  //跳转到查看
        window.location.href="/competition/toView?id="+row.systemid;
    }else if(k==3){  //跳转到修改
        window.location.href="/competition/toUpdate?id="+row.systemid;
    }
    else{  //删除
        if(confirm('你确定删除吗?', '确认对话框')){
            $.ajax({
                type: "POST",
                url: "/competition/del",
                data: {id:row.systemid},
                success: function(data){
                    $('#table').datagrid('reload', {
                        /*filter: "aaaaaa",*/
                    });
                    alert("删除成功");
                },
                error:function(xhr,textStatus){
                }
            });
        }
    }
}

/*增加功能*/
function add() {
    $.ajax({
        type: "POST",
        url: "/competition/add",
        data: JSON.stringify(this.competition),
        contentType:"application/json",
        success: function(data){
            alert("增加成功!!");
            to_index();
        },
        error:function(xhr,textStatus){
        }
    });
}

//修改
function update() {
    $.ajax({
        type: "POST",
        url: "/competition/update",
        contentType:"application/json",
        data: JSON.stringify(this.competition),
        success: function(data){
            alert("保存成功!!");
            to_index();
        },
        error:function(xhr,textStatus){
        }
    });
}