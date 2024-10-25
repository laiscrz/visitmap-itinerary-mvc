INSERT INTO itinerary (nome, pais, data_criacao) VALUES ('Exploração do Brasil', 'BRASIL', '2024-10-24');
INSERT INTO itinerary (nome, pais, data_criacao) VALUES ('Tour pela Europa', 'FRANCA', '2024-10-24');

INSERT INTO place (nome, descricao, cidade, estado, rua, tipo, entrada, url_imagem, description) VALUES ('Cristo Redentor', 'Estátua icônica no Rio de Janeiro', 'Rio de Janeiro', 'RJ', 'Rua Cosme Velho', 'Estatua', 'PAGO', 'https://abrir.link/ZLXgi', 'Uma das estátuas mais famosas do mundo, oferecendo uma vista panorâmica do Rio de Janeiro.');
INSERT INTO place (nome, descricao, cidade, estado, rua, tipo, entrada, url_imagem, description) VALUES ('Museu do Ipiranga', 'Museu histórico localizado em São Paulo', 'São Paulo', 'SP', 'Parque da Independência', 'MUSEU', 'PAGO', 'https://abrir.link/rztKU', 'Museu dedicado à história do Brasil, com exposições de artefatos históricos.');
INSERT INTO place (nome, descricao, cidade, estado, rua, tipo, entrada, url_imagem, description) VALUES ('Torre Eiffel', 'Famoso marco em Paris', 'Paris', 'Ile-de-France', 'Champ de Mars', 'OUTRO', 'PAGO', 'https://abrir.link/NdfEB', 'Uma das estruturas mais icônicas do mundo, localizada no coração de Paris.');
INSERT INTO place (nome, descricao, cidade, estado, rua, tipo, entrada, url_imagem, description) VALUES ('Museu do Louvre', 'Museu de arte famoso em Paris', 'Paris', 'Ile-de-France', 'Rue de Rivoli', 'MUSEU', 'PAGO', 'https://abrir.link/fYLhP', 'Casa de algumas das pinturas mais famosas do mundo, incluindo a Mona Lisa.');

INSERT INTO itinerary_place (itinerary_id, place_id) VALUES (1, 1);
INSERT INTO itinerary_place (itinerary_id, place_id) VALUES (1, 2);
INSERT INTO itinerary_place (itinerary_id, place_id) VALUES (2, 3);
INSERT INTO itinerary_place (itinerary_id, place_id) VALUES (2, 4);

