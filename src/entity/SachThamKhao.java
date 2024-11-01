package entity;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao(int maSach, Ngay ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }
    
    public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public double tinhThanhTien() {
        return soLuong * donGia + thue;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thuế: " + thue + ", Thành Tiền: " + tinhThanhTien();
    }
}
