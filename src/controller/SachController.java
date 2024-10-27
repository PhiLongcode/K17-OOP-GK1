package controller;

import java.util.ArrayList;



import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

public class SachController {
	 	private ArrayList<Sach> danhSachSach;

	    public SachController() {
	        danhSachSach = new ArrayList<>();
	    }

		public void themSach(Sach sach) {
	        danhSachSach.add(sach);
	    }

	    public void xoaSach(int maSach) {
	        danhSachSach.removeIf(sach -> sach.getMaSach() == maSach);
	    }

	    public void suaSach(int maSach, Sach sachDaSua) {
	        for (int i = 0; i < danhSachSach.size(); i++) {
	        	  if (danhSachSach.get(i).getMaSach() == maSach) { 
	                  danhSachSach.set(i, sachDaSua);
	                break;
	            }
	        }
	    }

	    public Sach timKiem(int maSach) {
	    	for (Sach sach : danhSachSach) {
	            if (sach.getMaSach() == maSach) { 
	                return sach;
	            }
	        }
	        return null; 
	    }

	    public float tinhTongThanhTienTheoLoai(String loaiSach) {
	        float tongThanhTien = 0;

	        for (Sach sach : danhSachSach) {
	            if (loaiSach.equals("1") && sach instanceof SachGiaoKhoa) {
	                tongThanhTien += ((SachGiaoKhoa) sach).tinhThanhTien();
	            } else if (loaiSach.equals("2") && sach instanceof SachThamKhao) {
	                tongThanhTien += ((SachThamKhao) sach).tinhThanhTien();
	            }
	        }

	        return tongThanhTien;
	    }

	    public double tinhTrungBinhDonGiaSachThamKhao() {
	        double tongDonGia = 0;
	        int demSachThamKhao = 0;
	        for (Sach sach : danhSachSach) {
	            if (sach instanceof SachThamKhao) {
	                SachThamKhao sachThamKhao = (SachThamKhao) sach;
	                tongDonGia += sachThamKhao.getDonGia();
	                demSachThamKhao++;
	            }
	        }
	        return demSachThamKhao > 0 ? tongDonGia / demSachThamKhao : 0;
	    }

	    public ArrayList<SachGiaoKhoa> xuatSachGiaoKhoaTheoNXB(String nhaXuatBan) {
	        ArrayList<SachGiaoKhoa> sachGiaoKhoaTheoNXB = new ArrayList<>();
	        for (Sach sach : danhSachSach) {
	            if (sach instanceof SachGiaoKhoa) {
	                SachGiaoKhoa sachGiaoKhoa = (SachGiaoKhoa) sach;
	                if (sachGiaoKhoa.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
	                    sachGiaoKhoaTheoNXB.add(sachGiaoKhoa);
	                }
	            }
	        }
	        return sachGiaoKhoaTheoNXB;
	    }

	   
	    public void inDanhSachSach() {
	        for (Sach sach : danhSachSach) {
	            System.out.println(sach);
	        }
	    }
}
