package entity;

import java.util.Date;

public class SachGiaoKhoa extends Sach {
	 	private boolean tinhTrang; // true: mới, false: cũ
	 	private String loaiSach = "1";
	    public SachGiaoKhoa(int maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
	        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
	        this.tinhTrang = tinhTrang;
	    }

	    public String getLoaiSach() {
	    	return loaiSach;
	    }
	    public double tinhThanhTien() {
	        return tinhTrang ? soLuong * donGia : soLuong * donGia * 0.5;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + ", Tình Trạng: " + (tinhTrang ? "Mới" : "Cũ") + ", Thành Tiền: " + tinhThanhTien();
	    }
}
