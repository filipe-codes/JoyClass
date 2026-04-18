DELIMITER $$

CREATE PROCEDURE relatorio_compras_por_dia()
BEGIN
    SELECT 
        DATE(data_compra) AS dia,
        COUNT(*) AS quantidade_produtos_comprados
    FROM compras
    GROUP BY DATE(data_compra)
    ORDER BY dia DESC;
END $$

DELIMITER ;