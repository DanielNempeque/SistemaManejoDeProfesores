$('#btnmod').click(function(){
    var ans = confirm("¿Está seguro de que desea modificar?");
    if(ans == true){
        $('#modificaform').submit();
    }
});
$('#btndel').click(function(){
    var ans = confirm("¿Está seguro que desea eliminar?");
    if(ans == true){
        $('#formdel').submit();
    }
});
