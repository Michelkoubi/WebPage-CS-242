<?php
	/*
	* This file is used to do all the parsing of svn_log.xml,
	* and create objects of the class Project in order to show them
	* afterwards to the user.
	*/
	include 'Classes.php';
    $ProjectArray = array();
    $name;
    $msg;
    $date;
    $author;
    $nameAssig;
    define("START_POSITION", 0);
    define("END_POSITION", 11);

	function parseXML()
	{
		global $ProjectArray, $name, $msg, $date, $author;
             $xml = simplexml_load_file(dirname(__FILE__).'/svn_log.xml');
             foreach ($xml->logentry as $logentry)
             {
                $date = (string) $logentry->date;

                foreach ($logentry->paths as $paths)
				{
				    foreach ($paths->path as $path)
				    {
				      $content = (string) $path;
					  $name=parseGetName($content);
					  $autor=parseGetAutor($content);
					}
				}
             	foreach ($logentry->msg as $msg)
              	{
              		
        			$mesage = (string) $msg;
    				$newProj = new Project($name,$date,$mesage);
    				array_push($ProjectArray, $newProj);
    			}

   			 }
	}
	function parseGetName($content)
	{
		$startPos=strpos($content,"Assignment");
		$length=13;

		// I check if that path has the word Assignment
		if($startPos!=NULL && $startPos!=False)
		{
			$name=substr($content, $startPos ,$length);
		}
		return $name;
	}
	function parseGetAutor($content)
	{
		$startPos=strpos($content,"/");
		$length=8;
		$autor=substr($content, $startPos+1 ,$length);
		return $autor;
	}
	function setName($nameA)
	{
		global $nameAssig;
		$nameAssig=$nameA;
	}
	function printInfo()
	{
		global $nameAssig,$ProjectArray, $name, $msg, $date, $author;
		   	//I print the information for that project
			for($i=0;$i<count($ProjectArray);$i++)
			{
				$pName=$ProjectArray[$i]->name;
				$pNameCompare=substr($pName, START_POSITION ,END_POSITION);
				if($pNameCompare==$nameAssig)
				{
					$pDate=$ProjectArray[$i]->date;
					$pMesage=$ProjectArray[$i]->msg;
					echo "<u>Name:</u> $pName";
					echo "<br>";
					echo "<u>Date:</u> $pDate";
					echo "<br>";
					echo "<u>Mesage:</u> $pMesage";
					echo "<br>";
					echo "<br>";
				}
			}
	}
?>