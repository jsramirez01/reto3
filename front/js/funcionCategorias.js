function traerInformacionCategorias(){
    $.ajax({
        url:"http://132.226.165.128:8080/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuestas(respuesta);
        }
    });
}

function pintarRespuestas(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].description+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado1").html(myTable);
}

function guardarInformacionCategorias(){
    let var2 = {
        name:$("#Cname").val(),
        description:$("#Cdescription").val()
        };

        $.ajax({
        type:'POST',
        contentType: "aplication/json; charset=utf-8",
        datatype: 'JSON',
        data: JSON.stringfy(var2),

        url:"http://152.67.41.215:8080/api/Category/save",

        success:function(response){
            console.log(response);
            console.log("Se guardo correctamente");
            alert("se guardo correctamente");
            windows.location.reload()
        },

        error: function(jqXHR, textStatus, errorThrown){
            window.location.reload()
            alert("No se guardo correctamente");
        }
        });
}
