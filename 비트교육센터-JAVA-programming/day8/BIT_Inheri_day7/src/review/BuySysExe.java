package review;

public class BuySysExe {

	public static void main(String[] args) {

		Person buyer1 = new Person("�赿��");
		CreditCard pay1 = new CreditCard();
		Order order1 = new Order( );
		order1.productOrder(buyer1, pay1 );
		Cash pay2 = new Cash();
		order1.productOrder(buyer1, pay2 );
		
		Person buyer2 = new Person("ȫ�浿");
		order1.productOrder(buyer2, pay1 );
	}

}
