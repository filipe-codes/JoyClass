# Banco de Dados — Sistema Escolar

Projeto de banco de dados relacional com 4 tabelas vinculadas por chaves estrangeiras, incluindo consultas com JOIN.

---

## Diagrama das tabelas

```
PROFESSORES ──< CURSOS ──< MATRICULAS >── ALUNOS
```

| Tabela | Relacionamento |
|---|---|
| `professores` → `cursos` | Um professor ministra vários cursos |
| `cursos` → `matriculas` | Um curso recebe várias matrículas |
| `alunos` → `matriculas` | Um aluno realiza várias matrículas |

---

## Criação do banco de dados

```sql
CREATE DATABASE escola;
USE escola;
```

---

## Criação das tabelas

```sql
CREATE TABLE professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100)
);

CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    professor_id INT,
    carga_horaria INT,
    FOREIGN KEY (professor_id) REFERENCES professores(id)
);

CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    data_nascimento DATE
);

CREATE TABLE matriculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT NOT NULL,
    curso_id INT NOT NULL,
    data_matricula DATE DEFAULT (CURRENT_DATE),
    status VARCHAR(20) DEFAULT 'ativo',
    FOREIGN KEY (aluno_id) REFERENCES alunos(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
```

---

## Inserção de dados

```sql
INSERT INTO professores (nome, especialidade) VALUES
    ('Ana Lima', 'Banco de Dados'),
    ('Carlos Mendes', 'Desenvolvimento Web'),
    ('Fernanda Costa', 'Ciência de Dados');

INSERT INTO cursos (nome, professor_id, carga_horaria) VALUES
    ('SQL do Zero ao Avançado', 1, 40),
    ('HTML, CSS e JavaScript', 2, 60),
    ('Python para Dados', 3, 50);

INSERT INTO alunos (nome, email, data_nascimento) VALUES
    ('João Silva', 'joao@email.com', '2000-03-15'),
    ('Maria Souza', 'maria@email.com', '1999-07-22'),
    ('Pedro Alves', 'pedro@email.com', '2001-11-10'),
    ('Lucas Pereira', 'lucas@email.com', '1998-05-30');

INSERT INTO matriculas (aluno_id, curso_id, data_matricula, status) VALUES
    (1, 1, '2024-01-10', 'ativo'),
    (1, 3, '2024-01-10', 'ativo'),
    (2, 1, '2024-01-12', 'ativo'),
    (2, 2, '2024-01-12', 'concluido'),
    (3, 2, '2024-02-01', 'ativo'),
    (4, 3, '2024-02-05', 'ativo');
```

---

## Consultas com JOIN

### 1. INNER JOIN — alunos com seus cursos matriculados

```sql
SELECT 
    a.nome AS aluno,
    c.nome AS curso,
    m.data_matricula,
    m.status
FROM matriculas m
INNER JOIN alunos a ON m.aluno_id = a.id
INNER JOIN cursos c ON m.curso_id = c.id
ORDER BY a.nome;
```

### 2. LEFT JOIN — todos os cursos, mesmo sem matrículas

```sql
SELECT 
    c.nome AS curso,
    p.nome AS professor,
    COUNT(m.id) AS total_alunos
FROM cursos c
LEFT JOIN matriculas m ON c.id = m.curso_id
LEFT JOIN professores p ON c.professor_id = p.id
GROUP BY c.id, c.nome, p.nome;
```

### 3. JOIN triplo — aluno + curso + professor em uma consulta

```sql
SELECT 
    a.nome AS aluno,
    c.nome AS curso,
    p.nome AS professor,
    p.especialidade
FROM matriculas m
INNER JOIN alunos a    ON m.aluno_id = a.id
INNER JOIN cursos c    ON m.curso_id = c.id
INNER JOIN professores p ON c.professor_id = p.id
ORDER BY p.nome, a.nome;
```

### 4. Alunos com mais de uma matrícula ativa

```sql
SELECT 
    a.nome AS aluno,
    COUNT(m.id) AS total_matriculas
FROM alunos a
INNER JOIN matriculas m ON a.id = m.aluno_id
WHERE m.status = 'ativo'
GROUP BY a.id, a.nome
HAVING COUNT(m.id) > 1;
```
