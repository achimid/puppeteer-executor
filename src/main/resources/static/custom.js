function liberaOpcoes() {
    if (this.event.target.value.length > 5) {
        let opcoes = document.getElementById("opcoes");
        opcoes.classList.remove('d-none');
    }
}

function iniciaBusca() {
    if (this.event.type === 'click' || this.event.key === "Enter") {
        // document.querySelector("main").className = 'busca-feita';
    }
}

function voltaBusca() {
    document.querySelector("main").className = '';
}



function onSubmit() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "url": document.getElementById("campoURL").value,
        "script": document.getElementById("campoOutro").value || undefined
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("/api/v1/execution", requestOptions)
        .then(response => response.json())
        .then(onResponseRequest)
        .catch(error => console.log('error', error));
}

function onResponseRequest(executionRequest) {
    let loop = setInterval(() => {
        fetch(`/api/v1/execution/${executionRequest.id}`)
            .then(res => res.json())
            .then(onResponseResult(loop))
            .catch(err => console.log("Aguardando resposta..."))
    }, 500)

    setTimeout(() => { clearInterval(loop) }, 30000)
}

const onResponseResult = (loop) => (execution) => {    
        clearInterval(loop)            
        console.log(execution)
}