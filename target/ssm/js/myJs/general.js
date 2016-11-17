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


	///// SHOW/HIDE VERTICAL SUB MENU /////

	jQuery('.vernav > ul li a, .vernav2 > ul li a').each(function(){
		var url = jQuery(this).attr('href');
		jQuery(this).click(function(){
			if(jQuery(url).length > 0) {
				if(jQuery(url).is(':visible')) {
					if(!jQuery(this).parents('div').hasClass('menucoll') &&
						!jQuery(this).parents('div').hasClass('menucoll2'))
						jQuery(url).slideUp();
				} else {
					jQuery('.vernav ul ul, .vernav2 ul ul').each(function(){
						jQuery(this).slideUp();
					});
					if(!jQuery(this).parents('div').hasClass('menucoll') &&
						!jQuery(this).parents('div').hasClass('menucoll2'))
						jQuery(url).slideDown();
				}
				return false;
			}
		});
	});


	///// SHOW/HIDE SUB MENU WHEN MENU COLLAPSED /////
	jQuery(document).on('mouseenter mouseleave','.menucoll > ul > li, .menucoll2 > ul > li',function(e){
		if(e.type == 'mouseenter') {
			jQuery(this).addClass('hover');
			jQuery(this).find('ul').show();
		} else {
			jQuery(this).removeClass('hover').find('ul').hide();
		}
	});


});