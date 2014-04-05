<?php
class Project
{
	    var $name;
	    var $date;
	    var $msg;
	    //var $version;

	    function Project($name="",$date="",$msg="") 
	    {
	        $this->name = $name;
	        $this->date = $date;
	        $this->msg = $msg;
	    }
	    function name() 
	    {
	        return $this->name;
	    }
	    function date() 
	    {
	        return $this->date;
	    }
	    function msg() 
	    {
	        return $this->msg;
	    }
}
?>