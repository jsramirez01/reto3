funtion traerInformacionReservacionre(){
    $.ajax({
        url:"http://localhost:8080/api/Reservation/all",
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
        myTable+="<td>"+respuesta[i].starDate+"</td>";
        myTable+="<td>"+respuesta[i].devolutionDate+"</td>";
        myTable+="</tr>";
   }
   myTable+="</table>";
   $("#resultado5").html(myTable);
}

funtion guardarResevaciones(){
    let var6 = {
        starDate:$("#RstarDate").val(),
        devolutionDate:$("#RdevolutionDate").val()
    };

    $.ajax({
        type:'POST',
        contentType: "aplication/json; charset=utf-8",
        datatype: 'JSON',
        data: JSON.stringfy(var6),

        url:"http://localhost:8080/api/Reservation/save",

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