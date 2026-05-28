USE kursusbahasa;

CREATE TABLE bahasa(
id_bahasa varchar(10) NOT NULL PRIMARY KEY,
nama_bahasa VARCHAR(50) NOT NULL
);

CREATE TABLE jadwal(
id_jadwal varchar(10) NOT NULL PRIMARY KEY,
id_bahasa VARCHAR(10) NOT NULL,
hari VARCHAR(15) NOT NULL,
waktu VARCHAR (50) NOT NULL,
kelas VARCHAR(20) NOT NULL,
FOREIGN KEY (id_bahasa) REFERENCES bahasa (id_bahasa)
);

CREATE TABLE anggota(
id_anggota varchar(10) NOT NULL PRIMARY KEY,
id_bahasa varchar(10) NOT NULL,
id_jadwal varchar(10) not null,
nama_anggota VARCHAR(50) NOT NULL,
alamat VARCHAR(100) NOT NULL,
noHP varchar(50) NOT NULL,
FOREIGN KEY (id_bahasa) REFERENCES bahasa (id_bahasa)
);

CREATE TABLE tutor(
id_tutor VARCHAR(30) NOT NULL PRIMARY KEY,
id_bahasa varchar(10) NOT NULL,
nama_tutor VARCHAR(50) NOT NULL,
noHP varchar(50) NOT NULL,
alamat VARCHAR(100) NOT NULL,
FOREIGN KEY (id_bahasa) REFERENCES bahasa (id_bahasa)
);

CREATE TABLE transaksi(
id_transaksi VARCHAR (10) NOT NULL PRIMARY KEY,
id_anggota varchar (10) NOT NULL,
tgl_transaksi DATE NOT NULL,
nominal VARCHAR (100) NOT NULL,
keterangan VARCHAR (100) NOT NULL,
FOREIGN KEY (id_anggota) REFERENCES anggota (id_anggota)
);

CREATE TABLE login (
username VARCHAR (20) NOT NULL,
PASSWORD VARCHAR (20) NOT NULL
);

insert into bahasa values 
(1,'Inggris'),
(2,'Jepang'),
(3,'Korea');
select*from bahasa;

insert into tutor values
('I001',1,'Fadilatul Fitria,M.Pd',0815437682,'jl.Kenanga no.12'),
('I002',1,'Nurhayati,M.Si',0813425676,'jl.Anggrek no.10'),
('I003',1,'Rizal Furqon Ramadhan,S.Kom',0890807964,'jl.Indah no.5'),
('I004',1,'Dr.Irfan Khoiril Huda,M.Pd',0854345376,'jl.Pemuda no.11'),
('J001',2,'Yukimaru Samira,M.Pd',0812767088,'jl.Kemuning no.9'),
('J002',2,'Dr.Moh.Ahsan Rizal,M.Pd',0836678791,'jl.Mawar no.4'),
('J003',2,'Intan Dwi Wulandari,M.Pd',0851087987,'jl.Pagesangan no.10'),
('K001',3,'Hwang Seo Jun,M.Pd',0812324537,'jl.Indah no.20'),
('K002',3,'Kim Jennie,M.Pd',0837875463,'jl.Pahlawan no.14'),
('K003',3,'Dr.Guntur Lee,M.Pd',0898767501,'jl.Anggrek no.15');
select*from tutor;

insert into jadwal values
('IP1', 1, 'Senin, Kamis', '09.00-11.00', 'A'),
('IS1', 1, 'Senin, Kamis', '15.00-17.00', 'A'),
('JP2', 2, 'Selasa, Jumat', '09.00-11.00', 'B'),
('JS2', 2, 'Selasa, Jumat', '15.00-17.00', 'B'),
('KP3', 3, 'Rabu, Sabtu ', '09.00-11.00', 'C'),
('KS3', 3, 'Rabu, Sabtu', '15.00-17.00', 'C');
select*from jadwal;

