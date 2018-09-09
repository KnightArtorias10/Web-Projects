<html lang="de">
<head>
    <meta name="library" content="Bücherei, leihen, Dornbirn">
    <meta name="products" content="Film, Buch, Bücher, Spiel">
    <meta name="literature" content="Sachbuch, Fachbuch, Fantasy, Drama, Roman">
    <meta name="technologies" content="HTML, CSS, JavaScript">
    <meta name="category" content="internet, web, app, web-application, book, library">

    <link rel="stylesheet" href="bibliothekLayout.css">

    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
            position: fixed;
            top: 0;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111;
        }
    </style>

    <script>
        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
        }

        function cookieSetter() {
            setCookie("lastpage", "index.jsp", 30);
        }
    </script>

    <script>
        function trololol() {
            for(var i = 12; i > 0; i++) {
                alert("trlololol");
            }
        }
    </script>
</head>
<body onload="cookieSetter()" onload="trololol()">
<div class="tab">
    <ul>
        <li><a href="Media.jsp">Medien</a></li>
        <li><a href="Guestbook.jsp">Guestbook</a></li>
        <li><a href="Registration.jsp">Registrieren</a></li>
        <li><a href="History.jsp">Verlauf</a></li>
        <li><a href="Evaluation.xhtml">Evaluation</a></li>
        <li><a href="Result.xhtml">Ergebnisse ansehen</a></li>
        <li><a href="Mashup.jsp">Mashup</a></li>
    </ul>
</div>

<div>
    <h1>Bibliothek Dornbirn</h1>
    Herzlich Willkommen in der Bibliothek Dornbirn!<br>
    In unserer Bibliothek können Sie Bücher, Filme und Spiele <br>
    ausleihen. <br>
    <br>
    <b>Adresse:</b> Dornbirn, Hochschulstraße 1<br>
    <b>Geöffnet:</b> Von 8:00 - 21:00 Uhr <br></div>
</body>
</html>
