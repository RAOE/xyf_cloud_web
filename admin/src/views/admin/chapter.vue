<template>
    <div>
        <p>
            <button v-on:click="add(2)" class="btn btn-white btn-primary btn-round">
                <i class="ace-icon fa fa-refresh"></i>
                新增
            </button>
            &nbsp;
            <button v-on:click="list(2)" class="btn btn-white btn-success btn-round">
                <i class="ace-icon fa fa-refresh"></i>
                刷新
            </button>
        </p>
        <pagination ref="pagination" v-bind:list="list" v-bind:item-count="8"></pagination>

        <div class="row">
            <div class="col-xs-12">
                <table id="simple-table" class="table  table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="center">
                            <label class="pos-rel">
                                <input type="checkbox" class="ace">
                                <span class="lbl"></span>
                            </label>
                        </th>
                        <th>编号</th>
                        <th>课程编号</th>
                        <th class="hidden-480">课程名称</th>
                        <th class="hidden-480">Status</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr v-for="chapter in chapters" v-bind:key="chapter.id">
                        <td class="center">
                            <label class="pos-rel">
                                <input type="checkbox" class="ace">
                                <span class="lbl"></span>
                            </label>
                        </td>
                        <td>
                            <a href="#">{{chapter.id}}</a>
                        </td>
                        <td class="hidden-480">{{chapter.courseId}}</td>
                        <td>{{chapter.name}}</td>
                        <td>
                            <div class="hidden-sm hidden-xs btn-group">
                                <button class="btn btn-xs btn-success">
                                    <i class="ace-icon fa fa-check bigger-120"></i>
                                </button>

                                <button class="btn btn-xs btn-info">
                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                </button>

                                <button class="btn btn-xs btn-danger">
                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                </button>

                                <button class="btn btn-xs btn-warning">
                                    <i class="ace-icon fa fa-flag bigger-120"></i>
                                </button>
                            </div>

                            <div class="hidden-md hidden-lg">
                                <div class="inline pos-rel">
                                    <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"
                                            data-position="auto">
                                        <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                    </button>

                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                        <li>
                                            <a href="#" class="tooltip-info" data-rel="tooltip" title=""
                                               data-original-title="View">
													<span class="blue">
													<i class="ace-icon fa fa-search-plus bigger-120"></i>
											</span>
                                            </a>
                                        </li>

                                        <li>
                                        </li>

                                        <li>
                                            <a href="#" class="tooltip-error" data-rel="tooltip" title=""
                                               data-original-title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div><!-- /.span -->
        </div>
        <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">表单</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input class="form-control" placeholder="名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static"></p>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</template>
<script src="<%= BASE_URL %>ace/assets/js/jquery-2.1.4.min.js"></script>
<script src="<%= BASE_URL %>ace/assets/js/jquery-1.11.3.min.js"></script>
<script>
    import Pagination from "../../components/pagination"

    export default {
        components: {Pagination},
        name: "chapter",
        data: function () {
            return {
                chapters: []
            }
        },
        mounted: function () {
            let _this = this;
            _this.$refs.pagination.size = 1;
            _this.$parent.activeSidebar("business-chapter-sidebar");
            _this.list(1);
        },
        methods: {
            list(page) {
                let _this = this;
                let paramData = {
                    page: page,
                    size: _this.$refs.pagination.size,
                };
                console.log("执行了")

                _this.$ajax.post('http://localhost:9000/business/chapter/queryAll', _this.$qs.stringify(paramData)).then((response) => {
                    console.log("查询信息请求发送完成{}");
                    console.log(response.data);
                    console.log(response.data.list);
                    _this.chapters = response.data.list.list;
                    console.log("result:", page);
                    console.log("total:", response.data.total);
                    _this.$refs.pagination.render(page, response.data.list.total);
                })
            },
            add() {
                let _this = this;
                _this.chapter = {};
                $("#form-modal").modal("show");
            },
            save(page) {
                let _this = this;
                _this.$ajax.post("").then((response) => {
                    console.log("保存成功");
                })
            }
        }
    }
</script>