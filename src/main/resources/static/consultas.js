//////Muestra informacion de los usuarios//////////
function infoUser(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/user/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            imprimirUser(respuesta);
        }
    });

}

/////Imprime informacion del usuario en tabla////////
function imprimirUser(respuesta){

    let myTable = "<table class='table table-striped table-dark'>"
    myTable+="<h3>Usuarios registrados</h3>"
    myTable += "<tr>";
    myTable += "<td>Identificación</td>";
    myTable += "<td>Nombre</td>";
    myTable += "<td>Direccion</td>";
    myTable += "<td>Telefono</td>";
    myTable += "<td>Correo</td>";
    myTable += "<td>Contraseña</td>";
    "</tr>";
    for (i = 0; i <respuesta.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + respuesta[i].identification + "</td>";
        myTable += "<td>" + respuesta[i].name + "</td>";
        myTable += "<td>" + respuesta[i].address + "</td>";
        myTable += "<td>" + respuesta[i].cellPhone + "</td>";
        myTable += "<td>" + respuesta[i].email + "</td>";
        myTable += "<td>" + respuesta[i].password + "</td>";
        myTable += '<td><button class = "btn btn-danger" onclick="borrarUser(' + respuesta[i].id + ')">Borrar</button></td>';
        myTable += '<td><button class = "btn btn-info" onclick="cargarUser(' + respuesta[i].id + ')">Cargar</button></td>';
        myTable += '<td><button class = "btn btn-warning" onclick="actualizarUser(' + respuesta[i].id + ')">Actualizar</button></td>';
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#tablaUser").html(myTable);

}

///Guarda un item de mi app/////////////
function guardarItem(){
    let datos={
        reference:$("#id2").val(),
        category:$("#cat").val(),
        description:$("#describe").val(),
        availability:$("#disponible").val(),
        price:$("#precio").val(),
        quantity:$("#cant").val(),
        photography:$("#imagen").val()
        
    };

    $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(datos),
        url:"http://168.138.143.61:8080/api/chocolate/new",
       
        
        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Item guardado");
            window.location.reload();
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              
            alert("Ocurrio un error inesperado");
            window.location.reload()
    
    
        }
        });

}


///////Trae informacion de mis productos registrados///////////
function infoItem(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/chocolate/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            mostrarItem(respuesta);
        }
    });

}

//////Funcion que imprime informacion de los items en tabla////////////
function mostrarItem(respuesta){

    let myTable = "<table class='table table-striped table-dark'>"
    myTable+="<h3>Productos en base de datos</h3>"
    myTable += "<tr>";
    myTable += "<th>Referencia</th>";
    myTable += "<th>Categoria</th>";
    myTable += "<th>Descripción</th>";
    myTable += "<th>Disponibilidad</th>";
    myTable += "<th>Precio item</th>";
    myTable += "<th>Cantidad</th>";
    myTable += "<th>Fotografia</th>";
    "</tr>";
    for (i = 0; i <respuesta.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + respuesta[i].reference + "</td>";
        myTable += "<td>" + respuesta[i].category + "</td>";
        myTable += "<td>" + respuesta[i].description + "</td>";
        myTable += "<td>" + respuesta[i].availability + "</td>";
        myTable += "<td>" + respuesta[i].price + "</td>";
        myTable += "<td>" + respuesta[i].quantity + "</td>";
        myTable += "<td>" + respuesta[i].photography + "</td>";
        myTable += '<td><button class = "btn btn-danger" onclick="borrarItem(' + respuesta[i].reference + ')">Borrar</button></td>';
        myTable += '<td><button class = "btn btn-info" onclick="cargarItem(' + respuesta[i].id + ')">Cargar</button></td>';
        myTable += '<td><button class = "btn btn-warning" onclick="actualizarItem(' + respuesta[i].reference + ')">Actualizar</button></td>';
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#tablaItem").html(myTable);

}


////Funcion guardar pedidos//////

function guardarOrden(){
    let datos={
        id:$("#id3").val(),
        registerDay:$("#registro").val(),
        status:$("#estado").val(),
        salesMan:$("#manSale").val(),
        products:$("#item2").val(),
        quantities:$("cantItem").val()   
    };

    $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(datos),
        url:"http://168.138.143.61:8080/api/order/new",
       
        
        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Pedido guardado");
            window.location.reload();
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              
            alert("Ocurrio un error inesperado");
            window.location.reload()
        }
        });

}