insert into anggota values 
('231001','1','IP1','Heru Pamungkas','jl.Sakura no.1',0895467384),
('231002','1','IS1','Yuliansyah','jl.Melati no.14',0814567331),
('231003','1','IP1','Puspita Lestari','jl.Pahlawan no.2',0812433265),
('231004','1','IS1','Naufal Fatih','jl.Ahmad Yani no,1',0853440987),
('231005','1','IS1','IKirana Putri','jl.Sakura no.4',0813002561),
('231006','1','IS1','Hana Salsabila','jl.Anggrek no.5',0854677301),
('231007','1','IP1','Raka Athaya Pratama','jl.Pemuda no.7',0832400754),
('231008','1','IP1','Syahrul Latif','jl.Kalasan no.3',08947560065),
('231009','1','IS1','Alya Cahyani','jl.Tanjung Sari no.1',0853746529),
('231010','1','IP1','Muhammad Ardiansyah','jl.Tambaksari no.6',0836700987),
('231011','1','IP1','Rifky Andri Pradipta','jl.Pemuda no.8',0814352679),
('231012','1','IS1','Aini Mutiara Sabila','jl.Surapati no.3',0854676408),
('231013','1','IS1','Hilda Risyanda Putri','jl.Merdeka no.9',0894352368),
('231014','1','IP1','Shinta Permatasari','jl.Dahlia no.2',0832410046),
('231015','1','IP1','Prayuda Rachman','jl.Sakura no.4',0897354124),
('231016','1','IS1','Dinanta Putra','jl.Sakura no.3',08964530037),
('231017','1','IP1','Veny Nur Hikmah','jl.Sakura no.8',0897637384),
('231018','1','IS1','Dafa Yuda','jl.Ahmad Yani no.9',0814325347),
('231019','1','IS1','Muhammad Luthfi','jl.Sakura no.1',0895467986),
('231020','1','IP1','Okta Viana Cantika','jl.Surapati',0894256004),
('232001','2','JP2','Andre Setya','jl.Merdeka no.4',0853653428),
('232002','2','JS2','Ranty Syefana','jl.Dahlia no.1', 085465393),
('232003','2','JP2','Ayu Ikviani','jl.Denpasar',08143556006),
('232004','2','JS2','Rifqi Maulana Azmi','jl.Surapati',0814356473),
('232005','2','JP2','Veda Aini','jl.Nusantara no.4',0899956738),
('232006','2','JS2','Andre Gentala','jl.Anggrek',0834524396),
('232007','2','JP2','Alma Alsyantika','jl.Primbogo no.3',0899875004),
('232008','2','JP2','Suci Wulandari','jl.Merdeka no.5',0834098796),
('232009','2','JS2','Erika Nurfathaya','jl.gajah mada',0895467384),
('232010','2','JS2','Raka Putra Ananda','jl.Sakura no.5',0894320754),
('232011','2','JP2','Arka Rizal Anggoro','jl.Pahlawan no.3 ',0817243649),
('232012','2','JS2','Septi Rengganis','jl.Sakura no.1',0832456231),
('232013','2','JP2','Azza Andhika Putri','jl.Sakura no.2',0816574536),
('232014','2','JS2','Fitriani Alzidni','jl.Merdeka no.3',0854634524),
('232015','2','JP2','Riana Febriyanti','jl.Dahlia no.7',0815468976),
('232016','2','JP2','Sarah Pramitha Ayu','jl.Gajah Mada no.5',0896780435),
('232017','2','JS2','Nita Wahyuni','jl.Pahlawan no.5',0832451309),
('232018','2','JP2','Galih Andika','jl.Ahmad Yani no.4',0854690878),
('232019','2','JS2','Sindy Rahayu','jl.Pemuda no.3',0893245432),
('232020','2','JS2','Wirya Ramadhani','jl.Kalangan no.5',081543890435),
('233001','3','KP3','Muhammad Farhan','jl.Tanjung Sari no.7',0854634781),
('233002','3','KS3','Surya Adi Putra','jl.Dahlia no.6 ',0854634324),
('233003','3','KP3','Rissa Danias Putri','jl.Kalangan no.7',0832413865),
('233004','3','KS3','Erin Amrita','jl.Kebon Agung no.2',0819863727),
('233005','3','KS3','Evi Risyanda','jl.Pagesangan no.1',0896783421),
('233006','3','KP3','Anang Prabu Setya','jl.Jambangan no.4',08324154672),
('233007','3','KP3','Tina Wardanindya','jl.Jemursari no.5' ,0896479003),
('233008','3','KS3','Yulia Nirmala','jl.Pagesangan no.3',0815462398),
('233009','3','KP3','Dimas Primbayun','jl.Kebon agung no.6',0832415432),
('233010','3','KS3','Anggara Alfath','jl.Jambangan no.2',0817684351),
('233011','3','KP3','Dina Nuriyanti','jl.Tanjung Sari no.8',0854632451),
('233012','3','KS3','Bagas Setiyawan','jl.Blauran no.1',0832431246),
('233013','3','KP3','Ilya Maharani','jl.Blauran no.2',0815768452),
('233014','3','KS3','Nabila Putri','jl.Kendalsari no.1',0854673481),
('233015','3','KP3','Bayu Satria Andhika','jl.Kalisari no,1',0896574329),
('233016','3','KS3','Helmy Pebriyani','jl.Jagalan no.4',0854367321),
('233017','3','KS3','Dian Eka Lestari','jl.Kalianyar no.3',0832124785),
('233018','3','KP3','Indah Kartika Sari','jl.Kendalsari no.3',0836754218),
('233019','3','KS3','Erwin Girwantoro','jl.Jambangan no.5',0817684938),
('233020','3','KP3','Cindy Septiana','jl.Pagesangan no.8',0854327642);
select * from anggota;

