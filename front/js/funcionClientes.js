funtion traerInformacionClientes(){
    $.ajax({
        url:"http://localhost:8080/api/Client/all",
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
        myTable+="<td>"+respuesta[i].email+"</td>";
        myTable+="<td>"+respuesta[i].password+"</td>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].age+"</td>";
        myTable+="</tr>";
   }
      myTable+="</table>";
      $("#resultado3").html(myTable);

}

funtion guardarBoat(){
    let var4 = {
        email:$("CLemail").val(),
        password:$("CLpassword").val(),
        name:$("#CLname").val(),
        age:$("CLage").val()
    };

    $.ajax({
        type:'POST',
        contentType: "aplication/json; charset=utf-8",
        datatype: 'JSON',
        data: JSON.stringfy(var4),

        url:"http://localhost:8080/api/Client/save",

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