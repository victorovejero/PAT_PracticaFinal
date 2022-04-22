//Funciones para buscar.

function PlaylistPorId(){
    var inputValue = document.getElementById("playlistId").value;
    var address;
    let username = localStorage.getItem("accessToken");

    if(inputValue == '' || inputValue == 'all'){
        address = '/api/v1/playlists';
    }else{
        address = '/api/v1/playlist/'+inputValue+'?'+'accessToken'+'='+accessToken;
    }
    console.log(address);
    window.location.href = address;
    return false;

}
function CancionPorId(){
    var inputValue = document.getElementById("cancionId").value;
    var address;

        if(inputValue == '' || inputValue == 'all'){
            address = 'ListOfCanciones.html';
        }else{
            address = '/api/v1/cancion/'+inputValue;
        }
    window.location.href = address;
    return false;

}
function UsuarioPorId(){
    var inputValue = document.getElementById("usuarioId").value;
    var address;
        if(inputValue == '' || inputValue == 'all'){
            address = '/api/v1/usuarios';
        }else{
            address = '/api/v1/usuario/'+inputValue;
        }
    window.location.href = address;
    return false;

}



//Funciones para borrar.
function BorraPlaylistPorId(){


    var inputValue = document.getElementById("playlistId").value;
    var address = '/api/v1/playlist/delete/'+inputValue;
    var currentAddress = window.location.href;
    window.location.href = address;
    window.location.href = currentAddress;
    alert("La playlist se ha borrado correctamente.");

    return false;

}
function BorraCancionPorId(){
    var inputValue = document.getElementById("cancionId").value;
    var address = '/api/v1/cancion/delete/'+inputValue;
    var currentAddress = window.location.href;
    window.location.href = address; //Consumimos el endpoint
    window.location.href = currentAddress; //Volvemos a la pagina instantaneamente
    alert("La cancion se ha borrado correctamente.");
    return false;

}
function BorraUsuarioPorId(){
    var inputValue = document.getElementById("usuarioUsername").value;
    var address = '/api/v1/usuario/delete/'+inputValue;
    var currentAddress = window.location.href;
    window.location.href = address;
    window.location.href = currentAddress;
    alert("El usuario se ha borrado correctamente.");

    return false;

}



//funciones para crear.

function CreatePlaylistMethod(){
    try {
        let inputValue1 = document.getElementById("playlist").value;
        var accessToken = localStorage.getItem("accessToken");
        const address = 'api/v1/playlist/create/'+inputValue1+"?user="+accessToken;
        fetch(address, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if(data.result == "OK") {
                    alert("Playlist Created");
                    document.location.href="/api/v1/playlists";
                }else {
                    alert(data.result);
                }
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;

}

