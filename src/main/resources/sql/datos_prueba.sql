INSERT INTO Usuario (uid, username, password, roles) VALUES
   (1, 'admin', '$2a$10$DBc2FPq.4XperQMRTGpYnufwdTFxFCJtRZj1zsX.7vFo9YVe9rCyW', 'ADMIN'),
   (2, 'dani', '$2a$10$DBc2FPq.4XperQMRTGpYnufwdTFxFCJtRZj1zsX.7vFo9YVe9rCyW', 'USER'),
   (3, 'pedro', '$2a$10$DBc2FPq.4XperQMRTGpYnufwdTFxFCJtRZj1zsX.7vFo9YVe9rCyW', 'USER');

INSERT INTO Héroes (uid, nombre_heroe, inteligencia, fuerza, agilidad, vida, mana, historia_heroe) VALUES
   (1, 'Axe', 15, 25, 20, 700, 200, 'Un guerrero feroz que se alimenta del caos en el campo de batalla.'),
   (2, 'Crystal Maiden', 20, 18, 16, 500, 400, 'Una maga con poder sobre el hielo, controlando el campo de batalla.'),
   (3, 'Phantom Assassin', 18, 19, 23, 550, 300, 'Asesina entrenada para eliminar enemigos con precisión.'),
   (4, 'Invoker', 22, 18, 14, 520, 500, 'El mago más versátil, capaz de manipular múltiples hechizos.'),
   (5, 'Sniper', 16, 18, 23, 540, 320, 'Un maestro tirador que elimina enemigos desde la distancia.'),
   (6, 'Sven', 14, 26, 21, 680, 220, 'Guerrero de gran fuerza que lidera la carga con su espada poderosa.'),
   (7, 'Lina', 27, 16, 18, 490, 450, 'Una hechicera experta en fuego que puede devastar con su magia.'),
   (8, 'Earthshaker', 16, 22, 12, 600, 300, 'Un guerrero elemental que controla la tierra con golpes sísmicos.'),
   (9, 'Pudge', 13, 24, 14, 700, NULL, 'Un carnicero grotesco conocido por su garfio letal y resistencia.'),
   (10, 'Mirana', 20, 18, 22, 550, 400, 'Una princesa guerrera con habilidades mágicas y letales flechas.'),
   (11, 'Juggernaut', 14, 22, 20, 600, 300, 'Un espadachín ágil con habilidades de auto-regeneración y ofensiva.'),
   (12, 'Anti-Mage', 16, 18, 22, 540, 300, 'Un cazador de magos con un enfoque en destruir el maná enemigo.'),
   (13, 'Drow Ranger', 15, 18, 26, 520, 300, 'Una arquera silenciosa que controla el viento para vencer a sus enemigos.'),
   (14, 'Zeus', 26, 18, 15, 500, 500, 'El dios del trueno, maestro de los rayos y del daño global.'),
   (15, 'Tinker', 30, 16, 15, 480, 500, 'Un genio tecnológico que utiliza herramientas avanzadas para combatir.'),
   (16, 'Bristleback', 14, 28, 18, 700, NULL, 'Un guerrero tanque conocido por su durabilidad y contraataques.'),
   (17, 'Storm Spirit', 23, 18, 19, 520, 400, 'Un espíritu eléctrico que se mueve por el mapa con una velocidad vertiginosa.'),
   (18, 'Viper', 15, 21, 20, 580, 300, 'Una serpiente venenosa que castiga a los enemigos con ataques tóxicos.'),
   (19, 'Shadow Fiend', 18, 20, 20, 550, 300, 'Un demonio que acumula almas y desata explosiones de oscuridad.'),
   (20, 'Necrophos', 25, 20, 15, 520, 400, 'Un nigromante que drena la vida de los enemigos para curarse a sí mismo.');

