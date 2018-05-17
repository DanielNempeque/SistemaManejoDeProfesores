$('#newbtn').click(function(){
    var ans = confirm("¿Está segur@ que desa crear?");
    if(ans == true){
        $('#newUsr').submit();
    }
});
$('#current').click();

