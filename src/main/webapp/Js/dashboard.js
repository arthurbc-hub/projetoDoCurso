async function carregarEstoque() {
    try {
        const response = await fetch("/api/estoque");
        if (!response.ok) { console.error("Erro estoque:", response.status); return; }

        const dados = await response.json();
        const tabela = document.getElementById("corpoTabela");
        tabela.innerHTML = "";

        if (dados.length === 0) {
            tabela.innerHTML = "<tr><td colspan='10'>Nenhum produto cadastrado.</td></tr>";
            return;
        }

        dados.forEach(item => {
            tabela.innerHTML += `<tr>
                <td>${item.codigoBarras ?? ""}</td>
                <td>${item.nomeProduto ?? ""}</td>
                <td>${item.fabricante ?? ""}</td>
                <td>${item.marca ?? ""}</td>
                <td>${item.dataFabricacao ?? ""}</td>
                <td>${item.dataVencimento ?? ""}</td>
                <td>${item.quantidade ?? ""}</td>
                <td>${item.valor ?? ""}</td>
                <td>${item.total ?? ""}</td>
                <td>${item.status ?? ""}</td>
            </tr>`;
        });
    } catch (erro) {
        console.error("Erro ao carregar os produtos:", erro);
    }
}

async function carregarResumo() {
    try {
        const response = await fetch("/api/resumo");
        if (!response.ok) { console.error("Erro resumo:", response.status); return; }

        const dados = await response.json();
        document.getElementById("cardEntrada").innerHTML = dados.entrada ?? 0;
        document.getElementById("cardSaida").innerHTML   = dados.saida   ?? 0;
        document.getElementById("cardTotal").innerHTML   = dados.total   ?? 0;
    } catch (erro) {
        console.error("Erro ao carregar o resumo:", erro);
    }
}

window.onload = () => {
    carregarEstoque();
    carregarResumo();
};