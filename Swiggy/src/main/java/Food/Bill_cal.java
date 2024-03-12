package Food;

public class Bill_cal {
	
	public void Calculations (int amount) {
		
//		double percentage =0.5;
		double gst =3.25;
		int discount =100;
		double total = amount + (gst - discount); // with discount
		
		// without discount
		double without_discount = amount + gst;
	
		if(amount >= 1000) {
			System.out.println("BILL AMOUNT "+ amount);
			System.out.println("DISCOUNT AMOUNT " + discount);
			System.out.println("GST AMOUNT "+ gst);
			System.out.println("TOTAL AMOUNT "+ total);

		}
		else{
			System.out.println("BILL AMOUNT "+ amount);
			System.out.println("GST AMOUNT "+ gst);
			System.out.println("TOTAL AMOUNT "+ without_discount);


		}
	}



}
