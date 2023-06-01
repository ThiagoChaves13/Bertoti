async function buscarRoupa() {
    try {
        const response = await axios.get('http://localhost:8080/roupas');
        const roupas = response.data;
    
        const selectroupas = document.getElementById('tabela');
    
        roupas.forEach(roupa => {
          const linha = document.createElement('tr');
          const idRoupa = document.createElement ('td')
          idRoupa.textContent = roupa.id
          const roupaMarca = document.createElement ('td')
          roupaMarca.textContent = roupa.marca
          const roupaTamanho = document.createElement ('td')
          roupaTamanho.textContent = roupa.tamanho
          const roupaCor = document.createElement ('td')
          roupaCor.textContent = roupa.cor
          const roupaQuantidade = document.createElement ('td')
          roupaQuantidade.textContent = roupa.quantidade
          linha.appendChild(idRoupa)
          linha.appendChild(roupaMarca)
          linha.appendChild(roupaTamanho)
          linha.appendChild(roupaCor)
          linha.appendChild(roupaQuantidade)
          selectroupas.appendChild(linha)
        });
      } catch (error) {
        console.error(error)
      }
    }

async function cadastrar(){
    const marca = document.getElementById("txtmarca")
    const tamanho = document.getElementById("txttamanho")
    const cor = document.getElementById("txtcor")
    const quantidade = document.getElementById("txtquantidade")

     await axios.post('http://localhost:8080/roupas',{
        marca: marca.value,
        tamanho: tamanho.value,
        cor: cor.value,
        quantidade: quantidade.value
    })
}

document.addEventListener('DOMContentLoaded', () => {
    buscarRoupa();
  });
