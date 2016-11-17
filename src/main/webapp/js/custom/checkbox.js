jQuery(document).ready(function(){
    ////批量选择
    jQuery("#firstCheckBox").click(function(){
        var s = jQuery(this).prop("checked");
        jQuery('input:checkbox').not('#firstCheckBox').prop("checked",s);
    });

    ////checkbox选中后 批量添加按钮显示
    jQuery(document).on('click','input:checkbox',function(){
        var s = 0;
        jQuery('input:checkbox').each(function(){
            if(jQuery(this).attr('checked')){
                s = 1;
                return false;
            }
        });
        if( s == 1){
            jQuery('#batch_update').css('display','inline')
        }else{
            jQuery('#batch_update').css('display','none')
        }
    });

    ////批量修改
    jQuery(document).off('click','#batch_update_button').on('click','#batch_update_button',function(){
        var empIds = new Array();
        var stDate = jQuery('input[name="stDate"]').val();
        var endDate = jQuery('input[name="endDate"]').val();
        var shiftId = jQuery('select[name="shiftId"]').val();
        jQuery('input:checkbox').not('#firstCheckBox').each(function(){
            if(jQuery(this).attr('checked')){
                empIds.push(jQuery(this).val());
            }
        });
        jQuery.ajax({
            url:'/shift/batchUpdateShift.do',
            type:'post',
            dataType:"json",
            data:{
                "empIds":empIds,
                "stDate":stDate,
                "endDate":endDate,
                "shiftId":shiftId
            },
            success: function (data) {
                alert("设置成功！刷新后显示！");
            }
        });
    })
});