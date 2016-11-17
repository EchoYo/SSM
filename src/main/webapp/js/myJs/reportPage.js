jQuery(document).ready(function(){
    jQuery(document).on('click','#nonFullyReport',function () {
        jQuery.ajax({
            url: '/report/nonFullyList.do',
            type: 'post',
            data: {
                stDate: jQuery('input[name="stDate"]').val(),
                endDate: jQuery('input[name="endDate"]').val(),
                deptId: jQuery('select[name="deptId"]').val(),
                empName: jQuery('input[name="empName"]').val()
            },
            success: function (data) {
                jQuery('#reportTable').empty().html(data);
            }
        });
    });

    jQuery(document).on('click','#reportOfDays',function () {
        jQuery.ajax({
            url: '/report/dateTable.do',
            type: 'post',
            data: {
                stDate: jQuery('input[name="stDate"]').val(),
                endDate: jQuery('input[name="endDate"]').val(),
                deptId: jQuery('select[name="deptId"]').val(),
                empName: jQuery('input[name="empName"]').val()
            },
            success: function (data) {
                jQuery('#listReportDate').empty().html(data);
            }
        });
    });

    jQuery(document).on('click','#reportOfMonth',function () {
        jQuery.ajax({
            url: '/report/monthTable.do',
            type: 'post',
            data: {
                stDate: jQuery('input[name="stDate"]').val(),
                endDate: jQuery('input[name="endDate"]').val(),
                deptId: jQuery('select[name="deptId"]').val(),
                empName: jQuery('input[name="empName"]').val()
            },
            success: function (data) {
                jQuery('#listReportMonth').empty().html(data);
            }
        });
    });

    jQuery(document).on('click','#nonFully',function () {
        jQuery.ajax({
            url: '/report/reportFully.do',
            type: 'post',
            success: function (data) {
                jQuery('#listNonFullyPage').empty().html(data);
            }
        });
    });

    jQuery(document).on('click','#report_month',function () {
        jQuery.ajax({
            url: '/report/reportOfMonthList.do',
            type: 'post',
            success: function (data) {
                jQuery('#listNonFullyPage').empty().html(data);
            }
        });
    });

    jQuery(document).on('click','#report_dates',function () {
        jQuery.ajax({
            url: '/report/reportOfDaysList.do',
            type: 'post',
            success: function (data) {
                jQuery('#listNonFullyPage').empty().html(data);
            }
        });
    });

    ////批量生成
    jQuery(document).on('click','#reportButton',function () {
        var empIds = new Array();
        var stDate = jQuery('input[name="stDate"]').val();
        var endDate = jQuery('input[name="endDate"]').val();
        jQuery('input:checkbox').not('#reportCheckBox').each(function () {
            if (jQuery(this).attr('checked')) {
                empIds.push(jQuery(this).val());
            }
        });
        jQuery.ajax({
            url: '/report/disposeData.do',
            type: 'post',
            dataType: "json",
            data: {
                "empIds": empIds,
                "stDate": stDate,
                "endDate":endDate
            },
            success: function (data) {
                alert("报表已生成！");
                jQuery('#nonFully').parent().toggleClass("current");
                jQuery('#report_dates').parent().toggleClass("current");
                jQuery('#listNonFullyPage').empty().load("/report/reportOfDaysList.do")
            }
        });
    });

    ////重新生成
    jQuery(document).on('click','#restButton',function () {
        var empIds = new Array();
        var stDate = jQuery('input[name="stDate"]').val();
        var endDate = jQuery('input[name="endDate"]').val();
        jQuery('input:checkbox').not('#reportMonthBox').each(function () {
            if (jQuery(this).attr('checked')) {
                empIds.push(jQuery(this).val());
            }
        });
        jQuery.ajax({
            url: '/report/resetData.do',
            type: 'post',
            dataType: "json",
            data: {
                "empIds": empIds,
                "stDate": stDate,
                "endDate":endDate
            },
            success: function (data) {
                alert("报表已重新生成！");
                jQuery('#listNonFullyPage').empty().load("/report/reportOfMonthList.do")
            }
        });
    });

    ////批量删除
    jQuery(document).on('click','#deleteButton',function () {
        var empIds = new Array();
        var stDate = jQuery('input[name="stDate"]').val();
        var endDate = jQuery('input[name="endDate"]').val();
        jQuery('input:checkbox').not('#reportMonthBox').each(function () {
            if (jQuery(this).attr('checked')) {
                empIds.push(jQuery(this).val());
            }
        });
        jQuery.ajax({
            url: '/report/deleteData.do',
            type: 'post',
            dataType: "json",
            async: false,
            data: {
                "empIds": empIds,
                "stDate": stDate,
                "endDate":endDate
            },
            success: function (data) {
                alert("删除成功！");
                jQuery('#listReportMonth').empty().load("/report/monthTable.do?stDate="+stDate+"&endDate="+endDate)
            }
        });
    });

    ////批量调休
    jQuery(document).on('click','#changeButton',function () {
        var empIds = new Array();
        var stDate = jQuery('input[name="stDate"]').val();
        var endDate = jQuery('input[name="endDate"]').val();
        jQuery('input:checkbox').not('#changeBox').each(function () {
            if (jQuery(this).attr('checked')) {
                empIds.push(jQuery(this).val());
            }
        });
        jQuery.ajax({
            url: '/leave/addChangeShift.do',
            type: 'post',
            dataType: "json",
            async: false,
            data: {
                "empIds": empIds,
                "stDate": stDate,
                "endDate": endDate
            },
            success: function (data) {
                alert("设置成功！");
                jQuery("#a7").trigger('click');
            }
        });
    });


    ////批量添加加班单
    jQuery(document).on('click','#addOverList',function () {
        var empIds = new Array();
        var recDate = jQuery('input[name="recDate"]').val();
        var stTime = jQuery('input[name="stTime"]').val();
        var endTime = jQuery('input[name="endTime"]').val();
        var hours = jQuery('input[name="hours"]').val();
        var resultType = jQuery('select[name="resultType"]').val();
        jQuery('input:checkbox').not('#overListBox').each(function () {
            if (jQuery(this).attr('checked')) {
                empIds.push(jQuery(this).val());
            }
        });
        jQuery.ajax({
            type: 'post',
            url: '/over/add.do',
            async: false,
            dataType: 'json',
            data: {
                "empIds":empIds,
                "resultType":resultType,
                "recDate": recDate,
                "stTime": stTime,
                "endTime": endTime,
                "hours": hours
            },
            success: function (data) {
                alert("添加成功！");
                return false;
            }
        })
    });

});