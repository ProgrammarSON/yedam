
public class ERP_DTO {
	private String index;
	//private String product_id;
	//private String amount;			//입고 ? or 출고 ?
	private int product_id;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private int amount;
	private String product_name;
	private String sar_date;
	private String total;
	private String warehouse;
	
	
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	
	/*public String getProduct_id() {
		return product_id;
	}*/
	/*public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}*/
	/*public String getAmount() {
		return amount;
	}*/
	/*public void setAmount(String amount) {
		this.amount = amount;
	}*/
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getSar_date() {
		return sar_date;
	}
	public void setSar_date(String sar_date) {
		this.sar_date = sar_date;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	/*public String printSAR() {
		return index + "\t" + product_id +"\t" + sar_date;  
	}*/
	
}
