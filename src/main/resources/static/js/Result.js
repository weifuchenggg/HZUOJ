function to_index() {
    window.location.href="/result/index";
}
//打开新窗口
function new_windows(id) {
    window.open("/hzuoj/index?src="+"/result/toView"+"?id="+id);
}
//查看
function to_view(value, row, index) {
    return  '<a href="#" onclick="new_windows(\''+row.systemid+'\')">'+'查看代码'+'</a> ';
}
//状态加样式
function state_css(value, row, index) {
    return  '<h4><span class="label label-success">'+value+'</span></h4>';
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

/*easyui  表单绑定*/
$(function () {
    $('#table').datagrid({
        url:'/result/getresult',
        //每列的标题
        columns:[[
            {field:'systemid',title:'systemid',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'num',title:'题号',width:100,sortable:true,align:'center'},
			{field:'user',title:'用户名',width:200,sortable:true,align:'center'},
			{field:'language',title:'语言',width:100,sortable:true,align:'center'},
            {field:'state',title:'状态',width:100,sortable:true,align:'center', formatter: state_css},
			{field:'content',title:'查看代码',width:100,sortable:true,align:'center', formatter: to_view},
            {field:'createtime',title:'提交时间',width:200,sortable:true,align:'center', formatter: DateFormat},
			{field:'type',title:'type',width:100,sortable:true,align:'center',hidden:'true'},
			
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
        window.location.href="/result/toAdd";
    }else if(k==2){  //跳转到查看
        window.location.href="/result/toView?id="+row.systemid;
    }else if(k==3){  //跳转到修改
        window.location.href="/result/toUpdate?id="+row.systemid;
    }
    else{  //删除
        if(confirm('你确定删除吗?', '确认对话框')){
            $.ajax({
                type: "POST",
                url: "/result/del",
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
        url: "/result/add",
        data: JSON.stringify(this.result),
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
        url: "/result/update",
        contentType:"application/json",
        data: JSON.stringify(this.result),
        success: function(data){
            alert("保存成功!!");
            to_index();
        },
        error:function(xhr,textStatus){
        }
    });
}