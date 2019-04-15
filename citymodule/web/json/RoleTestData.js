var TestData = [
	{ id:"00000000", pId:0, name:"外部角色",open: true,isParent:true},
	{ id:"00000001", pId:"00000000", name:"私营",open: true,isParent:true},
	{ id:"00000003", pId:"00000001", name:"机构操作员(私营)"},
	{ id:"00000004", pId:"00000001", name:"机构运营岗(私营)"},
	{ id:"00000002", pId:"00000000", name:"公营",open: true,isParent:true},
	{ id:"00000005", pId:"00000002", name:"机构操作员(私营)"},
	{ id:"00000006", pId:"00000002", name:"机构运营岗(私营)"},
	{ id:"00000007", pId:0, name:"内部角色",open: true,isParent:true},
	{ id:"00000008", pId:"00000007", name:"系统管理员"},
	{ id:"00000009", pId:"00000007", name:"系统运维岗"},
	{ id:"00000010", pId:"00000007", name:"系统运营岗"}
]

var TestData2 = [
	{ id:"00000003", name:"机构操作员(私营)"},
	{ id:"00000008", name:"系统管理员"}
]
