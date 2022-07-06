$(document).ready(function (){
    listar();
});
function listar(){
   $.ajax({
        url: "/persona/all",
        type: 'GET',
        success: function (x) {
            $("#table tbody tr").remove();
            x.forEach((item,index,array)=>{
                $("#table").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.persApPaterno + " " + item.persApMaterno + "</td>\n\
                            <td>" + item.persNombres + "</td>\n\
                            <td>" + item.persDni + "</td>\n\
                            <td>" + item.persTelefono + "</td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='editar("+ item.persId + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a>\n\
                            </td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='eliminar(" + item.persId + ")'><i class='fa-solid fa-trash-can red'></i></a>\n\
                            </td>\n\
                        </tr>");
                
            });
    }
   }); 
}
function editar(id) {
    $.ajax({
        url: "/persona/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombres").val(w.nombres);
            $("#editar_apellidos").val(w.apellidos);
            $("#editar_id").val(w.id);
            $("#edit_persId").val(w.persId),
            $("#edit_apPaterno").val(w.persApPaterno),
            $("#edit_apMaterno").val(w.persApMaterno), 
            $("#edit_nombres").val(w.persNombres), 
            $("#edit_dni").val(w.persDni), 
            $("#edit_telefono").val(w.persTelefono)
        }
    });
    $("#editarModal").modal('show');
}
function eliminar(id) {
    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/persona/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}
$("#guardar").click(function () {
    $.ajax({
        url: "/persona/save",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        //data: JSON.stringify({'nombres': nombre, 'apellidos': apellido, 'estado':true}),
        data: JSON.stringify({
            persApPaterno: $("#apPaterno").val(),
            persApMaterno: $("#apMaterno").val(), 
            persNombres: $("#nombres").val(), 
            persDni: $("#dni").val(), 
            persTelefono: $("#telefono").val(), 
            persEstado:true
        }),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            /*bootbox.dialog({
                message: '<p class="text-center mb-0"><i class="fa fa-spin fa-cog"></i> Registro guardado correctamente</p>',
                closeButton: false,
            });*/
            // do something in the background
            // dialog.modal('hide');
            limpiar();
            listar();
        }
    });
    $("#exampleModal").modal('hide');
});
function limpiar() {
    $("#apPaterno").val(),
    $("#apMaterno").val(), 
    $("#nombres").val(), 
    $("#dni").val(), 
    $("#telefono").val()
}

$("#modificar").click(function () {
    var nombres = $("#editar_nombres").val();
    var apellidos = $("#editar_apellidos").val();
    var id = $("#editar_id").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/persona/update",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({
                        persId: $("#edit_persId").val(),
                        persApPaterno: $("#edit_apPaterno").val(),
                        persApMaterno: $("#edit_apMaterno").val(), 
                        persNombres: $("#edit_nombres").val(), 
                        persDni: $("#edit_dni").val(), 
                        persTelefono: $("#edit_telefono").val()
                    }),
                    // data: JSON.stringify({'id': id, 'nombres': nombres, 'apellidos': apellidos}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            /*callback: function () {
                                console.log('This was logged in the callback!');
                            }*/
                        });
                        limpiar();
                        listar();
                    }
                });
                $("#editarModal").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});
