PMR2490_2014AGO_T4
==================

Repositório para Turma 4 do 2 semestre de 2014 de PMR2490

Instruções GitHub:

1) Baixe o Github para:
	-Windows: https://windows.github.com/
	-Mac: https://mac.github.com/

2) Instale no PC

3) Faça login

4) Pule a etapa de adicionar repositórios locais

5) Busque um repositório ( o do projeto )

6) Clone esse repositório no seu pc, ele conterá os dados mais atuais.

------------------------

Instruções MySQL:


1)Fazer download: http://www.mysql.com/downloads/ (precisa criar uma conta na Oracle, mas é de graça)

2) Baixar o Mysql Installer (V46646-01)

3) Baixar o MySQL Database (V46639-01)

4) Baixar o MySQL Workbench (V45910-01)

Ao instalar o MySQL Installer, vá em Add/Modify this product e selecione também os Conectores (ODBC, J, C++)

Depois ao configurar o MySQL Server, escolha como Development Machine e siga os outros passos.

5) Configurando o MySQL:

a) Adicionar no Path do sistema a pasta bin do MySQL

b) No prompt de comando digitar "mysql -u root -p" e Enter

c) Na área do mysql atualizar a senha do root :  update mysql.user set password = password('password_chosen') where user = 'root';

(Escolhemos uma senha unica juntos)

d) Deleter guest user: "delete from user where user = '';"

e) usar comando "flush privileges;"

d) sair usando "quit"

6) Criando database:

a) usar comando, sendo o mydb o nome da base (vamos utilizar o nome do projeto)

"CREATE DATABASE mydb
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;"

Ao final de tudo isso seu servidor estará pronto! O MySQL Workbench é o programa que tem toda uma interface gráfica para lidar com o servidor, permitindo criar schemas, tabelas e fazer QUERIES.

-------------

Repositório:

1) Download e instalação do Git:
 http://git-scm.com/downloads


 2) Clonar repositório:

> git clone https://github.com/Muriloo/PMR2490_3Design
