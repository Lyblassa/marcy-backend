-- Supprimer les tables si elles existent (ordre inverse à la création)
DROP TABLE IF EXISTS Decodeur_Chaine;
DROP TABLE IF EXISTS Decodeur;
DROP TABLE IF EXISTS Chaine;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Administrateur;
DROP TABLE IF EXISTS "User";

-- Table User (pour stocker les informations communes des utilisateurs)
CREATE TABLE User (
                        id SERIAL PRIMARY KEY,
                        email VARCHAR(100) UNIQUE,
                        mot_de_passe VARCHAR(100),
                        role VARCHAR(50) -- Peut être 'client' ou 'administrateur'
);

-- Table Administrateur (référence à la table User)
CREATE TABLE Administrateur (
                                id SERIAL PRIMARY KEY,
                                nom VARCHAR(50),
                                prenom VARCHAR(50),
                                user_id INTEGER REFERENCES User(id) ON DELETE CASCADE
);

-- Table Client (référence à la table User)
CREATE TABLE Client (
                        id SERIAL PRIMARY KEY,
                        nom VARCHAR(50),
                        prenom VARCHAR(50),
                        user_id INTEGER REFERENCES User(id) ON DELETE CASCADE
);

-- Table Décodeur
CREATE TABLE Decodeur (
                          id SERIAL PRIMARY KEY,
                          ip VARCHAR(15) UNIQUE,
                          client_id INTEGER REFERENCES Client(id) ON DELETE SET NULL
);

-- Table Chaine
CREATE TABLE Chaine (
                        id SERIAL PRIMARY KEY,
                        nom VARCHAR(100)
);

-- Table de liaison Décodeur <-> Chaine (relation plusieurs-à-plusieurs)
CREATE TABLE Decodeur_Chaine (
                                 decodeur_id INTEGER REFERENCES Decodeur(id) ON DELETE CASCADE,
                                 chaine_id INTEGER REFERENCES Chaine(id) ON DELETE CASCADE,
                                 PRIMARY KEY (decodeur_id, chaine_id)
);

-- Insertion de l'administrateur dans la table User
INSERT INTO User (email, mot_de_passe, role)
VALUES ('admin@decodeur.com', 'admin123', 'administrateur');

-- Insertion d'un client dans la table User
INSERT INTO User (email, mot_de_passe, role)
VALUES ('alice.dupont@email.com', '1234', 'client'),
       ('bob.lemoine@email.com', 'abcd', 'client'),
       ('carla.nguyen@email.com', 'pass123', 'client'),
       ('david.tremblay@email.com', 'secure', 'client'),
       ('emma.moreau@email.com', 'azerty', 'client'),
       ('franck.kouassi@email.com', 'password', 'client');

-- Insertion de l'administrateur dans la table Administrateur
INSERT INTO Administrateur (nom, prenom, user_id)
VALUES ('Admin', 'Principal', 1); -- Le user_id 1 fait référence à l'administrateur

-- Insertion des clients dans la table Client
INSERT INTO Client (nom, prenom, user_id) VALUES
                                              ('Dupont', 'Alice', 2),
                                              ('Lemoine', 'Bob', 3),
                                              ('Nguyen', 'Carla', 4),
                                              ('Tremblay', 'David', 5),
                                              ('Moreau', 'Emma', 6),
                                              ('Kouassi', 'Franck', 7);

-- Insertion des 12 décodeurs (1 IP par ligne)
INSERT INTO Decodeur (ip, client_id) VALUES
                                         ('127.0.10.1', 1),
                                         ('127.0.10.2', 1),
                                         ('127.0.10.3', 2),
                                         ('127.0.10.4', 2),
                                         ('127.0.10.5', 3),
                                         ('127.0.10.6', 3),
                                         ('127.0.10.7', 4),
                                         ('127.0.10.8', 4),
                                         ('127.0.10.9', 5),
                                         ('127.0.10.10', 5),
                                         ('127.0.10.11', 6),
                                         ('127.0.10.12', 6);

-- Insertion de chaînes
INSERT INTO Chaine (nom) VALUES
                             ('TVA'),
                             ('Radio-Canada'),
                             ('Canal Vie'),
                             ('Télé-Québec'),
                             ('VRAK'),
                             ('Canal D');

-- Exemple d'association chaînes-décodeurs
INSERT INTO Decodeur_Chaine (decodeur_id, chaine_id) VALUES
                                                         (1, 1), (1, 2), (1, 3),
                                                         (2, 1), (2, 4),
                                                         (3, 2), (3, 5),
                                                         (4, 6),
                                                         (5, 1), (5, 2), (5, 3),
                                                         (6, 4),
                                                         (7, 5),
                                                         (8, 6),
                                                         (9, 1), (9, 2),
                                                         (10, 3),
                                                         (11, 4),
                                                         (12, 5);

select * from Decodeur_Chaine;