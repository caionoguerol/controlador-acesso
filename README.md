

# Trabalho 01 – Tema Controle de Acesso

## Problema:
A UFSC necessita controlar os acessos de entrada e saída às diferentes salas e laboratórios. Essas salas só poderiam ser acessadas por pessoas da comunidade UFSC (Alunos e servidores) cadastradas no sistema e que tenham permissão para isso. 

Implementar um sistema orientado a objetos em Java para permitir o controle de acesso às salas da Universidade.


### Escopo do desenvolvimento:
Um sistema é responsável por controlar o acesso de pessoas às salas e laboratórios da UFSC.

#### O sistema deve permitir o cadastro das salas, contendo ao menos: Numero, bloco, centro e campus. 

#### Deve ser possível também cadastrar os funcionários Alunos e Professores, contendo no mínimo: número de matrícula, nome, email, telefone, cargo/curso, e nível de permissão ao sistema (usuário/administrador) . 

####  No cadastro da pessoa também deve ser possível indicar quais das salas cadastradas a pessoa poderá utilizar. E por sua vez o cadastro de pessoas também deve indicar quais salas uma pessoa é cadastrada.

#### O sistema deve portanto controlar o acesso às salas. Ao abrir o sistema, é perguntado o que a pessoa deseja fazer. Abrir a porta ou abrir o menu de gerenciamento Adm. Caso opte por abrir o gerenciamento, verifica se é ADM. Caso seja administrador abre-se opções de verificação de acesso ou gerenciamento do sistema (cadastro de salas e alunos, permissão ou retirada de acesso e relatório de acessos em uma determinada sala ou acessos feitos por uma pessoa).

#### Para permitir a entrada em uma das salas, o sistema deve verificar primeiramente se a matrícula da pessoa é válida (se existe algum pessoa cadastrado com aquele número de matrícula) e, em caso positivo, verificar se a pessoa possui permissão para entrar na sala.

#### Cada vez que uma sala é acessada por uma pessoa, deve ser registrado um evento do acesso permitido. Deve ser registrado: data e hora do acesso, matrícula da pessoa, o número da sala e uma informação de “Acesso Permitido” ou "Acesso Negado", caso seja negado o motivo da negação de acesso.

#### Se uma pessoa tentar acessar a sala, digitando sua matrícula, e tiver seu acesso negado, 
##### deve ser emitida uma mensagem com o motivo ("matrícula não existe, não possui acesso à sala, ou acesso bloqueado") 

##### e deve ser armazenado um registro da data e hora da tentativa de acesso negada. Deve ser registrado: data e hora da tentativa de acesso, matrícula do funcionário, número da sala e o motivo de negação de acesso.

#### Também deve ser possível pesquisar pelos registros de acesso negados ou permitidos. 
##### O sistema deve permitir emitir um relatório de acessos às salas, onde seja possível pesquisar pela matrícula da pessoa ou pelo número da sala.

