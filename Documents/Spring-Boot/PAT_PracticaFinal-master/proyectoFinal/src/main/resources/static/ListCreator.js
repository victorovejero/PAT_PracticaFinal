window.onload = async function(){

    let accessToken = localStorage.getItem("accessToken");
    let url = 'api/v1/playlists/'+accessToken;

    fetch(url).then((response) => {
            response.json().then((data) => {
                // PROCESAR LA INFORMACION OBTENIDA DE LAS PLAYLISTS, CREAR EL HTML.
                const list = document.querySelector("#list");
                let nombre = [];
                for(i=0;i<data.length;i++){
                    nombre[i] = data[i].nombre;

                }
                for(i=0;i<data.length;i++){
                    const a = document.createElement("button");
                    a.textContent = nombre[i];
                    a.setAttribute("id",nombre[i])
                    a.setAttribute("class", "list-group-item");
                    a.setAttribute("onclick", 'GoToCanciones("'+nombre[i]+'")')
                    //a.addEventListener("click", GoToCanciones(nombre[i]));

//                    function(){
//                        localStorage.setItem("playlist",nombre[i]);
//                        console.log(localStorage.getItem("playlist"));
//                       // window.location.href = 'ListOfCanciones.html';
//                    });
                    list.appendChild(a);
                }

            });
       });



};


function GoToCanciones(nombre){
    localStorage.setItem("playlist",nombre);
    window.location.href = 'ListOfCanciones.html';
}
