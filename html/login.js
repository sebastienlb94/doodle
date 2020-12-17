$(function (){

    var $name = $('#name')
    var $pwd = $('#pwd')

    var token= "";

    $('#submit').on('click',function() {
        $.ajax({
            type: 'GET',
            url: "http://127.0.0.1:8081/login/" + $name.val() + '?' + $pwd.val(),
            success: function(key) {
                        token=key;            
            },
            error: function() {
                alert('error credentials');
            }
        });
    });
});
