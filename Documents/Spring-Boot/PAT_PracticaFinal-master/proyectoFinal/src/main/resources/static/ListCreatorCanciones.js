window.onload = async function(){


    let playlist = localStorage.getItem("playlist");
    localStorage.removeItem("playlist");
    console.log(playlist);
    document.getElementById("titleCanciones").innerHTML = playlist;

    let url = 'api/v1/canciones/playlist/'+playlist;

    fetch(url).then((response) => {
            console.log(response);
            response.json().then((data) => {
                // PROCESAR LA INFORMACION OBTENIDA DE LAS PLAYLISTS, CREAR EL HTML.
                const list = document.querySelector("#list");

                if(data.length == 0){
                    const text = document.createElement("h3");
                    text.textContent = "No tienes ninguna canción en esta playlist.";
                    list.appendChild(text);
                }else{
                    for(i=0;i<data.length;i++){
                        const button = document.createElement("button");
                        let nombre = data[i].nombre;
                        let artista = data[i].artista;
                        button.textContent = nombre + " by " + artista;
                        button.setAttribute("class", "list-group-item");
                        button.addEventListener("click", function(){
                            console.log("HELLO WORLD!");
                            })
                        list.appendChild(button);
                    }
                }
            });
       });



};


function SendData(){
    let val = document.getElementById("HELLO").getAttribute("value");
    console.log(val);
}



