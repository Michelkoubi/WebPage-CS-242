<?php
//require_once 'PHPUnit/Framework.php';
class parseListXML_test() extends PHPUnit_Framework_TestCase
{
		public function testProject()
		{
			//Send the test file to see the output of the class
			$testFile="test.xml";
			$output=parseListXML($testFile);

	        // Assert
	        $WantedOutputSize;
    	    $this->assertEquals($WantedOutputSize, $output);

    	    // Assert
	        $WantedOutputName;
    	    $this->assertEquals($WantedOutputName, $output);
		}
}


//FUNCTIONS THAT I WANT TO TEST
class parseListXML_test()
{
	function parseListXML(fileName)
	{
		global $FileArray, $name, $size, $path, $revision, $kind;
             $xml = simplexml_load_file(dirname(__FILE__).'/fileName');
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
   			 return $size;
	}
}

?>