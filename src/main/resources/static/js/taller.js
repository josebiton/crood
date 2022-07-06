$(document).ready(function (){
    listar();
});
function listar(){
   $.ajax({
        url: "/taller/all",
        type: 'GET',
        success: function (x) {
            $("#table tbody tr").remove();
            x.forEach((item,index,array)=>{
                $("#table").append(
                        "<tr>\n\
                            <td>" + (index + 1) + "</td>\n\
                            <td>" + item.tallTema + "</td>\n\
                            <td>" + item.tallFecha + "</td>\n\
                            <td>" + item.tallTime + "</td>\n\
\n\                         <td>" + item.tallLugar + "</td>\n\
                            <td>" + item.TallDireccion + "</td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='editar("+ item.tallId + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a>\n\
                            </td>\n\
                            <td style='text-align: center'>\n\
                                <a href='#' onclick='eliminar(" + item.tallId + ")'><i class='fa-solid fa-trash-can red'></i></a>\n\
                            </td>\n\
                        </tr>");
                
            });
    }
   }); 
}
function editar(id) {
    $.ajax({
        url: "/taller/" + id,
        type: 'GET',
        success: function (w) {
            $("#edit_id").val(w.tallId),
            $("#edit_tema").val(w.tallTema),
            $("#edit_fecha").val(w.tallFecha), 
            $("#edit_time").val(w.tallTime), 
            $("#edit_lugar").val(w.tallLugar), 
            $("#edit_direccion").val(w.tallDireccion)
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
                    url: "/taller/" + id,
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
        url: "/taller/save",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        //data: JSON.stringify({'nombres': nombre, 'apellidos': apellido, 'estado':true}),
        data: JSON.stringify({
            tallTema: $("#tema").val(),
            tallFecha: $("#fecha").val(), 
            tallTime: $("#time").val(), 
            tallLugar: $("#lugar").val(), 
            tallDireccion: $("#direccion").val(), 
             
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
    $("#tema").val(),
    $("#fecha").val(), 
    $("#time").val(), 
    $("#lugar").val(), 
    $("#direccion").val()
}

$("#modificar").click(function () {
    var tema = $("#editar_tema").val();
    var fecha = $("#editar_fecha").val();
    var time = $("#editar_time").val();
    var lugar = $("#editar_lugar").val();
    var direccion = $("#editar_direccion").val();
 
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
                    url: "/taller/update",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({
                        tallId: $("#edit_id").val(),
                        tallTema: $("#edit_tema").val(),
                        tallFecha: $("#edit_fecha").val(), 
                        tallTime: $("#edit_time").val(), 
                        tallLugar: $("#edit_lugar").val(), 
                        tallDireccion: $("#edit_direccion").val()
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
