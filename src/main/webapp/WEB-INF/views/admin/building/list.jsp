<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file = "/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api/building"/>
<c:url var="buildingListURL" value="/admin/building-list"/>
<c:url var="userAPI" value="/api/user"/>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>
<div class="main-content">

    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">DS tòa nhà</li>
            </ul><!-- /.breadcrumb -->

        </div>

        <div class="page-content">


            <div class="row">
                <div class="col-sm-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="widget-box">
                        <div class="widget-header">
                            <h4 class="widget-title">Tìm kiếm</h4>

                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <!-- Chức năng tìm kiếm -->
                                <form:form commandName="modelSearch" action="${buildingListURL}" id="listForm" method = "GET">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <label for="name">Tên sản phẩm</label>
                                            <form:input path="name" cssClass="form-control"/>
                                        </div>

                                        <div class="col-sm-6">
                                            <label for="floorArea"> Diện tích sàn </label>
                                            <input type="number" id="floorArea" class="form-control" name="floorArea" value="${modelSearch.floorArea}"/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-4">
                                            <label for="district">Quận hiện có</label>
                                            <form:select path="district" cssClass="form-control">
                                                <form:option value="-1" label="---chọn quận---"/>
                                                <form:options items="${districtmaps}"/>
                                            </form:select>
                                        </div>

                                        <div class="col-sm-4">
                                            <label for="ward"> Phường </label>
                                            <form:input path="ward" cssClass="form-control"/>
                                        </div>

                                        <div class="col-sm-4">
                                            <label for="street"> Đường </label>
                                            <form:input path="street" cssClass="form-control"/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-4">
                                            <label for="numberOfBasement">Số tầng hầm</label>
                                            <input type="number" id="numberOfBasement" class="form-control" name="numberOfBasement" value="${modelSearch.numberOfBasement}"/>
                                        </div>

                                        <div class="col-sm-4">
                                            <label for="direction"> Hướng </label>
                                            <form:input path="direction" cssClass="form-control"/>
                                        </div>

                                        <div class="col-sm-4">
                                            <label for="level"> Hạng </label>
                                            <form:input path="level" cssClass="form-control"/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3">
                                            <label for="areaFrom">Diện tích từ</label>
                                            <input type="number" id="areaFrom" class="form-control" name="areaFrom" value="${modelSearch.areaFrom}">
                                        </div>

                                        <div class="col-sm-3">
                                            <label for="areaTo">Diện tích đến</label>
                                            <input type="number" id="areaTo" class="form-control" name="areaTo" value="${modelSearch.areaTo}">

                                        </div>

                                        <div class="col-sm-3">
                                            <label for="rentPriceFrom"> Giá thuê từ </label>
                                            <input type="number" id="rentPriceFrom" class="form-control" name="rentPriceFrom" value="${modelSearch.rentPriceFrom}">
                                        </div>

                                        <div class="col-sm-3">
                                            <label for="rentPriceTo"> Giá thuê đến </label>
                                            <input type="number" id="rentPriceTo" class="form-control" name="rentPriceTo" value="${modelSearch.rentPriceTo}">
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-4">
                                            <label for="managerName">Tên quản lý</label>
                                            <form:input path="managerName" cssClass="form-control"/>
                                        </div>

                                        <div class="col-sm-4">
                                            <label for="managerPhone"> Điện thoại quản lý </label>
                                            <form:input path="managerPhone" cssClass="form-control"/>
                                        </div>
                                        <security:authorize access="hasRole('MANAGER')">
                                                <div class="col-sm-3">
                                                    <label for="staffId">Chọn nhân viên phụ trách</label>
                                                    <form:select path="staffId" cssClass="form-control">
                                                        <form:option value="-1" label="---chọn nhân viên---"/>
                                                        <form:options items="${staffmaps}"/>
                                                    </form:select>
                                                </div>
                                        </security:authorize>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-12">
                                            <form:checkboxes path="types" items="${typemaps}" delimiter=" "/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-12">
                                            <button type="button" class="btn btn-primary" id="btnSearch">Tìm kiếm</button>
                                        </div>
                                    </div>
                                </form:form>

                            </div> <!--widget-main-->
                        </div>  <!--widget-body-->
                    </div>  <!--widget-box-->

                    <!-- Nút bấm thêm và xóa	 -->
                    <div class="clearfix">
                        <div class="pull-right">
                            <a href="/admin/building-edit" class="btn btn-white btn-info btn-bold" role="button" data-toggle="tooltip"  title="Thêm tòa nhà">
                                <i class="fa fa-plus-circle" aria-hidden="true"></i>
                            </a>

                            <button class="btn btn-white btn-info btn-bold" data-toggle="tooltip"
                                    title="Xóa tòa nhà" id="btnDeleteBuilding">
                                <i class="fa fa-trash" aria-hidden="true"></i>
                            </button>
                        </div>
                    </div>

                    <!-- Danh sách tòa nhà tìm kiếm -->
                    <br><br>
                    <div class=row>
                        <div class="col-xs-12">
                            <table id="buildingList" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>Tên sản phẩm</th>
                                    <th>Địa chỉ</th>
                                    <th>D.T sàn</th>
                                    <th>D.T trống</th>
                                    <th>Giá thuê</th>
                                    <th>Phí dịch vụ</th>
                                    <th>Phí MG</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>

                                <c:forEach var="item" items="${buildings}">
                                    <tr>
                                        <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"></td>
                                        <td>${item.name}</td>
                                        <td>${item.address}</td>
                                        <td>${item.floorArea}</td>
                                        <td>${item.rentPriceDescription}</td>
                                        <td>${item.rentPrice}</td>
                                        <td>${item.serviceFee}</td>
                                        <td>${item.brokerageFee}</td>

                                        <td>
                                            <security:authorize access="hasRole('MANAGER')">
                                            <button class="btn btn-xs btn-info" data-toggle ="tooltip" title="Giao tòa nhà"
                                                    onclick="assingmentBuilding(${item.id})">
                                                <i class="fa fa-bars" aria-hidden="true"></i>
                                            </button>
                                            </security:authorize>
                                            <a href="/admin/building-edit-${item.id}" class="btn btn-xs btn-info" role="button" data-toggle="tooltip"  title="Chỉnh sửa">
                                                <i class="fa fa-eye" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                    </tr>

                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- PAGE CONTENT ENDS -->
                </div><!-- /.col -->
            </div><!-- /.row -->

        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->

