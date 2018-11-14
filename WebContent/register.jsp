<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Customer</title>
</head>
<body>

<div>
	<h3> Register Customer </h3>
</div>
<table>
	<form  action="user/register" method="post">
		<tr> 
			<td> SSN : </td>
			<td> <input type="number" name="ssn" placeholder="Enter SSN"> </td>
		</tr>
		<tr>
			<td> Name : </td>
			<td> <input type="text" name="cust_name" placeholder="Enter customer name"></td>
		</tr>
		<tr>
			<td> Address : </td>
			<td> <textarea cols="25" rows="2" name="cust_addr"> </textarea></td>
		</tr>
		<tr>
			<td> Age : </td>
			<td> <input type="number" name="cust_age" placeholder="Enter age"> </td>
		</tr>
		<tr>
			<td> City : </td>
			<td> <input type="text" name="cust_city" placeholder="Enter City"></td>
		</tr>
		<tr>
			<td> State : </td>
			<td> 
				<select name="cust_state">
					<option selected> Select </option>
					<option value="sdf"> Andhra Pradesh</option>
					<option value="asda"> Gujarat </option>
					<option value="asd"> Rajasthan</option>
					<option value="das"> UP</option>
					<option value="acs"> Kerala </option>
					<option value="acs"> MP </option>
					<option value="ascas"> West Bengal </option>
				</select>
			</td>
		</tr>
		<tr>
			
			<td colspan="2"> <input type="submit" value="Register" > </td>
		</tr>
	</form>
</table>

</body>
</html>