INSERT INTO transaksi VALUES
('T001', '231001', '2023-09-01', 'Rp 2000000', 'Lunas'),
('T002', '231002', '2023-09-01', 'Rp 2000000', 'Lunas'),
('T003', '231003', '2023-09-02', 'Rp 1200000', 'Belum Lunas'),
('T004', '231004', '2023-09-02', 'Rp 2000000', 'Lunas'),
('T005', '231005', '2023-09-02', 'Rp 1000000', 'Belum Lunas'),
('T006', '231006', '2023-09-02', 'Rp 2000000', 'Lunas'),
('T007', '231007', '2023-09-03', 'Rp 2000000', 'Lunas'),
('T008', '231008', '2023-09-03', 'Rp 2000000', 'Lunas'),
('T009', '231009', '2023-09-04', 'Rp 2000000', 'Lunas'),
('T010','231010', '2023-09-05', 'Rp 1300000', 'Belum Lunas'),
('T011','231011', '2023-09-05', 'Rp 2000000', 'Lunas'),
('T012','231012', '2023-09-06', 'Rp 1000000', 'Belum Lunas'),
('T013','231013', '2023-09-07', 'Rp 2000000', 'Lunas'),
('T014','231014', '2023-09-07', 'Rp 1500000', 'Belum Lunas'),
('T015','231015', '2023-09-09', 'Rp 2000000', 'Lunas'),
('T016','231016', '2023-09-09', 'Rp 2000000', 'Lunas'),
('T017','231017', '2023-09-10', 'Rp 1300000', 'Belum Lunas'),
('T018','231018', '2023-09-11', 'Rp 2000000', 'Lunas'),
('T019','231019', '2023-09-13', 'Rp 1000000', 'Belum Lunas'),
('T020','231020', '2023-09-13', 'Rp 2000000', 'Lunas'),
('T021','232001', '2023-09-15', 'Rp 2000000', 'Lunas'),
('T022','232002', '2023-09-17', 'Rp 2000000', 'Lunas'),
('T023','232003', '2023-09-19', 'Rp 1500000', 'Belum Lunas'),
('T024','232004', '2023-09-21', 'Rp 2000000', 'Lunas'),
('T025','232005', '2023-09-22', 'Rp 2000000', 'Lunas'),
('T026','232006', '2023-09-24', 'Rp 2000000', 'Lunas'),
('T027','232007', '2023-09-24', 'Rp 2000000', 'Lunas'),
('T028','232008', '2023-09-25', 'Rp 1000000', 'Belum Lunas'),
('T029','232009', '2023-09-26', 'Rp 2000000', 'Lunas'),
('T030','232010', '2023-09-27', 'Rp 2000000', 'Lunas'),
('T031','232011', '2023-09-29', 'Rp 1000000', 'Belum Lunas'),
('T032','232012', '2023-09-30', 'Rp 2000000', 'Lunas'),
('T033','232013', '2023-10-01', 'Rp 2000000', 'Lunas'),
('T034','232014', '2023-10-02', 'Rp 1500000', 'Belum Lunas'),
('T035','232015', '2023-10-03', 'Rp 2000000', 'Lunas'),
('T036','232016', '2023-10-04', 'Rp 2000000', 'Lunas'),
('T037','232017', '2023-10-06', 'Rp 2000000', 'Lunas'),
('T038','232018', '2023-10-07', 'Rp 1500000', 'Belum Lunas'),
('T039','232019', '2023-10-07', 'Rp 2000000', 'Lunas'),
('T040','232020', '2023-10-09', 'Rp 2000000', 'Lunas'),
('T041','233001', '2023-10-10', 'Rp 2000000', 'Lunas'),
('T042','233004', '2023-10-14', 'Rp 2000000', 'Lunas'),
('T043','233003', '2023-10-15', 'Rp 1500000', 'Belum Lunas'),
('T044','233004', '2023-10-15', 'Rp 2000000', 'Lunas'),
('T045','233005', '2023-10-16', 'Rp 2000000', 'Lunas'),
('T046','233006', '2023-10-17', 'Rp 1000000', 'Belum Lunas'),
('T047','233007', '2023-10-18', 'Rp 2000000', 'Lunas'),
('T048','233008', '2023-10-18', 'Rp 2000000', 'Lunas'),
('T049','233009', '2023-10-19', 'Rp 2000000', 'Lunas'),
('T050','233010', '2023-10-20', 'Rp 1300000', 'Belum Lunas'),
('T051','233011', '2023-10-21', 'Rp 2000000', 'Lunas'),
('T052','233012', '2023-10-22', 'Rp 1000000', 'Belum Lunas'),
('T053','233013', '2023-10-22', 'Rp 2000000', 'Lunas'),
('T054','233014', '2023-10-23', 'Rp 2000000', 'Lunas'),
('T055','233015', '2023-10-25', 'Rp 2000000', 'Lunas'),
('T056','233016', '2023-10-26', 'Rp 1500000', 'Belum Lunas'),
('T057','233017', '2023-10-26', 'Rp 2000000', 'Lunas'),
('T058','233018', '2023-10-28', 'Rp 2000000', 'Lunas'),
('T059','233019', '2023-10-28', 'Rp 2000000', 'Lunas'),
('T060','233020', '2023-10-28', 'Rp 2000000' , 'Lunas');
select * from transaksi;

insert into login values
('andin','admin'),
('keke','admin'),
('afril','admin'),
('anisa','admin'),
('fina','admin'),
('sasa','admin'),
('zhoni','admin');

select*from transaksi order by left (id_transaksi,1), cast(substring(id_transaksi, 2)as unsigned);
insert into transaksi values ('V2', '231001', '2023-09-01', 'Rp 2000000', 'Lunas');