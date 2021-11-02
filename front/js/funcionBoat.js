funtion traerInformacionBoat(){
    $.ajax({
        url:"http://152.67.41.215:8080/api/Boat/all",
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
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].brand+"</td>";
        myTable+="<td>"+respuesta[i].year+"</td>";
        myTable+="<td>"+respuesta[i].description+"</td>";
        myTable+="</tr>";
   }
      myTable+="</table>";
      $("#resultado2").html(myTable);
}

funtion guardarBoat(){
    let var3 = {
        name:$("#Bname").val(),
        brand:$("#Bbrand").val(),
        year:$("#Byear").val(),
        description:$("#Bdescription").val()
    };

    $.ajax({
        type:'POST',
        contentType: "aplication/json; charset=utf-8",
        datatype: 'JSON',
        data: JSON.stringfy(var3),

        url:"http://152.67.41.215:8080/api/Boat/save",

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