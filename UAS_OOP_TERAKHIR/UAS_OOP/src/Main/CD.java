package Main;

public class CD {
	private int idCD;
	private String title;
	private String qty;
	private String price;
	private String status;
	
	public CD(int idCD, String title, String qty, String price, String status) {
		this.idCD=idCD;
		this.title=title;
		this.qty=qty;
		this.price=price;
		this.status=status;
	}
	
	public int getid(){
        return idCD;
    }
	
	public String getname(){
        return title;
    }
	
	public String getqty(){
        return qty;
    }
	
	public String getprice(){
        return price;
    }
	
	public String getstatus(){
        return status;
    }
}
