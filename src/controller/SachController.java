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
	    
	    public boolean kiemTraMaSachTrung(int maSach) {
	        for( Sach sach: danhSachSach) {
	        	if(sach.getMaSach() == maSach) {
	        		return true;
	        	}
	        }
	        return false;
	    }
	    //Method them sach
		public void themSach(Sach sach) {
	        danhSachSach.add(sach);
	    }
		 //Method xoa sach
	    public void xoaSach(int maSach) {

	        if(danhSachSach.get(maSach).getMaSach() == maSach){
	            danhSachSach.remove(maSach);
	        }
	    }
	    //Method sua sach
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

	    public double tinhTongThanhTienTheoLoai(String loaiSach) {
	    	double tongThanhTien = 0;

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

	    public ArrayList<SachGiaoKhoa> xuatSachGiaoKhoaTheoNXB(String NXB) {
	        ArrayList<SachGiaoKhoa> sachGiaoKhoaTheoNXB = new ArrayList<>();
	        for (Sach sach : danhSachSach) {
	            if (sach instanceof SachGiaoKhoa) {
	                SachGiaoKhoa sachGiaoKhoa = (SachGiaoKhoa) sach;
	                if (sachGiaoKhoa.getNhaXuatBan().equalsIgnoreCase(NXB)) {
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
