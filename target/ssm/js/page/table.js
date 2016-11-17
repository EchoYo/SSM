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

jQuery.noConflict();

jQuery(document).ready(function(){

	jQuery('#dyntable a').click(function(){

		var url = jQuery(this).attr('href');

		jQuery.post(url, function(data){
			jQuery('#list_right').load(url);
		});
		return false;
	});

});
