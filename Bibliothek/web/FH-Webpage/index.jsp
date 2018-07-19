<!-- habe Code aus den folgenden 2 seiten verwendet und benutze boilerplate mit IntelliJ -->
<!-- https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_vertical_tabs -->
<!-- https://www.w3schools.com/html/html_tables.asp -->


<!doctype html>
<html class="no-js" lang="de">
<title>Home</title>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fachhochschule Vorarlberg">
    <meta name="keywords" content="Punktenoten,Noten,Schule,studieren,Student,Studenten,Punkte,Kurs,Kurse,Informatik,English,Englisch,Dornbirn">
    <meta name="author" content="Marcel Hanser">
    <link href="${pageContext.request.contextPath}/css/fhvstylesheet.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="${pageContext.request.contextPath}/css/fhvonprint.css" rel="stylesheet" type="text/css" media="print" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script>
        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
        }

        function cookieSetter() {
           setCookie("lastpage", "index.html", 30);
        }
    </script>
</head>

<!-- Add your site application content here -->
<!-- Site navigation menu -->
<img src="fhv.logo.jpg" alt="FHV logo" width="50%" height="50%">



<meta name="viewport" content="width=device-width, initial-scale=1">
<body onload="cookieSetter()">

<p></p>

<div class="tab">
    <button class="tablinks" onclick="openCourse(event, 'Home')" id="defaultOpen">Home</button>
    <button id="Guestbook" class="float-left submit-button" >Gästebuch</button>
    <button id="Envelope" class="fa fa-envelope" style='color:black'>Email an Administrator</button>
    <button id="Login" class="float-left submit-button" >Login Seite</button>
    <button id="History" class="float-left submit-button" >History</button>
</div>

<script type="text/javascript">
    document.getElementById("Envelope").onclick = function () {
        location.href = "mailto:marcel.hanser@students.fhv.at";
    };
</script>

<script type="text/javascript">
    document.getElementById("Login").onclick = function () {
        location.href = "Controller?dispatchto=Login";
    };
</script>

<script type="text/javascript">
    document.getElementById("History").onclick = function () {
        location.href = "Controller?dispatchto=History";
    };
</script>


<script type="text/javascript">
    document.getElementById("Guestbook").onclick = function () {
        location.href = "Controller?dispatchto=Gaestebuch";
    };
</script>


<div id="Home" class="tabcontent">
    <p>Wilkommen auf der FH Homepage</p>
</div>

<script>
    function openCourse(evt, courseName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(courseName).style.display = "block";
        evt.currentTarget.className += " active";
    }
    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
</script>





<script src="js/vendor/modernizr-3.5.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-3.2.1.min.js"><\/script>')</script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>

<!-- Google Analytics: change UA-XXXXX-Y to be your site's ID. -->
<script>
    window.ga=function(){ga.q.push(arguments)};ga.q=[];ga.l=+new Date;
    ga('create','UA-XXXXX-Y','auto');ga('send','pageview')
</script>
<script src="https://www.google-analytics.com/analytics.js" async defer></script>
</body>
</html>
