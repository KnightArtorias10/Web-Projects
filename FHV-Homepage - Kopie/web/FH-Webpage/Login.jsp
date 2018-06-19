<!DOCTYPE html>
<html class="no-js" lang="de">
<title>Login</title>
<head>
    <meta charset="UTF-8">
    <script>
        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
        }

        function cookieSetter() {
            setCookie("lastpage", "Login.jsp", 30);
        }
    </script>
</head>
<body onload="cookieSetter()">
<a href="javascript:history.back()">Zurueck</a>
<script type="text/javascript" lang="de">
    function validate() {
        var User_ID = document.getElementById("User-ID");
        var Ausdruck;
        if (User_ID.value == "" || User_ID.value == null) {
            alert("Bitte wähle ein User-ID aus");
            User_ID.style.border = "2px solid red";
            User_ID.focus();
            return false;
        } else {
            Ausdruck = /^([a-zA-Z_]){5,8}$/;
            if (!Ausdruck.test(User_ID.value)) {
                alert("Die User-ID muss muss zwischen 5 und 8 Zeichen lang sein und darf nur\n" +
                    "Buchstaben und “_“, keine Leer- oder Sonderzeichen und keine Ziffern\n" +
                    "enthalten");
                User_ID.style.border = "2px solid red";
                User_ID.focus();
                return false;
            } else {
                User_ID.style.border = "";
            }
        }
        var Passwort = document.getElementById("Passwort");
        if (Passwort.value == "" || Passwort.value == null) {
            alert("Bitte gib ein Passwort ein");
            Passwort.style.border = "2px solid red";
            Passwort.focus();
            return false;
        } else {
            Ausdruck = /^[a-zA-Z](\w{5,8})$/;
            if (!Ausdruck.test(Passwort.value)) {
                alert("Das Passwort muss zwischen 6 und 9 Zeichen lang sein und mit " +
                    "einem Buchstaben anfangen und darf nur Buchstaben, Ziffern und “_“, keine " +
                    "Leer- oder Sonderzeichen enthalten");
                Passwort.style.border = "2px solid red";
                Passwort.focus();
                return false;
            } else {
                Passwort.style.border = "";
            }
        }
    }

    function register() {
        document.getElementById('dispatchto').value = "Loginform";
        return true;
    }
</script>

<form action="Controller" method="get" enctype="text/plain">

    User-ID:<br>
    <input type="text" id="User-ID" name="User-ID">
    <br>
    Passwort:<br>
    <input type="password" id="Passwort" name="Passwort">
    <br>
    <INPUT type="hidden" id="dispatchto" name="dispatchto" value="LoggedIn" />
    <input type="submit" value="Submit" onclick="return validate()">
    <br>
    <input type="submit" value="Register" onclick="return register()">
    <br><br><br><br>
    <input type="button" value="Reset Form" onClick="this.form.reset()" />
</form>
</body>
</html>
