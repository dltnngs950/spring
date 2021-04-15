package kr.or.ddit.batch.ranger;

import org.springframework.batch.item.ItemProcessor;

public class RangerProcessor implements ItemProcessor<String, String>{

	// brown => sally => cony => moon => james
	@Override
	public String process(String item) throws Exception {
		
		return item + "modified";
	}

}
