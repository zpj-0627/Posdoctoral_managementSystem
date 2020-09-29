/**
 * 右侧属性改变中间工作区的某个控件的内容
 */
/*当页面初始化完成后 我们在左侧加一个示例配置*/
MagicalCallback.prototype.after_start = function(param){
    var api = param.api;
    var constant = api.getConstant();
    var component = {
        name:"常用",
        children:[
            {
                name:"配置示例",
                icon:"assets/drag/img/left/other1.png",
                html:"<div class='mc-demo'>我只是一个示例-elementUI</div>",
            }
        ]
    };
    //追加头部
    constant.getComponents().unshift(component);

    //增加一个tagClassMapping
    constant.tagClassMapping['mc-demo']={name:"参考示例", dragInto:true, duplicateAttr:[],canDelete:true,assistDelete:true};
    //增加属性配置
    var configs = [
        {type:constant.type.SELECT,clearAttr:true       ,oneLine:true,change:constant.change.ATTR,attrName:'mc-change-html',title:'控制孩子节点',tooltip:"",options:[{"1":"增加孩子节点"},{"2":"删除孩子节点"}]},
    ]
    var content = constant.getRightPanel()[0].content;
    content['mc-demo']=configs;
    api.refreshAll();
}

MagicalCallback.prototype.after_change_attr_callback = function (obj) {
    //示例三：三级联动示例
    var focusNode = obj.node;
    if(focusNode.magicalCoder.identifier=='mc-demo'){//当前修改的是mc-demo的属性
        if(obj.name =='mc-change-html'){
            var api = new MagicalApi();
            switch(obj.value){
                case '1':
                    var prevNode = null;//代表头部 如果要最后位置添加怎么做
                    if(focusNode.magicalCoder.children.length>0){
                        prevNode = focusNode.magicalCoder.children[focusNode.magicalCoder.children.length-1];//在尾部添加
                    }
                    api.appendHtml({parentNode:focusNode,html:"<el-button>参数</el-button>",prevNode:prevNode});
                    break;
                case '2':
                    var deleteNodes = focusNode.magicalCoder.children;//您可以继续筛选此nodes
                    api.deleteNodes({nodes:deleteNodes});
                    break;
            }


        }
    }
}
