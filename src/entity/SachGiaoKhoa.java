package entity;



public class SachGiaoKhoa extends Sach {
	 	private boolean tinhTrang; // true: mới, false: cũ
	    public SachGiaoKhoa(int maSach, Ngay ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
	        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
	        this.tinhTrang = tinhTrang;
	    }

	    
	    public boolean isTinhTrang() {
			return tinhTrang;
		}

		public void setTinhTrang(boolean tinhTrang) {
			this.tinhTrang = tinhTrang;
		}

		public double tinhThanhTien() {
	        return tinhTrang ? soLuong * donGia : soLuong * donGia * 0.5;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + ", Tình Trạng: " + (tinhTrang ? "Mới" : "Cũ") + ", Thành Tiền: " + tinhThanhTien();
	    }
}
