
/////////Guardar usuarios///////////////
function emailExist() {
    var email = $("#correo").val();

    $.ajax({
        url: "http://168.138.143.61:8080/api/user/emailexist/"+email,
        type: 'GET',
        dataType: 'json',

        success: function (respuesta) {
            console.log(respuesta);
            if(respuesta){
                alert("Email ya existe en el sistema");
            }
            else{
                guardarUser();
            }
        },

        error: function (xhr, status) {
            console.log(status);
        }
    });
}



function guardarUser(){
    let datos={
        id:$("#id1").val(),
        identification:$("#cedula").val(),
        name:$("#nombre").val(),
        address:$("#dir").val(),
        cellPhone:$("#tel").val(),
        email:$("#correo").val(),
        password:$("#pass").val()
        
    };

    if($("#id1").val().length < 0 || $("#cedula").val().length < 0 || $("#nombre").val().length < 0 || $("#dir").val().length < 1
         || $("#tel").val().length < 1 || $("#correo").val().length < 1 || $("#pass").val().length < 1){
        
        alert("Todos los campos deben estar llenos!!");
        return false;
    }

    else{

    $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(datos),
        url:"http://168.138.143.61:8080/api/user/new",
       
        
        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Registro guardado");
            window.location.href= "/admin.html";
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              
            alert("Ocurrio un error inesperado");
            window.location.reload()
        }
        });
    }

}

/////////Login de usuario////////////////

function login(){
    
    let email = $("#correo").val()
    let password = $("#pass").val()
    console.log(email);
    console.log(password);

    if(email != "" && password != ""){
        $.ajax({
            
            url:'http://168.138.143.61:8080/api/user/'+email+'/'+password,
            type: 'GET',
            contentType: 'application/json',
            dataType : 'json',
            error : function(result){
                alert("Algo fallo con la sesion");
                console.log(result);
            },
            success: function(respuesta){
                console.log(respuesta);
                if(respuesta.id == null){
                    alert("No existe usuario con estos datos!");
                }
                else{
                    alert("Bienvenido: "+respuesta.name);
                    window.location.href = "admin.html";
                }
                $(':input').val('');
                $('#correo').focus();
            }
        });
        return false;
    }











}