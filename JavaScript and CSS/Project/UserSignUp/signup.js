// Display current date and time
function displayDateTime() {

    var now = new Date();

    var dateTime =
        now.toLocaleDateString() + " " +
        now.toLocaleTimeString();

    document.getElementById("dateTime").innerHTML =
        dateTime;
}

// Update date and time every second
setInterval(displayDateTime, 1000);

// Display immediately when page loads
displayDateTime();


// Registration form validation
function validateForm() {

    // First Name
    var firstName =
        document.getElementById("firstName").value.trim();

    if (firstName === "") {
        alert("First Name must be entered.");
        return false;
    }

    if (!/^[A-Za-z]+$/.test(firstName)) {
        alert("First Name must contain only characters.");
        return false;
    }


    // Last Name
    var lastName =
        document.getElementById("lastName").value.trim();

    if (lastName === "") {
        alert("Last Name must be entered.");
        return false;
    }

    if (!/^[A-Za-z]+$/.test(lastName)) {
        alert("Last Name must contain only characters.");
        return false;
    }


    // Password
    var password =
        document.getElementById("password").value;

    if (password === "") {
        alert("Password must be entered.");
        return false;
    }

    if (password.length < 6 || password.length > 20) {
        alert("Password length must be between 6 and 20 characters.");
        return false;
    }


    // Confirm Password
    var confirmPassword =
        document.getElementById("confirmPassword").value;

    if (confirmPassword === "") {
        alert("Confirm Password must be entered.");
        return false;
    }

    if (confirmPassword.length < 6 ||
        confirmPassword.length > 20) {

        alert(
            "Confirm Password length must be between 6 and 20 characters."
        );

        return false;
    }


    // Password matching
    if (password !== confirmPassword) {

        alert(
            "Password and Confirm Password should be same."
        );

        return false;
    }


    // Gender
    var gender =
        document.querySelector(
            'input[name="gender"]:checked'
        );

    if (gender === null) {

        alert("Gender must be selected.");

        return false;
    }


    // Mobile Number
    var mobile =
        document.getElementById("mobile").value.trim();

    if (mobile === "") {

        alert("Mobile Number must be entered.");

        return false;
    }

    /*
       Accepted formats:

       XXX-XXX-XXXX
       XXX.XXX.XXXX
       XXX XXX XXXX
    */

    var mobilePattern =
        /^\d{3}[-. ]\d{3}[-. ]\d{4}$/;

    if (!mobilePattern.test(mobile)) {

        alert(
            "Mobile Number must be in XXX-XXX-XXXX, " +
            "XXX.XXX.XXXX or XXX XXX XXXX format."
        );

        return false;
    }


    // Date of Birth
    var dob =
        document.getElementById("dob").value.trim();

    if (dob === "") {

        alert("DOB must be entered.");

        return false;
    }

    var dobPattern =
        /^\d{2}-\d{2}-\d{4}$/;

    if (!dobPattern.test(dob)) {

        alert(
            "DOB must be in DD-MM-YYYY format."
        );

        return false;
    }


    // Email
    var email =
        document.getElementById("email").value.trim();

    if (email === "") {

        alert("Email Address must be entered.");

        return false;
    }

    /*
       Email requirements:
       - @ should not be first
       - @ should exist
       - dot should exist after @
       - at least one character between @ and last dot
    */

    var atPosition = email.indexOf("@");
    var lastDotPosition = email.lastIndexOf(".");

    if (
        atPosition <= 0 ||
        lastDotPosition <= atPosition + 1 ||
        lastDotPosition === email.length - 1
    ) {

        alert(
            "Please enter a valid Email Address."
        );

        return false;
    }


    // All validations successful
    alert("Registration successful!");

    return true;
}


// 3-minute timer
setTimeout(function () {

    alert("3 mins past.");

}, 3 * 60 * 1000);