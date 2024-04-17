-- Insertar datos de ejemplo en la tabla "factura"
INSERT INTO factura (name, nit, fechahora, total) VALUES ('Pablo', 123456789, '2024-04-16 10:00:00', 100.00);
INSERT INTO factura (name, nit, fechahora, total) VALUES ('Maria', 987654321, '2024-04-16 11:00:00', 200.00);
INSERT INTO factura (name, nit, fechahora, total) VALUES ('Juan', 111222333, '2024-04-16 12:00:00', 300.00);

-- Insertar datos de ejemplo en la tabla "detalleFactura"
INSERT INTO detalle_Factura (cantidad, precio, factura_id, product_id) VALUES (2, 40.00, 1, 1);
INSERT INTO detalle_Factura (cantidad, precio, factura_id, product_id) VALUES (1, 30.00, 1, 2);
