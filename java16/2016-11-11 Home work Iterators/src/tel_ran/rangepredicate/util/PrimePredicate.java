package tel_ran.rangepredicate.util;


public class PrimePredicate extends NumberPredicate{

	@Override
	public boolean test(Integer t) {
		if (t<2) return false;
		if (t==2||t==3) return true;
		if (t%2==0)return false;
		for(int i=3;i*i<=t&&i*i>0;i+=2){
			if(t%i==0) return false;
		}		
		return true;
	}


	@Override
	public Integer getMatcingLargerOrEquel(int number) {
		if (number<=2) return 2;
		if (number%2==0) return getMatcingLargerOrEquel(number+1);
		
		while (!test(number)) number+=2;
		
		return number;
	}

}
