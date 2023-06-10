<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file = "/common/taglib.jsp"%>
<c:url var="customerAPI" value="/api/customer"/>
<c:url var="customerListURL" value="/admin/customer-list"/>
<c:url var="userAPI" value="/api/user"/>
<html>
<head>
    <title>Danh sách khách hàng</title>
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
                <li class="active">DS khách hàng</li>
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
                                <form:form commandName="modelSearch" action="${customerListURL}" id="listForm" method = "GET">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <label for="fullName">Tên khách hàng</label>
                                            <form:input path="fullName" cssClass="form-control"/>
                                        </div>

                                        <div class="col-sm-4">
                                            <label for="phone">Di động</label>
                                            <form:input path="phone" cssClass="form-control"/>
                                        </div>

                                        <div class="col-sm-4">
                                            <label for="email">Email</label>
                                            <form:input path="email" cssClass="form-control"/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <security:authorize access="hasRole('MANAGER')">
                                        <div class="col-sm-3">
                                            <label for="staffId">Chọn nhân viên phụ trách</label>
                                            <form:select path="staffId" cssClass="form-control">
                                                <form:option value="-1" label="---chọn nhân viên---"/>
                                                <form:options items="${staffmaps}"/>
                                            </form:select>
                                        </div>
                                        </security:authorize>
                                        <div class="col-sm-5">
                                        </div>
                                        <div class="col-sm-4 float-right">
                                            <br>
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
                            <a href="/admin/customer-edit" class="btn btn-white btn-info btn-bold" role="button" data-toggle="tooltip"  title="Thêm tòa nhà">
                                <i class="fa fa-plus-circle" aria-hidden="true"></i>
                            </a>

                            <button class="btn btn-white btn-info btn-bold" data-toggle="tooltip"
                                    title="Xóa tòa nhà" id="btnDeleteCustomer">
                                <i class="fa fa-trash" aria-hidden="true"></i>
                            </button>
                        </div>
                    </div>

                    <!-- Danh sách tòa nhà tìm kiếm -->
                    <br><br>
                    <div class=row>
                        <div class="col-xs-12">
                            <table id="customerList" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>Tên</th>
                                    <th>Di động</th>
                                    <th>Email</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>

                                <c:forEach var="item" items="${customers}">
                                    <tr>
                                        <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"></td>
                                        <td>${item.fullName}</td>
                                        <td>${item.phone}</td>
                                        <td>${item.email}</td>


                                        <td>
                                            <security:authorize access="hasRole('MANAGER')">
                                            <button class="btn btn-xs btn-info" data-toggle ="tooltip" title="Giao tòa nhà"
                                                    onclick="assingmentCustomer(${item.id})">
                                                <i class="fa fa-bars" aria-hidden="true"></i>
                                            </button>
                                            </security:authorize>
                                            <a href="/admin/customer-edit-${item.id}" class="btn btn-xs btn-info" role="button" data-toggle="tooltip"  title="Chỉnh sửa">
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

<!-- Assingment CustomerEntity Model -->
<div class="modal fade" id="assingmentCustomerModel" role="dialog">
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
                <input type="hidden" id="customerId" name="customerId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>
        </div>

    </div>
</div>

<script>
    function assingmentCustomer (customerId) {
        openModelAssingmentCustomer()
        loadStaff(customerId);
        $('#customerId').val(customerId);

    }
    
    function loadStaff(customerId) {
        $.ajax({
            type: "GET",
            url: "${customerAPI}/"+customerId+"/staffs",
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
    
    function openModelAssingmentCustomer (){
        $('#assingmentCustomerModel').modal();
    }
    $('#btnAssignCustomer').click(function (e) {
        e.preventDefault();
        var data ={};
        data['customerId'] = $('#customerId').val();
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
            url: "${customerAPI}/assignment",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert("Assignment customer success");
            },
            error: function (response) {
                alert("Assignment customer failed");

            },
        });
    }

    $('#btnDeleteCustomer').click(function (e) {
        e.preventDefault();
        var idList = $('#customerList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        deleteCustomer(idList);
    });

    function deleteCustomer(data){
        $.ajax({
            type: "DELETE",
            url: "${customerAPI}",
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
