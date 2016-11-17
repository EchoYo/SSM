/*
 * 	Additional function for this template
 *	Written by ThemePixels	
 *	http://themepixels.com/
 *
 *	Copyright (c) 2012 ThemePixels (http://themepixels.com)
 *	
 *	Built for Amanda Premium Responsive Admin Template
 *  http://themeforest.net/category/site-templates/admin-templates
 */
jQuery(document).ready(function(){

	///// SHOW/HIDE USERDATA WHEN USERINFO IS CLICKED ///// 
	
	jQuery(document).on('click','.userinfo',function(){
		if(!jQuery(this).hasClass('active')) {
			jQuery('.userinfodrop').show();
			jQuery(this).addClass('active');
		} else {
			jQuery('.userinfodrop').hide();
			jQuery(this).removeClass('active');
		}
		//remove notification box if visible
		jQuery('.notification').removeClass('active');
		jQuery('.noticontent').remove();
		
		return false;
	});

	
	///// SHOW/HIDE BOTH NOTIFICATION & USERINFO WHEN CLICKED OUTSIDE OF THIS ELEMENT /////


	jQuery(document).on('click','.userinfodrop',function(event) {
		var ud = jQuery('.userinfodrop');
		
		//hide user drop menu when clicked outside of this element
		if(!jQuery(event.target).is('.userinfodrop') 
			&& !jQuery(event.target).is('.userdata') 
			&& ud.is(':visible')) {
				ud.hide();
				jQuery('.userinfo').removeClass('active');
		}
	});
	
	
	///// NOTIFICATION CONTENT /////
	
	jQuery(document).on('click','.notitab a', function(){
		var id = jQuery(this).attr('href');
		jQuery('.notitab li').removeClass('current'); //reset current 
		jQuery(this).parent().addClass('current');
		if(id == '#messages')
			jQuery('#activities').hide();
		else
			jQuery('#messages').hide();
		jQuery(id).show();
		return false;
	});


	//left
	jQuery(document).on('click','.leftnav a',function(){
		//this is only applicable when window size below 450px
		if(jQuery(this).parents('.more').length == 0)
		jQuery('.leftnav li.more ul').hide();
		//remove current menu
		jQuery('.leftnav li').each(function(){
			jQuery(this).removeClass('current');
		});
		jQuery(this).parent().addClass('current');	// set as current menu
		var url = jQuery(this).attr('href');
		jQuery.post(url, function(data){
			jQuery('#list_right').empty().html(data);
		});
		return false;
	});

	
	///// HORIZONTAL NAVIGATION (AJAX/INLINE DATA) /////	
	
	jQuery(document).on("click",".hornav a",function(){
		
		//this is only applicable when window size below 450px
		if(jQuery(this).parents('.more').length == 0)
			jQuery('.hornav li.more ul').hide();
		
		//remove current menu
		jQuery('.hornav li').each(function(){
			jQuery(this).removeClass('current');
		});
		
		jQuery(this).parent().addClass('current');	// set as current menu
		
		var url = jQuery(this).attr('href');
		if(jQuery(url).length > 0) {
			jQuery('.contentwrapper .subcontent').hide();
			jQuery(url).show();
		} else {
			jQuery.post(url, function(data){
				jQuery('#contentwrapper').html(data);
				jQuery('.stdtable input:checkbox').uniform();	//restyling checkbox
			});
		}
		return false;
	});
	
	
	///// SEARCH BOX WITH AUTOCOMPLETE /////
	
	var availableTags = [
			"ActionScript",
			"AppleScript",
			"Asp",
			"BASIC",
			"C",
			"C++",
			"Clojure",
			"COBOL",
			"ColdFusion",
			"Erlang",
			"Fortran",
			"Groovy",
			"Haskell",
			"Java",
			"JavaScript",
			"Lisp",
			"Perl",
			"PHP",
			"Python",
			"Ruby",
			"Scala",
			"Scheme"
		];
	jQuery('#keyword').autocomplete({
		source: availableTags
	});
	

	///// SEARCH BOX ON FOCUS /////
	
	jQuery(document).on('focusin focusout','#keyword', function(e){
		var t = jQuery(this);
		if(e.type == 'focusin' && t.val() == 'Enter keyword(s)') {
			t.val('');
		} else if(e.type == 'focusout' && t.val() == '') {
			t.val('Enter keyword(s)');	
		}
	});
	
	
	///// NOTIFICATION CLOSE BUTTON /////
	
	jQuery(document).on('click','.notibar .close',function(){
		jQuery(this).parent().fadeOut(function(){
			jQuery(this).remove();
		});
	});


	///// COLLAPSED/EXPAND LEFT MENU /////
	jQuery(document).on('click','.togglemenu',function(){
		if(!jQuery(this).hasClass('togglemenu_collapsed')) {

			//if(jQuery('.iconmenu').hasClass('vernav')) {
			if(jQuery('.vernav').length > 0) {
				if(jQuery('.vernav').hasClass('iconmenu')) {
					jQuery('body').addClass('withmenucoll');
					jQuery('.iconmenu').addClass('menucoll');
				} else {
					jQuery('body').addClass('withmenucoll');
					jQuery('.vernav').addClass('menucoll').find('ul').hide();
				}
			} else if(jQuery('.vernav2').length > 0) {
				//} else {
				jQuery('body').addClass('withmenucoll2');
				jQuery('.iconmenu').addClass('menucoll2');
			}

			jQuery(this).addClass('togglemenu_collapsed');

			jQuery('.iconmenu > ul > li > a').each(function(){
				var label = jQuery(this).text();
				jQuery('<li><span>'+label+'</span></li>')
					.insertBefore(jQuery(this).parent().find('ul li:first-child'));
			});
		} else {

			//if(jQuery('.iconmenu').hasClass('vernav')) {
			if(jQuery('.vernav').length > 0) {
				if(jQuery('.vernav').hasClass('iconmenu')) {
					jQuery('body').removeClass('withmenucoll');
					jQuery('.iconmenu').removeClass('menucoll');
				} else {
					jQuery('body').removeClass('withmenucoll');
					jQuery('.vernav').removeClass('menucoll').find('ul').show();
				}
			} else if(jQuery('.vernav2').length > 0) {
				//} else {
				jQuery('body').removeClass('withmenucoll2');
				jQuery('.iconmenu').removeClass('menucoll2');
			}
			jQuery(this).removeClass('togglemenu_collapsed');

			jQuery('.iconmenu ul ul li:first-child').remove();
		}
	});
	
	
	
	///// RESPONSIVE /////
	if(jQuery(document).width() < 640) {
		jQuery('.togglemenu').addClass('togglemenu_collapsed');
		if(jQuery('.vernav').length > 0) {
			
			jQuery('.iconmenu').addClass('menucoll');
			jQuery('body').addClass('withmenucoll');
			jQuery('.centercontent').css({marginLeft: '56px'});
			if(jQuery('.iconmenu').length == 0) {
				jQuery('.togglemenu').removeClass('togglemenu_collapsed');
			} else {
				jQuery('.iconmenu > ul > li > a').each(function(){
					var label = jQuery(this).text();
					jQuery('<li><span>'+label+'</span></li>')
						.insertBefore(jQuery(this).parent().find('ul li:first-child'));
				});		
			}

		} else {
			
			jQuery('.iconmenu').addClass('menucoll2');
			jQuery('body').addClass('withmenucoll2');
			jQuery('.centercontent').css({marginLeft: '36px'});
			
			jQuery('.iconmenu > ul > li > a').each(function(){
				var label = jQuery(this).text();
				jQuery('<li><span>'+label+'</span></li>')
					.insertBefore(jQuery(this).parent().find('ul li:first-child'));
			});		
		}
	}
	
	
	jQuery(document).on('click','.searchicon',function(){
		jQuery('.searchinner').show();
	});

	jQuery(document).on('click','.searchicon',function(){
		jQuery('.searchinner').hide();
	});
	
	
	
	///// ON LOAD WINDOW /////
	function reposSearch() {
		if(jQuery(window).width() < 520) {
			if(jQuery('.searchinner').length == 0) {
				jQuery('.search').wrapInner('<div class="searchinner"></div>');	
				jQuery('<a class="searchicon"></a>').insertBefore(jQuery('.searchinner'));
				jQuery('<a class="searchcancel"></a>').insertAfter(jQuery('.searchinner button'));
			}
		} else {
			if(jQuery('.searchinner').length > 0) {
				jQuery('.search form').unwrap();
				jQuery('.searchicon, .searchcancel').remove();
			}
		}
	}
	reposSearch();
	
	///// ON RESIZE WINDOW /////
	jQuery(window).resize(function(){
		
		if(jQuery(window).width() > 640)
			jQuery('.centercontent').removeAttr('style');
		
		reposSearch();
		
	});

	
	///// CHANGE THEME /////
	jQuery(document).on('click','.changetheme a',function(){
		var c = jQuery(this).attr('class');
		if(jQuery('#addonstyle').length == 0) {
			if(c != 'default') {
				jQuery('head').append('<link id="addonstyle" rel="stylesheet" href="css/style.'+c+'.css" type="text/css" />');
				jQuery.cookie("addonstyle", c, { path: '/' });
			}
		} else {
			if(c != 'default') {
				jQuery('#addonstyle').attr('href','css/style.'+c+'.css');
				jQuery.cookie("addonstyle", c, { path: '/' });
			} else {
				jQuery('#addonstyle').remove();	
				jQuery.cookie("addonstyle", null);
			}
		}
	});
	
	///// LOAD ADDON STYLE WHEN IT'S ALREADY SET /////
	if(jQuery.cookie('addonstyle')) {
		var c = jQuery.cookie('addonstyle');
		if(c != '') {
			jQuery('head').append('<link id="addonstyle" rel="stylesheet" href="css/style.'+c+'.css" type="text/css" />');
			jQuery.cookie("addonstyle", c, { path: '/' });
		}
	}

	////table////

	jQuery(document).on('click','table a',function(){
		var url = jQuery(this).attr('href');
		jQuery.post(url, function(data){
			jQuery('#list_right').empty().html(data);
		});
		return false;
	});

	////主模块////
	jQuery(document).on('click','.headermenu a',function(){
		//remove current menu
		jQuery('.headermenu li').each(function(){
			jQuery(this).removeClass('current');
		});
		jQuery(this).parent().addClass('current');	// set as current menu
		var url = jQuery(this).attr('href');
		jQuery('#load').empty();
		jQuery.post(url, function(data){
			jQuery('#load').html(data);
		});
		return false;
	});
	////dept添加
	jQuery(document).on('click','#add_dept',function(){
		jQuery.post('/dept/addUI.do', function(data){
			jQuery('#list_right').empty().html(data);
		});
	});

	////导入emp花名册
	jQuery(document).on('click','#import_excel',function(){
		jQuery.post('/hr/importData.do', function(data){
			alert("导入成功！");
			jQuery('#list_right').empty().html(data);
		});
	});

	////导入打卡记录
	jQuery(document).on('click','#add_raw_data',function(){
		jQuery.post('/record/addRawData.do', function(data){
			if(data.result){
				alert("导入成功！");
			}else{
				alert("记录已存在！");
			}
		});
		return false;
	});

	////月打卡记录
	jQuery(document).on('click','#rec_dataOfMonth',function(){
		jQuery.ajax({
			url:'/record/recordOfMonth.do',
			type:'get',
			data:{
				month:jQuery('select[name="month"]').val(),
				deptId:jQuery('select[name="deptId"]').val(),
				empName:jQuery('input[name="empName"]').val()
			},
			success: function (data) {
			jQuery('#load').empty().html(data);
			}
		});
	});

	////天刷卡汇总
	jQuery(document).on('click','#rec_dataOfDays',function(){
		jQuery.ajax({
			url:'/record/recordOfDays.do',
			type:'post',
			data:{
				stDate:jQuery('input[name="stDate"]').val(),
				endDate:jQuery('input[name="endDate"]').val(),
				deptId:jQuery('select[name="deptId"]').val(),
				empName:jQuery('input[name="empName"]').val()
			},
			success: function (data) {
				jQuery('#record_detail').empty().html(data);
			}
		});
	});


	////导出月考勤记录
	jQuery(document).on('click','#exp_record_month',function(){
		jQuery.ajax({
			url:'/record/exportRecordOfMonth.do',
			type:'get',
			success: function (data) {
				alert("导出成功！")
			}
		});
	});

	////日视图页面跳转
	jQuery(document).on('click','#record_days',function(){
		jQuery.ajax({
			url:'/record/list.do',
			type:'get',
			success: function (data) {
				jQuery('#list_right').empty().html(data);
			}
		});
	});

	////月视图跳转
	jQuery(document).on('click','#record_month',function(){
		jQuery.ajax({
			url:'/record/viewOfMonth.do',
			type:'get',
			success: function (data) {
				jQuery('#list_right').empty().html(data);
			}
		});
	});

	////添加默认考勤
	jQuery(document).on('click','#buttonOfSaveDefault',function(){
		jQuery.ajax({
			url:'/shift/addDefaultShift.do',
			type:'post',
			data:{
				month:jQuery('select[name="month"]').val()
			},
			success: function (data) {
				alert("设置成功！");
			}
		});
	});
	////根据条件查询月排班记录
	jQuery(document).on('click','#recShiftOfMonth',function(){
		jQuery.ajax({
			url:'/shift/getShiftOfMonth.do',
			type:'post',
			data:{
				month:jQuery('select[name="month"]').val(),
				deptId:jQuery('select[name="deptId"]').val(),
				empName:jQuery('input[name="empName"]').val()
			},
			success:function(data){
				jQuery('#load').empty().html(data);
			}
		});
	});

});