function to_index() {
    window.location.href="/user/index";
}

/*easyui  表单绑定*/
$(function () {
    $('#table').datagrid({
        url:'/user/getuser',
        //每列的标题
        columns:[[
            {field:'username',title:'用户名',width:100,sortable:true,align:'center'},
            {field:'autograph',title:'个性签名',width:300,sortable:true,align:'center'},
			{field:'ac',title:'通过题数',width:100,sortable:true,align:'center'},
			{field:'wa',title:'错误',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'rank',title:'竞赛积分',width:100,sortable:true,align:'center'},
			{field:'img',title:'img',width:100,sortable:true,align:'center',hidden:'true'},
			{field:'createtime',title:'createtime',width:100,sortable:true,align:'center',hidden:'true'},
			
            ]
        ],
        fitColumns:true,   //列填满grid
        pagination: true,         //分页
        pageSize:10,       //一页显示的数量
        striped: true,   //条纹
        remoteSort: true,  //服务器排序
        nowrap:false,           //可以多行
        rownumbers: true,  //显示行号
        idField: "username",
        singleSelect:true,   //单选
        sortable:true,
        sortName: 'ac',
        sortOrder:'desc',
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
        window.location.href="/user/toAdd";
    }else if(k==2){  //跳转到查看
        window.location.href="/user/toView?id="+row.username;
    }else if(k==3){  //跳转到修改
        window.location.href="/user/toUpdate?id="+row.username;
    }
    else{  //删除
        if(confirm('你确定删除吗?', '确认对话框')){
            $.ajax({
                type: "POST",
                url: "/user/del",
                data: {id:row.username},
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
        url: "/user/add",
        data: JSON.stringify(this.user),
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
        url: "/user/update",
        contentType:"application/json",
        data: JSON.stringify(this.user),
        success: function(data){
            alert("保存成功!!");
            to_index();
        },
        error:function(xhr,textStatus){
        }
    });
}