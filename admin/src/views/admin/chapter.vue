<template>
    <div>
        <button v-on:click="list(2)" class="btn btn-white btn-default btn-round">
            <i class="ace-icon fa fa-refresh"></i>
            刷新
        </button>
        <!--        <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"></pagination>-->

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
    </div>
</template>
<script>
    export default {
        name: "chapter",
        data: function () {
            return {
                chapters: []
            }
        },
        mounted: function () {
            let _this = this;
            _this.list(1);
        },
        methods: {
            list(page) {
                let paramData = {
                    page: page,
                    size: 4
                };
                console.log("执行了")
                let _this = this;
                _this.$ajax.post('http://localhost:9000/business/chapter/queryAll', _this.$qs.stringify(paramData)).then((response) => {
                    console.log("查询信息请求发送完成{}");
                    console.log(response.data);
                    console.log(response.data.list);
                    _this.chapters = response.data.list.list;
                })
            }
        }
    }
</script>