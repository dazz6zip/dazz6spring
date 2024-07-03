package pack.model;

public class SangpumImpl implements SangpumInter {
	@Override
	public String[] calcMoney(String sp, int st, int pr) {
		String[] result = {sp, Integer.toString(st * pr)};
		return result;
	}
}
