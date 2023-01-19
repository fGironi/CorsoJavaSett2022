CREATE TABLE ALIMENTAZIONE (
nome VARCHAR(10) PRIMARY KEY,
descrizione VARCHAR(45)
);
INSERT INTO ALIMENTAZIONE (nome,descrizione) values('BENZINA', 'Benzina');
INSERT INTO ALIMENTAZIONE (nome,descrizione) values('METANO', 'Metano');
INSERT INTO ALIMENTAZIONE (nome,descrizione) values('ELETTRICA', 'Elettrica');
INSERT INTO ALIMENTAZIONE (nome,descrizione) values('GPL', 'GPL');
INSERT INTO ALIMENTAZIONE (nome,descrizione) values('IBRIDA', 'Ibrida');
INSERT INTO ALIMENTAZIONE (nome,descrizione) values('DIESEL', 'Diesel');

CREATE TABLE COSTRUTTORE (
nome VARCHAR(16) PRIMARY KEY,
descrizione VARCHAR(45)
);
INSERT INTO COSTRUTTORE (nome,descrizione) values('ALFAROMEO', 'Alfa Romeo');
INSERT INTO COSTRUTTORE (nome,descrizione) values('DALLARA', 'Dallara');
INSERT INTO COSTRUTTORE (nome,descrizione) values('FERRARI', 'Ferrari');
INSERT INTO COSTRUTTORE (nome,descrizione) values('FIAT', 'Fiat');
INSERT INTO COSTRUTTORE (nome,descrizione) values('LAMBORGHINI', 'Lamborghini');
INSERT INTO COSTRUTTORE (nome,descrizione) values('LANCIA', 'Lancia');
INSERT INTO COSTRUTTORE (nome,descrizione) values('MASERATI', 'Maserati');

CREATE TABLE COLORE (
codColore VARCHAR(6) PRIMARY KEY,
descrizione VARCHAR(45)
);
INSERT INTO COLORE (codColore,descrizione) values('NERSTD', 'nero');
INSERT INTO COLORE (codColore,descrizione) values('NERMTL', 'nero metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('NEROPC', 'nero opaco');
INSERT INTO COLORE (codColore,descrizione) values('BIASTD', 'bianco');
INSERT INTO COLORE (codColore,descrizione) values('BIAMTL', 'bianco metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('BIAOPC', 'bianco opaco');
INSERT INTO COLORE (codColore,descrizione) values('GRISTD', 'grigio');
INSERT INTO COLORE (codColore,descrizione) values('GRIMTL', 'grigio metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('GRIOPC', 'grigio opaco');
INSERT INTO COLORE (codColore,descrizione) values('BLUSTD', 'blu');
INSERT INTO COLORE (codColore,descrizione) values('BLUMTL', 'blu metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('BLUOPC', 'blu opaco');
INSERT INTO COLORE (codColore,descrizione) values('VERSTD', 'verde');
INSERT INTO COLORE (codColore,descrizione) values('VERMTL', 'verde metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('VEROPC', 'verde opaco');
INSERT INTO COLORE (codColore,descrizione) values('ROSSTD', 'rosso');
INSERT INTO COLORE (codColore,descrizione) values('ROSMTL', 'rosso metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('ROSOPC', 'rosso opaco');
INSERT INTO COLORE (codColore,descrizione) values('GIASTD', 'giallo');
INSERT INTO COLORE (codColore,descrizione) values('GIAMTL', 'giallo metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('GIAOPC', 'giallo opaco');
INSERT INTO COLORE (codColore,descrizione) values('MARSTD', 'marrone');
INSERT INTO COLORE (codColore,descrizione) values('MARMTL', 'marrone metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('MAROPC', 'marrone opaco');
INSERT INTO COLORE (codColore,descrizione) values('ARASTD', 'arancione');
INSERT INTO COLORE (codColore,descrizione) values('ARAMTL', 'arancione metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('ARAOPC', 'arancione opaco');
INSERT INTO COLORE (codColore,descrizione) values('VIOSTD', 'viola');
INSERT INTO COLORE (codColore,descrizione) values('VIOMTL', 'viola metallizzato');
INSERT INTO COLORE (codColore,descrizione) values('VIOOPC', 'viola opaco');

CREATE TABLE TIPOLOGIAACC(
nome VARCHAR(16) PRIMARY KEY,
descrizione VARCHAR(45),
categoria VARCHAR(7)
);
INSERT INTO TIPOLOGIAACC (nome,descrizione,categoria) values('CERCHI', 'Cerchi', 'Esterni');
INSERT INTO TIPOLOGIAACC (nome,descrizione,categoria) values('ENTERTAINMENT', 'Entertainmnet', 'Altro');
INSERT INTO TIPOLOGIAACC (nome,descrizione,categoria) values('SEDILI', 'Sedili', 'Interni');
INSERT INTO TIPOLOGIAACC (nome,descrizione,categoria) values('ALTRO', 'Altro', 'Altro');

CREATE TABLE AUTO(
id VARCHAR(5) PRIMARY KEY,
targa VARCHAR(8),
modello VARCHAR(45),
colore VARCHAR(6),
alimentazione VARCHAR(10),
costruttore VARCHAR(16), 
anno INT,
costoBase INT,
costoTot INT,
FOREIGN KEY (colore) REFERENCES COLORE(codColore),
FOREIGN KEY (alimentazione )REFERENCES ALIMENTAZIONE(nome),
FOREIGN KEY (costruttore) REFERENCES COSTRUTTORE(nome)
);

CREATE TABLE ACCESSORIO(
id INT PRIMARY KEY,
descrizione VARCHAR(45),
costo INT,
tipologia VARCHAR(16),
idAuto VARCHAR(5),
FOREIGN KEY (tipologia) REFERENCES TIPOLOGIAACC(nome),
FOREIGN KEY (idAuto) REFERENCES AUTO(id)
);


