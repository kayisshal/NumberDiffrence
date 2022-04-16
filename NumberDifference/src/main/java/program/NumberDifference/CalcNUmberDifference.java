package program.NumberDifference;

import java.util.ArrayList;

public class CalcNUmberDifference {

	// fungsi mengembalikan nilai selisih antara nilai terbesar dan terkecil
	public int numberDiffirenceProcess(ArrayList<Integer> deretBil) {
		int difference = 0;
		int min;
		int max;
		int idxDeretBil;
		
		min = deretBil.get(0);
		max = deretBil.get(0);

		for (idxDeretBil = 1; idxDeretBil < deretBil.size(); idxDeretBil++) { 
			if (deretBil.get(idxDeretBil) < min)
				min = deretBil.get(idxDeretBil);
			if (deretBil.get(idxDeretBil) > max)
				max = deretBil.get(idxDeretBil);
		}
		
		difference = max - min;
		
		return difference;
	}
	
	// fungsi mengembalikan jenis grup berdasarkan nilai selisih nilai terbesar dan terkecil
	// kelompok “Small Difference” untuk selisih berada di antara 1-10 
	// kelompok “Medium Difference” untuk selisih berada di antara 11-50
	// kelompok “Large Difference” untuk selisih berada di antara > 50
	// kelompok “There’s no difference” untuk selisih 0 atau tidak memiliki selisih, yaitu nilai terkecil = terbesar
	public String groupingDifference(int diff) {
		String message;
		int group;
		
		message = "Difference : " + diff; 
		if(diff>50) {
			group = 3;
		}else if(diff>=11 && diff<=50) { 
			group = 2;
		}else if(diff>=1 && diff<=10){ 
			group = 1;
		}else {
			group = 0;
		}
		
		if(group>0){
			message = message + "\nGroup " + group + ", ";
		}else{
			message = message + "\nNon Group ";
		}
		
		switch(group) {
			case 1: message = message + "Small Difference"; break; 
			case 2: message = message + "Medium Difference"; break;
			case 3: message = message + "Large Differece"; break;
			default: message = message + "There's no difference"; break;
		}
		
		return message;
	}
	
	// function validasi nilai N sesuai dengan range valid, yaitu N berada pada range 1-10
	// mengembalikan true, jika nilai N sesuai dengan range
	// // sebaliknya mengembalikan false
	public boolean validateRangeInputMaxDeret(int nBil) {
		boolean valid = false;
		if(nBil>=1 && nBil<=10) { 
			valid =  true;
		}
		return valid;
	}
}