INSERT INTO Objetos (uid, nombre_objeto, daño_fisico, daño_magico, vida_adicional, mana_adicional, regeneracion_mana, regeneracion_vida, descripcion_objeto) VALUES
    (1, 'Divine Rapier', 300, NULL, NULL, NULL, NULL, NULL, 'El arma definitiva para un daño físico masivo.'),
    (2, 'Aghanims Scepter', NULL, NULL, 200, 300, 1.0, 0.5, 'Mejora habilidades y añade nuevas capacidades a héroes específicos.'),
    (3, 'Heart of Tarrasque', NULL, NULL, 500, NULL, NULL, 1.5, 'Aumenta la vida y la regeneración del portador.'),
    (4, 'Blink Dagger', NULL, NULL, NULL, NULL, NULL, NULL, 'Permite teletransportarse a una ubicación cercana para evadir o iniciar combates.'),
    (5, 'Black King Bar', NULL, NULL, 300, NULL, NULL, NULL, 'Otorga inmunidad mágica temporal al portador.'),
    (6, 'Shadow Blade', 30, NULL, NULL, NULL, NULL, NULL, 'Permite al portador volverse invisible y aumentar su velocidad.'),
    (7, 'Manta Style', 26, NULL, NULL, 250, NULL, NULL, 'Crea ilusiones del héroe y disipa ciertos efectos negativos.'),
    (8, 'Scythe of Vyse', NULL, 35, NULL, 400, 2.5, NULL, 'Un cetro que transforma enemigos en criaturas inofensivas.'),
    (9, 'Monkey King Bar', 70, NULL, NULL, NULL, NULL, NULL, 'Proporciona daño físico y un golpe que no falla.'),
    (10, 'Desolator', 60, NULL, NULL, NULL, NULL, NULL, 'Un arma que reduce la armadura de los enemigos al golpear.'),
    (11, 'Eye of Skadi', 25, 25, 250, 250, NULL, NULL, 'Reduce la velocidad de movimiento y ataque de los enemigos.'),
    (12, 'Crimson Guard', NULL, NULL, 350, NULL, NULL, 1.0, 'Otorga un escudo protector que reduce el daño recibido.'),
    (13, 'Heavens Halberd', NULL, NULL, 200, NULL, NULL, NULL, 'Desactiva ataques básicos de un enemigo por unos segundos.'),
    (14, 'Ethereal Blade', NULL, 40, NULL, 200, 1.0, NULL, 'Convierte al objetivo en etéreo y aumenta el daño mágico recibido.'),
    (15, 'Radiance', 65, NULL, NULL, NULL, NULL, NULL, 'Causa daño continuo a enemigos cercanos.'),
    (16, 'Lotus Orb', NULL, NULL, 250, 300, 1.0, 1.0, 'Refleja habilidades enemigas dirigidas.'),
    (17, 'Force Staff', NULL, NULL, NULL, NULL, 1.0, NULL, 'Empuja a una unidad hacia adelante, amiga o enemiga.'),
    (18, 'Holy Locket', NULL, NULL, 250, 200, 2.0, NULL, 'Mejora las habilidades de curación del portador.'),
    (19, 'Vanguard', NULL, NULL, 250, NULL, NULL, 1.5, 'Bloquea daño recibido y aumenta la regeneración.'),
    (20, 'Battle Fury', 60, NULL, NULL, NULL, NULL, NULL, 'Proporciona daño en área con cada golpe.');

INSERT INTO heroe_objeto (id_heroe, id_objeto, cantidad_objeto) VALUES
    (1, 3, 1), -- Axe tiene un Heart of Tarrasque
    (1, 5, 2), -- Axe tiene 2 Black King Bars
    (2, 8, 1), -- Crystal Maiden tiene un Scythe of Vyse
    (2, 2, 1), -- Crystal Maiden tiene un Aghanim's Scepter
    (3, 10, 1), -- Phantom Assassin tiene una Desolator
    (3, 14, 1), -- Phantom Assassin tiene un Ethereal Blade
    (4, 6, 1), -- Invoker tiene una Shadow Blade
    (4, 8, 1), -- Invoker tiene un Scythe of Vyse
    (5, 9, 1), -- Sniper tiene un Monkey King Bar
    (5, 11, 1), -- Sniper tiene un Eye of Skadi
    (6, 15, 1), -- Sven tiene un Radiance
    (6, 5, 1), -- Sven tiene un Black King Bar
    (7, 13, 1), -- Lina tiene un Heaven's Halberd
    (7, 14, 1), -- Lina tiene un Ethereal Blade
    (8, 12, 1), -- Earthshaker tiene un Crimson Guard
    (8, 4, 1), -- Earthshaker tiene un Blink Dagger
    (9, 19, 1), -- Pudge tiene un Vanguard
    (9, 20, 1), -- Pudge tiene un Battle Fury
    (10, 7, 1), -- Mirana tiene un Manta Style
    (10, 17, 1); -- Mirana tiene un Force Staff