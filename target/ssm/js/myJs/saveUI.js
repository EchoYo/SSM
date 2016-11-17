/*
 * 	Additional function for tables.html
 *	Written by ThemePixels	
 *	http://themepixels.com/
 *
 *	Copyright (c) 2012 ThemePixels (http://themepixels.com)
 *	
 *	Built for Amanda Premium Responsive Admin Template
 *  http://themeforest.net/category/site-templates/admin-templates
 */

jQuery(document).ready(function () {

    //查询所有部门信息
    jQuery.ajax({
        type: 'POST',
        url: '/dept/getDeptForHr.do',
        dataType: 'json',
        success: function (data) {
            jQuery.each(data, function (k, v) {
                jQuery('select[name="deptId"]').append("<option value='" + v.deptId + "'>" + v.deptName + "</option>");
            })
        },
        error: function () {
            alert("链接服务器出错！！:");
        }
    });

    //查询所有中介信息
    jQuery.ajax({
        type: 'POST',
        url: '/nature/getNatureForHr.do',
        dataType: 'json',
        success: function (data) {
            jQuery.each(data, function (k, v) {
                jQuery('select[name="natureId"]').append("<option value='" + v.natureId + "'>" + v.natureName + "</option>");
            })
        },
        error: function () {
            alert("链接服务器出错！！:");
        }
    });

    //根据版本查询存货名称
    jQuery('input[name="build_no"]').one('blur', function () {
        jQuery.ajax({
            type: 'POST',
            url: '/erp/getByCode.do',
            dataType: 'json',
            data: {
                cInvAddCode: jQuery('input[name="build_no"]').val()
            },
            success: function (data) {
                jQuery.each(data, function (k, v) {
                    jQuery('select[name="part_no"]').append("<option value='" + v.cInvName + "'>" + v.cInvName + "</option>");
                })
            },
            error: function () {
                alert("出错了！！:");
            }
        });
    });

    jQuery('#updatezx').click(function () {
        var serial_no = jQuery('input[name="serial_no"]').val();
        var url;
        if (serial_no != null) {
            url = '/zx/update.do';
        } else {
            url = '/zx/add.do';
        }
        jQuery.ajax({
            url: url,
            type: "POST",
            data: {
                serial_no: serial_no,
                type_id: jQuery('input[name="type_id"]').val(),
                st_date: jQuery('input[name="st_date"]').val(),
                month: jQuery('input[name="month"]').val(),
                mat_code: jQuery('input[name="mat_code"]').val(),
                batch: jQuery('input[name="batch"]').val(),
                qty: jQuery('input[name="qty"]').val()
            },
            success: function (data) {
                jQuery('#list_right').html(data);
            }
        });
    });

    jQuery('#updatewx').click(function () {
        var id = jQuery('input[name="id"]').val();
        var url;
        if (id == '') {
            url = '/wx/add.do';
        } else {
            url = '/wx/update.do';
        }
        jQuery.ajax({
            url: url,
            type: "POST",
            data: {
                id: id,
                order_id: jQuery('input[name="order_id"]').val(),
                type_id: jQuery('input[name="type_id"]').val(),
                build_no: jQuery('input[name="build_no"]').val(),
                month: jQuery('input[name="month"]').val(),
                item_no: jQuery('input[name="item_no"]').val(),
                qyt: jQuery('input[name="qyt"]').val()
            },
            success: function (data) {
                jQuery('#list_right').html(data);
            }
        });
    });
    //员工信息修改
    jQuery('#hrEmp').click(function () {
        var empId = jQuery('input[name="empId"]').val();
        var url;
        if (empId == '') {
            url = '/hr/add.do';
        } else {
            url = '/hr/update.do';
        }
        jQuery.ajax({
            url: url,
            type: "POST",
            async: false,
            data: {
                empId: empId,
                workId: jQuery('input[name="workId"]').val(),
                cardId: jQuery('input[name="cardId"]').val(),
                natureId: jQuery('select[name="natureId"]').val(),
                cpfId: jQuery('select[name="cpfId"]').val(),
                shiftId: jQuery('select[name="shiftId"]').val(),
                empName: jQuery('input[name="empName"]').val(),
                sex: jQuery('select[name="sex"]').val(),
                deptId: jQuery('select[name="deptId"]').val(),
                postName: jQuery('input[name="postName"]').val(),
                identityId: jQuery('input[name="identityId"]').val(),
                entryDate: jQuery('input[name="entryDate"]').val(),
                homeAddress: jQuery('input[name="homeAddress"]').val(),
                tmpAddress: jQuery('input[name="tmpAddress"]').val(),
                contractStart: jQuery('input[name="contractStart"]').val(),
                contractEnd: jQuery('input[name="contractEnd"]').val(),
                remarks: jQuery('textarea[name="remarks"]').val(),
                phone: jQuery('input[name="phone"]').val(),
                education: jQuery('select[name="education"]').val()
            },
            success: function (data) {
                if (data.x == "add") {
                    alert("添加成功！");
                    jQuery('#list_right').load("/hr/addUI.do");
                } else {
                    alert("修改成功！");
                    jQuery('#list_right').load("/hr/list.do");
                }

            },
            error: function () {
                alert("连接数据库出错！！:");
            }
        });
    });
    //添加修改部门
    jQuery('#updateDept').click(function () {
        var id = jQuery('input[name="id"]').val();
        var url;
        if (id == '') {
            url = '/dept/add.do';
        } else {
            url = '/dept/update.do';
        }
        jQuery.ajax({
            url: url,
            type: "POST",
            data: {
                id: id,
                deptId: jQuery('input[name="deptId"]').val(),
                deptName: jQuery('input[name="deptName"]').val(),
                phone: jQuery('input[name="phone"]').val()
            },
            success: function (data) {
                jQuery('#list_right').html(data);
            }
        });
    });
    //添加修改图纸信息
    jQuery("#save_dwg").click(function () {
        var date = jQuery('input[name="date"]').val();
        var url;
        if (date == '') {
            url = '/drawing/add.do';
        } else {
            url = '/drawing/update.do';
        }
        jQuery.ajax({
            url: url,
            type: "POST",
            data: {
                id: jQuery('input[name="id"]').val(),
                date: date,
                sampleDrawingEdition: jQuery('input[name="sampleDrawingEdition"]').val(),
                customerName: jQuery('input[name="customerName"]').val(),
                customerDrawingName: jQuery('input[name="customerDrawingName"]').val(),
                customerDrawingNumber: jQuery('input[name="customerDrawingNumber"]').val(),
                customerDrawingEdition: jQuery('input[name="customerDrawingEdition"]').val(),
                moldDrawingEdition: jQuery('input[name="moldDrawingEdition"]').val(),
                moldDrawingDate: jQuery('input[name="moldDrawingDate"]').val(),
                formalDrawingEdition: jQuery('input[name="formalDrawingEdition"]').val(),
                formalDrawingDate: jQuery('input[name="formalDrawingDate"]').val(),
                craftNumber: jQuery('input[name="craftNumber"]').val(),
                craftEdition: jQuery('input[name="craftEdition"]').val(),
                craftDate: jQuery('input[name="craftDate"]').val(),
                formalMoldDrawingEdition: jQuery('input[name="formalMoldDrawingEdition"]').val(),
                formalMoldDrawingDate: jQuery('input[name="formalMoldDrawingDate"]').val(),
                remark: jQuery('textarea[name="remark"]').val()
            },
            success: function (data) {
                window.location.reload();
            }
        });
    });

});