function infoPedido(){

    $.ajax({
        url:"http://168.138.143.61:8080/api/order/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            mostrarPedido(respuesta);
        }
    });

}

//////Funcion que imprime informacion de los items en tabla////////////
function mostrarPedido(respuesta){

    let myTable = "<table class='table table-striped table-dark'>"
    myTable+="<h3>Pedidos listados</h3>"
    myTable += "<tr>";
    myTable += "<td>Codigo Pedido</td>";
    myTable += "<td>Fecha Registro</td>";
    myTable += "<td>Estado Pedido</td>";
    myTable += "<td>Vendedor</td>";
    myTable += "<td>Productos de pedido</td>";
    myTable += "<td>Cantidades</td>";
    "</tr>";
    for (i = 0; i <respuesta.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + respuesta[i].id + "</td>";
        myTable += "<td>" + respuesta[i].registerDay + "</td>";
        myTable += "<td>" + respuesta[i].status + "</td>";
        myTable += '<td><button class = "btn btn-danger" onclick="borrarPedido(' + respuesta[i].id + ')">Borrar</button></td>';
        myTable += '<td><button class = "btn btn-info" onclick="cargarOrden('+ respuesta[i].id + ')">Cargar</button></td>';
        myTable += '<td><button class = "btn btn-warning" onclick="actualizarOrden(' + respuesta[i].id + ')">Actualizar</button></td>';
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#tablaPedido").html(myTable);

}


////////Actualizacion colecciones/////////////////

function actualizarUser(idElemento){
    let datosUser={
        id:idElemento,
        identification:$("#cedula").val(),
        name:$("#nombre").val(),
        address:$("#dir").val(),
        cellPhone:$("#tel").val(),
        email:$("#correo").val(),
        password:$("#pass").val()
        
    };
    console.log(datosUser);
    let dataToSend=JSON.stringify(datosUser);
    $.ajax({
        url:"http://168.138.143.61:8080/api/user/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#tablaUser").empty();
            $("#id1").val("");
            $("#cedula").val("");
            $("#nombre").val("");
            $("#dir").val("");
            $("#tel").val("");
            $("#correo").val("");
            $("#pass").val("");
            infoUser();
            alert("Usuario actualizado!!!")
            window.location.reload();
        }
    });
}

function actualizarItem(idElemento){
    let datosItem={
        id:idElemento,
        reference:$("#id2").val(),
        category:$("#cat").val(),
        description:$("#describe").val(),
        availability:$("#disponible").val(),
        price:$("#precio").val(),
        quantity:$("#cant").val(),
        photography:$("#imagen").val()
        
        
    };
    console.log(datosItem);
    let dataToSend=JSON.stringify(datosItem);
    $.ajax({
        url:"http://168.138.143.61:8080/api/chocolate/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#tablaItem").empty();
            $("#id2").val("");
            $("#cat").val("");
            $("#describe").val("");
            $("#precio").val("");
            $("#cant").val("");
            $("#imagen").val("");
            infoItem();
            alert("Item actualizado!!!")
            window.location.reload();
        }
    });
}


function actualizarOrden(idElemento){
    let datosOrden={
        id:idElemento,
        id:$("#id3").val(),
        registerDay:$("#registro").val(),
        status:$("#estado").val(),
        salesMan:$("#manSale").val(),
        products:$("#item2").val(),
        quantities:$("#cantItem").val()
        
        
    };
    console.log(datosOrden);
    let dataToSend=JSON.stringify(datosOrden);
    $.ajax({
        url:"http://168.138.143.61:8080/api/order/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#tablaPedido").empty();
            $("#id3").val("");
            $("#registro").val("");
            $("#estado").val("");
            $("#manSale").val("");
            $("#precio").val("");
            $("#item2").val("");
            $("#cantItem").val("");

            infoItem();
            alert("Orden  actualizada!!!")
            window.location.reload();
        }
    });
}

