$(document).ready(function(){
    $('input[type=checkbox]').on('change', function() {
          if ($(this).is(':checked') ) {
              if($(this).prop("id") == 'checktelo'){
                $('#telO').prop('disabled',false);
              }
          } else {
            if($(this).prop("id") == 'checktelo'){
              $('#telO').prop('disabled',true);
            }
          }
      });
      $('input[type=checkbox]').on('change', function() {
            if ($(this).is(':checked') ) {
                if($(this).prop("id") == 'checkeo'){
                  $('#corro').prop('disabled',false);
                }
            } else {
              if($(this).prop("id") == 'checkeo'){
                $('#corro').prop('disabled',true);
              }
            }
        });
});
$('#newbtn').click(function(){
    var ans = confirm("¿Esta segur@ que desa crear?");
    if(ans == true){
        $('#newUsr').submit();
    }
});
