import java.util.*;

public class SetFactory<E> {
	public Set<E> getSet(int setSelection){
		if(setSelection==1){
			return new HashSet<E>();
		}
		if(setSelection==2){
			return new TreeSet<E>();
		}
		if(setSelection==3){
			return new LinkedHashSet<E>();
		}
		return null;
	}
}
