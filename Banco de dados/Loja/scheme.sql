CREATE OR REPLACE FUNCTION total_clientes_por_dia(data_cadastro DATE)
RETURNS INTEGER
LANGUAGE plpgsql
AS $$
DECLARE
    total INTEGER;
BEGIN
    SELECT COUNT(*) INTO total
    FROM clientes
    WHERE DATE(data_cadastro) = data_cadastro;
    
    RETURN total;
END;
$$;

-- Como usar:
SELECT total_clientes_por_dia('2024-01-15');