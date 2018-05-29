$('#cambio').click(function (){
    var con1 = $('#con1').val();
    var con2 = $('#con2').val();
    if(con1 == con2){
        $('#cambioForm').submit();
    }else{
        alert("Ingrese contraseñas iguales");
    }
});

