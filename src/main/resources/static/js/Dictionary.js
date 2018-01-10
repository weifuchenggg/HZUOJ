function to_index() {
    window.location.href="/dictionary/index";
}

/*easyui  表单绑定*/
$(function () {
    $('#table').datagrid({
        url:'/dictionary/getdictionary',
        //每列的标题
        columns:[[
            {field:'systemid',title:'systemid',width:100,sortable:true,align:'center'},
			{field:'kind',title:'kind',width:100,sortable:true,align:'center'},
			{field:'code',title:'code',width:100,sortable:true,align:'center'},
			{field:'detail',title:'detail',width:100,sortable:true,align:'center'},
			{field:'detail2',title:'detail2',width:100,sortable:true,align:'center'},
			
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
        window.location.href="/dictionary/toAdd";
    }else if(k==2){  //跳转到查看
        window.location.href="/dictionary/toView?id="+row.systemid;
    }else if(k==3){  //跳转到修改
        window.location.href="/dictionary/toUpdate?id="+row.systemid;
    }
    else{  //删除
        if(confirm('你确定删除吗?', '确认对话框')){
            $.ajax({
                type: "POST",
                url: "/dictionary/del",
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
        url: "/dictionary/add",
        data: JSON.stringify(this.dictionary),
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
        url: "/dictionary/update",
        contentType:"application/json",
        data: JSON.stringify(this.dictionary),
        success: function(data){
            alert("保存成功!!");
            to_index();
        },
        error:function(xhr,textStatus){
        }
    });
}