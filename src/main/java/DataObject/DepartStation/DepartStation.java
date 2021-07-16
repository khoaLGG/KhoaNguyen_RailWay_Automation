package DataObject.DepartStation;

public class DepartStation {
    public static String [] departStation(){
        String [] departStation ={"ignore","Sài Gòn","Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi" };
        return departStation;
    }

    public static void main(String[] args) {
        String [] a = departStation();
        System.out.println(a[1]);
    }
}
