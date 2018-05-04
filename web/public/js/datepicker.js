$.cloudinary.config({ cloud_name: 'dnempeque', secure: true});
$('#fechaegreso').datepicker({
    uiLibrary: 'bootstrap4'
});
$('#fechaingreso').datepicker({
    uiLibrary: 'bootstrap4'
});
$(document).ready(function(){
  $('input[type=checkbox]').on('change', function() {
        if ($(this).is(':checked') ) {
            if($(this).prop("id") == 'checkfechaegreso'){
              $('#picker').show();
            }
        } else {
          if($(this).prop("id") == 'checkfechaegreso'){
            $('#picker').hide();
          }
        }
    });
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
