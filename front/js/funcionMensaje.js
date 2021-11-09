funtion traerInformacionMensaje(){
    $.ajax({
        url:"http://132.226.165.128:8080/api/Message/all",
        type:"GET",
        datatype:"JSON",
        success:funtion(resouesta){
            console.log(respuesta);
            PintarRespuesta(respuesta);
        }
    });
}

funtion pintarRespuesta(respuesta){
    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].messageText+"</td>";
        myTable+="</tr>";
   }
   myTable+="</table>";
   $("#resultado4").html(myTable);
}

funtion guardarBoat(){
    let var5 = {
        messageText:$("#MmessageText").val()
    };

    $.ajax({
        type:'POST',
        contentType: "aplication/json; charset=utf-8",
        datatype: 'JSON',
        data: JSON.stringfy(var5),

        url:"http://152.67.41.215:8080/api/Message/save",

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