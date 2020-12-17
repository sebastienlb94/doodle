$(function (){

    var $idDel = $('#idDel')

    $('#delete').on('click',function() {
        $.ajax({
           type: 'DELETE',
           url: "http://127.0.0.1:8080/employees/" + $idVote.val()
        });
    });
});

