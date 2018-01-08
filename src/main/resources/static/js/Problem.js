function to_index() {
    window.location.href="/problem/index";
}

//打开新窗口
function new_windows(src,id) {
    window.open("/hzuoj/index?src="+"/problem/toView"+"?id="+id);
}

//跳转到题目的内容
function to_view(value, row, index) {
    return  '<a href="#" onclick="new_windows(\'/problem/toView\',\''+row.systemid+'\')">'+value+'</a> ';
}
/*easyui  表单绑定*/
$(function () {
    $('#table').datagrid({
        url:'/problem/getproblem',
        //每列的标题
        columns:[[
            {field:'systemid',title:'systemid',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'num',title:'题号',width:100,sortable:true,align:'center'},
			{field:'title',title:'标题',width:300,sortable:true,align:'center', formatter: to_view},
			{field:'content',title:'content',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'start',title:'start',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'end',title:'end',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'deteleflag',title:'deteleflag',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'laber',title:'标签',width:200,sortable:true,align:'center'},
			{field:'type',title:'type',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'competname',title:'competname',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'createtime',title:'createtime',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'ac',title:'通过人数',width:100,sortable:true,align:'center'},
            {field:'lv',title:'难度',width:100,sortable:true,align:'center'},
			{field:'error',title:'ERROR',width:100,sortable:true,align:'center',hidden:'true'},
			
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
        sortable:true,
        sortName: 'num',
        order: 'asc',
        pageList : [5,10,15,20,25,30,35,40,45,50],
        frozenColumns: [[     //多选
            { field: 'ck', checkbox: true,width:200 },
        ]],
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
        window.location.href="/problem/toAdd";
    }else if(k==2){  //跳转到查看
        window.location.href="/problem/toView?id="+row.systemid;
    }else if(k==3){  //跳转到修改
        window.location.href="/problem/toUpdate?id="+row.systemid;
    }
    else{  //删除
        if(confirm('你确定删除吗?', '确认对话框')){
            $.ajax({
                type: "POST",
                url: "/problem/del",
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
    this.problem.content=UE.getEditor('editor').getContent();
    $.ajax({
        type: "POST",
        url: "/problem/add",
        contentType:"application/json",
        data: JSON.stringify(this.problem),
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
    this.problem.content=UE.getEditor('editor').getContent();
    $.ajax({
        type: "POST",
        url: "/problem/update",
        contentType:"application/json",
        data: JSON.stringify(this.problem),
        success: function(data){
            alert("保存成功!!");
            to_index();
        },
        error:function(xhr,textStatus){
        }
    });
}