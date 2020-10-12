create database CaPhe
go

use CaPhe
go


create table NhanVien(
MaNhanVien varchar(20) primary key,
Username varchar(50),
[Password] varchar(20),
TenNhanVien nvarchar(20),
NgaySinh datetime,
GioiTinh bit,
DiaChi nvarchar(20),
SoDienThoai varchar(20),
GR_name bit
)
go

create table KieuSanPham
(
	MaKieu varchar(20) primary key,
	TenKieu nvarchar(50),
	KichCo nvarchar(10)
)
go

create table SanPham
(
	MaSanPham varchar(20) primary key,
	MaKieu varchar(20) FOREIGN KEY REFERENCES KieuSanPham(MaKieu),
	TenSanPham nvarchar(100),
	KichCo nvarchar(10),
	GiaTien float
)
go

select * from SanPham

create table KichCo1(
	Kcid int not null identity(1,1) primary key,
	KichCo nvarchar(20)
)
go

create table Ban(
MaBan int primary key,
TenBan varchar(20),
TrangThai bit
)
go


create table GoiMon
(	
	MaBan int FOREIGN KEY REFERENCES Ban(MaBan),
	MaKieu varchar(20) FOREIGN KEY REFERENCES KieuSanPham(MaKieu),
	MaSanPham varchar(20) FOREIGN KEY REFERENCES SanPham(MaSanPham),
	SoLuong int,
	KichCo nvarchar(10),
	GiaTien float
)
go




-- thủ tục get all nhân viên
	
	create proc getAllNhanVien
	as
	select * from NhanVien
	go

	-- thủ tục update nhân viên

	create proc updateNhanVien
	@MaNhanVien varchar(20),
	@Username varchar(50),
	@Password varchar(20),
	@TenNhanVien nvarchar(20),
	@NgaySinh datetime,
	@GioiTinh bit,
	@DiaChi nvarchar(20),
	@SoDienThoai varchar(20),
	@GR_name bit
	as
	update NhanVien set Username=@Username,[Password]=@Password,TenNhanVien=@TenNhanVien,NgaySinh=@NgaySinh,GioiTinh=@GioiTinh,DiaChi=@DiaChi,SoDienThoai=@SoDienThoai,GR_name=@GR_name
	where MaNhanVien=@MaNhanVien
	go

	
	-- thủ tục get all kích cơ 

	create proc getAllKichCo
	as
	select * from KichCo1
	go
	-- thủ tục get all kiểu sản phẩm 
	create proc getAllKieuSanPham
	as
	select * from KieuSanPham
	go

	-- thủ tục update kiểu sản phẩm
	create proc updateKieuSanPham
	@MaKieu varchar(20),
	@TenKieu nvarchar(50),
	@KichCo nvarchar(10)
	as
	update KieuSanPham set TenKieu=@TenKieu,KichCo=@KichCo
	where MaKieu=@MaKieu
	go

	-- combobox kích cỡ
	insert into KichCo1 values (N'Nhỏ')
	insert into KichCo1 values (N'Vừa')
	insert into KichCo1 values (N'Lớn')

	-- thủ tục get all sản phẩm
	create proc getAllSanPham
	as
	select sp.MaSanPham,ksp.TenKieu,sp.TenSanPham,sp.KichCo,sp.GiaTien from SanPham sp inner join KieuSanPham ksp on sp.MaKieu=ksp.MaKieu
	go
	
	
	-- thủ tục update sản phẩm
	create proc updateSanPham
	@MaSanPham varchar(20),
	@MaKieu varchar(20),
	@TenSanPham nvarchar(100),
	@KichCo nvarchar(10),
	@GiaTien float
	as
	update SanPham set MaKieu=@MaKieu,TenSanPham=@TenSanPham,KichCo=@KichCo,GiaTien=@GiaTien
	where MaSanPham=@MaSanPham
	go

	-- thủ tục tìm kiếm sản phẩm 
	create proc timkiemSanPham
	@TenSanPham nvarchar(100)
	as
	select * from SanPham where TenSanPham like N'%' + @TenSanPham + '%'
	go
	-- thủ tục get bàn by id
	create proc getBanById
	@MaBan varchar
	as
	select * from Ban
	go
	-- thủ tục get all bàn
	create proc getAllBan
	as
	select * from Ban
	go
	-- thủ tục update bàn
	alter proc updateBan
	@MaBan int, 
	@TrangThai bit
	as
	update Ban set TrangThai=@TrangThai
	where MaBan=@MaBan
	go
	-- thủ tục get all gọi món 
	create proc getallGoiMon
	as
	select * from GoiMon
	go
	select * from KieuSanPham
	go
	select sp.TenSanPham,sp.GiaTien from SanPham sp inner join  KieuSanPham ksp on sp.MaKieu= ksp.MaKieu
	where ksp.TenKieu = N'Trà sữa'

	--create proc goi mon
	create proc getallSP
	as
	select sp.MaSanPham,sp.TenSanPham,ksp.TenKieu,sp.KichCo,sp.GiaTien from SanPham sp inner join KieuSanPham ksp on sp.MaKieu=ksp.MaKieu
	go
	
	select * from SanPham
	select sp.MaSanPham,sp.TenSanPham,ksp.TenKieu,sp.KichCo,sp.GiaTien from SanPham sp inner join KieuSanPham ksp on sp.MaKieu=ksp.MaKieu  where sp.MaSanPham =N'CF01'
	-- thủ tục thêm món
	create proc AddMon
	@MaBan int,
	@MaKieu varchar(20),
	@MaSanPham varchar(20),
	@SoLuong int,
	@KichCo nvarchar(10),
	@GiaTien float
	as
	insert into GoiMon values(@MaBan,@MaKieu,@MaSanPham,@SoLuong,@KichCo,@GiaTien)
	go
	drop proc AddMon
	select b.MaBan,b.TenBan,b.TrangThai from GoiMon gm inner join Ban b on gm.MaBan = b.MaBan where gm.MaBan = 3

	-- thủ tục getall gọi món
	select b.TenBan,ksp.TenKieu,sp.TenSanPham,gm.SoLuong,gm.KichCo,gm.GiaTien,(gm.SoLuong*gm.GiaTien) as 'Total' from GoiMon gm inner join SanPham sp on gm.MaSanPham = sp.MaSanPham
	inner join KieuSanPham ksp on gm.MaKieu = ksp.MaKieu
	inner join Ban b on gm.MaBan = b.MaBan
	where gm.MaBan=1
	select b.MaBan,b.TenBan,b.TrangThai from Ban b 
	select b.TenBan,ksp.TenKieu,sp.TenSanPham,gm.SoLuong,gm.KichCo,gm.GiaTien,(gm.SoLuong*gm.GiaTien) as 'Total' from GoiMon gm inner join SanPham sp on gm.MaSanPham = sp.MaSanPham
    inner join KieuSanPham ksp on gm.MaKieu = ksp.MaKieu
	inner join Ban b on gm.MaBan = b.MaBan
  	where gm.MaBan=1
	delete from GoiMon  where MaBan=1
	select * from GoiMon