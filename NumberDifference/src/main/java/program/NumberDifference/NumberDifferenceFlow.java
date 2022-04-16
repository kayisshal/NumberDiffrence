package program.NumberDifference;

import java.util.ArrayList;

public class NumberDifferenceFlow {

	public void execute() {
		Screen layout =  new Screen();
		CalcNUmberDifference proc = new CalcNUmberDifference();
    	int nBil;
    	int differenceBil;
    	ArrayList<Integer> deretBil = new ArrayList<Integer>();
    	String messageGroup;
    	
    	layout.printHeader();
    	layout.printLabelInputNBilangan();
    	nBil = layout.inputNumberSingleValue();
		
    	if(proc.validateRangeInputMaxDeret(nBil)) {
    		layout.printLabelInputDeret();
    		deretBil = layout.inputNumberListValue(nBil);
    		differenceBil = proc.numberDiffirenceProcess(deretBil);
    		messageGroup = proc.groupingDifference(differenceBil);
    		System.out.println(messageGroup);
    	}else {
    		System.out.println("Number difference can not be processed");
    	}
	}
}
