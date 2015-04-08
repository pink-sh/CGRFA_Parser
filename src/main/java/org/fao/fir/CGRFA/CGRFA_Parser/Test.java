package org.fao.fir.CGRFA.CGRFA_Parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.pdfbox.extension.XFA_Parser;
import org.pdfbox.extension.objects.Field;
import org.pdfbox.extension.objects.Subform;

public class Test {
	
	private static String INPUT = "/home/enrico/Desktop/Adobe/CGRFA_dynamic_newVersion_filled.pdf";

	public static void main(String[] args) {
		try {
			XFA_Parser parser = new XFA_Parser(INPUT);
			parser.parse();
			
			//To remove, just for debug purposes
			Subform sf = parser.getTree();
			
			//Get Meta Information
			Field Country = parser.getFieldByXPath("/Page3/txt_country/");
			Field PreparedBy = parser.getFieldByXPath("/Page3/txt_preparedBy/");
			Field Date = parser.getFieldByXPath("/Page3/txt_date/");
			Field ExecutiveSummary = parser.getFieldByXPath("/Page5/executiveSummary/");
			Field Introduction = parser.getFieldByXPath("/Page5/introduction/");
			
			
			//Question 1
			Field Question1 = parser.getFieldByXPath("/Page5/q1_subform/q1_radioList/");
			
			//Question 2
			Field Question2 = parser.getFieldByXPath("/Page6/q2_subform/q2_radioList/");
			
			//Question 3
			Field Question3Radio = parser.getFieldByXPath("/Page6/q3_subform/q3_radioList/");
			Field Question3Comments = parser.getFieldByXPath("/Page6/q3_txtinfo/");
			
			//Question 4
			Field Question4Radio = parser.getFieldByXPath("/Page6/q4_subform/q4_radioList/");
			Field Question4Comments = parser.getFieldByXPath("/Page6/q4_txtinfo/");
			
			//Question 5
			Field Question5Radio = parser.getFieldByXPath("/Page7/q5_sf/q5_radioList/");
			Field Question5Comments = parser.getFieldByXPath("/Page7/q5_sf/q5_txtinfo/");
			
			//Question 6
			Field Question6Perc1 = parser.getFieldByXPath("/Page7/q6_sf/q6_txtperc1/");
			Field Question6Perc2 = parser.getFieldByXPath("/Page7/q6_sf/q6_txtperc2/");
			Field Question6Perc3 = parser.getFieldByXPath("/Page7/q6_sf/q6_txtperc3/");
			Field Question6Comments = parser.getFieldByXPath("/Page7/q6_sf/q6_txtinfo/");
			
			//Question7
			Field Question7Radio = parser.getFieldByXPath("/Page7/q7_sf/q7_radioList/");
			
			
			//Question8
			List<ArrayList<Field>> Question8 = new ArrayList<ArrayList<Field>>();
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page8/q8Table/Item"); x++) {
				ArrayList<Field> t = new ArrayList<Field>();
				
				Field q8_01 = parser.getFieldByXPath("/Page8/q8Table/Item[" + Integer.toString(x) + "]/q8_species");
				Subform q8_02_sf = parser.getSubformByXPath("/Page8/q8Table/Item[" + Integer.toString(x) + "]/q8_q2");
				
				Field q8_03 = parser.getFieldByXPath("/Page8/q8Table/Item[" + Integer.toString(x) + "]/q8_txtName");
				
				t.add(q8_01);
				t.add(buildCheckBoxList(q8_02_sf, "q8_02"));
				t.add(q8_03);
				
				Question8.add(t);
			}
			
			
			List<ArrayList<Field>> Question9 = new ArrayList<ArrayList<Field>>();
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page9/q9Table/Item"); x++) {
				ArrayList<Field> t = new ArrayList<Field>();
				
				Field q9_01 = parser.getFieldByXPath("/Page9/q9Table/Item[" + Integer.toString(x) + "]/q9_farmedSpecies");
				Subform q9_02 = parser.getSubformByXPath("/Page9/q9Table/Item[" + Integer.toString(x) + "]/q9_chk2");
				Field q9_03 = parser.getFieldByXPath("/Page9/q9Table/Item[" + Integer.toString(x) + "]/q9_chk3/q9_radio3");
				Field q9_04 = parser.getFieldByXPath("/Page9/q9Table/Item[" + Integer.toString(x) + "]/q9_chk4/q9_radio4");
				Field q9_05 = parser.getFieldByXPath("/Page9/q9Table/Item[" + Integer.toString(x) + "]/q9_chk5/q9_radio5");
				Subform q9_06 = parser.getSubformByXPath("/Page9/q9Table/Item[" + Integer.toString(x) + "]/q9_chk6");
				Subform q9_07 = parser.getSubformByXPath("/Page9/q9Table/Item[" + Integer.toString(x) + "]/q9_chk7");
				Field q9_08 = parser.getFieldByXPath("/Page9/q9Table/Item[" + Integer.toString(x) + "]/q9_txtComments");
				t.add(q9_01);
				t.add(buildCheckBoxList(q9_02, "q9_02"));
				t.add(q9_03);
				t.add(q9_04);
				t.add(q9_05);
				t.add(buildCheckBoxList(q9_06, "q9_06"));
				t.add(buildCheckBoxList(q9_07, "q9_07"));
				t.add(q9_08);
				Question9.add(t);
			}
			
