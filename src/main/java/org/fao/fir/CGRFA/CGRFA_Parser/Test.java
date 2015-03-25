package org.fao.fir.CGRFA.CGRFA_Parser;

import java.io.FileNotFoundException;

import org.pdfbox.extension.XFA_Parser;
import org.pdfbox.extension.objects.Field;
import org.pdfbox.extension.objects.Subform;

public class Test {
	
	private static String INPUT = "/media/enrico/Data2/Adobe/CGRFA_dynamic_250312_filled.pdf";

	public static void main(String[] args) {
		try {
			XFA_Parser parser = new XFA_Parser(INPUT);
			parser.parse();
			
			Subform sf = parser.getTree();
			
			Subform sf2 = parser.getSubformByXPath("/Page14/q13Table");
			
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page14/q13Table/Item"); x++) {
				Field q13_01 = parser.getFieldByXPath("/Page14/q13Table/Item[" + Integer.toString(x) + "]/q13_01");
				Field q13_02 = parser.getFieldByXPath("/Page14/q13Table/Item[" + Integer.toString(x) + "]/q13_02");
				Field q13_03 = parser.getFieldByXPath("/Page14/q13Table/Item[" + Integer.toString(x) + "]/q13_03");
				Field q13_04= parser.getFieldByXPath("/Page14/q13Table/Item[" + Integer.toString(x) + "]/q13_04");
				
				System.out.println("Item " + Integer.toString(x));
				System.out.println(q13_01.getName() + " -> " + q13_01.getValue() );
				System.out.println(q13_02.getName() + " -> " + q13_02.getValue() );
				System.out.println(q13_03.getName() + " -> " + q13_03.getValue() );
				System.out.println(q13_04.getName() + " -> " + q13_04.getValue() );
				System.out.println("----------------------------------");
			}					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
