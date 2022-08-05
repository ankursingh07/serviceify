<?php

$servername = "sql108.epizy.com";
$username = "epiz_32230516";
$password = "EQxE7T9jWFosT96";
$databasename = "epiz_32230516_test";

// CREATE CONNECTION
$conn = new mysqli($servername,
	$username, $password, $databasename);

// GET CONNECTION ERRORS
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}

// SQL QUERY
$query = "SELECT * FROM 'user';";

// FETCHING DATA FROM DATABASE
$result = $conn->query($query);

	if ($result->num_rows > 0)
	{
		// OUTPUT DATA OF EACH ROW
		while($row = $result->fetch_assoc())
		{
			echo "name: " .
				$row["name"]. " - Name: " ;
		}
	}
	else {
		echo "0 results";
	}

$conn->close();

?>
