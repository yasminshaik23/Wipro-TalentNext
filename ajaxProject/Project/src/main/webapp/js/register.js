function validateEmail() {

    const email = document.getElementById("email").value;
    const message = document.getElementById("emailMessage");

    // Check email pattern
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailPattern.test(email)) {
        message.textContent = "Invalid email-id";
        return;
    }

    // AJAX request
    const xhr = new XMLHttpRequest();

    xhr.open("GET", "validateEmail?email=" + encodeURIComponent(email), true);

    xhr.onreadystatechange = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {
            message.textContent = xhr.responseText;
        }

    };

    xhr.send();
}