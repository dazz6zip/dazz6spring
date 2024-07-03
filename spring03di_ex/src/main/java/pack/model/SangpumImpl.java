package pack.model;

public class SangpumImpl implements SangpumInter {
	@Override
	public int calcMoney(int st, int pr) {
		int result = st * pr;
		return result;
	}
}
