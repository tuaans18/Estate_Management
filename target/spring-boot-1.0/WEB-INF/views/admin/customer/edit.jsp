<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerAPI" value="/api/customer"/>
<html>
<head>
    <title>Chỉnh sửa tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
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
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form class="form-horizontal" id="formEdit" commandName="model">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Tên khách <hàng></hàng></label>
                            <div class="col-sm-9">
                                <form:input path="fullName" id="name" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Số điện thoại</label>
                            <div class="col-sm-9">
                                <form:input path="phone" id="phone" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Email</label>
                            <div class="col-sm-9">
                                <form:input path="email" id="email" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <button type="button" class="btn btn-primary" id="btnAddOrUpdateCustomer">Cập nhập khách hàng
                                </button>
                            </div>
                        </div>
                        <form:hidden path="id" id="customerId"/>

                    </form:form>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="form-group">
                        <div class="col-sm-12">
                            <c:forEach var="entry" items="${model.transactionMaps}">
                                <h3><c:out value="${entry.value}"/>

                                        <button class="btn btn-white btn-info btn-bold" data-toggle="tooltip"
                                        title="Tạo mới giao dịch" onclick="createTransaction('${entry.key}')">
                                        <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                        </button>
                                </h3>
                                <table id="customerList" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Ngày tạo</th>
                                        <th>Ghi chú</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${transaction}">
                                        <tr>
                                            <c:if test="${item.code == entry.key}">
                                                <td><fmt:formatDate value="${item.createdDate}" pattern="dd-MM-yyyy" /></td>
                                                <td>${item.note}</td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td></td>
                                        <td><input id="new_notes_${entry.key}" class="form-control"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div><!-- /.row -->

</div><!-- /.page-content -->
</div>
</div><!-- /.main-content -->

<script>

    function createTransaction (transactioncode) {
        var data ={};
        data['code'] = transactioncode;
        data['note'] = $( "#new_notes_"+transactioncode ).val();
        data['customerId'] = $("#customerId").val();
        newTransaction(data);
    };
    function newTransaction(data) {
        $.ajax({
            type: 'POST',
            url: "${customerAPI}" +"/transaction",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert("Save success");
                location.reload();
            },
            error: function (response) {
                alert("Save failed");
                location.reload();
            },
        });
    }

    $("#btnAddOrUpdateCustomer").click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $("#formEdit").serializeArray();
        $.each(formData, function (index, v) {
            data["" + v.name + ""] = v.value;
        });
        if ($('#customerId').val() != "") {
            var customerId = $('#customerId').val();
            updateCustomer(data, customerId);
        } else {
            addCustomer(data);
        }
    });

    function updateCustomer(data, id) {
        $.ajax({
            type: 'PUT',
            url: '${customerAPI}/' + id,
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert("Save success");
            },
            error: function (response) {
                alert("Save failed");
            },
        });
    }

    function addCustomer(data) {
        $.ajax({
            type: 'POST',
            url: '${customerAPI}',
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                alert("Save success");

            },
            error: function (response) {
                alert("Save failed");

            },
        });
    }
</script>
</body>
</html>
