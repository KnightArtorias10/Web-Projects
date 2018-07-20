<!DOCTYPE html>
<html class="no-js" lang="de">
<title>Loginform</title>
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
            setCookie("lastpage", "Loginform.jsp", 30);
        }
    </script>
</head>
<body onload="cookieSetter()">
<a href="javascript:history.back()">Zurueck</a>

<script type="text/javascript" lang="de">
    function validate() {
        var vorName = document.getElementById("Vorname");
        if (vorName.value == "" || vorName.value == null) {
            alert("Bitte gib einen Vornamen ein");
            vorName.style.border = "2px solid red";
            vorName.focus();
            return false;
        } else {
            vorName.style.border = "";
        }
        var nachName = document.getElementById("Nachname");
        if (nachName.value == "" || nachName.value == null) {
            alert("Bitte gib einen Nachnamen ein");
            nachName.style.border = "2px solid red";
            nachName.focus();
            return false;
        } else {
            nachName.style.border = "";
        }
        var Adresse = document.getElementById("Adresse");
        if (Adresse.value == "" || Adresse.value == null) {
            alert("Bitte gib eine Adresse ein");
            Adresse.style.border = "2px solid red";
            Adresse.focus();
            return false;
        } else {
            Adresse.style.border = "";
        }
        var Land = document.getElementById("Land");
        if (Land.value == "" || Land.value == null) {
            alert("Bitte wähle ein Land aus");
            Land.style.border = "2px solid red";
            Land.focus();
            return false;
        } else {
            Land.style.border = "";
        }
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
        var Passwortbestaetigung = document.getElementById("Passwortbestaetigung");
        if (Passwortbestaetigung.value == "" || Passwortbestaetigung.value == null) {
            alert("Bitte wiederhole dein Passwort in der Passwortbestätigung");
            Passwortbestaetigung.style.border = "2px solid red";
            Passwortbestaetigung.focus();
            return false;
        } else {
            if (Passwortbestaetigung.value != Passwort.value) {
                alert("Die Passwortbestätigung stimmt nicht mit dem Passwort überein");
                Passwortbestaetigung.style.border = "2px solid red";
                Passwortbestaetigung.focus();
                return false;
            } else {
                Passwortbestaetigung.style.border = "";
            }
        }
        var maennlich = document.getElementById("maennlich");
        var weiblich = document.getElementById("weiblich");
        if (!maennlich.checked && !weiblich.checked) {
            alert("Bitte wähle ein Geschlecht aus");
            maennlich.focus();
            return false;
        }
        var Studiengang = document.getElementById("Studiengang");
        if (Studiengang.value == "" || Studiengang.value == null) {
            alert("Bitte wähle einen Studiengang aus");
            Studiengang.style.border = "2px solid red";
            Studiengang.focus();
            return false;
        } else {
            Studiengang.style.border = "";
        }
        var S2016 = document.getElementById("2016");
        var S2017 = document.getElementById("2017");
        var S2018 = document.getElementById("2018");
        if (!S2016.checked && !S2017.checked && !S2018.checked) {
            alert("Bitte wähle ein Studienjahr aus");
            S2016.focus();
            return false;
        }
        var Dozent = document.getElementById("Dozent");
        var Student = document.getElementById("Student");
        var Admin = document.getElementById("Admin");
        if (!Dozent.checked && !Student.checked && !Admin.checked) {
            alert("Bitte kreuze mindestens eine Berechtigung an");
            Dozent.focus();
            return false;
        }
        var Email = document.getElementById("Email");
        if (Email.value == "" || Email.value == null) {
            alert("Bitte gib eine Emailadresse an");
            Email.style.border = "2px solid red";
            Email.focus();
            return false;
        } else {
            Ausdruck = /^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])$/;
            if (!Ausdruck.test(Email.value)) {
                alert("Ungültige Email Adresse");
                Email.style.border = "2px solid red";
                Email.focus();
                return false;
            } else {

                Email.style.border = "";
            }
        }
    }


</script>

<form action="Controller" method="get" enctype="text/plain">

    Vorname:<br>
    <input type="text" name="Vorname" id="Vorname">
    <br>
    Nachname:<br>
    <input type="text" id="Nachname" name="Nachname">
    <br>
    Adresse:<br>
    <textarea id="Adresse" cols="40" rows="5"></textarea>
    <br>
    <br>
    Land:<br>
    <select id="Land" name="Land">
        <option value=""></option>
        <option value="Österreich">Österreich</option>
        <option value="Schweiz">Schweiz</option>
        <option value="Deutschland">Deutschland</option>
        <option value="Andere">Andere</option>
    </select>
    <br>
    <br>
    User-ID:<br>
    <input type="text" id="User-ID" name="User-ID">
    <br>
    Passwort:<br>
    <input type="password" id="Passwort" name="Passwort">
    <br>
    Passwortbestätigung:<br>
    <input type="password" id="Passwortbestaetigung" name="Passwortbestaetigung">
    <br>
    <br>
    Geschlecht<br>
    <input type="radio" name="Geschlecht" id="maennlich" value="männlich"> Männlich<br>
    <input type="radio" name="Geschlecht" id="weiblich" value="weiblich"> Weiblich<br>
    <br>
    Studiengang:
    <select id="Studiengang" name="Studiengang">
        <option value=""></option>
        <option value="Informatik">Informatik BSc</option>
        <option value="Elektrotechnik">Elektrotechnik Dual BSc</option>
        <option value="Mechatronik">Mechatronik - Maschinenbau BSc</option>
    </select>
    <br><br>
    Studienjahr:<br>
    <input type="radio" name="Studienjahr" id="2016" value="2016"> 2016<br>
    <input type="radio" name="Studienjahr" id="2017" value="2017"> 2017<br>
    <input type="radio" name="Studienjahr" id="2018" value="2018"> 2018<br>
    <br>
    Kreuzen Sie ihre Berechtigungsstufen an:<br>

    <input type="checkbox" name="Berechtigungsstufe" id="Dozent" value="Dozent"> Dozent<br>

    <input type="checkbox" name="Berechtigungsstufe" id="Student" value="Student"> Student<br>
    <input type="checkbox" name="Berechtigungsstufe" id="Admin" value="Admin"> Admin<br>
    <br>
    Email-Adresse:<br>
    <input type="text" id="Email" name="Email">
    <br><br>
    <INPUT type="hidden" name="dispatchto" value="LoginSave" />
    <input type="submit" value="Submit" onclick="return validate()">
    <br><br><br><br>
    <input type="button" value="Reset Form" onClick="this.form.reset()" />
</form>
</body>
</html>
