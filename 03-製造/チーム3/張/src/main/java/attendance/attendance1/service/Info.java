package attendance.attendance1.service;

import java.util.HashMap;



public class Info {
	 public static String getSelect(String name,String tablename,String zdname,String where)
	 {
		  
		 String select = "<select name=\""+name+"\" id=\""+name+"\" >";
		 select+="<option value=\"\">なし</option>";
		 for(HashMap permap:new CommDao().select("select * from "+tablename+" where "+where)){ 
			 String optionstr = "";
			 optionstr=permap.get(zdname).toString();
			 if(optionstr.indexOf(" - ")>-1)optionstr=optionstr.substring(0,optionstr.length()-3);
			 select+="<option value=\""+optionstr+"\">"+optionstr+"</option>";
		 }
		 select+="</select>";
		 return select;
	 }

}