<!-- Assingment BuildingEntity Model -->
<div class="modal fade" id="assingmentBuildingModel" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table" id = "staffList">
                    <thead>
                    <tr>
                        <th>Chọn nhân viên</th>
                        <th>Tên nhân viên</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>
        </div>

    </div>
</div>

<script>
    function assingmentBuilding (buildingId) {
        openModelAssingmentBuilding()
        loadStaff(buildingId);
        $('#buildingId').val(buildingId);

    }
    
    function loadStaff(buildingId) {
        $.ajax({
            type: "GET",
            url: "${buildingAPI}/"+buildingId+"/staffs",
            //data: JSON.stringify(data),
            dataType: "json",
            //contentType: "application/json",
            success: function (response) {
                //console.log('success');
                var row = '';
                $.each(response.data,function (index,item) {
                    row += '<tr>';
                    row += '<td class ="text-center"><input type="checkbox" value='+ item.staffId +' id="checkbox_'+ item.staffId + '" class="check-box-element" ' +item.checked+ '/></td>';
                    row += '<td class="text-center">' +item.fullName +'</td>';
                    row += '</tr>';
                })

                $('#staffList tbody').html(row);
            },
            error: function (response) {
                console.log('failed');

            },
        });
    }
    
    function openModelAssingmentBuilding (){
        $('#assingmentBuildingModel').modal();
    }
    $('#btnAssignBuilding').click(function (e) {
        e.preventDefault();
        var data ={};
        data['buildingId'] = $('#buildingId').val();
        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['listStaffId'] = staffs;
        // staffs.push();
        //call API
        assignStaff(data);
    });

    function assignStaff(data){
        $.ajax({
            type: "POST",
            url: "${buildingAPI}/assignment",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert("Assignment building success");
            },
            error: function (response) {
                alert("Assignment building failed");

            },
        });
    }

    $('#btnDeleteBuilding').click(function (e) {
        e.preventDefault();
        var idList = $('#buildingList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        deleteBuilding(idList);
    });

    function deleteBuilding(data){
        $.ajax({
            type: "DELETE",
            url: "${buildingAPI}",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert("Delete success");
                location.reload();
            },
            error: function (response) {
                alert("Delete failed");
                location.reload();
            },
        });
    }

    $('#btnSearch').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();

    });
</script>
</body>
</html>
