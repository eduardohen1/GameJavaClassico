# GameJava - 🚀 A Simple Java Game with libGDX

## 📝 Descrição do Projeto
GameJava é um jogo simples desenvolvido em Java usando a biblioteca libGDX. O objetivo do jogo é controlar um personagem que pode saltar e disparar tiros para evitar obstáculos e acumular pontos. Este projeto é uma introdução divertida ao desenvolvimento de jogos 2D com Java e libGDX.

## 📂 Estrutura do Projeto
O projeto é composto pelas seguintes classes principais:

- Game.java: Configura a aplicação e inicializa a tela principal do jogo.
- GameScreen.java: Gerencia a lógica principal do jogo, como atualizações de estado, renderização e manipulação de elementos na tela.
- Player.java: Representa o jogador no jogo, incluindo a lógica de movimentação e colisões.
- Obstacle.java: Define os obstáculos que o jogador deve evitar.
- Shot.java: Implementa os tiros que o jogador pode disparar para destruir obstáculos.
- assets/: Contém as imagens e sons usados no jogo.

## ✨ Componentes do Jogo

### 🎮 Game.java
- Configura o título da janela e a resolução.
- Inicia o jogo chamando a classe GameScreen.

### 🌟 GameScreen.java
- Gerencia a lógica central do jogo:
- Atualiza o estado dos obstáculos e tiros.
- Renderiza todos os elementos, como o jogador, os obstáculos e o plano de fundo.
- Exibe o placar e os poderes disponíveis.
- Reseta o jogo após colisões.

### 🕹️ Player.java
- Controla o movimento do jogador (saltos).
- Gerencia a detecção de colisões com obstáculos.
- Posiciona o jogador no ponto inicial após o reset.

### 🚧 Obstacle.java
- Representa os obstáculos com movimentação horizontal.
- Gerencia colisões com o jogador e remoção ao sair da tela.

### 🔫 Shot.java
- Controla os tiros disparados pelo jogador.
- Detecta colisões com obstáculos.
- Remove os tiros ao sair da tela.

## 🛠️ Como Rodar o Projeto
*_Pré-requisitos:_*

### Instale o Java JDK 17+.
- Baixe e configure o libGDX.

*_Configuração:_*

### Clone este repositório.
- Certifique-se de que os arquivos de imagem e sons estejam na pasta assets/.
- Execução:

### Compile o projeto usando seu IDE favorito ou javac.
- Execute a classe Game.java.

## 🌈 Recursos Visuais
- Plano de Fundo: Uma cidade estilizada com visual vibrante.
- Jogador: Uma imagem personalizada representando o personagem principal.
- Obstáculos: Elementos animados que se movem da direita para a esquerda.
- Tiros: Disparos visuais que destroem obstáculos.

## 🎯 Objetivo do Jogo
- Controle o jogador para evitar obstáculos.
- Utilize os poderes (tiros) estrategicamente.
- Acumule pontos ao evitar ou destruir obstáculos.

## 📜 Licença
Este projeto é open-source e está disponível sob a licença MIT.

## 🤝Contribuições são bem-vindas! Sinta-se à vontade para explorar, contribuir e aprimorar este projeto.

Se precisar de mais detalhes ou quiser implementar melhorias, me avise! 🚀
