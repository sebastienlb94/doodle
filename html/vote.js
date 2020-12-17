$(function (){

    var $idVote = $('#idVote')

    $('#plus').on('click',function() {
        $.ajax({
           type: 'GET',
           url: "http://127.0.0.1:8083/vote/plus/" + $idVote.val()
        });
    });

    $('#minus').on('click',function() {
        $.ajax({
           type: 'GET',
           url: "http://127.0.0.1:8083/vote/minus/" + $idVote.val()
        });
    });
});

