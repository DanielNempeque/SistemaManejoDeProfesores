$('#newbtn').click(function(){
    var ans = confirm("¿Está segur@ que desa crear?");
    if(ans == true){
        $('#newUsr').submit();
    }
});
function cargar(elemento){
    var file = elemento.files[0];
    var objHidden = document.form.hidd;
    objHidden.value = file.name;
}
$('#current').click();
$('#myModal').modal('show');

