# Trabalho-Final-Paradigmas-de-Programacao

Trabalho desenvolvido na linguagem JAVA, para o trabalho de Paradigmas da Programação, pelos alunos: 

**Ana Letícia Souza Pinheiro,
Lucas Soares da Silva Lopes,
João Gabriel Ribeiro Holanda,
Fernanda Mendes Marques de Oliveira**

**ATENÇÃO!!!**

**PARA O FUNCIONAMENTO CORRETO, EXTRAIR DO ZIP BAIXADO A PASTA 'TRABALHO-FINAL-PARADIGMAS-DE-PROGRAMACAO'. APÓS ISSO, ABRIR EXATAMENTE A PASTA 'src' NA IDE (VSCODE RECOMENDADO) PARA QUE NÃO HAJA ERROS DE DIRETÓRIO.**

**ESPECIFICAÇÕES**
Este projeto é programa em JAVA para atendentes de companhias aéreas, permitindo a venda de passagens, controle de filas de espera e gerenciamento de passageiros. Cada voo tem capacidade máxima de 10 passageiros, com excedentes direcionados para uma fila de espera de até 5 pessoas. Os dados são persistidos em arquivos de texto, e o sistema opera para os voos BH-RIO, BH-SP e BH-BRASÍLIA.

**Funcionalidades do Menu**:

**1.** Lista de passageiros de um voo:
Exibe CPF, Nome, Número da Passagem e Número da Poltrona de todos os passageiros do voo.

**2.** Pesquisar passageiro por CPF:
Mostra o cadastro completo do passageiro, se presente na lista; caso contrário, exibe "Passageiro não consta neste voo".

**3.** Pesquisar passageiro por nome:
Mostra o cadastro completo do passageiro, se presente na lista; caso contrário, exibe "Passageiro não consta neste voo".

**4.** Cadastrar passageiro:
Adiciona passageiro no voo e automaticamente à fila de espera se a lista de passageiros estiver cheia; se a fila também estiver cheia, exibe "Fila Cheia, reserva não possível".

**5.** Excluir passageiro":
Remove o passageiro da lista e automaticamente move um passageiro da lista de espera para a lista oficial do voo; se não estiver presente, mostra "Passageiro não consta neste voo".

**6.** Lista de espera:
Mostra os passageiros da lista de espera do voo.

**Banco de dados**
**Nos arquivos .txt todos os voos estão lotados e apenas o voo de Brasília está com a lista de espera vazia!!**
