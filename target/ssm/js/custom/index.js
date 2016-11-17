jQuery(document).ready(function () {
    ///// LOGIN FORM SUBMIT /////
    //jQuery('.button').click(function () {
    //    jQuery.ajax({
    //        type: "POST",
    //        url: "/verify.do",
    //        data: {username: jQuery('#username').val(), password: jQuery('#password').val()},
    //    });
    //
    //});

    ///// ADD PLACEHOLDER /////
    jQuery('#username').attr('placeholder', 'Username');
    jQuery('#password').attr('placeholder', 'Password');
});