/////Cargar datos a formularios///////////
function cargarItem(idItem){
  
    $.ajax({
        dataType: 'json', 
        data: {id:idItem},
        url:"http://168.138.143.61:8080/api/chocolate/all",
        type:'GET',
        success:function(response) {
          console.log(idItem);
          console.log(response);
          var misItems = response;
          misItems.forEach(function(item){
            if (item.id == idItem){
              $("#id2").val(item.reference);
              $("#cat").val(item.category);
              $("#describe").val(item.description);
              $("#disponible").val(item.availability);
              $("#precio").val(item.price);
              $("#cant").val(item.quantity);
              $("#imagen").val(item.photography);
            };
          });
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              
        }
    });
  
  }


  function cargarUser(idUser){
  
    $.ajax({
        dataType: 'json', 
        data: {id:idUser},
        url:"http://168.138.143.61:8080/api/user/all",
        type:'GET',
        success:function(response) {
          console.log(idUser);
          console.log(response);
          var misUsers = response;
          misUsers.forEach(function(user){
            if (user.id == idUser){
              $("#id1").val(user.id);
              $("#cedula").val(user.identification);
              $("#nombre").val(user.name);
              $("#dir").val(user.address);
              $("#tel").val(user.cellPhone);
              $("#correo").val(user.email);
              $("#pass").val(user.password);
            };
          });
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              
        }
    });
  
  }

  function cargarOrden(idOrden){
  
    $.ajax({
        dataType: 'json', 
        data: {id:idOrden},
        url:"http://168.138.143.61:8080/api/order/all",
        type:'GET',
        success:function(response) {
          console.log(idOrden);
          console.log(response);
          var pedidosOrder = response;
          pedidosOrder.forEach(function(item){
            if (item.id == idOrden){
              $("#id3").val(item.id);
              $("#registro").val(item.registerDay);
              $("#estado").val(item.status);
              $("#manSale").val(item.salesMan);
              $("#precio").val(item.price);
              $("#item2").val(item.products);
              $("#cantItem").val(item.quantities);
            };
          });
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              
        }
    });
  
  }

/////////Borrar datos////////////
function borrarUser(id1) {
    var element = {
        id: id1
    }
    
    var dataToSend = JSON.stringify(element);

    $.ajax({
        dataType: 'json',
        data: dataToSend,
        url: "http://168.138.143.61:8080/api/user/" + id1,
        type: 'DELETE',
        contentType: "application/JSON",
        success: function (response) {
            console.log(response);
            $("#tablaUser").empty();

            alert("El usuario se ha eliminado!")
        },

        error: function (jqXHR, textStatus, errorThrown) {
            alert("Problemas al borrar usuario")
        }
    });
}

function borrarItem(reference) {
    console.log(reference);
    let elemento={
        id:reference
      };
      let dataToSend=JSON.stringify(elemento);
      //JSON= JavaScript Object Notation
      $.ajax({
            dataType:'json',
            data:dataToSend,
            url:"http://168.138.143.61:8080/api/chocolate/"+ reference,
            type:'DELETE',
            contentType:'application/json',
            success:function(response) {
                $("#tablaItem").empty();
                 alert("El item se ha eliminado!")
                console.log(response);
      
            },
         error: function(jqXHR, textStatus, errorThrown) {
            }
        });
      
}



function borrarPedido(id3) {
    var element = {
        id: id3
    }
    
    var dataToSend = JSON.stringify(element);

    $.ajax({
        dataType: 'json',
        data: dataToSend,
        url: "http://168.138.143.61:8080/api/order/" + id3,
        type: 'DELETE',
        contentType: "application/JSON",
        success: function (response) {
            console.log(response);
            $("#tablaPedido").empty();

            alert("El pedido se ha eliminado!")
        },

        error: function (jqXHR, textStatus, errorThrown) {
            alert("Problemas al borrar el pedido")
        }
    });
}









