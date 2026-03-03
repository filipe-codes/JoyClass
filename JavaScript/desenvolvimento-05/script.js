const elementoBody = document.querySelector('body');

function titulo(){
    const elementoH1 = document.createElement('h1');
    elementoH1.setAttribute('id', 'titulo');
    elementoH1.textContent = 'Compre o melhor curso de JavaScript do mercado';
    elementoH1.style.color = 'blue';
    elementoBody.appendChild(elementoH1);
}

function imagem(){
    const elementoImg = document.createElement('img');
    elementoImg.setAttribute('height', '300');
    elementoImg.setAttribute('width', '300');
    elementoImg.setAttribute('src', './javascript-code.jpg');
    elementoBody.appendChild(elementoImg);
}

function paragrafo(texto){
    const elementoP = document.createElement('p');
    elementoP.textContent = texto;
    elementoBody.appendChild(elementoP);    
}

function botao(){
    const elementoButton = document.createElement('button');
    elementoButton.textContent = 'Comprar Agora';
    elementoButton.style.backgroundColor = 'green';
    elementoButton.style.color = 'white';
    elementoButton.style.padding = '10px 20px';
    elementoButton.style.border = 'none';
    elementoButton.style.borderRadius = '5px';
    elementoButton.style.cursor = 'pointer';
    elementoBody.appendChild(elementoButton);
}

titulo();
paragrafo("Aprenda JavaScript do zero ao avançado, com projetos práticos e suporte completo.");   
imagem();   
paragrafo("");    
botao();