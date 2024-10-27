package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sach {
		protected int maSach;
	    protected String ngayNhap;
	    protected double donGia;
	    protected int soLuong;
	    protected String nhaXuatBan;
 
		public Sach(int maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
			this.maSach = maSach;
			this.ngayNhap = ngayNhap;
			this.donGia = donGia;
			this.soLuong = soLuong;
			this.nhaXuatBan = nhaXuatBan;
		}

		

	    public int getMaSach() {
			return maSach;
		}
		public void setMaSach(int maSach) {
			this.maSach = maSach;
		}
		public String getNgayNhap() {
			return ngayNhap;
		}
		public void setNgayNhap(String ngayNhap) {
			this.ngayNhap = ngayNhap;
		}
		public double getDonGia() {
			return donGia;
		}
		public void setDonGia(double donGia) {
			this.donGia = donGia;
		}
		public int getSoLuong() {
			return soLuong;
		}
		public void setSoLuong(int soLuong) {
			this.soLuong = soLuong;
		}
		public String getNhaXuatBan() {
			return nhaXuatBan;
		}
		public void setNhaXuatBan(String nhaXuatBan) {
			this.nhaXuatBan = nhaXuatBan;
		}
		@Override
	    public String toString() {
	        return "Mã Sách: " + maSach + ", Ngày Nhập: " + ngayNhap + ", Đơn Giá: " + donGia +
	                ", Số Lượng: " + soLuong + ", Nhà Xuất Bản: " + nhaXuatBan;
	    }

		
}