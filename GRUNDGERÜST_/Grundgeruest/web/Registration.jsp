<%--
    Document   : Registrieren1
    Created on : 01.09.2018, 12:50:24
    Author     : HP EliteBook 8440p
--%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" href="bibliothekLayout.css">

    <script>
        function validateRegistration() {
            var fname = document.forms["regForm"]["tf_fname"];
            var lname = document.forms["regForm"]["tf_lname"];
            var address = document.forms["regForm"]["ta_address"];
            var country = document.forms["regForm"]["select_country"];
            var userID = document.forms["regForm"]["tf_userID"];
            var password = document.forms["regForm"]["tf_password"];
            var confirmPassword = document.forms["regForm"]["tf_confirmPw"];
            var email = document.forms["regForm"]["tf_email"];
            var radio_male = document.forms["regForm"]["r_male"];
            var radio_female = document.forms["regForm"]["r_female"];
            var check_child = document.forms["regForm"]["cb_child"];
            var check_adult = document.forms["regForm"]["cb_adult"];
            var check_mitarbeiter = document.forms["regForm"]["cb_mitarbeiter"];
            var check_admin = document.forms["regForm"]["cb_admin"];

            if(fname.value == "") {
                alert("Bitte Vornamen eingeben");
                return false;
            }

            if(lname.value == "") {
                alert("Bitte Nachnamen eingeben");
                return false;
            }

            if(address.value == "") {
                alert("Bitte Adresse eingeben");
                return false;
            }

            if(country.value == "") {
                alert("Bitte ein Land auswählen");
                return false;
            }

            if(userID.value == "") {
                alert("Bitte gewünschte User-ID eingeben");
                return false;
            }

            var userIDRegEx = /^[A-Za-z_]*$/;
            if(userIDRegEx.test(tf_userID.value) == false) {
                alert("Die User-ID darf nur Buchstaben und Underscores enthalten");
                return false;
            }

            if(userID.value.length < 5 || userID.value.length > 12) {
                alert("Die User-ID muss zwischen 5 und 12 Zeichen lang sein");
                return false;
            }

            if(password.value == "") {
                alert("Bitte gewünschtes Passwort eingeben");
                return false;
            }

            if(password.value.length < 6 || password.value.length > 11) {
                alert("Ihr Passwort muss zwischen 6 und 11 Zeichen lang sein");
                return false;
            }

            var passwordRegEx = /^[A-Za-z]*[A-Za-z0-9_]*$/;
            if(passwordRegEx.test(tf_password.value) == false) {
                alert("Ihr Passwort darf nur Buchstaben, Zahlen und Underscores enthalten. Außerdem muss es mit einem Buchstaben anfangen!")
                return false;
            }

            if(confirmPassword.value != password.value) {
                alert("Die Passwörter stimmen nicht miteinander überein!");
                return false;
            }

            if(email.value == "") {
                alert("Bitte eine E-Mail Adresse eingeben");
                return false;
            }

            var regEMail = /^[A-Za-z]*[A-Za-z0-9-_.]*@*[A-Za-z0-9]*.*[A-Za-z]$/;
            if(regEMail.test(tf_email.value) == false) {
                alert("Bitte geben Sie eine gültige E-Mail Adresse ein!");
                return false;
            }

            if(!radio_male.checked && !radio_female.checked) {
                alert("Wählen Sie ein Geschlecht aus");
                return false;
            }

            if(!check_child.checked && !check_adult.checked && !check_mitarbeiter.checked && !check_admin.checked) {
                alert("Wählen Sie mindestens eine Nutzerkategorie aus");
                return false;
            }

            alert("Registrierung erfolgreich!");
            return true;
        }

        function reset() {
            document.getElementById("regForm").reset();
        }
    </script>
    <meta charset="UTF-8">
    <title>Registrieren</title>
    <script>
        function setCookie(cname,cvalue,exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires=" + d.toGMTString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";domain=;path=/";
        }

        function cookieSetter() {
            setCookie("lastpage", "Registration.jsp", 30);
        }
    </script>
</head>
<body onload="cookieSetter()">
<form name="regForm" method="post">
    <center>
        <h3>Füllen Sie die Felder aus.</h3>
        <table>
            <tr>
                <td><b>Vorname:</b></td>
                <td><input type="text" id="tf_fname"/></td>
            </tr>
            <tr>
                <td><b>Nachname:</b></td>
                <td><input type="text" id="tf_lname"/></td>
            </tr>
            <tr>
                <td><b>Adresse:</b></td>
                <td><textarea id="ta_address"></textarea></td>
            </tr>
            <tr>
                <td><b>Land:</b></td>
                <td>
                    <select id="select_country">
                        <option value="">-- wähle --</option>
                        <option value="Österreich">Österreich</option>
                        <option value="Deutschland">Deutschland</option>
                        <option value="Schweiz">Schweiz</option>
                        <option value="Anderes Land">Anderes Land</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><b>User-ID:</b></td>
                <td><input type="text" id="tf_userID"/></td>
            </tr>
            <tr>
                <td><b>Passwort:</b></td>
                <td><input type="password" id="tf_password"/></td>
            </tr>
            <tr>
                <td><b>Passwort bestätigen:</b></td>
                <td><input type="password" id="tf_confirmPw"/></td>
            </tr>
            <tr>
                <td><b>Geschlecht:</b></td>
                <td><input type="radio" id="r_male"/> Männlich <input type="radio" id="r_female"/> Weiblich<td>
            </tr>
            <tr>
                <td><b>Nutzerkategorie:</b></td>
                <td>
                    <input type="checkbox" value="child" id="cb_child">Kunde (minderjrg.)</input>
                    <input type="checkbox" value="adult" id="cb_adult">Kunde (volljrg.)</input> <br>
                    <input type="checkbox" value="mitarbeiter" id="cb_mitarbeiter">Mitarbeiter</input>
                    <input type="checkbox" value="admin" id="cb_admin">Admin</input>
                </td>
            </tr>
            <tr>
                <td><b>E-Mail:</b></td>
                <td><input type="text" id="tf_email"/></td>
            </tr>
        </table> <br>
        <br>
        <input type="submit" value="Zurücksetzen" onclick="reset()"/>
        <input type="submit" value="Bestätigen" onclick="validateRegistration()"/>
    </center>
</form>
<%
    Date date = new Date();
    Cookie cookie = new Cookie("Registrieren1.jsp", String.valueOf(date.getTime()));
    cookie.setMaxAge(-1);
    response.addCookie(cookie);
%>
</body>
</html>
