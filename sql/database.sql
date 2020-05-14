select now(); 

create table Musteri(
	Id serial primary key not null,
	AdiSoyadi varchar(255),
	Telefon varchar(255),
	Adres varchar(255),
	Tel varchar(255),
	SehirId int
);
CREATE TABLE IF NOT EXISTS Kategori(
	Id  serial primary key NOT NULL,
	Adi VARCHAR(255),
	ParentId INT);
	
CREATE TABLE IF NOT EXISTS Urunler(
	Id  serial primary key NOT NULL,
	Adi VARCHAR(255), 
	KategoriId INT, 
	Tarih DATE, 
	Fiyat DECIMAL);
	

CREATE TABLE IF NOT EXISTS Yetkiler(
	Id serial primary key NOT NULL,
	Adi VARCHAR(255));
	
CREATE TABLE IF NOT EXISTS Accounts(
	Id serial primary key NOT NULL,
	YetkiId INT,
	PersonelId INT,
	Sifre VARCHAR(255));
	
CREATE TABLE IF NOT EXISTS Stok(
	Id serial primary key NOT NULL,
	UrunId INT,
	PersonelId INT,
	Tarih DATE,
	Adet INT);
	
CREATE TABLE IF NOT EXISTS Satis(
	Id serial primary key NOT NULL,
	UrunId INT,
	MusteriId INT,
	Tarih DATE,
	Adet INT,
	PersonelId INT);
	
CREATE TABLE IF NOT EXISTS Sehir(
	Id serial primary key NOT NULL,
	Sehir varchar(50));