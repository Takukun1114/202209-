<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="attendance.attendance1.service.*"%>
<%@ page import="attendance.attendance1.service.PageManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<h1>logo</h1>
</header>
<main>
社員ID
&nbsp;:&nbsp; 
<input type=text class=''  size=20 name='uId' />

<br>
所属部門
&nbsp;:&nbsp; 
<%=Info.getSelect("dept","m_dept","dept_name","del_flg=0")%><br>

氏名
&nbsp;:&nbsp; 
<input type=text class=''  size=20 name='uname' />
<br>

勤務状態
&nbsp;:&nbsp; 
<select name='status1'>
<option value="0">出勤</option>
<option value='1'>有給休暇</option>
<option value='2'>特殊休暇</option>

<option value='3'>欠勤</option>
<option value='4'>その他</option>


</select>
<br>
申請状態
&nbsp;:&nbsp; 
<%=Info.getSelect("status","m_stats","flow_status_name","del_flg=0")%><br>


勤務年月日
&nbsp;:&nbsp; 
<input type=text class=''  size=20 name='data1' />~<input type=text class=''  size=20 name='udata2' /><br><br>
<input type=submit class='' value='検索' />
 &nbsp;&nbsp;
<input type=button   class='' value='閉じる'  />
<%
String puId = request.getParameter("uId")==null?"":request.getParameter("uId"); 
String puname = request.getParameter("uname")==null?"":request.getParameter("uname"); 
String pdept = request.getParameter("dept")==null?"":request.getParameter("dept"); 
String pst1 = request.getParameter("status1")==null?"":request.getParameter("status1"); 

String pst = request.getParameter("status")==null?"":request.getParameter("status");
%>
 
<table>
 <tr>
               
<td height="30" align="center" bgcolor="#f2f2f2" >社員ID</td>
<td height="30" align="center" bgcolor="#f2f2f2" >氏名</td>
<td height="30" align="center" bgcolor="#f2f2f2">部署</td>
<td height="30" align="center" bgcolor="#f2f2f2">作業時間</td>
<td height="30" align="center" bgcolor="#f2f2f2">休憩時間</td>
<td height="30" align="center" bgcolor="#f2f2f2">残業時間</td>
<td height="30" align="center" bgcolor="#f2f2f2">欠勤時間</td>
<td height="30" align="center" bgcolor="#f2f2f2">勤務状態</td>
<td height="30" align="center" bgcolor="#f2f2f2">申請状態</td>
              
</tr>
      <%
String sql = "select * from t_attendance innner join t_employee on employee_id = create_user_id left join m_dept on m_dept.dept_id=t_employee.dept_id left join on m_stats.flow_status_id=t_attendance.flow_status_id where del_flg=0";
if(!puId.equals("")){ 
	 sql+= " and employee_id ="+puId ;
	 }  
if(!puname.equals("")){ 
	 sql+= " and employee_name like'%"+puname+"%' " ;
	 }  
if(!pdept.equals("")){ 
	 sql+= " and pdept l="+puname;
	 }  
if(!pst1.equals("")){ 
	 sql+= " and working_status_id="+pst1 ;
	 } 
if(!pst.equals("")){ 
	 sql+= " and flow_status_id="+pst ;
	 } 
 %>



              
</table>


</main>
</body>
</html>