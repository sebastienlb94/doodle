$(function (){

    var $mail = $('#mail')
    var $name = $('#name')
    var $surname = $('#surname')
    var $phone = $('#phone')
    var $role = $('#role')
    var $website = $('#website')
    
    $('#contactSubmit').on('click',function() {
            $.ajax({
                type: 'POST',
                url: "http://127.0.0.1:8080/employees",
                data : {
                    firstName: $name.val(),
                    lastName: $surname.val(),
                    role: $role.val(),
                    mail: $mail.val(),
                    site: $website.val(),
                    numero: $phone.val()
                }
            });
    });
});