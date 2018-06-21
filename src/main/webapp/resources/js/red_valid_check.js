var login = document.getElementById("reglogininput");
var loginRegex = new RegExp(".*[^a-zA-Z0-9].*");
function checkLogin() {
    if (loginRegex.test(login.value) || login.value == "" || login.value.length < 4) {
        if (login.classList.contains("correct")) {
            login.classList.remove("correct");
            turnOnButton();
        }
    }
    else {
        if (!login.classList.contains("correct")) {
            login.classList.add("correct");
            turnOnButton();
        }
    }
}

var password = document.getElementById("regpasswordinput");

function checkPassword() {
    if (loginRegex.test(password.value) || password.value == "" || password.value.length < 4) {
        if (password.classList.contains("correct")) {
            password.classList.remove("correct");
            turnOnButton();
        }
    }
    else {
        if (!password.classList.contains("correct")) {
            password.classList.add("correct");
            turnOnButton();
        }
    }
}
var regbutton = document.getElementById("regbutton");

function turnOnButton() {
    if (login.classList.contains("correct")
        && password.classList.contains("correct")) {
        regbutton.disabled = false;
    }
    else {
        regbutton.disabled = true;
    }
}