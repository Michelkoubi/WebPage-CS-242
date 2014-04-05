<!DOCTYPE HTML>
<html>

<head>
  <title>textured_blue - a page</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="style/style.css" title="style" />
</head>

<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index.html">Portfolio <span class="logo_colour">Miguel</span></a></h1>
          <h2>CS 242: Programming Studio </h2>
        </div>
      </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li><a href="index.html">Home</a></li>
          <li><a href="Assignment0.php">Assignment0</a></li>
          <li><a href="Assignment1.php">Assignment1</a></li>
          <li><a href="Assignment2.php">Assignment2</a></li>
          <li class="selected"><a href="WebBlog.php">Web Blog</a></li>
          <li ><a href="Comment.php">Write Comment</a></li>

        </ul>
      </div>
    </div>
    <div id="site_content">
      <div class="sidebar">
      </div>
      <div id="content">
          <div>
          <?php 
            //I include the SQL file where you can file all the processing regarding DB
            include 'SQL.php';
          ?>
          </div>
    </div>
    <div id="footer">
    </div>
  </div>
</body>
<script>
</script>
<!--

function sam_click()
{
  name =document.getElementById("name").value;
  comment =document.getElementById("comment").value;
  alert(x);
  alert("asadad");
  return false;
}
    <script>
    function loadXMLDoc()
    {
    var xmlhttp;
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
    xmlhttp.onreadystatechange=function()
      {
      if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
        document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
        }
      }
    xmlhttp.open("GET","ajax_info.txt",true);
    xmlhttp.send();
    }
</script>-->
</html>