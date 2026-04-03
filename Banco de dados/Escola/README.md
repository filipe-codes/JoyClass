Banco utilizado: SQLite

script utilizado:

CREATE TABLE "aluno" (
	"alunoID"	INTEGER NOT NULL UNIQUE,
	"nome"	TEXT NOT NULL,
	"email"	TEXT,
	"endereço"	TEXT NOT NULL,
	PRIMARY KEY("alunoID" AUTOINCREMENT)
);