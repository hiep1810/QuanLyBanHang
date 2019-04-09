package qlbh.tam;

import java.util.Random;
import java.util.Scanner;

public class TNV {
	private String ten;
	public String tenn[]={"NGUYỄN THỊ HÀ",
			"NGUYỄN THỊ XUÂN",
			"TRẦN THỊ THANH NGA", 
			"NGUYỄN THỊ THẢO", 
			"ĐỒNG THỊ HOÀI", 
			"HOÀNG THỊ PHA",  
			"NGUYỄN THỊ THÙY DUNG",  
			"NGUYỄN THỊ THU HÀ", 
			"ĐỖ THỊ THOA", 
			"NGUYỄN THU HIỀN", 
			"NGUYỄN THỊ NHƯ Ý", 
			"NGUYỄN THỊ HUYỀN", 
			"NGUYỄN THU HUYỀN",  
			"NGUYỄN HỒNG NHUNG",  
			"NGUYỄN THỊ NGỌC",   
			"NGUYỄN THỊ HỒNG DƯƠNG", 
			"TRẦN THỊ HIỀN ANH"
	};
	public TNV(){
		
	}
	public TNV(String ten){
		this.ten = ten;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public void nhap() {
		System.out.println("Nhập tên TNV: ");
		ten = new Scanner(System.in).nextLine();
	}
	public void show() {
		Random rd = new Random();
		for(int i=0; i<16;i++) {
			System.out.println(" ");
			int a = rd.nextInt(15);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(tenn[a]);
		}
	}
	public void randomArray(int array[]) {
        int number, nRCount = 0;
        boolean kt;
        Random rand = new Random();

        do {
            kt = true;
            number = rand.nextInt(17)+1;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == number) {
                    kt = false;

                }

            }
            if (kt = true) {
                array[nRCount] = number;
                nRCount++;
            }
        } while (nRCount < 9);

    }
	
	/*public static void main(String args[]) {
		TNV tn = new TNV();
		tn.show();
	}*/
}
