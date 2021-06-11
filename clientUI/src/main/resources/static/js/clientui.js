/**
 * Verifie que les mots de passe renseignés correspondent
 */
function matchPassword() {
    // let test = document.getElementById("prenom").valueOf();
    let test = $('#prenom').val();
    console.log(test);
    let pw1 = $('#password').val();
    let pw2 = $('#passwordVerif').val();
    let messagePw;
    console.log(pw1);
    console.log(pw2)
    if(pw1 !== pw2)
    {
        messagePw = 'Ko'

        // alert("Les mots de passe ne correspondent pas");
    } else {
        messagePw = 'OK'
        // alert("Password created successfully");
    }
    return messagePw;
}
function test() {
    let test = document.getElementById("prenom");
    console.log(test);
}