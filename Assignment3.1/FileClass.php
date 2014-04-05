<?php
class File
{
	    var $name;
	    var $size;
	    var $revision;
    	var $kind;

	    function File($name="",$size="",$revision="", $kind="") 
	    {
	        $this->name = $name;
	        $this->size = $size;
	        $this->revision = $revision;
	        $this->kind = $kind;
	    }
	    function name() 
	    {
	        return $this->name;
	    }
	    function size() 
	    {
	        return $this->size;
	    }
	    function revision() 
	    {
	        return $this->revision;
	    }
	    function kind() 
	    {
	        return $this->kind;
	    }
}
?>