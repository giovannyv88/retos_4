
/////////Guardar usuarios///////////////
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

    $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(datos),
        url:"http://localhost:8080/api/user/new",
       
        
        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Registro guardado");
            window.location.href= "/paginas/admin.html";
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              
            alert("Ocurrio un error inesperado");
            window.location.reload()
    
    
        }
        });

}

/////////Login de usuario////////////////
function login(){
    let email = $("#email").val()
    let password = $("#password").val()

    $.ajax({
        
        url: "http://localhost:8080/api/user/"+ email + "/" + password,
        type: 'GET',
        dataType: 'json',

        success: function (respuesta) {
            
            console.log(respuesta);
            resultado(respuesta)	
        },

        
        error: function (xhr, status) {
            		
            console.log("algo fallo");	
        },
        
        complete: function (xhr, status) {
            console.log("Todo super bien"  + status);
        }
    });

}

function resultado(respuesta){
    let id = respuesta.id
    let nombre= respuesta.name

    if (id==null)
        alert("Usuario no registrado : " + nombre)
    else
        alert("Bienvenido : " + id + " "+ nombre)

}

function estadoInicial(){
    $("#email").focus()
}

