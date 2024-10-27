package appQuanLySach;


import java.util.Scanner;

import controller.SachController;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

public class MenuUIConsole {
		private Scanner scanner = new Scanner(System.in);
	    private SachController quanLySachController = new SachController();
	    
	    public void hienThiMenu() {
	        int choice;
	        do {
	        	System.out.println("\n----- MENU -----");
	            System.out.println("1. Thêm sách giáo khoa");
	            System.out.println("2. Thêm sách tham khảo");
	            System.out.println("3. Xóa sách");
	            System.out.println("4. Sửa thông tin sách");
	            System.out.println("5. Tìm kiếm sách theo mã");
	            System.out.println("6. Tính tổng thành tiền");
	            System.out.println("7. Tính trung bình đơn giá sách tham khảo");
	            System.out.println("8. Xuất sách giáo khoa theo nhà xuất bản");
	            System.out.println("9. In danh sách tất cả sách");
	            System.out.println("0. Thoát");
	            System.out.print("Chọn một chức năng: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Clear the buffer

	            switch (choice) {
	                case 1:
	                    themSachGiaoKhoa();
	                    break;
	                case 2:
	                    themSachThamKhao();
	                    break;
	                case 3:
	                    xoaSach();
	                    break;
	                case 4:
	                    suaSach();
	                    break;
	                case 5:
	                    timKiemSach();
	                    break;
	                case 6:
	                	tinhTongThanhTienTheoLoai();
	                    break;
	                case 7:
	                    tinhTrungBinhDonGiaSachThamKhao();
	                    break;
	                case 8:
	                    xuatSachGiaoKhoaTheoNXB();
	                    break;
	                case 9:
	                    inDanhSachSach();
	                    break;
	                case 0:
	                    System.out.println("Thoát chương trình.");
	                    break;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
	                    break;
	            }
	        } while (choice != 0);

	        scanner.close();
	    }

	    private Sach nhapThongTinSachCoBan() {
	    	
	        System.out.print("Nhập mã sách: ");
	        int maSach = scanner.nextInt();
	        scanner.nextLine();
	        
	        System.out.print("Nhập ngày nhập (yyyy-MM-dd): ");
	        String ngayNhap = scanner.nextLine();
	        
	        System.out.print("Nhập đơn giá: ");
	        double donGia = scanner.nextDouble();
	        System.out.print("Nhập số lượng: ");
	        int soLuong = scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.print("Nhập nhà xuất bản: ");
	        String nhaXuatBan = scanner.nextLine();

	       return new Sach(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
	       
	    }

	    private void themSachGiaoKhoa() {
	        Sach thongTinSach = nhapThongTinSachCoBan(); // Nhập thông tin cơ bản
	        System.out.print("Tình trạng sách (1: mới, 2: cũ): ");
            int tinhTrang = scanner.nextInt();
            

	        
	        SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa(
	        		thongTinSach.getMaSach(),
	        		thongTinSach.getNgayNhap(),
	        		thongTinSach.getDonGia(),
	        		 thongTinSach.getSoLuong(),
	        		thongTinSach.getNhaXuatBan(),
	        		(tinhTrang == 1? true: false)
	        );

	        quanLySachController.themSach(sachGiaoKhoa);
	        System.out.println("Đã thêm sách giáo khoa thành công.");
	    }

	    private void themSachThamKhao() {
	    	Sach thongTinSach = nhapThongTinSachCoBan(); 
	        System.out.print("Nhập thuế: ");
	        double thue = scanner.nextDouble();

	        
	        SachThamKhao sachThamKhao = new SachThamKhao(
	        		thongTinSach.getMaSach(),
	        		thongTinSach.getNgayNhap(),
	        		thongTinSach.getDonGia(),
	        		thongTinSach.getSoLuong(),
	        		thongTinSach.getNhaXuatBan(),
	        		thue
	        );

	        quanLySachController.themSach(sachThamKhao);
	        System.out.println("Đã thêm sách tham khảo thành công.");
	    }
	    private void xoaSach() {
	        System.out.print("Nhập mã sách cần xóa: ");
	        int maSach = scanner.nextInt();
	        quanLySachController.xoaSach(maSach);
	        System.out.println("Đã xóa sách có mã " + maSach);
	    }

	    private void suaSach() {
	        System.out.print("Nhập mã sách cần sửa: ");
	        int maSach = scanner.nextInt();
	        System.out.println("Nhập thông tin mới cho sách:");
	   
	        System.out.print("Nhập ngày nhập (yyyy-MM-dd): ");
	        String ngayNhap = scanner.nextLine();
	        
	        System.out.print("Nhập đơn giá: ");
	        double donGia = scanner.nextDouble();
	        System.out.print("Nhập số lượng: ");
	        int soLuong = scanner.nextInt();
	        scanner.nextLine(); // Clear the buffer
	        System.out.print("Nhập nhà xuất bản: ");
	        String nhaXuatBan = scanner.nextLine();
	        Sach sachMoi;
	        System.out.print("Sách giáo khoa (1) hay sách tham khảo (2): ");
	        int loaiSach = scanner.nextInt();
	        scanner.nextLine(); // Clear the buffer
	        if (loaiSach == 1) {
	            System.out.print("Tình trạng sách (1: mới, 2: cũ): ");
	            int tinhTrang = scanner.nextInt();
	            sachMoi = new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, (tinhTrang == 1? true: false));
	        } else {
	            System.out.print("Nhập thuế: ");
	            double thue = scanner.nextDouble();
	            sachMoi = new SachThamKhao(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, thue);
	        }
	        quanLySachController.suaSach(maSach, sachMoi);
	        System.out.println("Đã sửa sách có mã " + maSach);
	    }

	    private void timKiemSach() {
	        System.out.print("Nhập mã sách cần tìm: ");
	        int maSach = scanner.nextInt();
	        Sach sach = quanLySachController.timKiem(maSach);
	        if (sach != null) {
	            System.out.println("Thông tin sách: " + sach);
	        } else {
	            System.out.println("Không tìm thấy sách có mã " + maSach);
	        }
	    }

	    private void tinhTongThanhTienTheoLoai() {
	        System.out.print("Nhập loại sách (1:SachGiaoKhoa hoặc 2:SachThamKhao) Lưu ý: (nhập số 1 or 2): ");
	        String loaiSach = scanner.nextLine();

	        float tongThanhTien = quanLySachController.tinhTongThanhTienTheoLoai(loaiSach);
	        System.out.println("Tổng thành tiền cho " + (loaiSach =="1" ?"Sach Giao Khoa" : "Sach tham khao")  + ": " + tongThanhTien);
	    }

	    private void tinhTrungBinhDonGiaSachThamKhao() {
	        System.out.println("Trung bình đơn giá sách tham khảo: " + quanLySachController.tinhTrungBinhDonGiaSachThamKhao());
	    }

	    private void xuatSachGiaoKhoaTheoNXB() {
	        System.out.print("Nhập tên nhà xuất bản: ");
	        String nhaXuatBan = scanner.nextLine();
	        System.out.println("Danh sách sách giáo khoa của NXB " + nhaXuatBan + ":");
	        quanLySachController.xuatSachGiaoKhoaTheoNXB(nhaXuatBan).forEach(System.out::println);
	    }

	    private void inDanhSachSach() {
	        System.out.println("Danh sách tất cả sách:");
	        quanLySachController.inDanhSachSach();
	    }
}

