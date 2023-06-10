<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file = "/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api/building"/>
<html>
<head>
    <title>Chỉnh sửa tòa nhà</title>
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
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form class="form-horizontal" id="formEdit"  commandName="model">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="name">Tên tòa nhà</label>
                            <div class="col-sm-9">
                                <form:input path="name" id="name" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="staffId">Người quản lý tòa nhà</label>
                            <div class="col-sm-9">
                                <input type="text" id="staffId" class="form-control" name = "staffId">
                            </div>
                        </div>
                        <%--QUẬN--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Quận</label>
                            <div class="col-sm-9">
                                <form:select path="district" cssClass="form-control">
                                    <form:option value="-1" label="---chọn quận---"/>
                                    <form:options items="${model.districtMaps}"/>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="ward">Phường</label>
                            <div class="col-sm-9">
                                <form:input path="ward" id="ward" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="street">Đường</label>
                            <div class="col-sm-9">
                                <form:input path="street" id="street" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="structure">Kết cấu</label>
                            <div class="col-sm-9">
                                <form:input path="structure" id="structure" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="numberOfBasement">Số tầng hầm </label>
                            <div class="col-sm-9">
                                <input type="number" id="numberOfBasement" class="form-control" name="numberOfBasement" value="${model.numberOfBasement}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="floorArea">Diện tích sàn </label>
                            <div class="col-sm-9">
                                <form:input path="floorArea" id="floorArea" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="direction">Hướng </label>
                            <div class="col-sm-9">
                                <form:input path="direction" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="level">Hạng </label>
                            <div class="col-sm-9">
                                <form:input path="level" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentArea">Diện tích thuê </label>
                            <div class="col-sm-9">
                                <form:input path="rentArea" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentArea">Giá thuê </label>
                            <div class="col-sm-9">
                                <form:input path="rentPrice" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentPriceDescription">Mô tả giá </label>
                            <div class="col-sm-9">
                                <form:input path="rentPriceDescription" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="serviceFee">Phí dịch vụ</label>
                            <div class="col-sm-9">
                                <form:input path="serviceFee" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="carFee">Phí ô tô</label>
                            <div class="col-sm-9">
                                <form:input path="carFee" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="motorbikeFee">Phí mô tô</label>
                            <div class="col-sm-9">
                                <form:input path="motorbikeFee" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="overtimeFee">Phí ngoài giờ</label>
                            <div class="col-sm-9">
                                <form:input path="overtimeFee" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="electricityFee">Tiền điện</label>
                            <div class="col-sm-9">
                                <form:input path="electricityFee" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="deposit">Đặt cọc</label>
                            <div class="col-sm-9">
                                <form:input path="deposit" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="payment">Thanh toán</label>
                            <div class="col-sm-9">
                                <form:input path="payment" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="rentTime">Thời hạn thuê</label>
                            <div class="col-sm-9">
                                <form:input path="rentTime" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="decorationTime">Thời gian trang trí</label>
                            <div class="col-sm-9">
                                <form:input path="decorationTime" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="managerName">Tên quản lý</label>
                            <div class="col-sm-9">
                                <input type="text" id="managerName" class="form-control" name = "managerName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="managerPhone">Số điện thoại quản lý</label>
                            <div class="col-sm-9">
                                <input type="text" id="managerPhone" class="form-control" name = "managerPhone">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="costTips">Phí mua giới</label>
                            <div class="col-sm-9">
                                <input type="text" id="costTips" class="form-control" name = "costTips">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Loại tòa nhà </label>
                            <div class="col-sm-9">
                                <form:checkboxes path="types" items="${model.typeMaps}" delimiter=" "/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Thêm tòa nhà
                                </button>
                                <button type="button" class="btn btn-primary">Hủy</button>
                            </div>
                        </div>
                        <form:hidden path="id" id="buildingId"/>
                    </form:form>
                </div>
            </div>
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div><!-- /.row -->

</div><!-- /.page-content -->
</div>
</div><!-- /.main-content -->

<script>
    $("#btnAddOrUpdateBuilding").click(function (e) {
        e.preventDefault();
        var data ={};
        var types = [];
        var formData = $("#formEdit").serializeArray();
        $.each(formData, function (index, v) {
            if (v.name == 'types'){
                types.push(v.value);
            }else{
                data[""+v.name+""] = v.value;
            }
        });
        data['types'] = types;
        if($('#buildingId').val() != ""){
            var buildingId = $('#buildingId').val();
            updateBuilding(data,buildingId);
        }else {
            addBuilding(data);
        }
    });
    function updateBuilding(data,id) {
        $.ajax({
            type: 'PUT',
            url: '${buildingAPI}/' + id ,
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

    function addBuilding(data) {
        $.ajax({
            type: 'POST',
            url: '${buildingAPI}',
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
