<?php
	/*
	* This file is used to do all the parsing of svn_list.xml,
	* and create objects of the class File in order to show them
	* afterwards to the user.
	*/
	include 'FileClass.php';
    $FileArray = array();
    $name;
    $size;
    $path;//just get it one time
    $revision;
    $kind;
    $nameAssigFile;

	function parseListXML()
	{
		global $FileArray, $name, $size, $path, $revision, $kind;
             $xml = simplexml_load_file(dirname(__FILE__).'/svn_list.xml');
             foreach ($xml->list as $list)
             {
             	$path = $list['path'];
                foreach ($list->entry as $entry)
                {
                	$kind = $entry['kind'];

	                foreach ($entry->name as $name)
					{
						$name = (string) $entry->name;
					}
	             	foreach ($entry->size as $size)
	              	{
	        			$size = (string) $entry->size;
	    			}
	    			foreach ($entry->commit as $commit)
	              	{
	              		$revision = $commit['revision'];
	    				$newFile = new File($name,$size,$revision,$kind);
    					array_push($FileArray, $newFile);
	    			}
	    		}

   			 }
	}
	function setFileName($nameA)
	{
		global $nameAssigFile;
		$nameAssigFile=$nameA;
	}
	function printFileInfo()
	{
		global $FileArray, $name, $size, $path, $revision, $kind, $nameAssigFile;
		   	//I print the information for that project
			echo"<u>Browser Path:</u> $path";
			echo "<br>";
			echo "<br>";
			for($i=0;$i<count($FileArray);$i++)
			{
				$pName=$FileArray[$i]->name;
				$pos = strpos($pName, $nameAssigFile);

				if ($pos === false) {
				    //String not founded
				} else {
				    $pSize=$FileArray[$i]->size;
					$pRevision=$FileArray[$i]->revision;
					$pKind=$FileArray[$i]->kind;
					echo "<u>Path:</u> $pName";
					echo "<br>";
					echo "<u>Size:</u> $pSize";
					echo "<br>";
					echo "<u>Revision:</u> $pRevision";
					echo "<br>";
					echo "<u>Kind:</u> $pKind";
					echo "<br>";
					echo "<br>";
				}
			}
	}
?>