			List<ArrayList<Field>> Question10 = new ArrayList<ArrayList<Field>>();
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page11/q10Table/Item"); x++) {
				ArrayList<Field> t = new ArrayList<Field>();

				Field q10_01 = parser.getFieldByXPath("/Page11/q10Table/Item[" + Integer.toString(x) + "]/q10_01/");
				Field q10_02 = parser.getFieldByXPath("/Page11/q10Table/Item[" + Integer.toString(x) + "]/q10_02/q10_radio2");
				Field q10_03 = parser.getFieldByXPath("/Page11/q10Table/Item[" + Integer.toString(x) + "]/q10_03/");
				
				t.add(q10_01);
				t.add(q10_02);
				t.add(q10_03);
				Question10.add(t);
			}
			
			List<ArrayList<Field>> Question11 = new ArrayList<ArrayList<Field>>();
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page12/q11Table/Item"); x++) {
				ArrayList<Field> t = new ArrayList<Field>();

				Field q11_01 = parser.getFieldByXPath("/Page12/q11Table/Item[" + Integer.toString(x) + "]/q11_01/");
				Field q11_02 = parser.getFieldByXPath("/Page12/q11Table/Item[" + Integer.toString(x) + "]/q11_02/q11_radio2");
				Subform q11_03 = parser.getSubformByXPath("/Page12/q11Table/Item[" + Integer.toString(x) + "]/q11_03/");
				Subform q11_04 = parser.getSubformByXPath("/Page12/q11Table/Item[" + Integer.toString(x) + "]/q11_04/");

				Field q11_05 = parser.getFieldByXPath("/Page12/q11Table/Item[" + Integer.toString(x) + "]/q11_05/");
				
				
				t.add(q11_01);
				t.add(q11_02);
				t.add(buildCheckBoxList(q11_03, "q11_03"));
				t.add(buildCheckBoxList(q11_04, "q11_04"));
				t.add(q11_05);
				Question11.add(t);
			}
			
			List<ArrayList<Field>> Question12 = new ArrayList<ArrayList<Field>>();
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page13/q12Table/Item"); x++) {
				ArrayList<Field> t = new ArrayList<Field>();

				Field q12_01 = parser.getFieldByXPath("/Page13/q12Table/Item[" + Integer.toString(x) + "]/q12_01/");
				Subform q12_02 = parser.getSubformByXPath("/Page13/q12Table/Item[" + Integer.toString(x) + "]/q12_02/");
				Field q12_03 = parser.getFieldByXPath("/Page13/q12Table/Item[" + Integer.toString(x) + "]/q12_03/");
				
				t.add(q12_01);
				t.add(buildCheckBoxList(q12_02, "q12_02"));
				t.add(q12_03);
				Question12.add(t);
			}
			
			List<ArrayList<Field>> Question13 = new ArrayList<ArrayList<Field>>();
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page13/q12Table/Item"); x++) {
				ArrayList<Field> t = new ArrayList<Field>();

				Field q13_01 = parser.getFieldByXPath("/Page14/q13Table/Item[" + Integer.toString(x) + "]/q13_01/");
				Subform q13_02 = parser.getSubformByXPath("/Page14/q13Table/Item[" + Integer.toString(x) + "]/q13_02/");
				Subform q13_03 = parser.getSubformByXPath("/Page14/q13Table/Item[" + Integer.toString(x) + "]/q13_03/");
				Field q13_04 = parser.getFieldByXPath("/Page14/q13Table/Item[" + Integer.toString(x) + "]/q13_04/");
				
				t.add(q13_01);
				t.add(buildCheckBoxList(q13_02, "q13_02"));
				t.add(buildCheckBoxList(q13_03, "q13_03"));
				t.add(q13_04);
				Question13.add(t);
			}
			
			List<ArrayList<Field>> Question14 = new ArrayList<ArrayList<Field>>();
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page13/q12Table/Item"); x++) {
				ArrayList<Field> t = new ArrayList<Field>();

				Field q14_01 = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_01/");
				Subform q14_02 = parser.getSubformByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_02/");
				Field q14_03 = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_03/");
				Field q14_04 = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_04/");
				Field q14_05 = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_05/");
				Field q14_06 = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_06/");
				Field q14_07 = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_07/");
				Field q14_08 = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_08/");
				Subform q14_09 = parser.getSubformByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_09/");
				Field q14_09_custom = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_09/q14_09_custom_sf/q14_09_custom");
				Field q14_10 = parser.getFieldByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_10/");
				Subform q14_11 = parser.getSubformByXPath("/Page15/q14Table/Item[" + Integer.toString(x) + "]/q14_11/");
				
				t.add(q14_01);
				t.add(buildCheckBoxList(q14_02, "q14_02"));
				t.add(q14_03);
				t.add(q14_04);
				t.add(q14_05);
				t.add(q14_06);
				t.add(q14_07);
				t.add(q14_08);
				t.add(buildCheckBoxList(q14_09, "q14_09"));
				t.add(q14_09_custom);
				t.add(q14_10);
				t.add(buildCheckBoxList(q14_11, "q14_11"));
				Question14.add(t);
			}
			
			List<ArrayList<Field>> Question15 = new ArrayList<ArrayList<Field>>();
			List<String> Question15OtherTitles = new ArrayList<String>();
			List<Field> Question15_01 = new ArrayList<Field>();
			List<Field> Question15_02 = new ArrayList<Field>();
			List<Field> Question15_03 = new ArrayList<Field>();
			List<Field> Question15_04 = new ArrayList<Field>();
			List<Field> Question15_05 = new ArrayList<Field>();
			List<Field> Question15_06 = new ArrayList<Field>();
			
			Question15_01.add(parser.getFieldByXPath("/Page17/q15Table/Row1/q15_02_01/"));
			Question15_01.add(parser.getFieldByXPath("/Page17/q15Table/Row1/q15_comment1/"));
			Question15_02.add(parser.getFieldByXPath("/Page17/q15Table/Row2/q15_02_02/"));
			Question15_02.add(parser.getFieldByXPath("/Page17/q15Table/Row2/q15_comment2/"));
			Question15_03.add(parser.getFieldByXPath("/Page17/q15Table/Row3/q15_02_03/"));
			Question15_03.add(parser.getFieldByXPath("/Page17/q15Table/Row3/q15_comment3/"));
			Question15_04.add(parser.getFieldByXPath("/Page17/q15Table/Row4/q15_02_04/"));
			Question15_04.add(parser.getFieldByXPath("/Page17/q15Table/Row4/q15_comment4/"));
			Question15_05.add(parser.getFieldByXPath("/Page17/q15Table/Row5/q15_02_05/"));
			Question15_05.add(parser.getFieldByXPath("/Page17/q15Table/Row5/q15_comment5/"));
			Question15_06.add(parser.getFieldByXPath("/Page17/q15Table/Row6/q15_02_06/"));
			Question15_06.add(parser.getFieldByXPath("/Page17/q15Table/Row6/q15_comment6/"));
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page17/q15Table/Item"); x++) {
				try {
					ArrayList<Field> t = new ArrayList<Field>();
					t.add(parser.getFieldByXPath("/Page17/q15Table/Item[" + Integer.toString(x) + "]/q15_02_02/q15_radioOther/"));
					t.add(parser.getFieldByXPath("/Page17/q15Table/Item[" + Integer.toString(x) + "]/q15_commentOther/"));
					Question15OtherTitles.add(parser.getFieldByXPath("/Page17/q15Table/Item[" + Integer.toString(x) + "]/tbl_q15_other/Row3/txt_q15_other").getValue());
					
					Question15.add(t);
				} catch (Exception ex) {
					continue;
				}
			}
			
			
			List<ArrayList<Field>> Question16 = new ArrayList<ArrayList<Field>>();
			List<String> Question16OtherTitles = new ArrayList<String>();
			List<Field> Question16_01 = new ArrayList<Field>();
			List<Field> Question16_02 = new ArrayList<Field>();
			List<Field> Question16_03 = new ArrayList<Field>();
			List<Field> Question16_04 = new ArrayList<Field>();
			List<Field> Question16_05 = new ArrayList<Field>();
			List<Field> Question16_06 = new ArrayList<Field>();
			
			Question16_01.add(parser.getFieldByXPath("/Page18/q16Table/Row1/q16_02_01/"));
			Question16_01.add(parser.getFieldByXPath("/Page18/q16Table/Row1/q16_comment1/"));
			Question16_02.add(parser.getFieldByXPath("/Page18/q16Table/Row2/q16_02_02/"));
			Question16_02.add(parser.getFieldByXPath("/Page18/q16Table/Row2/q16_comment2/"));
			Question16_03.add(parser.getFieldByXPath("/Page18/q16Table/Row3/q16_02_03/"));
			Question16_03.add(parser.getFieldByXPath("/Page18/q16Table/Row3/q16_comment3/"));
			Question16_04.add(parser.getFieldByXPath("/Page18/q16Table/Row4/q16_02_04/"));
			Question16_04.add(parser.getFieldByXPath("/Page18/q16Table/Row4/q16_comment4/"));
			Question16_05.add(parser.getFieldByXPath("/Page18/q16Table/Row5/q16_02_05/"));
			Question16_05.add(parser.getFieldByXPath("/Page18/q16Table/Row5/q16_comment5/"));
			Question16_06.add(parser.getFieldByXPath("/Page18/q16Table/Row6/q16_02_06/"));
			Question16_06.add(parser.getFieldByXPath("/Page18/q16Table/Row6/q16_comment6/"));
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page18/q16Table/Item"); x++) {
				try {
					ArrayList<Field> t = new ArrayList<Field>();
					t.add(parser.getFieldByXPath("/Page18/q16Table/Item[" + Integer.toString(x) + "]/q16_02_02/q16_radioOther/"));
					t.add(parser.getFieldByXPath("/Page18/q16Table/Item[" + Integer.toString(x) + "]/q16_commentOther/"));
					Question16OtherTitles.add(parser.getFieldByXPath("/Page18/q16Table/Item[" + Integer.toString(x) + "]/tbl_q16_other/Row3/txt_q16_other").getValue());
					Question16.add(t);
				} catch (Exception ex) {
					continue;
				}
			}
			
			Field Question17 = parser.getFieldByXPath("/Page19/q17_txt/q17_txtInfo/");
			
			
			List<ArrayList<Field>> Question18 = new ArrayList<ArrayList<Field>>();
			List<String> Question18OtherTitles = new ArrayList<String>();
			List<Field> Question18_01 = new ArrayList<Field>();
			List<Field> Question18_02 = new ArrayList<Field>();
			List<Field> Question18_03 = new ArrayList<Field>();
			List<Field> Question18_04 = new ArrayList<Field>();
			List<Field> Question18_05 = new ArrayList<Field>();
			List<Field> Question18_06 = new ArrayList<Field>();
			
			Question18_01.add(parser.getFieldByXPath("/Page20/q18Table/Row1/q18_sf1/q18_radio1"));
			Question18_02.add(parser.getFieldByXPath("/Page20/q18Table/Row2/q18_sf1/q18_radio2"));
			Question18_03.add(parser.getFieldByXPath("/Page20/q18Table/Row3/q18_sf1/q18_radio3"));
			Question18_04.add(parser.getFieldByXPath("/Page20/q18Table/Row4/q18_sf1/q18_radio4"));
			Question18_05.add(parser.getFieldByXPath("/Page20/q18Table/Row5/q18_sf1/q18_radio5"));
			Question18_06.add(parser.getFieldByXPath("/Page20/q18Table/Row1/q18_sf1/q18_radio6"));
			for (int x = 1; x <= parser.getNumberOfItemsByXPath("/Page20/q18Table/Item"); x++) {
				try {
					ArrayList<Field> t = new ArrayList<Field>();
					t.add(parser.getFieldByXPath("/Page20/q18Table/Item[" + Integer.toString(x) + "]/q18_sfOther/q18_radioOther/"));
					Question18OtherTitles.add(parser.getFieldByXPath("/Page20/q18Table/Item[" + Integer.toString(x) + "]/Table13/Row3/q18_01_other").getValue());
					Question18.add(t);
				} catch (Exception ex) {
					continue;
				}
			}
			
			
			
			System.out.println("Test");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	private static Field buildCheckBoxList(Subform sf, String name) {
		if (sf == null) {
			return null;
		}
		
		String chkVals = "";
		for (Field f : sf.getFields()) {
			if (f.getName().equals("CheckBox") && !f.getValue().equalsIgnoreCase("0")) {
				chkVals += f.getValue() + ",";
			}
		}
		chkVals = chkVals.replaceAll("(,)*$", "");
		Field field = new Field();
		field.setName(name);
		field.setValue(chkVals);
		
		return field;
	}

}
