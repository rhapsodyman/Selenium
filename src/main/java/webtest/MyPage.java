package webtest;

public class MyPage extends AbstractPage {

	String left() {
		return (String) initOnDemand();
	}

	public static void main(String[] args) {
		MyPage page = new MyPage();
		String left = page.left();
	}

}
