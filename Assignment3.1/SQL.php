<?php
    // Connecting using PDO
	$db = new PDO('mysql:host=127.0.0.1;dbname=blog;charset=utf8', 'root', 'mypass');
	$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

	$name = $_POST['name'];
	$comment = $_POST['comment'];

	if($name!=NULL && $comment!=NULL)
	{
		
		//FILTER COMMENTS
		//Create array with "red flag" words
		$comment_=FilterComments($comment);
		
		putDataInDB($db,$name,$comment_);
	}


	showDataInDB($db);
	
	//Read data from MySQL
	function showDataInDB($db)
	{
   		foreach($db->query('SELECT * FROM BlogComments') as $row) 
   		{
   			echo  '<div class="commentBlog">';
    		echo $row['Name'].' '.':'.' '.$row['Comment'];
    		echo  "</div>";
			echo "<br>";
    	}
	}
	function callPut($name,$comment)
	{
		putDataInDB($db,$name,$comment);
	}
	//Protected against malicious inputs
	function putDataInDB($db,$Name,$Comment)
	{
		//Inserting data to MySQL, I use prepare in PDO to protect against malicious inputs
		$stmt = $db->prepare("INSERT INTO BlogComments (Name,Comment) VALUES(:Name,:Comment)");
		$stmt->execute(array(':Name' => $Name, ':Comment' => $Comment));
		$affected_rows = $stmt->rowCount();
	}

	function FilterComments($comment)
	{
		$FilterArray = array();
		$badWord="fuck";
		array_push($FilterArray, $badWord);
		$badWord="bitch";
		array_push($FilterArray, $badWord);
		$badWord="dick";
		array_push($FilterArray, $badWord);
		$badWord="asshole";

		foreach ($FilterArray as &$value) 
		{
    		$redFlag = $value;
			if(strpos($comment,$redFlag))
			{
				//I replace the comments
				$filteredComment=str_replace($redFlag,"%@#piii",$comment);
			}
		}
		return $filteredComment;
	}	
	//CODE USE FOR THE DATABASE
	// Create database
    /*
    $sql="CREATE DATABASE blog";
    if (mysqli_query($con,$sql))
    {
        echo "Database my_db created successfully";
    }
    else
    {
        echo "Error creating database: " . mysqli_error($con);
    }
    
    // Create table
	$sql="CREATE TABLE BlogComments
	(
		PID INT NOT NULL AUTO_INCREMENT, 
		PRIMARY KEY(PID),
		Name CHAR(15),
		Comment VARCHAR(3000)
	)";

	// Execute query
	if (mysqli_query($con,$sql))
	  {
	  echo "Table persons created successfully";
	  }
	else
	  {
	  echo "Error creating table: " . mysqli_error($con);
	  }
	  	//
    //mysql_select_db("dogs"); 
    //$query = mysql_query("SELECT name FROM dogs WHERE id=1"); 
    //echo $query;

	 */
?>