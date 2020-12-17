$(function (){

    var $contacts = $('#contacts');
;


    $.ajax({
        type: 'GET',
        url: "http://127.0.0.1:8080/employees",
        success: function(embedded) {
            $.each(embedded, function(i, employees){
                if(!i){
                    $.each(employees.employee, function(i, employee)
                    {
                        $contacts.append('<li>' + employee.firstName + ' ' + employee.lastName + '<br>role :' +  employee.role + '<br>Mail :' +  employee.mail + '<br>Site :' + employee.site + '<br>Numéro :' + employee.numero +'<br>Bon travail :' + employee.bon  + '<br>Mauvais travail :' + employee.mauvais + '<br> <br> </li>');
                    });
                }
                });
        },
        error: function() {
            alert('error loading contacts');
        }
    });
});
