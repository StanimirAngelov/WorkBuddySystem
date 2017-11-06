<?php
$serverName = "stansproject.database.windows.net"; 
$connectionInfo = array( "Database"=>"stansfinal", "UID"=>"stanproject", "PWD"=>"password1");
$conn = sqlsrv_connect( $serverName, $connectionInfo);
//echo "we have entered the file <br />"; 
if( $conn ) 
{
	//echo "connection works <br />";
	
	
	
	$HelloWorld = $_POST["Hi"];
	//$Password = $_POST["password"];
	//$Role = $_POST["role"];
	

	
	$query = sprintf ("select Username from Users where Role = 'Employee'");
	$stmt = sqlsrv_query ($conn, $query);
	
	if ($stmt === false) 
	{
		//echo "statement broken";
        die(print_r(sqlsrv_errors(), true));
    }
	
	    $response = array();
		$Name = array();
		$index = 0;
	
		 while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC))
		{
			
				$Name[index] =  $row['Username'];
				$response['Username'][$index] = $row['Username'];
				
				$index++;
				
    
		}
	   
	   
		$response["success"] = true;

	   
		echo json_encode($response);
		

		}
		
	
	
	
else
	{
     echo "Connection could not be established.<br />";
     die( print_r( sqlsrv_errors(), true));
	}
	
	
	
?>
	
		
		
	