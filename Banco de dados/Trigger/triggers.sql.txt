CREATE TRIGGER trg_after_insert_pedido
AFTER INSERT
ON pedidos
FOR EACH ROW
BEGIN
    INSERT INTO log_pedidos (pedido_id, acao)
    VALUES (NEW.id, 'Pedido criado');
END;